<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.bg {
	background-color: red;
	width: 250px;
	height: 150px;
}

.silver {
	background-color: silver;
	width: 300px;
	height: 200px;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#display").addClass("silver");
	$("#display").click(function() {
		//$("#display").removeClass("silver");
		$(this).removeClass("silver");
		$(this).addClass("bg");
	});//#display.click
});//ready
</script>
</head>
<body>
<div style="background-color: yellow; width: 200px; height: 100px;">
안녕하세요, jQuery!
</div>

<div class="bg">
안녕하세요, jQuery!
</div>

<div id="display">
안녕하세요, jQuery!
</div>
</body>
</html>