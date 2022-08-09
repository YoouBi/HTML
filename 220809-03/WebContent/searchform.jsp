<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 사용자가 대륙을 선택할 수 있게 --%>
	<%-- 선택한 대륙의 국가들의 이름, 인구를 내림차순으로 볼 수 있는 페이지 --%>
	<form action = "selectpopulation.jsp">
		<select name = "continent">
			<option value = "North America">North America</option>
			<option value = "Asia">Asia</option>
			<option value = "Africa">Africa</option>
			<option value = "Europe">Europe</option>
			<option value = "South America">South America</option>
			<option value = "Oceania">Oceania</option>
			<option value = "Antarctica">Antarctica</option>
		</select>
		<select name = "OrderBy">
			<option value = "Desc">Desc</option>
			<option value = "Asc">Asc</option>
		</select>
		<input type = "submit" />
	</form>
</body>
</html>