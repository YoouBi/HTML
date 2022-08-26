<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터보내기</title>
</head>
<body>
	<button id="free">free</button>
	<p id="output"></p>
	
</body>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		$("#free").on("click", function() {
			$.ajax({
				url : "/MysteryBookClub/jsonServlet2", // 클라이언트가 요청을 보낼 서버의 URL 주소
				type : "POST", // HTTP 요청 방식(GET, POST)
				data: {storyNum:1,
						categoryNum:5},   
				dataType : "json" // 서버에서 보내줄 데이터의 타입
			}).done(function(json) {
				alert("요청 성공");
				console.log(json);
				console.log(json.result);
				console.log(json.result[0]);
				toBoard(json.result[0]);
				toBoard(json.result[1]);
				toBoard(json.result[2]);
				toBoard(json.result[3]);
			}).fail(function() {
				alert("요청 실패");
			}).always(function() {
				alert("요청 완료");
			});
		});
		function toBoard(article) {
			$("#output").append(article.article_no + "<br>" + article.user_name + "<br>" + article.title + "<br>" + article.content + "<br>" + article.record_time + "<br>");
		}
	});
</script>
</html>