package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서블릿이 요청 객체를 다루기 전
		// 두필터 위에서 조작을 하면 서블릿이 전달받기 전
		System.out.println("두필터 전!!!!!");
		
		System.out.println("사용자가 겟 방식의 요청을 하였습니다. (게시판 목록)");

		System.out.println("세션값을 확인합시다");
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object loginid = session.getAttribute("loginid");

		if (loginid != null) {
		// 원래 흐름
		chain.doFilter(request, response);
		// 두필터를 수행하고 나서 서블릿이 요청을 처리하고 응답을 보내기 전.
		
		} else {
			System.out.println("로그인되지 않은 유저");
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			request.getRequestDispatcher("/loginPracWithSS/needlogin.jsp").forward(request, response);
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		System.out.println("두필터 후!!!!!!");
	}

}
