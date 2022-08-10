<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- servlet 클래스-> 컴팩...? ->...?
결과적으로는 jsp나 써블릿 클래스나 같다....? --%>
<%@page import="kr.co.greenart.CountryDAO"%>
<%@page import="kr.co.greenart.Country"%>
<%@page import="java.util.List"%>
<%
	String continent = request.getParameter("continent");
	CountryDAO dao = new CountryDAO();
	List<Country> list = dao.getCountryByContinent(continent);
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("result.jsp").forward(request, response);
%>