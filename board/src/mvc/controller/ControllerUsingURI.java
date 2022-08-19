package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();

    public void init() throws ServletException {
        String configFile = getInitParameter("configFile");
        Properties prop = new Properties();
        String configFilePath = getServletContext().getRealPath(configFile);
        // getServletContext()는 부모에게서 쓸 수 있는 메소드라
        // super.getServletContext()로도 쓸 수 있...?다...?
        // .getRealPath는 절대경로를 찾아주는 메소드
        // 서블릿은 정적인 리소스를 찾기 힘든 메소드다
        // 클래스 아웃폴더의 경로를 찾기 힘드면 .getRealPath로 절대 경로를 찾아서 쓰는 것
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        Iterator keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);
            try {
                Class<?> handlerClass = Class.forName(handlerClassName);
                CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
                // logout을 형변환하려고 했는데 못해서 오류가 남
                // 보통 객체를 만들땐 new 객체()로 만드는데
                // .forName는 해당 이름을 가진 클래스를 투영해서 객체를 만드는 것이다
                // <?>는 generic으로 ?가 형이 정해지지 않았다는 뜻이다
                // ? 자체에 의미가 있어서 extends handler...
                // 따라서 handlerClass는 형이 정해지지 않은 Class instance로,
                // init으로 생성된 CommandHandler는
                // .newInstance로 로그인핸들러와 로그아웃핸들러의 인스턴스를 만드는데
                // 만들 때 로그아웃의 형이 logouthandler형이라서 오류가 난 것이다
                // 즉 implements commandhandler를 안해서 형이 다르므로 다운이 안돼서 오류
                
                // +
                // new A라고 하면 A라는 인스턴스가 만들어지는데
                // A.forName는 A '클래스'가 나온다
                // .forName는 해당 클래스를 로딩해서 적어놓은 클래스 내용을 클랙스 객체로 만들어준다
                // '투영'. 리플렉스.
                // '투영'이라는 기법은 인스턴스를 생성하는게 아니라 A 자체를 보기 때문에
                // 이 클래스의 필드, 메소드, 생성자가 뭔지를 볼 수 있고 필요하다면 추가할 수도 있다 -> 확장성
                // 클래스를 그 자체로 문자로써 다룰 수 있다
                // handlerClass.getMethod 또는 .getfield 등
                
                commandHandlerMap.put(command, handlerInstance);
                // 맵을 사용하는 이유. 키를 집어넣으면 객체가 나오니까 바로 꺼내쓰려고
                // 매번 필요할때마다 new로 생성할 필요없이 꺼내쓰면 되니까
                
                System.out.println(commandHandlerMap);
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
        CommandHandler handler = commandHandlerMap.get(command);
        if (handler == null) {
            handler = new NullHandler();
        }
        String viewPage = null;
        try {
            viewPage = handler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}