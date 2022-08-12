package person;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿의 이름 설정과 주소 표현을 쓰면 쉽게 서블릿 등록이 가능하다
// web.xml에 등록된게 아니라서 '실행 시'에 읽고 해석을 하는데 -> 실행 시 동작하는 annotation!
// 둘 다 쓰면 주소가 중복되었다고 에러가 나니 둘 중에 편한 방법을 써야함
@WebServlet(name = "testMethodServlet",
			urlPatterns = "/testMethod", // 사용자의 요청이 무엇인지를 파악하고 그에 대한 동작을 정확하게 구현해줘야하는데
			// ...같은 주소에 대해서도 요청방식을 다르게 줄 수 있다
			// 이때 사용자가 우리가 만들어놓은 방식이 아닌 다른 방식으로 접근하면
			// 예를 들어, get만 만들어놨는데 다른 방식으로 접근하면 안된다고 알려줘야함(1)
			initParams = @WebInitParam(name = "name1", value = "value1"),
			loadOnStartup = 1)
			// loadOnStartup으로 필요할 때 만들어놓는게 아니라 서버 구동할때부터 적어놓은 숫자 순서대로 미리 만들어놓음
			// 숫자를 안써두면 의도한 순서대로 구동이 되지 않을 뿐 미리 만들어지긴 함...?
public class TestMethodServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿은 사용자의 요청에 한해서 없을 때 처음 1회 생성
		// init은 해당 서블릿을 생성할 때 호출 되는 메소드
		// config는 생성될 때의 설정값들이 들어있음
		System.out.println("해당 서블릿을 생성할 때 호출됩니다.");
		System.out.println("ServletConfig 객체는 설정한 init param에 접근가능합니다.");
		System.out.println(config.getInitParameter("name1"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
		resp.setStatus(405); // (1) 네가 요청을 하긴 했는데 나는 그 방식을 지원하지 않으니 한번 더 확인해봐라
		// 404는 없는 걸 찾으려고 할 때, 405(클라이언트가 보는 거)는 있긴한데 지원하지 않는 방식을 요청할 때
		// 200은 요청을 제대로 처리했다는 뜻
	}
	
}
