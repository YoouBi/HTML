<%-- 
	jsp 페이지에
	사용자의 이름(name)과 나이(age), 성별(gender)을 입력받을 수 있는
	<form> 양식을 작성
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력 페이지</title>
</head>
<body>
<%-- method = "get"은 모든 정보를 주소창에 보여준다 --%>	
	<form action = "/hello2/requestinfo.jsp" method = "post" >
	<%-- post는 body에 정보를 담아온다 그래서 요청정보 길이는 바디의 길이값이고 포스트 내용은 못가져오니까 null
	전송 양식을 어떤 방식으로 했는지 이해할 수 없기때문에 한글은 깨진다
	한글을 입력하면 크롬에서 제대로 입력되어있는것처럼 보이지만 사실 그렇지 않다
	주소, 즉 URL은 한글을 표시할 수 없기 때문인데 크롬이 대충 %ED%95같은걸 보고 표현해준 것 뿐
	옛날 버전의 브라우저, 인터넷 익스플로러같은 경우에는 아예 깨져보일것이다
	보통 URL Encoding이라는 작업을 하는데 한글을 주소표현에서 담을 수 있게끔 변환하는 작업을 해주는 것이다
	서버에서 담는 건 %ED%95같은 문자이고 이걸 다시 원래 문자로 표현하는게 Decoding인데
	변환작업은 똑같은 약속을 지나야(지금 우리는 charset=UTP-8) 전의 문자 그대로 변환이 된다
	그래서 post에서도 똑같은 변환방식으로 지정해준다면 한글이 제대로 보일텐데(requestinfo.jsp참조(1)) --%>
		<label>이름 : <input type = "text" name = "name"></label>
		<label>나이 : <input type = "number" name = "age"></label>
		<label>성별 : 남성 <input type = "radio" name = "gender" value="male">
		여성<input type = "radio" name = "gender" value="female"></label>
		<label>자바<input type = "checkbox" name = "hobby" value = "java"></label>
		<label>하이퍼 텍스트 마크업 랭귀지<input type = "checkbox" name = "hobby" value = "html"></label>
		<label>캐스캐이딩 스타일 시트<input type = "checkbox" name = "hobby" value = "css"></label>
		<label>자바 스크립트<input type = "checkbox" name = "hobby" value = "javascript"></label>
		<input type = "submit" value= "입력 완료" />
	</form>
</body>
</html>