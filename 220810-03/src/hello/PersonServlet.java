package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		
		PersonDAO dao = new PersonDAO();
		
		if(page.equals("list")) {
			List<persons> list = null;
			
			try {
				list = dao.getPerson();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			req.setAttribute("personlist", list);
			req.getRequestDispatcher("personResult.jsp").forward(req, resp);
		}
		
	}
}
