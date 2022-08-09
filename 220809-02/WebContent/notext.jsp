<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = 1 + 1;
	// response.sendRedirect("./viewPage.jsp?result=" + result);
	request.setAttribute("result", result);
	// response.sendRedirect("./viewPage.jsp");
	request.getRequestDispatcher("/WEB-INF/viewPage.jsp").forward(request, response);
	// 리다이렉트는 응답을 만드는데
	// 포워드는 응답을 만드는게 아니라 전달을 한다
	// Dispatcher는 포워드를 할 수 있는 이동을 할 수 있는 객체로 이동할 경로를 적어주고
	// 포워드 파라미터에 쓰던 요청 객체와 쓰던 응답 객체를 그대로 가지고 가라고 써줌
	// 주소창을 보면 요청한 페이지의 이름을 보고 있음을 알 수 있음
	// 요청한 페이지에서 흐름만 veiwPage로 넘어간 것
%>