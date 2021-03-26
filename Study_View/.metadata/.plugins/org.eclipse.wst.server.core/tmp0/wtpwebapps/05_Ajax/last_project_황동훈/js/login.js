$(document).ready(function() {
	
	//뒤로가기 버튼 이벤트
	$("#moveBack").mouseover(function() {
		$("#moveBack")
		.html("◀ GO BACK TO HOMEPAGE")
	}).mouseout(function() {
		$("#moveBack")
		.html("◀")
	});//moveBack mouseover,mouseout
	
	$("#moveBack").click(function() {
		var myConfirm = confirm("Are you sure?");
		if (myConfirm) {
			alert("Go Back to Homepage");
			location.href = "index.html";
			return false;
		} else {
			alert("Continue your login");
			return false;
		}//if
		
	});//moveBack click
	
	
	var id = document.getElementById("userId");
	var pw = document.getElementById("userPw");
	
	//아이디 창 커서 이벤트
	$("#userId").focus(function() {
		$("#userId")
		.attr("placeholder","")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
	}).blur(function() {
		$("#userId")
		.attr("placeholder","I          D")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
	});//userId focus,blur
	
	//비밀번호 창에 커서가 올라갈 때
	$("#userPw").focus(function() {
		$("#userPw").attr("placeholder","");
		//아이디 창에 값이 입력되지 않았을 경우
		if (!id.value) {
			$("#userId").focus()
			.css("border-bottom","2px solid #DB9700");
			$("#userPw").attr("placeholder", "I n p u t     y o u r     I D     F  I  R  S  T");
			return false;
		}//if
		
		$("#userPw")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
	}).blur(function() {
		$("#userPw")
		.attr("placeholder","P  A  S  S  W  O  R  D")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
	});//userId focus,blur
	
	//로그인 버튼을 눌렀을 때 이벤트
	document.login_form.onsubmit = function() {
		
		//아이디 창에 값이 입력되지 않았을 때
		if (!id.value) {
			$("#userId").attr("placeholder","I  n  p  u  t     y  o  u  r     I  D")
			.css("border","2px solid #FF5A5A")
			.css("border-radius","10px 0px");
			return false;
		}//if idvalue
		
		//비밀번호 창에 값이 입력되지 않았을 때
		if (!pw.value) {
			$("#userPw").attr("placeholder","I  n  p  u  t     y  o  u  r     p  a  s  s  w  o  r  d")
			.css("border","2px solid #FF5A5A")
			.css("border-radius","10px 0px");
			return false;
		}//if pwvalue
		
		//아이디와 비밀번호가 존재하는 데이터와 같은지 체크
		var idpwCheck = false;
		$.ajax({
			
			url: "loginCheck.json",
			type: "post",
			dataType: "json",
			async: false,
			
			success: function(result) {
				$(result).each(function(key, value) {
					if ((id.value == value.id) && (pw.value == value.pw)) {
						idpwCheck = true;
					}//if
				});//each
			}//success
			
		});//ajax
		
		//로그인 확인
		if (idpwCheck) {
			alert("Welcome Back! " + id.value + "!!");
			location.href = "index.html";
			return false;
		} else {
			alert("Sorry.\nWe can't find your ID or password");
			id.value = "";
			pw.value = "";
			$("#userId").focus();
			return false;
		}//if
		
		
	}//login_form onsubmit
	
	//취소 버튼을 눌렀을 때 이벤트
	document.login_form.onreset = function() {
		var input = confirm("Are you sure?");
		
		if (input) {
			alert("Login has been canceled. \nGo back to Main page.");
			location.href = "index.html";
			return false;
		} else {
			alert("Continue your login.");
			return false;
		}//if
	}//login_form onreset

});//ready