<%@page import="java.text.DecimalFormat"%>
<%@page import="com.hanul.cart.CartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");

ArrayList<CartDTO> cart = null;
Object obj = session.getAttribute("cart");	//세션객체에서 cart값을 가져온다

if (obj == null) {		//세션정보가 없다 : 주문내역이 없다 → 배열 생성
	cart = new ArrayList<CartDTO>();
} else {	//세션정보가 있다 : 주문내역이 있다 → 캐스팅하여 배열로 받자
	cart = (ArrayList<CartDTO>) obj;
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart View</title>

<script type="text/javascript">
function fnPay() {
	alert("결제 API를 발급 받으시기 바랍니다.");
}

function fnClear() {
	if (confirm("장바구니를 비우시겠습니까?")) {
		location.href = "CartClear.jsp";
	}
}

function fnShop() {
	location.href = "ShopMallMain.jsp";
}
</script>

</head>
<body>
	<div align="center">
	<h3>[장바구니 보기]</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>과일명</th>
			<th>단가</th>
			<th>주문수량</th>
			<th>가격</th>
		</tr>
		
		<%
		if (cart.size() == 0) {
			out.println("<tr align='center'>");
			out.println("<td colspan='5'>");
			out.println("주문하신 내역이 없습니다.<br />");
			out.println("<a href='ShopMallMain.jsp'>주문하기</a>");
			out.println("</td>");
			out.println("</tr>");
		} else {
			int total = 0, totalSum = 0;
			DecimalFormat df = new DecimalFormat("￦#,##0");
			for (int i = 0; i < cart.size(); i++) {
				CartDTO dto = cart.get(i);
			out.println("<tr align='center'>");
			out.println("<td>" + (i + 1) + "</td>");
			out.println("<td>" + dto.getName() + "</td>");
			out.println("<td>" + df.format(dto.getPrice()) + "</td>");
			out.println("<td>" + dto.getCnt() + "</td>");
			out.println("<td>" + df.format(dto.getPrice() * dto.getCnt()) + "</td>");
			out.println("</tr>");
			totalSum += dto.getPrice() * dto.getCnt();
			}
			out.println("<tr align='center'>");
			out.println("<td colspan='4'>");
			out.println("<input type='button' value='결제하기' onclick='fnPay()' />");
			out.println("<input type='button' value='장바구니 비우기' onclick='fnClear()' />");
			out.println("<input type='button' value='주문계속하기' onclick='fnShop()' />");
			out.println("</td>");
			out.println("<td>");
			out.println(df.format(totalSum));
			out.println("</td>");
			out.println("</tr>");
		}
		%>
	</table>
	</div>
</body>
</html>