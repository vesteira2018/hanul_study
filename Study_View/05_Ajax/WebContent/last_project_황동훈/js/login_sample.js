$(document).ready(function() {
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	
//	$("#loginBtn").click(function() {
//	});//loginBtn.click
	
//	$("#loginForm").submit(function() {
//	});//loginForm.submit
	
//	document.getElementById("loginForm").onsubmit = function() {
//	};//loginForm.onsubmit
	
	document.loginForm.onsubmit = function() {
		
//		if (!($("#id").val())) {
		if (!id.value) {
			alert("아이디를 입력하세요");
			id.focus();
			return false;
		}//if
		if (!pw.value) {
			alert("비밀번호를 입력하세요");
			pw.focus();
			return false;
		}//if
		
		var idCheck = false;
		$.ajax({
			
			url: "loginCheck.json",
			type: "post",
			dataType: "json",
			async: false,
			
			success: function(result) {
				
				$(result).each(function(key, value) {
					if ((id.value == value.id) && (pw.value == value.pw)) {
						idCheck = true;
					}//if
					
				});//each
			}//success
		
		});//ajax
		
		if (idCheck) {
			alert(id.value + "님이 로그인 하셨습니다.");
			location.href = "index.html";
			return false;
		} else {
			alert("존재하지 않는 아이디이거나 비밀번호를 잘못 입력하셨습니다.");
			id.value = "";
			pw.value = "";
			$("#id").focus();
			return false;
		}//if
		
		
	};//loginForm.onsubmit
	
	document.loginForm.onreset = function() {
		var input = confirm("로그인을 취소하시겠습니까?");
		
		if (input) {
			alert("로그인이 취소되었습니다. \n메인페이지로 이동합니다.");
			location.href = "index.html";
			return false;
		} else {
			alert("로그인이 계속됩니다.");
			return false;
		}//if
	};//loginForm.onreset
	
	$("#id").keyup(function() {
		$("input[type='submit']").prop("disabled", false);
		$("input[type='reset']").prop("disabled", false);
		
		var idCheck = false;
		$.ajax({
			
			url: "loginCheck.json",
			type: "post",
			dataType: "json",
			async: false,	//동기식으로 처리, "" 미사용
			
			success: function(result) {
				$(result).each(function(key,value) {
					if (id.value == value.id) {
						idCheck = true;
					}//if
					
				});//each
			}//success
			
		});//ajax
		
		if (!$(this).val()) {
			$("#idSpan").html("");
		} else if (idCheck == true) {
			$("#idSpan").html("사용가능한 아이디입니다.").css("color","yellowgreen");
		} else {
			$("#idSpan").html("사용 불가능한 아이디입니다.").css("color","red");
		}//if
	});//keyup
	
	$("#pw").keyup(function() {
		
		var idpwCheck = false;
		$.ajax({
			
			url: "loginCheck.json",
			type: "post",
			dataType: "json",
			async: false,	//동기식으로 처리, "" 미사용
			
			success: function(result) {
				$(result).each(function(key,value) {
					if (id.value == value.id && pw.value == value.pw) {
						idpwCheck = true;
					}//if
					
				});//each
			}//success
			
		});//ajax
		
		if (!$(this).val()) {
			$("#pwSpan").html("");
		} else if (idpwCheck == true) {
			$("#pwSpan").html("사용가능한 비밀번호입니다.").css("color","yellowgreen");
		} else {
			$("#pwSpan").html("사용 불가능한 비밀번호입니다.").css("color","red");
		}//if
		
	});//keyup
	
//	$("#close").mouseover(function() {
//		for (var i = 0; i < 10; i++) {
//			$(this).css("padding", i);
//		}//for
//	});//close.mouseover
//	$("#close").mouseout(function() {
//		$(this).css("padding", 0);
//	});//close.mouseover
	
	$("#close").click(function() {
		var input = confirm("로그인을 취소하시겠습니까?");
		
		if (input) {
			alert("로그인이 취소되었습니다. \n메인페이지로 이동합니다.");
			location.href = "index.html";
			return false;
		} else {
			alert("로그인이 계속됩니다.");
			return false;
		}//if
	});//close.click
	
	$("#id").focus(function() {
		$("#id").attr("placeholder","");
	}).blur(function() {
		$("#id").attr("placeholder","아이디(이메일)를 입력하세요");
	});//id focus,blur
	
	$("#pw").focus(function() {
		$("#pw").attr("placeholder","");
		if (!($("#id").val())) {
			$("#idSpan").html("아이디(이메일)를 먼저 입력해주세요").css("color","red");
			$("#id").focus();
		} else {
			$("#idSpan").html("");
		}//if
	}).blur(function() {
		$("#pw").attr("placeholder","비밀번호를 입력하세요");
	});//pw focus,blur
	
	$("i").click(function() {
		$("input").toggleClass("active");
		
		if ($("input").hasClass("active")) {
			$(this).attr("class","fa fa-eye-slash fa-lg")
			.prev("input").attr("type","text");
		} else{
			$(this).attr("class","fa fa-eye fa-lg")
			.prev("input").attr("type","password");
		}//if
	});//i click
	
	$("#eye").on("click mousedown mouseover", function() {
		$("#pw").attr("type","text");
		$("#eye").html("비번감추기");
	}).on("mouseup mouseleave", function() {
		$("#pw").attr("type","password");
		$("#eye").html("비번보기");
	});//on
	
});//ready