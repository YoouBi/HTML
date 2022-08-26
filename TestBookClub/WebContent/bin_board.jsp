<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			margin: 6px 0 0 3px;
			width: 30px;
			height: 30px;
			background-color: #a7c9f3;
			border: 0px;
			border-radius: 16px;
		}
		
		.headerBox button:hover {
			background-color: #cee2fc;
		}
		
		.headerBox i {
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
		
		.tab {
			margin: 45px 25px 0 0;
			float: left;
			width: 200px;
			height: 800px;
			text-align: center;
			line-height: 30px;
		}
		
		.tab>hr {
			width: 230px;
			height: 0.5px;
			border: 0.2px solid #b0c4de;
		}
		
		.tab a {
			color: #464964;
			padding: 0 0 0 15px;
		}
		
		.tab a:link {
			color: #464964;
			text-decoration-line: none;
		}
		
		.tab form {
			padding: 0 0 0 25px;
		}
		
		.tab input[type="text"]:focus {
			border: 2px solid #add8e6;
			border-radius: 3px;
			outline: none;
		}
		
		.searchBtn {
			margin: 3 0 0 0px;
			width: 30px;
			height: 25px;
			background-color: #add8e6;
			border: 0px;
			border-radius: 3px;
		}
		
		.searchBtn:hover {
			background-color: #d3f1fc;
			color: #fff;
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
		<div class="sectionBox" id="box">
			<h1>자유 게시판</h1>
			<hr>
			<div class="writebtn"><button class="writebtn" onclick="location.href='write.do'">글쓰기</button></div>
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
					<p>게시글이 없습니다. 여기 주황색 선은 게시글 들어갈 부분 표시만 해놓은 것이니 border 색 없애면 돼요!</p>
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
			<div class="pagebtn">
				<c:if test="${ articlePage.startPage > 5 }">
					<a href="list.do?pageNo=${ articlePage.startPage - 5 }" class="before">이전</a>
				</c:if>
				<c:forEach var="pNo" begin="${ articlePage.startPage }"
					end="${ articlePage.endPage }">
					<c:if test="${ articlePage.hasNoArticles() }">
							0
					</c:if>
					<c:if test="${ articlePage.hasArticles() }">
						<a href="list.do?pageNo=${ pNo }">
							[${ pNo }]
						</a>
					</c:if>
				</c:forEach>
				<c:if test="${ articlePage.endPage < articlePage.totalPages }">
					<a href="list.do?pageNo=${ articlePage.startPage + 5 }" class="after">다음</a>
				</c:if>
			</div>
		</div>
		<div class="tab">
			<div><a href="">내 글 보기</a></div>
			<hr>
			<div><a href="">공지사항</a></div>
			<hr>
			<div><a href="#" id="requestBtn1">주간도서</a></div>
			<div><a href="#" id="requestBtn2">가입인사</a></div>
			<div><a href="#" id="requestBtn3">자유게시판</a></div>
			<div><a href="#" id="requestBtn4">우리 모여요!</a></div>
			<hr>
			<form action="">
				<input type="text" name="searchBook" placeholder="도서 검색" style="width:110px;height:19px;" />
				<button type="submit" class="searchBtn"><i class="xi-search"></i></button>
			</form>
		</div>
	</section>
</body>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function() {
		$("#requestBtn1").on("click", function() {
			$("#box").load("week_article.jsp");
		});
		$("#requestBtn2").on("click", function() {
			$("#box").load("hello_article.jsp");
		});
		$("#requestBtn3").on("click", function() {
			$("#box").load("free_article.jsp");
		});
		$("#requestBtn4").on("click", function() {
			$("#box").load("meet_article.jsp");
		});
	});
</script>
</html>