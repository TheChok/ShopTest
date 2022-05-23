<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome BookMall</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css?after"/>
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
	<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
	<script
	  src="https://code.jquery.com/jquery-3.4.1.js"
	  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  crossorigin="anonymous">
	</script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	
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
				<a href="/main"><img src="resources/img/mLogo.jpg"></a>
			</div>
			
			<div class="search_area">
				<div class="search_wrap">
					<form id="searchForm" action="/search" method="get">
						<div class="search_input">
							<select name="type">
								<option value="T">책 제목</option>
								<option value="A">작가</option>
							</select>
							<input type="text" name="keyword"/>
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
		
		
		<!-- class="navi_bar_area" -->
		<div class="navi_bar_area">
			<div class="navi_bar_area">
				<div class="dropdown">
					<button class="dropbtn">국내
						<i class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<c:forEach items="${cate1 }" var="cate">
							<a href="search?type=C&keyword=&cateCode=${cate.cateCode }">${cate.cate_name }</a>
						</c:forEach>
					</div>
				</div>
				<div class="dropdown">
					<button class="dropbtn">국외
						<i class="dropbtn"></i>
					</button>
					<div class="dropdown-content">
						<c:forEach items="${cate2}" var="cate">
							<a href="search?type=C&keyword=&cateCode=${cate.cateCode }">${cate.cate_name }</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		
		<!-- class="content_area" -->
		<div class="content_area">
			
			<div class="slide_div_wrap">
				<div class="slide_div">
					<div>
						<a>
							<img src="/resources/img/title1.jpg"/>
						</a>
					</div>
					<div>
						<a>
							<img src="/resources/img/title2.jpg"/>
						</a>
					</div>
					<div>
						<a>
							<img src="/resources/img/title3.jpg"/>
						</a>
					</div>
				</div>
			</div>
			
		</div>
		
		
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

<script>

$(document).ready(function(){
	
	$(".slide_div").slick({
		dots : true,
		autoplay : true,
		autoplaySpeed : 6000,
	});
	
	
	
	
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