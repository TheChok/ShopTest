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
								<td class="td_width_1"></td>
								<td class="td_width_2"></td>
								<td class="td_width_3">${ci.book_name }</td>
								<td class="td_width_4 price_td">
									<del>정가 : <fmt:formatNumber value="${ci.book_price }" pattern="#,### 원"/></del>
									판매가 : <span class="red_color"><fmt:formatNumber value="${ci.sale_price }" pattern="#,### 원"/></span>
									마일리지: <span class="green_color"><fmt:formatNumber value="${ci.point }" pattern="#,###"/></span>
								</td>
								<td class="td_width_4 table_text_align_center">
									<div class="table_text_align_center quantity_div">
										<input type="text" value="${ci.book_count }" class="quantity_input"/>
										<button class="quantity_btn plus_btn">+</button>
										<button class="quantity_btn minus_btn">-</button>
									</div>
									<a class="quantity_modify_btn">변경</a>
								</td>
								<td class="td_width_4 table_text_align_center">
									<fmt:formatNumber value="${ci.sale_price * ci.book_count }" pattern="#,### 원"/>
								</td>
								<td class="td_width_4 table_text_align_center delete_btn"><button>삭제</button></td>
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
											<span class="total_price_span">7000</span>원
										</td>
									</tr>
									<tr>
										<td>배송비</td>
										<td>
											<span class="delivery_price">3000</span>원
										</td>
									</tr>
									<tr>
										<td>총 주문 상품수</td>
										<td>
											<span class="total_kind_span">종 </span><span class="total_count_span"></span>권
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
												<span class="finalTotalPrice_span">70000</span> 원
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
												<span class="totalPoint_span">7000</span> 원
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
				<a>주문하기</a>
			</div>
			
			
			
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
                    <img src="resources/img/Logo.jpg">
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


</body>
</html>