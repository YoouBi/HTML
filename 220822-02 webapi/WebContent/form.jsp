<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<form>
	<!-- 사용자가 일일이 submit 제출을 해서 읽는 건 불편하다
	따라서 버튼을 하나 눌러서 id 값 하나만 확인하고자하는데 이를 ajax라고 한다
	사용자가 자바스크립트로 요청을 보내는 기술인데 '비동기'로 일어난다
	사용자 화면에는 요청 흐름을 알 수 없게끔 보낼 수 있다 -->
		<input type="text" name="id" id="textid"/><button id="btnchk">아이디 중복확인</button>
		<input type="submit" />
	</form>
</body>
<script>
	let elem = document.getElementById("btnchk");
	elem.addEventListener("click", function (e) {
		e.preventDefault(); // 기본 설정되어있는 submit은 동작하지 않고
		e.stopPropagation(); // 이벤트 전달
		let textid = document.getElementById("textid").value;
		// alert("버튼 동작");
		
		if (!textid) {
			return;
		}
		
		fetch("http://localhost:8080/api/idcheck?id=" + textid)
			.then((resp) => resp.text())
			.then((json) => {
				let result = JSON.parse(json);
				if (result.duplicate) {
					alert("중복");
				} else {
					alert("사용 가능");
				}
			})
			.catch((e) => console.log(e));
	});
</script>
</html>