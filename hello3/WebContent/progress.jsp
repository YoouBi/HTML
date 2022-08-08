<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<p>로그인 처리 요청이 전달되었나요?</p>
	<% 
		String id = request.getParameter("userid");
	
		// 해당 파라미터 값이 전달이 되었으나 입력값이 없으면 ""
		// 없는 파라미터의 값을 달라고 요청하면 null
		
		// 입력값이 있으면 xx님 반갑습니다.
		if (id.length() > 0) {
			out.println(id + "님 방가");
		} else {
			out.println("입력해주세요.");
			response.sendRedirect("./login.jsp");
			// 사용자가 요청을 보내면 서버(톰캣)이 jsp요청을 한 결과로 progress 페이지를 읽어간다
			// 버퍼에 있는 흐름을 쏴주는데, 제대로 된 요청이 없을 경우에는
			// 출력 버퍼에 있는 걸 안 내보내고 '여기로 리다이렉트 해라'는 응답을 보낸다
			// 브라우저가 그걸 보고 전달받은 주소로 '새 요청'을 보낸다
		}
	%>
	
</body>
</html>