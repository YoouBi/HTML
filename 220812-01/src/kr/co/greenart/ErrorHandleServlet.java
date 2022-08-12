package kr.co.greenart;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorhandle")
public class ErrorHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> e = request.getAttributeNames();
		// request 객체의 모든 Attribute의 이름들을 Enumeration이라는 형태로 가져오는데
		// Enumeration는 iterator와 비슷함
		
		while (e.hasMoreElements()) { // 있으면 가져옴
			String name = e.nextElement();
			System.out.println(name + " : ");
			System.out.println(request.getAttribute(name));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
