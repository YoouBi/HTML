package kr.co.greenart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 논리적인 제어 흐름을 servlet에 위치시킴
public class CountryServlet extends HttpServlet {
	// 파라미터로 받는 두개는 jsp에서 사용했던 기본객체 request와 response
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter pw = resp.getWriter();
//		pw.println("Hello Servlet");
		
//		pw.println("<!DOCTYPE html>");
//		pw.println("<html>");
//		pw.println("<head><meta charset = 'utf-8' /></head>");
//		pw.println("<body><h1>hello servlet</h1></body>");
//		// 표현하는게 힘들어서 보통 서블렛으로 사용자가 보는 view를 담당하진 않는다 화면은 jsp가 담당
//		pw.flush();
		
		// servlet은 요청 주소에 요청 흐름 제어
//		req.setAttribute("title", "서블릿에서 설정한 제목");
//		req.setAttribute("message", "서블릿에서 설정한 메시지");
//		req.getRequestDispatcher("messageoutput.jsp").forward(req, resp);
		
		String continent = req.getParameter("continent");
		CountryDAO dao = new CountryDAO();
		List<Country> list = null;
		try { // 헤더가 부모껄로 정의되어있어서 던지지 못함
			list = dao.getCountryByContinent(continent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}