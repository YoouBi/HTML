<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<style>
	p.result1,p.result2{ 
	display: inline-block; 
	font-size:20px; 
	height:24px; 
	line-height: 24px; 
	border-right: 2px solid #fff; 
	padding-right: 2px; 
	box-sizing: border-box; 
	padding:0; 
	margin:5px; }
	
	p.cursor {animation: cursor 0.4s infinite;}
	
	 @keyframes cursor{ 
	      0%{border-right: 1px solid #fff} 
	      50%{border-right: 1px solid #000} 
	      100%{border-right: 1px solid #fff} 
	    }
	body::after{
		content :'';
	   	position : absolute;
	    	top : 0;
	    	left : 0;
	        width : 100%;
	        height : 100%;
	        background-color : rgba(0,0,0,0.5);}
	body * {
		z-index : 1;}  
</style>
<head>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<p class="result1" style="font-size: 20px; font-family: 'Noto Sans KR', sans-serif;"></p>
	<br>
	<strong><p class="result2" style="font-size: 20px; font-family: 'Noto Sans KR', sans-serif;"></p></strong>
</body>
<script>
	String.prototype.toKorChars = function() { 
	    var cCho = [ 'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' ], 
	    cJung = [ 'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ' ], 
	    cJong = [ '', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' ], cho, jung, jong; 
	    var str = this, 
	    cnt = str.length, 
	    chars = [], 
	    cCode; 
	    for (var i = 0; i < cnt; i++) { 
	        cCode = str.charCodeAt(i); 
	        
	        if (cCode == 32) { 
	          chars.push(" ");
	          continue;
	        }
	        
	        // 한글이 아닌 경우 
	        if (cCode < 0xAC00 || cCode > 0xD7A3) { 
	            chars.push(str.charAt(i)); 
	            continue; 
	        } 
	        cCode = str.charCodeAt(i) - 0xAC00; 
	
	        jong = cCode % 28; 
	        // 종성 
	        jung = ((cCode - jong) / 28 ) % 21;
	
	        // 중성 
	        cho = (((cCode - jong) / 28 ) - jung ) / 21;
	        // 초성 
	
	        //  테스트라는 문장이 있으면 ㅌ테ㅅ스ㅌ트 형식으로 저장되도록함 (타이핑을 위해서)
	        chars.push(cCho[cho]);
	        chars.push(String.fromCharCode( 44032 + (cho * 588) + (jung  * 28)));
	        if (cJong[jong] !== '') { 
	            chars.push(String.fromCharCode( 44032 + (cho * 588) + (jung  * 28) + jong ));
	        }
	    } 
	    return chars; 
	}
	
	
	// db길이 가져오기
	
	
	//타이핑할 문장
	/* for (var i = 1; i <= array.length; i++) {
		String varname = "result" + i;
		var varname = {}
	} */
	var result1  = `눈을 뜬 곳은 사방이 막혀있는 아주 좁은 공간이다.
	두줄이 될까?`;
	var result2  = "숨이 막힐 정도로 좁다.";
	var typeing1=[], typeing2=[];;
	result1 = result1.split(''); // 한글자씩자름
	result2 = result2.split(''); // 한글자씩자름
	
	//각글자 초성,중성,종성으로 나눔
	for(var i =0; i<result1.length; i++){
	    typeing1[i]=result1[i].toKorChars();
	}
	for(var i =0; i<result2.length; i++){
	    typeing2[i]=result2[i].toKorChars();
	}
	
	//출력할 엘리먼트요소 가져옴 
	var resultDiv1 = document.getElementsByClassName("result1")[0];
	var resultDiv2 = document.getElementsByClassName("result2")[0];
	
	//
	var text = "";
	var i=0; 
	var j=0; 
	
	//총글자수
	var imax1 = typeing1.length;
	var imax2 = typeing2.length;
	
	//setInterval을 이용해 반복적으로 출력 
	var inter = setInterval(typi,50);
	var inter2;
	
	document.addEventListener("keydown", spaceKey, true);
	
	function spaceKey(event) {
		setInterval(typing, 0);
	}
	
	function typi(){
	    //글자수만큼 반복후 종료 
	  resultDiv1.classList.add("cursor");
	    if(i<=imax1-1){
	        //각 글자가 초성 중성 종성 순서대로 추가되도록 
	        var jmax1 = typeing1[i].length;
	        resultDiv1.innerHTML = text + typeing1[i][j];
	        j++;
	        if(j==jmax1){
	            text+=  typeing1[i][j-1];//초성중성종성 순서대로 출력된 글자는 저장 ( 다음 글자와 이어붙이기 위해서 )
	            i++;
	            j=0;
	        }
	    } else{
	        clearInterval(inter);
	         text ="";
	        i=0;
	        j=0; 
	   setTimeout(function(){    
	      resultDiv1.classList.remove("cursor");
	      setTimeout(function(){             
	         resultDiv2.classList.add("cursor");
	         setTimeout(function(){
	            inter2 = setInterval(typi2,50);
	         },400);
	       },300);
	     },400);
	    }
	}
	
		function typi2(){
		    //글자수만큼 반복후 종료 
		
		    if(i<=imax2-1){
		        //각 글자가 초성 중성 종성 순서대로 추가되도록 
		        var jmax2 = typeing2[i].length;
		        resultDiv2.innerHTML = text + typeing2[i][j];
		        j++;
		        if(j==jmax2){
		            text+=  typeing2[i][j-1];//초성중성종성 순서대로 출력된 글자는 저장 ( 다음 글자와 이어붙이기 위해서 )
		            i++;
		            j=0;
		        }
		    } else{
		        clearInterval(inter);
		    }
		}
</script>
</html>