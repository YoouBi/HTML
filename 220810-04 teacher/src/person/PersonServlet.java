package person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 깨짐 -> 값 전달 방식을 post로 바꾸고 set utf-8!
		req.setCharacterEncoding("utf-8"); // 널 값일때는 톰캣이 정한 iso-88...영문자만 가능한 아스키코드
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String age = req.getParameter("age");		
		String email = req.getParameter("email");
		
		// 입력값이 유효한지?
		// 모든 값은 필수! 이름과 성 10자, 나이 정수, 이메일 고유 50자
		PersonValidator validator = new PersonValidator();
		Map<String, String> errors = new HashMap<String, String>();
//		Map<String, String> nameError = validator.isValiName(firstname, lastname);
//		Map<String, String> ageError = validator.isValiAge(String.valueOf(age));
//		Map<String, String> EmailError = validator.isValiEmail(email);
		errors.putAll(validator.isValiName(firstname, lastname));
		errors.putAll(validator.isValiAge(String.valueOf(age)));
		errors.putAll(validator.isValiEmail(email));
		
		if (errors.size() > 0) { // 에러가 한개라도 있으면 다시 form으로 돌아가게 만드는 흐름
			// 그러면 잘못된 값일 때 사용자에게 뭐라고 해야할지?
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("form.jsp").forward(req, resp);
		} else {
			PersonDAO dao = new PersonDAO();
			try {
				dao.insert(new Person(firstname, lastname, Integer.valueOf(age), email));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// 나중에 목록 페이지로 보낼 것
			resp.sendRedirect(req.getContextPath() + "/list");
		}
	}
}
