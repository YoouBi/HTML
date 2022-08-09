<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String alphabet = request.getParameter("alphabet");

	// 입력값에 따라 페이지 이동
	// a페이지 : 현재 서버 시간 표시
	// b페이지 : 현재 서버 날짜 표시
	// c페이지 : 랜덤 정수 숫자 표시
	LocalDate date = LocalDate.now();
	LocalTime time = LocalTime.now();
	Random ran = new Random();
	String result = "";
	String pageAlphabet = "";
	int ranNum = ran.nextInt();	

	if(alphabet.equals("a")) {
		/* request.setAttribute("result", LocalTime.now());
		request.getRequestDispatcher("A.jsp").forward(request, response); */
		
		// 첨에 내가 한 방식...;ㅅ;
		result = "현재 서버의 시간 : " + time.getHour() + "시" + time.getMinute() + "분";
		pageAlphabet = "A.jsp";
		
// 		response.sendRedirect("A.jsp");
	} else if (alphabet.equals("b")) {
		request.setAttribute("result", LocalDate.now());
		request.getRequestDispatcher("B.jsp").forward(request, response);
		
		/* result = "현재 서버의 날짜 : " + date.getMonthValue() + "월" + date.getDayOfMonth() + "일";
		pageAlphabet = "B.jsp"; */
		
// 		response.sendRedirect("B.jsp");
	} else if (alphabet.equals("c")) {
		request.setAttribute("result", ran.nextInt());
		request.getRequestDispatcher("C.jsp").forward(request, response);
		
		/* result = "랜덤한 정수 숫자 : " + ranNum;
		pageAlphabet = "C.jsp"; */
		
// 		response.sendRedirect("C.jsp");
	}
	
	request.setAttribute("result", result);
	request.getRequestDispatcher(pageAlphabet).forward(request, response);
	
%>