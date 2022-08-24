<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Rubik+Dirt&display=swap" rel="stylesheet">
	<meta charset="UTF-8">
	<title>게시판</title>
	<style>
	
		body {
			background-color: #F8F8FF;
		}
	
		.headerBox {
			margin: 50px 0 0 80px;
			width: 1200px;
			height: 40px;
			background-color: #a7c9f3;
			border: 0.4px solid #464964;
			border-bottom: none;
			border-radius: 5px 5px 0 0;
		}
		
		.headerBox button {
			background-color: #a7c9f3;
			border: 0px;
		}
		
		.headerBox i {
			margin: 8px 0 0 3px;
			border-radius: 0 0 5px 5px;
			font-size: 20px;
			color: #fff;
		}
		
		section {
			margin: 0 0 0 80px;
			width: 1200px;
			height: 800px;
			border: 0.4px solid #464964;
			background-color: #fff;
		}
		
		.sectionBox {
			margin: 0 0 0 60px;
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
		
		.calum {
			padding: 25px 25px 0 0;
			width: 800px;
		}
		
		.calum p {
			width: 120px;
			float: left;
			text-align: center;
		}
		
		.calum button {
			width: 80px;
			height: 30px;
			margin: 12px 0 0 40px;
			padding: 3px;
			background-color: #add8e6;
			border: 0.1px solid #add8e6;
			border-radius: 3px;
		}
		
		.emphasis {
			width: 770px;
			background-color: #F8F8FF;
			text-align: left;
		}
		
		.emphasis p:first-child {
			margin: 3px 0 0 5px;
			text-align: left;
			width: 45px;
			height: 20px;
			background-color: #FFCD82;
			border: 0.4px solid #f6b65a;
			border-radius: 3px;
			text-align: center;
		}
		
		.emphasis P:nth-child(2) {
			
			width: 725px;
		}
		
		.tab {
			margin: 50px 25px 0 0;
			float: left;
			width: 200px;
			height: 800px;
			text-align: center;
			line-height: 40px;
		}
		
		.tab>hr {
			width: 230px;
			height: 0.5px;
			border: 0.2px solid #b0c4de;
		}
		
		.tab>hr:nth-child(2) {
			height: 0.5px;
			border: 0.2px solid #b0c4de;
		}
		
		.tab a {
			padding: 0 0 0 15px;
		}
		
		.tab a:link {
			color: #464964;
			text-decoration-line: none;
		}
		
		.searchBtn {
			margin: 3 0 0 0px;
			width: 30px;
			height: 25px;
			background-color: #add8e6;
			border: 0px;
			border-radius: 3px;
		}
		
	</style>
</head>

<header>
	<div class="headerBox">
		<button><i class="xi-redo icon"></i></button>
	</div>
</header>
<body>
	<section>
		<div class="sectionBox">
			<h1>자유 게시판</h1>
			<hr>
			<div class="calum">
				<p>글번호</p>
				<p>제목</p>
				<p>작성자</p>
				<p>작성시간</p>
				<button>글쓰기</button>
			</div>
			<div class="emphasis">
				<p class="notice">공지</p>
				<p>~ !! ~</p>
			</div>
			<c:if test="${ articlePage.hasNoArticles() }">
				<p>게시글이 없습니다.</p>
			</c:if>
			<c:forEach var="article" items="${ articlePage.content }">
				<p class="number">${ article.number }</p>
				<a href="read.do?no=${ article.number }&pageNo=${ articlePage.currentPage }">
					<c:out value="${ article.title }"></c:out>
				</a>
				<p>${ article.writer.name }</p>
				<p>${ article.readTime }</p>
			</c:forEach>
		</div>
		<div class="tab">
			<div><a href="">내 글 보기</a></div>
			<hr>
			<div><a href="">주간 도서</a></div>
			<div><a href="">가입 인사</a></div>
			<div><a href="">자유 게시판</a></div>
			<div><a href="">우리 모여요!</a></div>
			<hr>
			<form action="">
				<input type="text" name="searchBook" placeholder="도서 검색" style="width:110px;height:19px;" />
				<button type="submit" class="searchBtn"><i class="xi-search"></i></button>
			</form>
		</div>
	</section>
</body>
</html>