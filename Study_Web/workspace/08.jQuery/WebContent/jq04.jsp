<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery04</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="jquery/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#btn").click(function() {
		var row = $("#row").val();
		var col = $("#col").val();
		//alert("row : " + row + "\ncol : " + col);
		
		var html = "<table border='1'>";
		for (var i = 0; i < row; i++) {
			html += "<tr align=''>"
		}
		
		html += "</table>";
		$("#display").empty();
		$("#display").append(html);
	});//click
});//ready
</script>
</head>
<body>
	<input type="number" id="row" min="1" /> 행 X
	<input type="number" id="col" min="1" /> 열
	<button id="btn">테이블 생성하기</button>
	<br />
	<br />
	<div id="display">여기에 테이블이 생성됩니다.</div>
</body>
</html>