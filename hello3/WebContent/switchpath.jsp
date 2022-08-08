<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 중간 페이지는 보여야 될게 없으니 나머지는 다 지우고 흐름만 제대로 작성해도 됨
	윗 부분도 지우고 싶었는데 주석 한글처리가 안돼서...남겨놓음... --%>
<% 
	String choice = request.getParameter("choice");

	if (choice == null || choice.length() == 0) {
		response.sendRedirect("./want.jsp?progress=failed");
		// 이 방법은 주소에 정보가 다 담겨서 사용자가 파람을 볼 수 있음
	} else if (choice.equals("persons")) {
		response.sendRedirect("./persons.jsp");
	} else if (choice.equals("fruit")) {
		response.sendRedirect("./fruit.jsp");
	}
%>