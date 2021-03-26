<%@page import="com.hanul.cart.CartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String price = request.getParameter("price");

ArrayList<CartDTO> cart = null;
Object obj = session.getAttribute("cart");		//세션객체에서 cart값을 가져온다

if (obj == null) {	//세션정보가 없다 : 배열생성 ▶ 최초주문
	cart = new ArrayList<CartDTO>();
} else {	//세션정보가 있다 : object(배열)의 값을 배열타입으로 캐스팅 ▶ 추가주문
	cart = (ArrayList<CartDTO>) obj;
}

int pos = -1;	//등록된 제품이 없다

//장바구니 세션(cart)에 등록된 제품이 있을 경우 : 수량(cnt) 증가
for (int i = 0; i < cart.size(); i++) {
	CartDTO dto = cart.get(i);
	if (dto.getName().equals(name)) {
		pos = 1;
		dto.setCnt(dto.getCnt() + 1);
		break;
	}//if
}//for

//장바구니 세션(cart)에 등록된 제품이 없을 경우 : CartDTO 객체를 생성하여 배열에 등록
if (pos == -1) {
	CartDTO dto = new CartDTO();
	dto.setName(name);
	dto.setPrice(Integer.parseInt(price.replace(",", "")));	//1,500 → 1500
	dto.setCnt(1);
	cart.add(dto);
}

//cart 세션객체를 만들어준다 (갱신)
session.setAttribute("cart", cart);

%>

<script>
alert("장바구니에 담았습니다.");
location.href = "ShopMallMain.jsp";
</script>
