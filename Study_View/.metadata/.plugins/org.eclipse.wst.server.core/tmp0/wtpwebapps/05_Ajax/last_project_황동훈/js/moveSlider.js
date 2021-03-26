$(document).ready(function() {
	
	var imgCnt = $(".slider_panel").children().length;
	var imgIdx = 1;
	var refreshInterval = null;
	var timer = null;
	
	function moveSlider(index) {
		willMoveLeft = -(index * 600);
		
		$(".slider_panel").animate({
			left: willMoveLeft
		}, "slow");
		
		$(".control_button[data-index=" + index + "]").addClass("active");
		$(".control_button[data-index!=" + index + "]").removeClass("active");
		
		$(".slider_text[data-index=" + index + "]").show("fast")
			.animate({
				left: 0
			}, "slow");
		
		$(".slider_text[data-index!=" + index + "]").hide("fast")
		.animate({
			left: -300
		}, "slow");
		
	}//function
	
	timer = function() {
		moveSlider(imgIdx);
		if (imgIdx < imgCnt-1) {
			imgIdx++;
		} else {
			imgIdx = 0;
		}//if
	};	//timer
	
	$(".animation_canvas").on({
		mouseenter: function() {
			clearInterval(refreshInterval);
		},	//mouseenter
		mouseleave: function() {
			refreshInterval = setInterval(timer, 2000);
		}	//mouseleave
	});
	
	
	$(".control_button").each(function(index) {
		$(this).attr("data-index", index);
		
	}).click(function() {
		var index = $(this).attr("data-index");
		imgIdx = index;	//중간에 클릭한 버튼 인덱스
		moveSlider(index);
	});	//index
	
	
	$(".slider_text").css("left", -300).each(function(index) {
		$(this).attr("data-index", index);
	});	//slide_Text
	
	$(".slider_text[data-index=" + 0 + "]").show("fast")
		.animate({
			left: 0
		}, "slow");
	
	$(".control_button[data-index=" + 0 + "]").addClass("active");
	
	refreshInterval = setInterval(timer, 2000);
	

});	//ready