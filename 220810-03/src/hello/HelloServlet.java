package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private int some = 10; // 주의!!! 한명에 대한 값이 될 수 없음
	
	public HelloServlet() {
		super();
		System.out.println("헬로 서블릿 생성자는 언제 호출되나요?");
	}
	// hello를 부르면 생성될때 호줄되는데
	// 여러번 불렀다고 여러번 생성되는게 보이진 않음
	// 따라서 servlet 객체는 그때 하나 만들어놓고 그 이후에는 그걸로 계속 쓰는 것
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		some++;
		PrintWriter pw = resp.getWriter();
	    pw.println(req.getRequestURI());
	    pw.flush();
	    System.out.println("필드값 : " + some);
	    // 실행 흐름은 사용 요청을 할 때 여러번 만들어지는데
	    // 여러 사용자가 서블릿을 요청하면 상태에 대한 정확한 값을 얻어가기 힘들기 떄문에
	    // servlet이 상태를 가지면 구현하기 힘들어짐
	}
}