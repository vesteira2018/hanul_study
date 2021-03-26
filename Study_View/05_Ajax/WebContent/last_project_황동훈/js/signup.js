$(document).ready(function() {
	//변수 선언
	var name = document.getElementById("name");
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	var pwC = document.getElementById("pwConfirm");
	var email = document.getElementById("email");
	var tel1 = document.getElementById("tel1");
	var tel2 = document.getElementById("tel2");
	var tel3 = document.getElementById("tel3");

	//이름
	$("#name").focus(function() {
		$("#name")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
		$("#nameSpan").html("이름을 한글로 입력해주세요.");
	}).blur(function() {
		if (name.value) {
			//유효성 검사
			var regName = /^[가-힣]{2,5}$/;
			if (!regName.test(name.value)) {
				$("#nameSpan").html("Wrong Name Format!");
				$("#name")
				.css("border","0px")
				.css("border-radius","0px")
				.css("border-bottom","2px solid #FF5A5A")
				.css("width","400px");
				return false;
			}
		}
		
		$("#name")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
		$("#nameSpan").html("");
	});
	
	//아이디
	var idCheckClick = false;
	$("#id").focus(function() {
		idCheckClick = false;
		$("#id")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
		$("#idSpan").html("4~12글자의 영문자와 숫자, 특수문자(-, _)만 가능합니다");
	}).blur(function() {
		if (id.value) {
			//유효성 검사
			var regId = /^[a-zA-Z0-9_-]{4,12}$/;
			if (!regId.test(id.value)) {
				$("#idSpan").html("Wrong ID Format!");
				$("#id")
				.css("border","0px")
				.css("border-radius","0px")
				.css("border-bottom","2px solid #FF5A5A")
				.css("width","400px");
				return false;
			}
		}
		
		$("#id")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
		$("#idSpan").html("");
	});
	
	//아이디 중복 체크
	$("#idConfirm").click(function() {
		var idCheck = false;
		$.ajax({
			
			url: "loginCheck.json",
			type: "post",
			dataType: "json",
			async: false,
			
			success: function(result) {
				$(result).each(function(key,value) {
					if (id.value == value.id) {
						idCheck = true;
					}
					
				});//each
			}//success
		
		});//ajax
		
		if (!id.value) {
			$("#idSpan").html("Input your ID FIRST");
			$("#id")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		if (idCheck) {
			$("#idSpan").html("Someone use this ID already");
			$("#id")
			.val("")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		} else {
			$("#idSpan").html("You can use this ID!");
			idCheckClick = true;
		}
	});
	
	//비밀번호
	$("#pw").focus(function() {
		//아이디 중복검사 미실시 제외
		if (!idCheckClick) {
			alert("Please check if the ID is duplicated.");
			$("#id").focus();
			return false;
		}
		
		$("#idSpan").html("");
		$("#pw")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
		$("#pwSpan").html("8~16글자의 영문자와 숫자, 특수문자(-, _)만 가능합니다");
		}).blur(function() {
			if (pw.value) {
				//유효성 검사
				var regPw = /^[a-zA-Z0-9_-]{8,16}$/;
				if (!regPw.test(pw.value) || !pw.value) {
					$("#pwSpan").html("Wrong Password Format!");
					$("#pw")
					.css("border","0px")
					.css("border-radius","0px")
					.css("border-bottom","2px solid #FF5A5A")
					.css("width","400px");
					return false;
				}
			}
		
		$("#pw")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
		$("#pwSpan").html("");
	});
	
	//비밀번호 확인
	$("#pwConfirm").focus(function() {
		$("#pwConfirm")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
	}).blur(function() {
		$("#pwConfirm")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
		$("#pwConfirmSpan").html("");
	});
	
	//비밀번호 확인 체크
	var pwCheck = false;
	$("#pwConfirm").keyup(function() {
		pwCheck = false;
		if ($("#pw").val() == $("#pwConfirm").val()) {
			$("#pwConfirmSpan").html("C O R R E C T !").css("color","blue");
			pwCheck = true;
		} else {
			$("#pwConfirmSpan").html("I N C O R R E C T").css("color","red");
			pwCheck = false;
		}//if
	});	//pwConfirm keyup
	
	//비밀번호 보여주기
	$("#pwShow").click(function() {
		if ($("input:checked[id='pwShow']").is(":checked")) {
			$("#pw").attr("type","text");
			$("#pwConfirm").attr("type","text");
		} else {
			$("#pw").attr("type","password");
			$("#pwConfirm").attr("type","password");
		}
	});
	
	//이메일
	$("#email").focus(function() {
		$("#email")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","400px");
		$("#emailSpan").html("이메일 형식에 맞춰서 입력해주세요.");
	}).blur(function() {
		if (email.value) {
			//유효성 검사
			var regEmail = /^[a-z]\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
			if (!regEmail.test(email.value) || !email.value) {
				$("#emailSpan").html("Wrong E-Mail Format!");
				$("#email")
				.css("border","0px")
				.css("border-radius","0px")
				.css("border-bottom","2px solid #FF5A5A")
				.css("width","400px");
				return false;
			}
		}
		
		$("#email")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","350px");
		$("#emailSpan").html("");
	});
	
	//전화번호
	$(".tel").focus(function() {
		$(".tel")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #DB9700")
		.css("width","130px");
		$("#telSpan").html("전화번호를 입력해주세요.");
	}).blur(function() {
		if (tel1.value && tel2.value && tel3.value) {
			//유효성 검사
			var regTel1 = /^\d{3}$/;
			var regTel2 = /^\d{3,4}$/;
			var regTel3 = /^\d{4}$/;
			if (!regTel1.test(tel1.value) || !regTel2.test(tel2.value) || !regTel3.test(tel3.value)) {
				$("#telSpan").html("Wrong Phone Number Format!");
				return false;
			}
		}
		
		$(".tel")
		.css("border","0px")
		.css("border-radius","0px")
		.css("border-bottom","2px solid #3F0099")
		.css("width","110px");
		$("#telSpan").html("");
	});
	
	document.signup_form.onsubmit = function() {
	
		//이름 빈칸 제외
		if (!name.value) {
			$("#nameSpan").html("Input your name");
			$("#name")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//아이디 빈칸 제외
		if (!id.value) {
			$("#idSpan").html("Input your ID");
			$("#id")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//비밀번호 빈칸 제외
		if (!pw.value) {
			$("#pwSpan").html("Input your password");
			$("#pw")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//비밀번호 확인 빈칸 제외
		if (!pwC.value) {
			$("#pwConfirmSpan").html("Confirm your password");
			$("#pwConfirm")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//이메일 빈칸 제외
		if (!email.value) {
			$("#emailSpan").html("Input your email");
			$("#email")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//전화번호 빈칸 제외
		if (!tel1.value || !tel2.value || !tel3.value) {
			$("#telSpan").html("Input your Phone Number");
			$(".tel")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","130px");
			return false;
		}
		
		//이름 유효성 불통과 제외
		var regName = /^[가-힣]{2,5}$/;
		if (!regName.test(name.value)) {
			$("#nameSpan").html("Wrong Name Format!");
			$("#name")
			.val("")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//아이디 유효성 불통과 제외
		var regId = /^[a-zA-Z0-9_-]{4,12}$/;
		if (!regId.test(id.value)) {
			$("#idSpan").html("Wrong ID Format!");
			$("#id")
			.val("")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//비밀번호 유효성 불통과 제외
		var regPw = /^[a-zA-Z0-9_-]{8,16}$/;
		if (!regPw.test(pw.value)) {
			$("#pwSpan").html("Wrong Password Format!");
			$("#pw")
			.val("")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//이메일 유효성 불통과 제외
		var regEmail = /^[a-z]\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
		if (!regEmail.test(email.value)) {
			$("#emailSpan").html("Wrong E-Mail Format!");
			$("#email")
			.val("")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//전화번호 유효성 불통과 제외
		var regTel1 = /^\d{3}$/;
		var regTel2 = /^\d{3,4}$/;
		var regTel3 = /^\d{4}$/;
		if (tel1.value && tel2.value && tel3.value) {
			if (!regTel1.test(tel1.value) || !regTel2.test(tel2.value) || !regTel3.test(tel3.value)) {
				$("#telSpan").html("Wrong Phone Number Format!");
				$(".tel")
				.val("")
				.css("border-bottom","2px solid #FF5A5A")
				.css("width","130px");
				return false;
			}
		}
		
		//아이디 중복 제외
		var idCheck = false;
		$.ajax({
			
			url: "loginCheck.json",
			type: "post",
			dataType: "json",
			async: false,
			
			success: function(result) {
				$(result).each(function(key,value) {
					if (id.value == value.id) {
						idCheck = true;
					}
					
				});//each
			}//success
		
		});//ajax
		
		if (idCheck) {
			$("#idSpan").html("You can't use this ID");
			$("#id")
			.val("")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//비밀번호 불일치 제외
		var pwCheck = false;
		if (pw.value == pwC.value) {
			pwCheck = true;
		} else {
			pwCheck = false;
		}
		
		if (!pwCheck) {
			$("#pwConfirmSpan").html("Passwords do not match");
			$("#pw")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			$("#pwConfirm")
			.css("border-bottom","2px solid #FF5A5A")
			.css("width","400px");
			return false;
		}
		
		//모든 값이 정상적으로 작성되었을 경우
		alert("Sign Up Complete!\nWelcome!!!");
		location.href = "index.html";
		return false;
		
	}//signup_form onsubmit
	
	document.signup_form.onreset = function() {
		var input = confirm("Are you sure?");
		
		if (input) {
			alert("Sign up has been canceled. \nGo back to Main page.");
			location.href = "index.html";
			return false;
		} else {
			alert("Continue your sign up.");
			return false;
		}//if
	};//signup_form.onreset
	
	
});//ready