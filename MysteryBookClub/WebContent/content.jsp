<%@page import="com.fasterxml.jackson.annotation.JsonAlias"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용페이지</title>
	<style>	
	#contentBox {
		width: 800px;
		height: 600px;
		overflow: auto;
	}
	
	#contentBox::-webkit-scrollbar {
		background-color: #F8F8FF;
		border-radius: 5px;
	}
	
	#contentBox::-webkit-scrollbar-thumb {
		background-color: #d3f1fc;
		border-radius: 5px;
	}
	
	#contentBox button {
		height: 30px;
		justify-content: center;
	}
	
	#contentBox button:hover {
		background-color: #d3f1fc;
		color: #fff;
	}
	
	.beforeBtn {
		margin: 5px -6px 0 620px;
		background-color: #fff;
		border: 0.4px solid #add8e6;
		border-right: none;
		border-radius: 5px 0 0 5px;
	}
	
	.afterBtn {
		background-color: #fff;
		border: 0.4px solid #add8e6;
		border-radius: 0 5px 5px  0 ;
	}
	
	.beforeBtn:active,.afterBtn:active {
		background-color: #fff;
		color: #black;
		box-shadow: inset 1px 1px 2px 2px #add8e6;
	}
	
	.listBtn {
		height: 30px;
		background-color: #add8e6;
		border: 0px;
		border-radius: 5px;
	}
	
	.listBtn:hover {
		background-color: #d3f1fc;
		color: #fff;
	}
	
	.listBtn:active {
		background-color: #72bcd4;
		color: #fff;
		box-shadow: inset 1px 1px 2px 2px #286e84;
	}
	
	.contentBox {
		width: 768px;
		margin: 0 0 25px 0;
		line-height: 5px;
		<!-- border: 0.2px solid #85A0C2;
		border-radius: 5px; -->
	}
	
	.contentBox h2 {
		margin: 20px 0 15px 0;
		font-size: 23px;
		color: #85A0C2;
	}
	
	.userAndDate {
		height: 30px;
		display: flex;
		align-items: flex-end;
	}
	
	.userAndDate p {
		font-size: 13px;
	}
	
	.userAndDate p:first-child {
		font-size: 17px;
	}
	
	.userAndDate p:nth-child(2) {
		padding: 0 7px;
	}
	
	.contents {
		height: auto;
		line-height: 25px;
	}
	
	.commentBox {
		width: 760px;
		padding: 15px 5px;
		background-color: #F8F8FF;
		border-radius: 8px;
	}
	
	.commentField {
		width: 700px;
	}
	
	</style>
</head>
<body>
<% 
int articleNumBefore = Integer.valueOf(request.getParameter("article_no")) - 1;
int articleNumAfter = Integer.valueOf(request.getParameter("article_no")) + 1;
%>
	
	<button class="beforeBtn" onclick="showcontent(this)" 
	type="${ param.category }/<%= articleNumBefore %>">이전글</button>
	<button class="afterBtn" onclick="showcontent(this)" 
	type="${ param.category }/<%= articleNumAfter %>">다음글</button>
	<button class="loadArticleBtn listBtn" type="5">목록</button>
	<div class="contentBox">
		<h2>${ param.title }</h2>
		<div class="userAndDate"><p><strong>${ param.user_name }</strong></p>
		<p>${ param.record_date }</p>
		<p>${ param.record_time }</p></div>
		<p class="contents">${ param.content }</p>
	</div>
	<div class="commentBox">
		<i class="xi-message-o">댓글</i>
		<input type="text" class="commentField">
		<input type="submit" class="listBtn" value="등록"/>
	</div>
</body>
</html>