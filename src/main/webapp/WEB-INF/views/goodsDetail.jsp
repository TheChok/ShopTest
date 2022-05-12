<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome BookMall</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/goodsDetail.css?after"/>
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
						장바구니
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
			<div class="line">
				
			</div>
			<div class="content_top">
				<div class="ct_left_area">
					<div class="image_wrap" data-bookid="${goodsInfo.imageList[0].book_id }" data-path="${goodsInfo.imageList[0].uploadPath }" data-uuid="${goodsInfo.imageList[0].uuid }" data-filename="${goodsInfo.imageList[0].fileName }">
						<img>
					</div>
				</div>
				<div class="ct_right_area">
					<div class="title">
						<h1>
							${goodsInfo.book_name }
						</h1>
					</div>
					<div class="line">
						
					</div>
					<div class="author">
						<span>
							${goodsInfo.author_name }	지음
						</span>
						<span>|</span>
						<span>
							${goodsInfo.publisher }
						</span>
						<span>|</span>
						<span class="publeyear">
							${goodsInfo.publeYear }
						</span>
					</div>
					<div class="line">
						
					</div>
					<div class="price">
						<div class="sale_price">정가 : <fmt:formatNumber value="${goodsInfo.book_price }" pattern="#,### 원"/></div>
						<div class="discount_price">
							판매가 : <span class="discount_price_number"><fmt:formatNumber value="${goodsInfo.book_price - (goodsInfo.book_price * goodsInfo.book_discount) }" pattern="#,### 원"/></span>
							[<fmt:formatNumber value="${goodsInfo.book_discount * 100 }" pattern="###"/>%
							 <fmt:formatNumber value="${goodsInfo.book_price * goodsInfo.book_discount }" pattern="#,### 원"/> 할인]
						</div>
					</div>
					<div class="line">
						
					</div>
					<div class="button">
						<div class="button_quantity">
							주문수량
							<input type="text" value="1"/>
							<span>
								<button></button>
								<button></button>
							</span>
						</div>
						<div class="button_set">
							<a class="btn_cart">장바구니 담기</a>
							<a class="btn_buy">바로 구매</a>
						</div>
					</div>
				</div>
			</div>
			<div class="line">
				
			</div>	
			<div class="content_middle">
				<div class="book_intro">
					${goodsInfo.book_intro }
				</div>
				<div class="book_content">
					${goodsInfo.book_contents }
				</div>
			</div>
			<div class="line">
				
			</div>
			<div class="content_bottom">
				리뷰
			</div>		
			
		</div> <!-- End - content_area -->
		
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
$(document).ready(function(){
	
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
	
	/* publeYear */
	const year = "${goodsInfo.publeYear}";
	
	let tempYear = year.substr(0,10);
	
	let yearArray = tempYear.split("-")
	let publeYear = yearArray[0] + "년 " + yearArray[1] + "월 " + yearArray[2] + "일";
	
	$(".publeyear").html(publeYear);
	
	
	
	
});



</script>


</body>
</html>