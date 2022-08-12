package kr.co.greenart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editcookie")
public class EditCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c = new Cookie("yourname", "edit"); // 해당 이름의 쿠키의 값을 새롭게 변경
		resp.addCookie(c);
		// 쿠키는 사용자가 삭제할수도, 차단을 할 수도 있다
		// 브라우저에 저장되기 때문에 민감한 정보는 쓰지 않고,
		// 차단이 될 수도 있기 때문에 염두해두어야한다
		// 만약 쿠키가 필요하다면 해당 사이트의 쿠키를 허용하도록 명시해줄 것
		
		// 쿠키는 기간이 만료되었을 때 삭제됨
		Cookie c2 = new Cookie("korname", ""); // 보통은 값이 같이 전송되기 때문에 빈 문자열로 해둠
		c2.setMaxAge(0); // 초 단위로 기간 설정 가능 3600으로 써두면 1시간동안 가지고 있는 것
		
		resp.addCookie(c2);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
