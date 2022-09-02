<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>프롤로그 첫번째</title>
<style>
body {
	width: 90vw;
	height: 90vh;
}

.text_box {
	position: relative;
	padding: 20px;
	left: 50vw;
	top: 50vh;
	width: 900px;
	height: 700px;
	background-color: black;
	font-size: 1.2rem;
	text-align: left;
	z-index: 999;
	transform: translate(-50%, -50%);
}
.text_box h1 {
	padding: 0 0 0 20px;
	font-size: 1.5rem;
	color: #D3D3D3;
}
.txt{
	padding: 0 0 0 40px;
}

.text {
	color: #D3D3D3;
}

.next_btn {
	position: absolute;
	text-align: center;
	padding: 2px 6px;
	left: 90%;
	top: 95%;
}

.prev_btn{
	position: absolute;
	text-align: center;
	padding: 2px 6px;
	left: 80%;
	top: 95%;
}

.photo_horizontal{
	width: 700px;
	display: flex;
}

.photo {
	width: 180px;
	height: 400px;
	flex: 1;
}

.explain{
	display:none;
}

.photo:hover .explain{
	display: block;
	position: absolute;
	font-size:18x; 
	color:#fff; 
	background:red;
	line-height:40px; 
	width:900px;
	height:200px;
	margin-top:30px;
	color:#D3D3D3;
}

.explain:nth-child(2) {
	left: 20px;
	top: 500px;
	z-index: 3;
}

</style>
</head>

<body>
	<div class="text_box">
	<h1>프롤로그</h1>
		<div class="txt">
			<span class="text"></span>
		</div>
	
	<div class="photo_horizontal">
	
		<div class="photo" > 
		 	<img class="photo1" src="men3.png">
		 	<div class="explain">
			 	<p><strong>한정우</strong><br><br>
				이 사람은 TV에도 몇 번 출연한 적 있는 아주 잘나가는 피부과 전문의다.<br>
				게다가 얼굴도 나름 잘생겼다.<br>
				어린 나이에 전문의 타이틀을 단 데다가, 아버지가 국회의원이라던가.<br>
				<br>
				묘하게 사람들에게 거리를 둔다. 특히 나와 다른 한명에게.<br>
				독서 모임에 꽤 오래 나왔다고 한다.</p>
			</div>
		 </div>
		 <div class="photo" > 
		 	<img class="photo1" src="men3.png">
		 	<div class="explain">
		 		<p><strong>배준석</strong><br><br>
				이 사람도 TV나 SNS에서 자주 얼굴을 보던 사람이다.<br>
				잘생긴 보험설계사에다가 성공한 프로 N잡러라고 하던가.<br>
				호스트 바도 운영중이라고 한다.<br>
				24시간을 어떻게 사는 지 모를 정도로 바빠보이던데<br>
				독서 모임은 꼬박꼬박 나오는 모양이다.<br>
				이곳에서 얻을 수 있는 게 많으니까.</p>
			</div>
		</div>
		<div class="photo" > 
		 	<img class="photo1" src="men3.png">
		 	<div class="explain">
		 		<p><strong>최지예</strong><br><br>
			너튜브와 타위치에서 엄청나게 유명한 먹방 BJ인 먹찡이라고 한다.<br>
			그런걸 잘 몰라서 몰랐는데, 매번 독서 모임때마다<br>
			사인을 요청하는 사람, 사진 같이찍어달라고 요청하는 사람들이<br>
			엄청나게 많은 걸 보면 인기가 실감된다.<br>
			아무래도 얼굴도 되게 예쁘고 그러니까...<br></p>
			</div>
		</div>
		<div class="photo" > 
		 	<img class="photo1" src="men3.png">
		 	<div class="explain">
		 	<p><strong>차미라</strong><br><br>
			이 사람은 우리 출판사에서 계간지를 내기 위해<br>
			몇 번 찾아가 인터뷰를 요청했던 사람이다.<br>
			모두 거절당했지만.<br>
			해외에서도 활약하고 있는 개발자로 유명한 사람이라던데.<br>
			이런 곳에서 만나서 의외였다.</p>
			</div>
		</div>
		<div class="photo" > 
		 	<img class="photo1" src="men3.png">
		 	<div class="explain">
		 	<p><strong>내 친구 오미연</strong><br><br>
			미연이는 자수성가해서 성공한 헤어디자이너로,<br>
			서울 곳곳에 자기 이름으로 된 숍을 여러 개 가지고 있다.<br>
			연예인들이 머리와 메이크업을 다 미연이네 가게에서 한다고 한다.<br>
			TV에도 SNS에서도 엄청 유명하다.<br>
			곧 결혼을 앞두고 있다.</p>
			</div>
		</div>
		
	 </div>
	 
		<input type="button" class="prev_btn" id="prev_btn" value="이전페이지" onclick="location.href='./prolog_05.jsp'">
		<input type="button" class="next_btn" id="next_btn" value="다음페이지" onclick="location.href='./prolog_07.jsp'">
	</div>
</body>
</html>
