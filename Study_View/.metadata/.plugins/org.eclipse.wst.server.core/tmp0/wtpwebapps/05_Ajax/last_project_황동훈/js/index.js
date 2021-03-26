$(document).ready(function() {
	
	//로그인 버튼
	$("#login_button").click(function() {
		location.href = "login.html";
	});
	
	//회원가입 버튼
	$("#signup_button").click(function() {
		location.href = "signup.html";
	});
	
	//이미지 슬라이더
	var imgCnt = $(".imageSlider").children().length;
	var imgIndex = 1;
	var refreshInterval = null;
	var timer = null;
	
	function moveSlider(index) {
		willMoveLeft = -(index * 1000);
		
		$(".imageSlider").animate({
			left: willMoveLeft
		}, 2000);
		
		$(".control_button[data-index=" + index + "]").addClass("active");
		$(".control_button[data-index!=" + index + "]").removeClass("active");
		
		$(".slider_text[data-index=" + index + "]").show("fast")
			.animate({
				right: 0
			}, 2000);
		
		$(".slider_text[data-index!=" + index + "]").hide("fast")
		.animate({
			right: -800
		}, 2000);
		
	}//function
	
	timer = function() {
		moveSlider(imgIndex);
		if (imgIndex < imgCnt-1) {
			imgIndex++;
		} else {
			imgIndex = 0;
		}//if
	};	//timer
	
	$("#main").on({
		mouseenter: function() {
			clearInterval(refreshInterval);
		},	//mouseenter
		mouseleave: function() {
			refreshInterval = setInterval(timer, 7000);
		}	//mouseleave
	});
	
	$(".control_button").each(function(index) {
		$(this).attr("data-index", index);
		
	}).click(function() {
		var index = $(this).attr("data-index");
		imgIndex = index;	//중간에 클릭한 버튼 인덱스
		moveSlider(index);
	});	//index
	
	$(".slider_text").css("right", -800).each(function(index) {
		$(this).attr("data-index", index);
	});	//slide_Text
	
	$(".slider_text[data-index=" + 0 + "]").show("fast")
		.animate({
			right: 0
		}, "slow");
	
	$(".control_button[data-index=" + 0 + "]").addClass("active");
	
	refreshInterval = setInterval(timer, 7000);
	
});//ready40