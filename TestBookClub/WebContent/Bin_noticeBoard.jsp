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
			font-size: 26px;
			margin: 55px 0 0 0;
			border: 0;
			color: #464964;
		}
		
		.sectionBox hr {
			margin: 5px 80px 0 0;
			border-color: #464964;
		}
		
		/*
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
		} */
		
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
		<div class="sectionBox" id="sectionBox">
		</div>
		<div class="tab">
			<div><a href="">내 글 보기</a></div>
			<hr>
			<div><a href="">공지사항</a></div>
			<hr>
			<div><a href="">주간 도서</a></div>
			<div><a href="">가입 인사</a></div>
			<div><a href="" id="free_article">자유 게시판</a></div>
			<div><a href="">우리 모여요!</a></div>
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
      $("#free_article").on("click", function() {
         $("#sectionBox").load("AriticleFormat.jsp");
      });
   });

</script>

</html>