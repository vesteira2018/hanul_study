<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="jquery/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn").click(function() {
			$("#display").empty();
			$("#display").append("안녕하세요");
		});
	});
</script>
<title>jQuery03</title>
</head>
<body>
	<button id="btn">클릭하세요!</button>
	<br />
	<br />
	<div id="display">클릭하시면 여기의 글자가 변경됩니다.</div>
</body>
</html>