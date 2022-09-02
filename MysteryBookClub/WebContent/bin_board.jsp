<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Rubik+Dirt&display=swap"
	rel="stylesheet">
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

.main {
	text-align: center;
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

#bookResult {
	width: 230px;
	height: 410px;
	margin: 15px 0 0 0;
	font-size: 12px;
	line-height: 1.4;
}

#searchStart {
	margin: 3 0 0 0px;
	width: 30px;
	height: 25px;
	background-color: #add8e6;
	border: 0px;
	border-radius: 3px;
}

#searchStart:hover {
	background-color: #d3f1fc;
	color: #fff;
}

.bookTop {
	display: flex;
	width: 230px;
	height: 130px;
}

.bookTop img {
	margin: 15px 5px 5px 3px;
	width: 100px;
	height: 120px;
}

.bookTopText p {
	margin: 4px 0 0 0;
	vertical-align: top;
}

.bookTopText p:first-child {
	margin: 23px 0 0 0;
	font-weight: bolder;
}

.bookTopText p:nth-child(4) {
	color: #85A0C2;
	font-weight: bolder;
}

.buttom p:last-child {
	height: 280px;
	text-overflow: ellipsis;
	line-height: 1.8;
	text-align: left;
}

.timer {
	position: absolute;
	left: 1300px;
	top: -15px;
	width: 300px;
	height: 70px;
	font-size: 50px;
	text-align: center;
	width: 300px;
}

.onoff {
	position: absolute;
	left: 100px;
	top: 0px;
	width: 100px;
	height: 23px;
	text-align: center;
}
</style>
</head>

<header>
	<div class="headerBox">
		<button class="loadArticleBtn refresh" type="0">
			<i class="xi-redo icon"></i>
		</button>
	</div>
</header>
<body>
	<section>
		<div class="sectionBox" id="box">
			<div class="main">
				<!-- 첫화면 메인페이지 내용..사진같은거 넣어서 꾸미면 될 듯-->
				<h2>Mystery Book Club</h2>
			</div>
		</div>
		<div class="tab">
			<div>
				<a href="#">내 글 보기</a>
			</div>
			<hr>
			<div>
				<a href="#">공지사항</a>
			</div>
			<hr>
			<div>
				<a href="#" class="loadArticleBtn" type="3">주간도서</a>
			</div>
			<div>
				<a href="#" class="loadArticleBtn" type="4">가입인사</a>
			</div>
			<div>
				<a href="#" class="loadArticleBtn" type="5">자유게시판</a>
			</div>
			<div>
				<a href="#" class="loadArticleBtn" type="6">우리 모여요!</a>
			</div>
			<hr>
			<!-- <form action="#"> -->
			<input id="searchBook" type="text" placeholder="도서 검색"
				style="width: 110px; height: 19px;" />
			<button id="searchStart" type="submit">
				<i class="xi-search"></i>
			</button>
			<!-- </form> -->
			<div id="bookResult"></div>
			<div id="bookContent"></div>
		</div>
	</section>

	<!-- 타이머 -->
	<p class="timer" id="timers">긴급한 타이머 구동전</p>
	<input type="button" id="start" value="타이머 시작" />
	<!-- BGM ON,OFF -->
	<p class="onoff">
		BGM <input type="button" id="onoff" value="OFF" disabled="disabled" />
	</p>
</body>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	function showcontent(e) {
		//console.log($(e).attr("type"));
		$.ajax({
			url : "/MysteryBookClub/getArticle", // 클라이언트가 요청을 보낼 서버의 URL 주소
			type : "POST", // HTTP 요청 방식(GET, POST)
			data: {"contentinfo":$(e).attr("type")}
		}).done(function(json) {
			console.log(json);
			if(json.category == 2) {
				$("#titleName").html("<h1 id='titleh1'>공지사항</h1>");
			}
			$("#contentBox").load("content.jsp", json);
		}).fail(function() {
			alert("요청 실패");
		}); 
	}
	
	$(function() {
		var storyNum = 3; //임의설정 <- user정보에 있는거 넘겨받으면 됨!
		var storyNumRefresh = 8;
		var categoryNum = 0;
		var refresh = null;
		//게시글 불러오기 함수
		function loadArticle(category) { //게시판가는 버튼마다 attribute type값으로 categoryNum지정해놨음
			if(category.attr("type") !== "0") {
				console.log("누른 거 아냐?" + category.attr("type"));
				categoryNum = category.attr("type");//버튼 누른 애 특정하기
				refresh = "off";
			} else {
				var titleText = json.categoryText;
				refresh = "on";
			}
		
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
					
					console.log(json);
					const searchParams = new URLSearchParams(location.search); //파라미터 값만 가져오기
					
					console.log(json.currentPage + "currentPage");
					console.log(json.startPage > 5);
					console.log(json.noticeArticle.title + "일단 var추가");
					 if (json != null) {
						// 타이틀 텍스트부터 배치
						var title = "<h1 id='titleh1'>" + json.categoryText + "</h1>";
						$(".titleName").html(title);
						 
						var empLine = "<p>공지</p><a onclick='showcontent(this)' type='" + 2 
						+ "/" + json.noticeArticle.article_no + "/" + json.noticeArticle.title
						+ "/"+ json.noticeArticle.user_name + "/" + json.noticeArticle.record_date 
						+ "/" + json.noticeArticle.record_time + "' href='#' class='content'>" 
						+ json.noticeArticle.title + "</a><p>"
							+ json.noticeArticle.user_name + "</p><p>" + json.noticeArticle.record_date + "</p>";
						$(".emphasis").html(empLine);
						
						var line = "";
						var blankSize = 11 - json.content.length; //한페이지 게시글 11개 기준으로 설정함
						//console.log(blankSize);
						for (var k = 0; k < json.content.length; k++) {
							line += "<tr><td>" + json.content[k].article_no
						    + "</td><td><a onclick='showcontent(this)' type='" + categoryNum + "/" 
						    + json.content[k].article_no + "/" + json.content[k].title
						    + "/"+ json.content[k].user_name + "/" + json.content[k].record_date 
						    + "/" + json.content[k].record_time + "' href='#' class='content'>" 
						    + json.content[k].title 
						    + "</a></td><td>" + json.content[k].user_name 
						    + "</td><td>" + json.content[k].record_date + "</td></tr>";
						}
						
						//없는 게시글
						for (var i = 0; i < blankSize; i++) {
							line += "<div class='emptyRow'><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></div>";
						}
						
						var line2 = "";
						//페이징 처리 할 페이지 버튼 박스
						if(json.startPage > 5) {
							line2 += "<a href='#'>이전</a>";
						} else {
							for (var i = json.startPage; i <= json.endPage; i++) {
								line2 += "<a href='#' class='loadArticleBtn type='" + categoryNum + "' " ;
								if(i == json.currentPage) {
									line2 +="style='color:#99BBE7; font-weight:bold;'";
								}
								line2 += ">" + i + "</a>";
							}
							if(json.endPage < json.totalPages) {
								line2 += "<a href='#'>다음</a>";
							}
						}
						
						$("#articleList").html(line);
						//$(".pagebtn").html("<p>되는거 맞니</p>");
						$(".pagebtn").html(line2); //게시글 11개 이하일때 조건 줘야함
					} else { //이건 게시물 하나도 없을때.. 나중에 db채우고 나면 지워도됨
						var line = "";
						for (var i = 0; i < 11; i++) {
							line += "<div class='emptyRow'><tr><td>&nbsp;</td><td>&nbsp;</td>"
							+ "<td>&nbsp;</td><td>&nbsp;</td></tr></div>";
						}
						$(".titleName").html(title);
						$("#articleList").html(line);
						$(".pagebtn").html("<p>&nbsp;</p>");
					}
				 }).fail(function() {
					alert("요청 실패");
				}); 
		}
		// 지연 - 게시판이동 
		//효정 - 이동하고서 게시글 불러오기 by함수
		$(".loadArticleBtn").on("click", function() {
			var k = $(this);
			$("#box").load("free_article.jsp", function() {
				loadArticle(k);
			});
		});
		// 영빈 - 새로고침 ajax
		
		//효정 - 책검색하기위한 코드
		$("#searchStart").on("click", function() {
			var searchBook = $("#searchBook").val();
			$.ajax({
				url : "/MysteryBookClub/search", // 클라이언트가 요청을 보낼 서버의 URL 주소
				type : "POST", // HTTP 요청 방식(GET, POST)
				data: {"title":searchBook},   
				dataType : "json" // 서버에서 보내줄 데이터의 타입 
			}).done(function(json) {	
				//console.log(json.documents[0]);
				if (json.documents[0] != null) {
					const isbnArr = json.documents[0].isbn.split(" ");
					
					var tag = "<div class='bookTop'><img src=" + json.documents[0].thumbnail + "><div class='bookTopText'><p>";
					tag += json.documents[0].title + "</p><p>";
					tag += json.documents[0].authors + "</p><p>";
					tag += json.documents[0].publisher + "</p><p>isbn : ";
					tag += isbnArr[0] + "</p></div></div><div class='buttom'><p>"; // isbn 10자리는 인덱스 [0] 13자리는 [1]
					tag += json.documents[0].contents + "...(중략)</p></div>";
				} else {
					var tag = "<div class='bookTopText'><p>검색결과가 없습니다</p></div>";	
				}
				$("#bookResult").html(tag);
			}).fail(function() {
				alert("검색어를 입력하세요");
			});
		});
	});
	

//	대수 - 타이머 스크립트
	let start = document.getElementById("start"); // 타이머 시작 이벤트 가져옴
	let bgmOnOff = document.getElementById("onoff"); // BGM ON OFF 버튼

	let sec = 600;
	let time = sec;

	const bgm = new Audio();
	bgm.src = "./BGM/smooth-waters.mp3";

// 	타이머 실행 명령어
	start.addEventListener("click", function (e) {
		e.preventDefault;
		e.stopPropagation;
		if (time != sec) {
			return; // 첫 클릭에서만 타이머 실행
		}
		bgm.play();
		bgm.loop = true;
		bgmOnOff.removeAttribute("disabled"); // BGM 버튼 비활성화
		
		var interval = setInterval(() => {
			let h = parseInt(time / 60).toString();
			let m = (time % 60).toString();
			let timer = document.getElementById("timers");
			
			if (h.length < 2) {
				h = "0"+h;
			}
			if (m.length < 2) {
				m = "0"+m;
			};
			
			let timeover = h + " : " + m;
			if (time < 0) {
				bgm.pause();
				bgm.currentTime = 0;
				bgmOnOff.setAttribute("disabled", "disabled");
				
				timer.innerHTML = "TIME OVER!";
				time = sec;
				bgmOnOff.value = "OFF";
				clearInterval(interval); // 시간종료가 되면 종료됨, 멈춘상태에서 다시 누를경우 재실행
				return;
			} else {
				timer.innerHTML = timeover;
			}
			time--;
		}, 1000);
	});
	
	bgmOnOff.onclick = function() {
		let onoff = bgmOnOff.value;
		
		if (onoff === "OFF") {
			bgmOnOff.value = "ON";
			bgm.pause();
		} else {
			bgmOnOff.value = "OFF";
			bgm.play();
		}
	}
// 	여기까지 타이머

</script>
</html>