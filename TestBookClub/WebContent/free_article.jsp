<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Rubik+Dirt&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>자유게시판</title>
<style>
.sectionBox {
	margin: 0 30px 0 30px;
	float: left;
	width: 850px;
}

.sectionBox h1 {
	margin: 55px 0 0 0;
	border: 0;
	color: #464964;
}

.sectionBox hr {
	margin: 5px 80px 0 0;
	border-color: #464964;
}

.writebtn {
	display: flex;
	flex-direction: row-reverse;
}

.writebtn button {
	width: 80px;
	height: 30px;
	margin: 12px 80px 0 40px;
	padding: 5px;
	background-color: #add8e6;
	border: 0px;
	border-radius: 3px;
	justify-content: center;
}

.writebtn button:hover {
	background-color: #d3f1fc;
	color: #fff;
}

.calum {
	width: 755px;
	height: 40px;
}

.calum p {
	display: inline-block;
	width: auto;
	text-align: left;
	vertical-align: top;
}

.calum p:first-child {
	padding: 0 0 0 5px;
}

.calum p:nth-child(2) {
	padding: 0 240px;
}

.calum p:nth-child(3) {
	padding: 0 30px;
}

.emphasis {
	width: 770px;
	height: 40px;
	margin: 5px 0 0 0;
	background-color: #F8F8FF;
	text-align: left;
	align-items: center;
}

.emphasis p {
	display: inline-block;
	width: auto;
	text-align: center;
}

.emphasis p:first-child {
	margin: 3px 0 0 5px;
	width: 45px;
	height: 20px;
	background-color: #FFCD82;
	border: 0.4px solid #f6b65a;
	border-radius: 3px;
}

.emphasis a {
	display: inline-block;
	width: 520px;
}

.emphasis a:link {
	text-decoration-line: none;
}

.emphasis p:nth-child(3) {
	background-color: #d3f1fc;
	width: 95px;
}

.emphasis p:nth-child(4) {
	width: 80px;
}

.noticeList {
	width: 770px;
	height: 480px;
	border: 0.4px solid #FFCD82;
}

.pagebtn {
	text-align: center;
	padding: 0 110px 0 0;
}

.pagebtn a:link {
	text-decoration-line: none;
}

.before {
	color: #99bbe8;
	font-weight: bold;
}

.after {
	color: #99bbe8;
	font-weight: bold;
}


/* /////////////////////////바꾼 css ////////////////////////////*/
	table, td {
		border: 1px solid white;
		border-collapse: collapse;
		background-color: #FFCD82;
	}
	
	td {
		padding: 5px;
	}
	
	table {
		border-spacing: 5px;
	}

/* ///////////////////////// 여기까지 바꾼 css ////////////////////////////*/
</style>
</head>
<body>
	<div class="sectionBox">
		<h1>자유게시판</h1>
		<hr>
		<div class="writebtn">
			<button class="writebtn" onclick="location.href='write.do'">글쓰기</button>
		</div>
		<div class="calum">
			<p>글번호</p>
			<p>제목</p>
			<p>작성자</p>
			<p>작성날짜</p>
		</div>
		<div class="emphasis">
			<p>공지</p>
			<a href="">공지 알려드립니다.</a>
			<p>누구누구</p>
			<p>무슨시간</p>
		</div>
		<div class="noticeList">
			<c:if test="${ articlePage.hasNoArticles() }">
			
		<!-- ////////////////////////////////////여기부터 테이블//////////////////////////////////////-->
			
				<table style="width: 770px; height: 480px">
					<tr>
						<td>12</td>
						<td><a href="">게시글제목제목제목제목제목임</a></td>
						<td>갓예슬</td>
						<td>220826</td>
					</tr>
					<tr>
						<td>11</td>
						<td><a href="">게시글제목제목제목제목제목제목제목제목임</a></td>
						<td>갓예슬</td>
						<td>220826</td>
					</tr>
					<tr>
						<td>10</td>
						<td><a href="">게시글제목제목제목제목임</a></td>
						<td>갓예슬</td>
						<td>220826</td>
					</tr>
					<tr>
						<td>9</td>
						<td><a href="">게시글제목제목제목임</a></td>
						<td>김지연</td>
						<td>220823</td>
					</tr>
					<tr>
						<td>8</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>7</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>6</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>5</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>4</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>3</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="">제목 대충 적은거</a></td>
						<td>킹효정</td>
						<td>220821</td>
					</tr>
				</table>
				
				
				
<!-- ////////////////////////////////////여기까지 테이블//////////////////////////////////////-->
			</c:if>
			<c:forEach var="article" items="${ articlePage.content }">
				<p class="number">${ article.number }</p>
				<a
					href="read.do?no=${ article.number }&pageNo=${ articlePage.currentPage }">
					<c:out value="${ article.title }"></c:out>
				</a>
				<p>${ article.writer.name }</p>
				<p>${ article.readTime }</p>
			</c:forEach>
		</div>
		<div class="pagebtn">
			<c:if test="${ articlePage.startPage > 5 }">
				<a href="list.do?pageNo=${ articlePage.startPage - 5 }"
					class="before">이전</a>
			</c:if>
			<c:forEach var="pNo" begin="${ articlePage.startPage }"
				end="${ articlePage.endPage }">
				<c:if test="${ articlePage.hasNoArticles() }">
						0
				</c:if>
				<c:if test="${ articlePage.hasArticles() }">
					<a href="list.do?pageNo=${ pNo }"> [${ pNo }] </a>
				</c:if>
			</c:forEach>
			<c:if test="${ articlePage.endPage < articlePage.totalPages }">
				<a href="list.do?pageNo=${ articlePage.startPage + 5 }"
					class="after">다음</a>
			</c:if>
		</div>
	</div>
</body>
</html>