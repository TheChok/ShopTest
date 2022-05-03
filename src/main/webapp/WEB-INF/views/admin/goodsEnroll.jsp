<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="/resources/css/admin/goodsEnroll.css?after">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
	
	<script
	  	src="https://code.jquery.com/jquery-3.4.1.js"
	  	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  	crossorigin="anonymous">
	</script>
	<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

</head>
<body>


	<%@ include file="../includes/admin/header.jsp" %>

	    <div class="admin_content_wrap">
	        <div class="admin_content_subject"><span>상품 등록</span></div>

	        <div class="admin_content_main">
				<form action="/admin/goodsEnroll" method="post" id="enrollForm">
					<div class="form_section">
						<div class="form_section_title">
							<label>책 제목</label>
						</div>
						<div class="form_section_content">
							<input name="book_name"/>
							<span class="ck_warn book_name_warn">책 이름을 입력해주세요.</span>
						</div>
					</div>
					<div class="form_section">
						<div class="form_section_title">
							<label>작가</label>
						</div>
						<div class="form_section_content">
							<input id="author_name_input" readonly="readonly"/>
							<input id="author_id_input" name="author_id" type="hidden"/>
							<button class="author_id_btn">작가 선택</button>
							<span class="ck_warn author_id_warn">작가를 선택해주세요</span>
						</div>
					</div>            
					<div class="form_section">
						<div class="form_section_title">
							<label>출판일</label>
						</div>
						<div class="form_section_content">
							<input name="publeYear" autocomplete="off" readonly="readonly"/>
							<span class="ck_warn publeYear_warn">출판일을 입력해주세요.</span>
						</div>
					</div>            
					<div class="form_section">
						<div class="form_section_title">
							<label>출판사</label>
						</div>
						<div class="form_section_content">
							<input name="publisher"/>
							<span class="ck_warn publisher_warn">출판사를 입력해주세요.</span>
						</div>
					</div>             
					<div class="form_section">
						<div class="form_section_title">
							<label>책 카테고리</label>
						</div>
						<div class="form_section_content">
							<div class="cate_wrap">
								<span>대분류</span>
								<select class="cate1">
									<option selected value="none">선택</option>
								</select>
							</div>
							<div class="cate_wrap">
								<span>중분류</span>
								<select class="cate2">
									<option selected value="none">선택</option>
								</select>
							</div>
							<div class="cate_wrap">
								<span>소분류</span>
								<select class="cate3" name="cateCode">
									<option selected value="none">선택</option>
								</select>
							</div>
							<span class="ck_warn cateCode_warn">카테고리를 입력해주세요.</span>
						</div>
					</div>          
					<div class="form_section">
						<div class="form_section_title">
							<label>상품 가격</label>
						</div>
						<div class="form_section_content">
							<input name="book_price" value="0"/>
							<span class="ck_warn book_price_warn">상품 가격을 입력해주세요.</span>
						</div>
					</div>               
					<div class="form_section">
						<div class="form_section_title">
							<label>상품 재고</label>
						</div>
						<div class="form_section_content">
							<input name="book_stock" value="0"/>
							<span class="ck_warn book_stock_warn">상품 재고를 입력해주세요.</span>
						</div>
					</div>          
					<div class="form_section">
						<div class="form_section_title">
							<label>상품 할인율</label>
						</div>
						<div class="form_section_content">
							<input name="book_discount" placeholder="0.01~0.99 사이의 숫자를 입력해주세요"/>
							<span class="ck_warn book_discount_warn">상품 할인율을 입력해주세요</span>
						</div>
					</div>          		
					<div class="form_section">
						<div class="form_section_title">
							<label>책 소개</label>
						</div>
						<div class="form_section_content bit">
							<textarea name="book_intro" id="book_intro_textarea"></textarea>
							<span class="ck_warn book_intro_warn">책 소개를 입력해주세요.</span>
						</div>
					</div>        		
					<div class="form_section">
						<div class="form_section_title">
							<label>책 목차</label>
						</div>
						<div class="form_section_content bct">
							<textarea name="book_contents" id="book_contents_textarea"></textarea>
							<span class="ck_warn book_contents_warn">책 목차를 입력해주세요.</span>
						</div>
					</div>
				</form>
				<div class="btn_section">
					<button id="cancelBtn" class="btn">취 소</button>
			 		<button id="enrollBtn" class="btn enroll_btn">등 록</button>
			 	</div> 
			</div>
		</div> <!-- End - class="admin_content_wrap" -->

	 
	 
	<%@ include file="../includes/admin/footer.jsp" %>		    

<script>
	
	let enrollForm = $("#enrollForm")

	/* 취소 버튼 */
	$("#cancelBtn").click(function(){
	
		location.href="/admin/goodsManage"
	});

	/* 상품 등록 버튼 */
	$("#enrollBtn").on("click",function(e){
	
		e.preventDefault();
		
		/* 체크 변수 */
		let bookNameCk 	= false;
		let authorIdCk 	= false;
		let publeYearCk = false;
		let publisherCk = false;
		let cateCodeCk 	= false;
		let priceCk 	= false;
		let stockCk 	= false;
		let discountCk 	= false;
		let introCk 	= false;
		let contentsCk 	= false;
		
		/* 체크 대상 변수 */
		let bookName 	= $("input[name='book_name']").val();
		let authorId 	= $("input[name='author_id']").val();
		let publeYear 	= $("input[name='publeYear']").val();
		let publisher 	= $("input[name='publisher']").val();
		let cateCode 	= $("select[name='cateCode']").val();
		let bookPrice 	= $("input[name='book_price']").val();
		let bookStock 	= $("input[name='book_stock']").val();
		let bookDiscount = $("input[name='book_discount']").val();
		let bookIntro 	= $(".bit p").html();
		let bookContents = $(".bct p").html();
		
		
		if(bookName){
			$(".book_name_warn").css('display','none');
			bookNameCk = true;
		} else {
			$(".book_name_warn").css('display','block');
			bookNameCk = false;
		}
		
		if(authorId){
			$(".author_id_warn").css('display','none');
			authorIdCk = true;
		} else {
			$(".author_id_warn").css('display','block');
			authorIdCk = false;
		}
		
		if(publeYear){
			$(".publeYear_warn").css('display','none');
			publeYearCk = true;
		} else {
			$(".publeYear_warn").css('display','block');
			publeYearCk = false;
		}	
		
		if(publisher){
			$(".publisher_warn").css('display','none');
			publisherCk = true;
		} else {
			$(".publisher_warn").css('display','block');
			publisherCk = false;
		}
		
		if(cateCode != 'none'){
			$(".cateCode_warn").css('display','none');
			cateCodeCk = true;
		} else {
			$(".cateCode_warn").css('display','block');
			cateCodeCk = false;
		}	
		
		if(bookPrice != 0){
			$(".book_price_warn").css('display','none');
			priceCk = true;
		} else {
			$(".book_price_warn").css('display','block');
			priceCk = false;
		}	
		
		if(bookStock != 0){
			$(".book_stock_warn").css('display','none');
			stockCk = true;
		} else {
			$(".book_stock_warn").css('display','block');
			stockCk = false;
		}		
		
		if(bookDiscount < 1 && bookDiscount != ''){
			$(".book_discount_warn").css('display','none');
			discountCk = true;
		} else {
			$(".book_discount_warn").css('display','block');
			discountCk = false;
		}	
		
		if(bookIntro != '<br data-cke-filler="true">'){
			$(".book_intro_warn").css('display','none');
			introCk = true;
		} else {
			$(".book_intro_warn").css('display','block');
			introCk = false;
		}	
		
		if(bookContents != '<br data-cke-filler="true">'){
			$(".book_contents_warn").css('display','none');
			contentsCk = true;
		} else {
			$(".book_contents_warn").css('display','block');
			contentsCk = false;
		}	
		
		/* 최종 검사 */
		if(bookNameCk && authorIdCk && publeYearCk && publisherCk && cateCodeCk && priceCk && stockCk && discountCk && introCk && contentsCk ){
			//alert('통과');
			enrollForm.submit();
		} else {
			return false;
		}
		
	});
	
/* 위지웍 적용 */
	/* 책 소개 */
	ClassicEditor
		.create(document.querySelector('#book_intro_textarea'))
		.catch(error=>{
			console.error(error);
		});
		
	/* 책 목차 */
	ClassicEditor
		.create(document.querySelector('#book_contents_textarea'))
		.catch(error=>{
		console.error(error);
	});

/* 캘린더 위젯 적용 */
	
	/* 캘린더 */
	$(function() {
  		$( "input[name='publeYear']" ).datepicker({
  			dateFormat: "yy-mm-dd",
  			showOn:	"button",
  			buttonText: "날짜 선택",
  			prevText: '이전 달',
  		    nextText: '다음 달',
  		    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
  		    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
  		    dayNames: ['일','월','화','수','목','금','토'],
  		    dayNamesShort: ['일','월','화','수','목','금','토'],
  		    dayNamesMin: ['일','월','화','수','목','금','토'],
  		    yearSuffix: '년',
  		    yearRange:	"1800",
  	        changeMonth: true,
  	        changeYear: true
  		});
	});
	
/* 작가 선택 버튼 */	
	
	/* 작가 선택 */
	$('.author_id_btn').on("click", function(e) {
		
		e.preventDefault();
		
		let popUrl = "/admin/authorPop";
		let popOption = "width=650px, height=550px, top=300px, left=300px, scrollbars=yes";
		
		window.open(popUrl, "작가 찾기", popOption);
		
		
	});
/* 	
	$(document).ready(fucntion() {
		console.log('${cateList}');
	});
 */	
 	/* 카테고리 */
	let cateList = JSON.parse('${cateList}');
 
 	let cate1Array	= new Array();
 	let cate2Array	= new Array();
 	let cate3Array	= new Array();
 	let cate1Obj	= new Object();
 	let cate2Obj	= new Object();
 	let cate3Obj	= new Object();
 	
 	let cateSelect1	= $(".cate1");
 	let cateSelect2	= $(".cate2");
 	let cateSelect3	= $(".cate3");
 	
 	/* 카테고리 배열 초기화 메서드 */
	function makeCateArray(obj,array,cateList, tier){
		for(let i = 0; i < cateList.length; i++){
			if(cateList[i].tier == tier){
				obj = new Object();
				
				obj.cate_name = cateList[i].cate_name;
				obj.cateCode = cateList[i].cateCode;
				obj.cate_parent = cateList[i].cate_parent;
				
				array.push(obj);				
				
			}
		}
	}	
 	
	/* 배열 초기화 */
	makeCateArray(cate1Obj,cate1Array,cateList,1);
	makeCateArray(cate2Obj,cate2Array,cateList,2);
	makeCateArray(cate3Obj,cate3Array,cateList,3);
/*	
	$(document).ready(function(){
		console.log(cate1Array);
		console.log(cate2Array);
		console.log(cate3Array);
	});
*/ 
	/* 대분류 <option> 태그 */
	for(let i = 0; i < cate1Array.length; i++){
		cateSelect1.append("<option value='"+cate1Array[i].cateCode+"'>" + cate1Array[i].cate_name + "</option>");
	}
	
	/* 중분류 <option> 태그 */
	$(cateSelect1).on("change",function(){
		
		let selectVal1 = $(this).find("option:selected").val();	
		
		cateSelect2.children().remove();
		cateSelect3.children().remove();
		
		cateSelect2.append("<option value='none'>선택</option>");
		cateSelect3.append("<option value='none'>선택</option>");
		
		for(let i = 0; i < cate2Array.length; i++){
			if(selectVal1 == cate2Array[i].cate_parent){
				cateSelect2.append("<option value='"+cate2Array[i].cateCode+"'>" + cate2Array[i].cate_name + "</option>");	
			}
		}// for
		
	});
	
	/* 소분류 <option>태그 */
	$(cateSelect2).on("change",function(){
		
		let selectVal2 = $(this).find("option:selected").val();
		
		cateSelect3.children().remove();
		
		cateSelect3.append("<option value='none'>선택</option>");		
		
		for(let i = 0; i < cate3Array.length; i++){
			if(selectVal2 == cate3Array[i].cate_parent){
				cateSelect3.append("<option value='"+cate3Array[i].cateCode+"'>" + cate3Array[i].cate_name + "</option>");	
			}
		}// for		
		
	});	
	
</script>

</body>
</html>
