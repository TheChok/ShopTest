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
						<a href="/member/join">회원가입</a>
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
						<div>
							적립 포인트 : <span class="point_span"></span>
						</div>
					</div>
					<div class="line">
					</div>
					<div class="button">
						<div class="button_quantity">
							주문수량
							<input type="text" class="quantity_input" value="1"/>
							<span>
								<button class="plus_btn">+</button>
								<button class="minus_btn">-</button>
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
					<h2>책소개</h2><br><br>
					${goodsInfo.book_intro }
				</div><br><br><hr>
				<div class="book_content">
					<h2>목차</h2><br><br>
					${goodsInfo.book_contents }
				</div>
			</div>
			<div class="line">
				
			</div>
			<div class="content_bottom">
				<div class="reply_subject">
					<h2>리뷰</h2>
				</div>
				
				<c:if test="${member != null }">
					<div class="reply_button_wrap">
						<button class="reply_button_wrap1">리뷰 쓰기</button>
					</div>
				</c:if>
				
				<div class="reply_not_div">
					
				</div>
				<ul class="reply_content_ul">
					<!--
					<li>
						<div class="comment_wrap">
							<div class="reply_top">
								<span class="id_span">sjinjin7</span>
								<span class="date_span">2021-10-11</span>
								<span class="rating_span">평점 : <span class="raing_value_span">4</span>점</span>
								<a class="update_reply_btn">수정</a><a class="delete_reply_btn">삭제</a>
							</div>
							<div class="reply_bottom">
								<div class="reply_bottom_txt">
									사실 기대를 많이 하고 읽기 시작했는데, 읽으면서 작가가 쓴 것이 맞는지 의심이 들게 합니다.<br>
									문체도 그렇고 간결하지 않네요. 제가 기대가 크던 작았던 간에 책장이 사실 안 넘겨집니다.
								</div>
							</div>
						</div>
					</li> 
					-->
				</ul>
				<div class="reply_pageInfo_div">
					<ul class="pageMaker">
						<!--
						<li class="pageMaker_btn prev">
							<a>이전</a>
						</li>
						<li class="pageMaker_btn">
							<a>1</a>
						</li>
						<li class="pageMaker_btn">
							<a>2</a>
						</li>
						<li class="pageMaker_btn">
							<a>3</a>
						</li>
						<li class="pageMaker_btn next">
							<a>다음</a>
						</li>
						-->
					</ul>
				</div>
				
				
				
			</div>		
			
			<!-- 주문 form -->
			<form action="/order/${member.member_id}" method="get" class="order_form">
				<input type="hidden" name="orders[0].book_id" 	 value="${goodsInfo.book_id }"/>
				<input type="hidden" name="orders[0].book_count" value=""/>
			</form>
			
			
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
	
	
	/* 포인트 삽입 */
	let salePrice 	= "${goodsInfo.book_price - (goodsInfo.book_price * goodsInfo.book_discount)}"
	let point		= salePrice * 0.05;
	point			= Math.floor(point);
	$(".point_span").text(point);
	
	
	/* 리뷰 리스트 출력 */
	
	const book_id = '${goodsInfo.book_id}';	

	$.getJSON("/reply/list", {book_id : book_id}, function(obj){
		makeReplyContent(obj);
	});	
	
	
	
}); // End - $(document).ready(function())

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

/* 수량 버튼 조작 */
let quantity = $(".quantity_input").val();
$(".plus_btn").on("click", function() {
	$(".quantity_input").val(++quantity);
});
$(".minus_btn").on("click", function() {
	if(quantity > 1) {
		$(".quantity_input").val(--quantity);
	}
});


/*  서버로 전송할 데이터 */
const form = {
				member_id : '${member.member_id}',
				book_id:	'${goodsInfo.book_id}',
				book_count:	''
}

const errorCode = {
	FAIL_ERROR: 		"FAIL_ERROR",
	SUCCESS:			"SUCCESS",
	SAME_ERROR:			"SAME_ERROR", 
	LOGIN_NOT_ERROR: 	"LOGIN_NOT_ERROR"
}

/* 장바구니 추가 버튼 */
$(".btn_cart").on("click", function(e) {
	e.preventDefault();
	
	form.book_count = $(".quantity_input").val();
	$.ajax({
			url:		'/cart/add',
			type:		'POST',
			data:		form,
			success:	function(result) {
				console.log(result);
				cartAlert(result);	// 이건 호출하는거
			}
	});
	
});

/* cartAlert(result) */				// 이건 호출할거 만든거
function cartAlert(result) {
	
	
	if(result == errorCode.FAIL_ERROR) {
		alert("장바구니에 추가를 하지 못하였습니다.");
	} else if(result == errorCode.SUCCESS) {
		alert("장바구니에 추가되었습니다.");
	} else if(result == errorCode.SAME_ERROR) {
		alert("장바구니에 이미 추가되어져 있습니다.");
	} else if(result == errorCode.LOGIN_NOT_ERROR) {
		alert("로그인이 필요합니다.");
	}
}
 
	
/* 바로구매 버튼 */
$(".btn_buy").on("click", function(){
	let book_count = $(".quantity_input").val();
	$(".order_form").find("input[name='orders[0].book_count']").val(book_count);
	$(".order_form").submit();
});


/* 리뷰쓰기 */
$(".reply_button_wrap1").on("click", function(e){
	e.preventDefault();			
	
	const member_id = '${member.member_id}';
	const book_id = '${goodsInfo.book_id}';
	
	$.ajax({
		data : {
			book_id : book_id,
			member_id : member_id
		},
		url : '/reply/check',
		type : 'POST',
		success : function(result) {
			if(result == '1') {
				alert("이미 등록된 리뷰가 존재합니다.");
			} else if(result == '0') {
				let popUrl = "/replyEnroll/" + member_id + "?book_id=" + book_id;
				console.log(popUrl);
				let popOption = "width = 500px, height=600px, top=300px, left=300px, scrollbars=yes";
				
				window.open(popUrl,"리뷰 쓰기",popOption);
			}
		}
	});
	
	
});


/* 댓글 페이지 정보 */
const cri = {
	book_id : '${goodsInfo.book_id}',
	pageNum : 1,
	amount : 10
}

/* 댓글 페이지 이동 버튼 동작 */
$(document).on('click', '.pageMaker_btn a', function(e){
	e.preventDefault();
	
	let page = $(this).attr("href");	
	cri.pageNum = page;		
	
	replyListInit();

 });

/* 댓글 데이터 서버 요청 및 댓글 동적 생성 메서드 */
let replyListInit = function(){
	$.getJSON("/reply/list", cri , function(obj){
		makeReplyContent(obj);
	});
}

/* 리뷰 수정 버튼 */
$(document).on('click', '.update_reply_btn', function(e){
	e.preventDefault();
	
	let reply_id = $(this).attr("href");
	let popUrl = "/replyUpdate?reply_id=" + reply_id + "&book_id=" + '${goodsInfo.book_id}' + "&member_id=" + '${member.member_id}';	
	let popOption = "width = 490px, height=450px, top=300px, left=300px, scrollbars=yes"	
	
	window.open(popUrl,"리뷰 수정",popOption);
});	

/* 리뷰 삭제 버튼 */
$(document).on('click', '.delete_reply_btn', function(e){
	e.preventDefault();
	
	let reply_id = $(this).attr("href");	

	$.ajax({
		data : {
			reply_id : reply_id,
			book_id : '${goodsInfo.book_id}'
		},
		url : '/reply/delete',
		type : 'POST',
		success : function(result){
			replyListInit();
			alert('삭제가 완료되엇습니다.');
		}
	});		
		
});	


/* 댓글(리뷰) 동적 생성 메서드 */
function makeReplyContent(obj){
	
	if(obj.list.length === 0) {
		$(".reply_not_div").html('<span>등록된 리뷰가 없습니다.</span>');
		$(".reply_content_ul").html('');
		$(".pageMaker").html('');
	} else {
		$(".reply_not_div").html('');
		
		const list = obj.list;
		const pf = obj.pageInfo;
		const user_id = '${member.member_id}';	
		
		/* list */
		let reply_list = '';		
		
		$(list).each(function(i,obj){
			reply_list += '<li>';
			reply_list += '<div class="comment_wrap">';
			reply_list += '<div class="reply_top">';
			/* 아이디 */
			reply_list += '<span class="id_span">'+ obj.member_id+'</span>';
			/* 날짜 */
			reply_list += '<span class="date_span">'+ obj.regDate +'</span>';
			/* 평점 */
			reply_list += '<span class="rating_span">평점 : <span class="rating_value_span">'+ obj.rating +'</span>점</span>';
			if(obj.member_id === user_id){
				reply_list += '<a class="update_reply_btn" href="'+ obj.reply_id +'">수정</a><a class="delete_reply_btn" href="'+ obj.reply_id +'">삭제</a>';
			}
			reply_list += '</div>'; //<div class="reply_top">
			reply_list += '<div class="reply_bottom">';
			reply_list += '<div class="reply_bottom_txt">'+ obj.content +'</div>';
			reply_list += '</div>';//<div class="reply_bottom">
			reply_list += '</div>';//<div class="comment_wrap">
			reply_list += '</li>';
		});		
		
		
		$(".reply_content_ul").html(reply_list);
		
		/* 페이지 버튼 */
		let reply_pageMaker = '';	
		
			/* prev */
			if(pf.prev){
				let prev_num = pf.pageStart -1;
				reply_pageMaker += '<li class="pageMaker_btn prev">';
				reply_pageMaker += '<a href="'+ prev_num +'">이전</a>';
				reply_pageMaker += '</li>';	
			}
			/* numbre btn */
			for(let i = pf.pageStart; i < pf.pageEnd+1; i++){
				reply_pageMaker += '<li class="pageMaker_btn ';
				if(pf.cri.pageNum === i){
					reply_pageMaker += 'active';
				}
				reply_pageMaker += '">';
				reply_pageMaker += '<a href="'+i+'">'+i+'</a>';
				reply_pageMaker += '</li>';
			}
			/* next */
			if(pf.next){
				let next_num = pf.pageEnd +1;
				reply_pageMaker += '<li class="pageMaker_btn next">';
				reply_pageMaker += '<a href="'+ next_num +'">다음</a>';
				reply_pageMaker += '</li>';	
			}	
			
		$(".pageMaker").html(reply_pageMaker);	
		
	}
	
}

</script>


</body>
</html>