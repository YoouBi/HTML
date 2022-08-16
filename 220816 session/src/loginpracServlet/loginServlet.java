package loginpracServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginservice")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		if (pw != null && pw.equals("qwer")) {
			HttpSession session = request.getSession();
			session.setAttribute("loginid", id);
		}
		
		request.getRequestDispatcher("./loginPracWithSS/loginresult.jsp").forward(request, response);
	}

}
