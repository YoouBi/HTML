<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용페이지</title>
	<style>
	
	#contentBox button {
		width: 80px;
		height: 30px;
		margin: 5px 0 0 0;
		background-color: #add8e6;
		border: 0px;
		border-radius: 3px;
		justify-content: center;
	}
	
	#contentBox button:hover {
		background-color: #d3f1fc;
		color: #fff;
	}
	
	.contentBox {
		width: 768px;
		border: 0.2px solid #85A0C2;
		border-radius: 5px;
	}
	
	.contentBox h2 {
		font-size: 20px;
		color: #85A0C2;
	}
	
	</style>
</head>
<body>
	<button onclick="showcontent(this)" 
	type="${ param.category }/${ param.articleNumBefore }">이전글</button>
	<button onclick="showcontent(this)" 
	type="${ param.category }/${ param.articleNumAfter }">다음글</button>
	<button class="loadArticleBtn" 
	type="${ param.category }">목록</button>
	<div class="contentBox">
		<h2>${ title }</h2>
		<p>글번호: ${ article_no }</p>		
		<p>작성자: ${ user_name }</p>
		<p>등록일: ${ record_date }</p>
		<p>등록시간: ${ record_time }</p>
		<p>내용: ${ content }</p>
		<input type="text">
		<input type="submit" value="등록"/>
	</div>
</body>
<script>
	$(document).ready(function(){
		jsonTest();
	})
	
	function jsonTest(){
		console.log(param.article.article_no);
	}
	
	
	function showcontent(e) {
		//console.log($(e).attr("type"));
		$.ajax({
			url : "/MysteryBookClub/getArticle", // 클라이언트가 요청을 보낼 서버의 URL 주소
			type : "POST", // HTTP 요청 방식(GET, POST)
			data: {"contentinfo":$(e).attr("type")}
		}).done(function(json) {
			//console.log(json);
			$("#contentBox").load("content.jsp", json);
		}).fail(function() {
			alert("요청 실패");
		}); 
	}
	
	$(function() {
		var storyNum = 2; //임의설정 <- user정보에 있는거 넘겨받으면 됨!
		var storyNumRefresh = 1;
		var categoryNum = 0;
		var refresh = null;
		//게시글 불러오기 함수
		function loadArticle(category) { //게시판가는 버튼마다 attribute type값으로 categoryNum지정해놨음
			if(category.attr("type") !== "0") {
				categoryNum = category.attr("type");//버튼 누른 애 특정하기
				refresh = "off";
			} else {
				var titleText = $("#titleh1").text();
				//categoryNum = json.parse("categoryNum");
				refresh = "on";
				if (titleText === "내 글 보기") {
					categoryNum = "1";
				} else if(titleText === "주간 도서") {
					categoryNum = "3";
				} else if(titleText === "가입 인사") {
					categoryNum = "4";
				} else if(titleText === "자유 게시판") {
					categoryNum = "5";
				} else if(titleText === "우리 모여요!") {
					categoryNum = "6";
				}
			}
		
			var title = "<h1 id='titleh1'>";
			if(categoryNum === "1") {
				title += "내 글 보기";
			} else if (categoryNum === "3") {
				title += "주간 도서";
			} else if (categoryNum === "4") {
				title += "가입 인사";
			} else if (categoryNum === "5") {
				title += "자유 게시판";
			} else if (categoryNum === "6") {
				title += "우리 모여요!";
			}
			title += "</h1>";
			
			console.log(title);
			//console.log(storyNum);
			 $.ajax({ 
					url : "/MysteryBookClub/getArticle", // 클라이언트가 요청을 보낼 서버의 URL 주소
					type : "GET", // HTTP 요청 방식(GET, POST)
					data: {"categoryNum":categoryNum,
							"storyNum":storyNum,
							"storyNumRefresh":storyNumRefresh,
							"refresh":refresh}, //5번이 free게시판임  
					dataType : "json" // 서버에서 보내줄 데이터의 타입 
				}).done(function(json) {
					//let jsonObj = JSON.parse(json);
					
					//console.log(document.getElementById("articleList").innerHTML);
					
					 if (json != null) {
						var empLine = "<p>공지</p><a onclick='showcontent(this)' type='" + 999 
						+ "/" + json.result[0].article_no + "/" + json.result[0].title
						+ "/"+ json.result[0].user_name + "/" + json.result[0].record_date 
						+ "/" + json.result[0].record_time + "' href='#' class='content'>" 
						+ json.result[0].title + "</a><p>"
							+ json.result[0].user_name + "</p><p>" + json.result[0].record_date + "</p>";
						$(".emphasis").html(empLine);
						
						var line = "";
						var blankSize = 11 - json.result.length; //한페이지 게시글 11개 기준으로 설정함
						//console.log(blankSize);
						for (var k = 1; k < json.result.length; k++) {
							line += "<tr><td>" + json.result[k].article_no
						    + "</td><td><a onclick='showcontent(this)' type='" + categoryNum + "/" 
						    + json.result[k].article_no + "/" + json.result[k].title
						    + "/"+ json.result[k].user_name + "/" +json.result[k].record_date 
						    + "/" + json.result[k].record_time + "' href='#' class='content'>" 
						    + json.result[k].title 
						    + "</a></td><td>" + json.result[k].user_name 
						    + "</td><td>" + json.result[k].record_date + "</td></tr>";
						}
						
						//없는 게시글
						for (var i = 0; i < blankSize; i++) {
							line += "<div class='emptyRow'><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></div>";
						}
						
						var line2 = "<c:if test='${ articlePage.startPage > 5 }'>"
							+ "<a href='list.do?pageNo=${ articlePage.startPage - 5 }' class='before'>이전</a></c:if>"
							+ "<c:forEach var='pNo' begin='${ articlePage.startPage }' end='${ articlePage.endPage }'>"
							+ "<c:if test='${ articlePage.hasArticles() }'><a href='list.do?pageNo=${ pNo }'> [${ pNo }] </a></c:if>"
							+ "</c:forEach>"
						 	+ "<c:if test='${ articlePage.endPage < articlePage.totalPages }'>"
							+ "<a href='list.do?pageNo=${ articlePage.startPage + 5 }' class='after'>다음</a></c:if>";
						
						$(".titleName").html(title);
						$("#articleList").html(line);
						$(".pagebtn").html(line2); //게시글 11개 이하일때 조건 줘야함
					} else { //이건 게시물 하나도 없을때.. 나중에 db채우고 나면 지워도됨
						var line = "";
						for (var i = 0; i < 11; i++) {
							line += "<div class='emptyRow'><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></div>";
						}
						$(".titleName").html(title);
						$("#articleList").html(line);
						$(".pagebtn").html("<p>&nbsp;</p>");
					}
				 }).fail(function() {
					alert("요청 실패");
				}); 
		}
		
		$(".loadArticleBtn").on("click", function() {
			$("#sectionBox").load("free_article.jsp");
			loadArticle($(this));
		});
</script>
</html>