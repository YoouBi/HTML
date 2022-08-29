<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width: 760px;
	height: 40px;
}

.calum p {
	display: inline-block;
	width: auto;
	text-align: left;
	vertical-align: top;
}

.calum p:first-child {
	padding: 0 0 0 7px;
}

.calum p:nth-child(2) {
	padding: 0 240px;
}

.calum p:nth-child(3) {
	padding: 0 32px;
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
	margin: 0 0 0 7px;
	text-decoration-line: none;
}

.emphasis p:nth-child(3) {
	width: 95px;
}

.emphasis p:nth-child(4) {
	padding: 0 0 0 5px;
	width: 90px;
}

/* /////////////////////////바꾼 css ////////////////////////////*/
	
	table {
		border-top: 1px solid #b0c4de;
		border-collapse: collapse;
		border-spacing: 5px;
	}
	
	td{
		border-top: 0.5px solid #b0c4de;
		border-collapse: collapse;
		padding: 0 0 0 5px;
		text-align: center;
	}
	
	td:first-child {
		width: 50px;
	}
	
	td:nth-child(2) {
		width: 515px;
		text-align: left;
	}
	
	td:nth-child(2) a {
		color: black;
	}
	
	td:nth-child(2) a:link {
		text-decoration-line: none;
	}
	
	td:nth-child(3) {
		width: 95px;
	}
	
	td:last-child {
		width: auto;
	}
	
	.emptyRow>td {
		border-top: 1px solid #fff;
	}

/* ///////////////////////// 여기까지 바꾼 css ////////////////////////////*/

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

</style>
</head>
<body>
	<div class="sectionBox">
		<div class="titleName"><h1 id="titleh1">&nbsp;</h1></div>
		<hr>
		<div id="contentBox">
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
		</div>
		
		<!-- ////////////////////////////////////여기부터 테이블//////////////////////////////////////-->
		<table id="articleList" style="width: 770px; height: 480px">
			<tr>
				<td></td>
				<td>로딩중..</td>
				<td></td>
				<td></td>
			</tr>
		</table>
<!-- ////////////////////////////////////여기까지 테이블//////////////////////////////////////-->
		
		<div class="pagebtn">
			<p>&nbsp;</p>
		</div>
		</div>
	</div>
</body>
</html>