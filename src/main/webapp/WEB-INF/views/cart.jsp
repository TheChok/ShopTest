<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome BookMall</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/cart.css?after"/>
	<script
	  src="https://code.jquery.com/jquery-3.4.1.js"
	  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  crossorigin="anonymous">
	</script>
	
</head>
<body>

<div class="wrapper">

	<div class="wrap">
	
		<!-- class="top_gnb_area" -->
		<div class="top_gnb_area">
			<ul class="list">
				<c:if test="${member == null }">
					<li>
						<a href="/member/login">로그인</a>
					</li>
					<li>
						<a href="member/join">회원가입</a>
					</li>
				</c:if>
				<c:if test="${member != null }">
					<c:if test="${member.admin_ck == 1 }">
						<li><a href="/admin/admain">관리자 페이지</a></li>
					</c:if>
					<li>
						<a id="gnb_logout_button">로그아웃</a>
					</li>
					<li>
						마이룸
					</li>
					<li>
						<a href="/cart/${member.member_id }">장바구니</a>
					</li>
				</c:if>
				<li>
					고객센터
				</li>
			</ul>
		</div>
	
		<!-- class="top_area" -->
		<div class="top_area">
			<!-- 로고영역 -->
			<div class="logo_area">
				<a href="/main"><img src="/resources/img/mLogo.jpg"></a>
			</div>
			
			<div class="search_area">
				<div class="search_wrap">
					<form id="searchForm" action="/search" method="get">
						<div class="search_input">
							<select name="type">
								<option value="T">책 제목</option>
								<option value="A">작가</option>
							</select>
							<input type="text" name="keyword" value="<c:out value='${pageMaker.cri.keyword }'/>"/>
							<button class="btn search_btn">검 색</button>
						</div>
					</form>
				</div>
			</div>
			
			<div class="login_area">
			
				<!-- 로그인 하지 않은 상태 -->
				<c:if test="${member == null }">
					<div class="login_button"><a href="/member/login">로그인</a></div>
					<span><a href="/member/join">회원가입</a></span>
				</c:if>
				
				<!-- 로그인 한 상태 -->
				<c:if test="${member != null }">
					<div class="login_success_area">
						<span>회원명 : ${member.member_name }</span>
						<span>충전금액 : <fmt:formatNumber value="${member.money }" pattern="\#,###.##"/></span>
						<span>포인트 : <fmt:formatNumber value="${member.point }" pattern="#,###"/></span>
						<a href="/member/logout.do">로그아웃</a>
					</div>
				</c:if>
				
			</div>
			<div class="clearfix"></div>
		</div> <!-- End - class="top_area" -->
		
		<!-- class="content_area" -->
		<div class="content_area">
			<div class="content_subject"><span>장바구니</span></div>
			<!-- 장바구니 리스트 -->
			<div class="content_middle_section"></div>
			<!-- 장바구니 가격 합계 -->
			<!-- cartInfo -->
			<div class="content_totalCount_section">
				
				<!-- 체크박스 전체 여부 -->
				<div class="all_check_input_div">
					<input type="checkbox" class="all_check_input input_size_20" checked="checked"/><span class="all_check_span">전체선택</span>
				</div>
				
				<table class="subject_table">
					<caption>표 제목 부분</caption>
					<tbody>
						<tr>
							<th class="td_width_1"></th>
							<th class="td_width_2"></th>
							<th class="td_width_3">상품명</th>
							<th class="td_width_4">가격</th>
							<th class="td_width_5">수량</th>
							<th class="td_width_6">합계</th>
							<th class="td_width_7">삭제</th>
						</tr>
					</tbody>
				</table>
				<table class="cart_table">
					<caption>표 내용 부분</caption>
					<tbody>
						<c:forEach items="${cartInfo }" var="ci">
							<tr>
								<td class="td_width_1 cart_info_td">
									<input type="checkbox" 	class="individual_cart_checkbox input_size_20" checked="checked"/>
									<input type="hidden" 	class="individual_book_price_input" 	value="${ci.book_price }"/>
									<input type="hidden" 	class="individual_sale_price_input" 	value="${ci.sale_price }"/>
									<input type="hidden" 	class="individual_book_count_input" 	value="${ci.book_count }" />
									<input type="hidden" 	class="individual_total_price_input" 	value="${ci.sale_price * ci.book_count }" />
									<input type="hidden" 	class="individual_point_input" 			value="${ci.point }" />
									<input type="hidden" 	class="individual_total_point_input" 	value="${ci.totalPoint }" />
									<input type="hidden"	class="individual_book_id_input"		value="${ci.book_id }"/>
								</td>
								<td class="td_width_2">
									<div class="image_wrap" data-bookid="${ci.imageList[0].book_id}" data-path="${ci.imageList[0].uploadPath}" data-uuid="${ci.imageList[0].uuid}" data-filename="${ci.imageList[0].fileName}">
										<img>
									</div>
								</td>
								<td class="td_width_3">${ci.book_name }</td>
								<td class="td_width_4 price_td">
									<del>정가 : <fmt:formatNumber value="${ci.book_price }" pattern="#,### 원"/></del><br>
									판매가 : <span class="red_color"><fmt:formatNumber value="${ci.sale_price }" pattern="#,### 원"/></span><br>
									마일리지: <span class="green_color"><fmt:formatNumber value="${ci.point }" pattern="#,###"/></span><br>
								</td>
								<td class="td_width_4 table_text_align_center">
									<div class="table_text_align_center quantity_div">
										<input type="text" value="${ci.book_count }" class="quantity_input"/>
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
									<a class="quantity_modify_btn" data-cartId="${ci.cart_id }">변경</a>
								</td>
								<td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.sale_price * ci.book_count }" pattern="#,### 원"/>
								</td>
								<td class="td_width_4 table_text_align_center">
									<div>
										<button class="delete_btn" data-cartid="${ci.cart_id }">삭제</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="list_table">
				</table>
			</div>
			
			<!-- 가격 총합 -->
			<div class="content_total_section">
				<div class="total_wrap">
					<table>
						<tr>
							<td>
								<table>
									<tr>
										<td>총 상품 가격</td>
										<td>
											<span class="total_price_span"></span>원
										</td>
									</tr>
									<tr>
										<td>배송비</td>
										<td>
											<span class="delivery_price"></span>원
										</td>
									</tr>
									<tr>
										<td>총 주문 상품수</td>
										<td>
											<span class="total_kind_span">총 </span><span class="total_count_span"></span>권
										</td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td></td>
										<td></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<div class="boundary_div">구분선</div>
					<table>
						<tr>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 결제 예상 금액</strong>
											</td>
											<td>
												<span class="finalTotalPrice_span"></span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
							<td>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>총 적립 예상 마일리지</strong>
											</td>
											<td>
												<span class="totalPoint_span"></span> 원
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			
			<!-- 구매 버튼 영역 -->
			<div class="content_btn_section">
				<a class="order_btn">주문하기</a>
			</div>
			
			<!-- 수량 조정 form -->
			<form action="/cart/update" method="post" class="quantity_update_form">
				<input type="hidden" name="cart_id" 	class="update_cart_id"/>
				<input type="hidden" name="book_count" 	class="update_book_count"/>
				<input type="hidden" name="member_id" 	value="${member.member_id}"/>
			</form>
			
			<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="cart_id" class="delete_cart_id">
				<input type="hidden" name="member_id" value="${member.member_id}">
			</form>
			
			<!-- 주문 form -->
			<form action="/order/${member.member_id}" method="get" class="order_form">
				
			</form>
			
			
		</div>	<!-- End - class="content_area" -->
		
		
		<!-- Footer 영역 -->
        <div class="footer_nav">
            <div class="footer_nav_container">
                <ul>
                    <li>회사소개</li>
                    <span class="line">|</span>
                    <li>이용약관</li>
                    <span class="line">|</span>
                    <li>고객센터</li>
                    <span class="line">|</span>
                    <li>광고문의</li>
                    <span class="line">|</span>
                    <li>채용정보</li>
                    <span class="line">|</span>
                </ul>
            </div>
        </div> <!-- class="footer_nav" -->
        
        <div class="footer">
            <div class="footer_container">
                
                <div class="footer_left">
                    <img src="/resources/img/Logo.jpg">
                </div>
                <div class="footer_right">
                    (주) shopBook    대표이사 : OOO
                    <br>
                    사업자등록번호 : ooo-oo-ooooo
                    <br>
                    대표전화 : oooo-oooo(발신자 부담전화)
                    <br>
                    <br>
                    COPYRIGHT(C) <strong>shop.tistory.com</strong>    ALL RIGHTS RESERVED.
                </div>
                <div class="clearfix"></div>
                
            </div>
        </div> <!-- End - class="footer" -->

		
	</div>	<!-- End - class="wrap" -->	
</div>	<!-- End - class="wrapper" -->

<script>
/* $(document).ready(function()) */
$(document).ready(function(){
	
	/* 종합 정보 섹션 정보 삽입 */
	setTotalInfo();	
	
	/* 이미지 삽입 */
	$(".image_wrap").each(function(i, obj){
		const bobj = $(obj);
			
		if(bobj.data("bookid")) {
			const uploadPath = bobj.data("path");
			const uuid = bobj.data("uuid");
			const fileName = bobj.data("filename");
			
			const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
			
			$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
		} else {
			$(this).find("img").attr('src', '/resources/img/goodsNoImage.png');
		}
		
	});
	
}); // End - $(document).ready(function())


/* 체크여부에 따른 종합 정보 변화 */
$(".individual_cart_checkbox").on("change", function(){
	/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
	setTotalInfo($(".cart_info_td"));
});


/* 체크박스 전체 선택 */
$(".all_check_input").on("click", function(){
	/* 체크박스 체크/해제 */
	if($(".all_check_input").prop("checked")){
		$(".individual_cart_checkbox").attr("checked", true);
	} else{
		$(".individual_cart_checkbox").attr("checked", false);
	}
	
	/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
	setTotalInfo($(".cart_info_td"));
});


/* 총 주문 정보 세팅(배송비, 총 가격, 물품 수, 종류) */
function setTotalInfo() {
	
	let totalPrice = 0;				// 총 가격
	let totalCount = 0;				// 총 갯수
	let totalKind = 0;				// 총 종류
	let totalPoint = 0;				// 총 마일리지
	let deliveryPrice = 0;			// 배송비
	let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)	
	
	
	$(".cart_info_td").each(function(index, element){
		if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
			// 총 가격
			totalPrice += parseInt($(element).find(".individual_total_price_input").val());
			// 총 갯수
			totalCount += parseInt($(element).find(".individual_book_count_input").val());
			// 총 종류
			totalKind += 1;
			// 총 마일리지
			totalPoint += parseInt($(element).find(".individual_total_point_input").val());			
		}
	});
	
	/* 배송비 결정 */
	if(totalPrice >= 30000){
		deliveryPrice = 0;
	} else if(totalPrice == 0){
		deliveryPrice = 0;
	} else {
		deliveryPrice = 3000;	
	}	
	
	/* 최종 가격 */
	finalTotalPrice = totalPrice + deliveryPrice;
	
	/* 값 삽입 */
	// 출력값에서 세자리 단위 컴마표시 -> Javascript Number 객체에 .tolocaleString()
	$(".total_price_span").text(totalPrice.toLocaleString());	// 총 가격
	$(".total_count_span").text(totalCount);					// 총 갯수
	$(".total_kind_span").text(totalKind);						// 총 종류
	$(".totalPoint_span").text(totalPoint.toLocaleString());	// 총 마일리지
	$(".delivery_price").text(deliveryPrice);					// 배송비	
	$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());	// 최종 가격(총 가격 + 배송비)
	
}

/* 수량버튼 */
$(".plus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	$(this).parent("div").find("input").val(++quantity);
});
$(".minus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	if(quantity > 1) {
		$(this).parent("div").find("input").val(--quantity);
	}
});


/* 수량 수정 버튼 */
$(".quantity_modify_btn").on("click", function(){
	let cartId = $(this).data("cartid");
	let bookCount = $(this).parent("td").find("input").val();
	$(".update_cart_id").val(cartId);
	$(".update_book_count").val(bookCount);
	$(".quantity_update_form").submit();
});


/* 장바구니 삭제 버튼 */
$(".delete_btn").on("click", function(e){
	e.preventDefault();
	let cartId = $(this).data("cartid");
	$(".delete_cart_id").val(cartId);
	$(".quantity_delete_form").submit();
});


/* 주문 페이지 이동 */	
$(".order_btn").on("click", function(){
	
	let form_contents 	= '';
	let orderNumber 	= 0;
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") == true){	//체크여부
			
			let book_id = $(element).find(".individual_book_id_input").val();
			let book_count = $(element).find(".individual_book_count_input").val();
			
			let book_id_input = "<input name='orders["+ orderNumber +"].book_id' type='hidden' value='"+ book_id +"'>";
			form_contents += book_id_input;
			
			let book_count_input = "<input name='orders["+ orderNumber +"].book_count' type='hidden' value='"+ book_count +"'>";
			form_contents += book_count_input;
			
			orderNumber += 1;
		}
	});	

	$(".order_form").html(form_contents);
	$(".order_form").submit();
});

/* gnb_area 로그아웃 버튼 작동 */
$("#gnb_logout_button").click(function(){
    //alert("버튼 작동");
    $.ajax({
        type:"POST",
        url:"/member/logout.do",
        success:function(data){
            //alert("로그아웃 성공");
            document.location.reload();     
        } 
    }); // ajax 
});

</script>


</body>
</html>
