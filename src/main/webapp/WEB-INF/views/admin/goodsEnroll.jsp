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
					</div>
				</div>            
				<div class="form_section">
					<div class="form_section_title">
						<label>출판일</label>
					</div>
					<div class="form_section_content">
						<input name="publeYear" autocomplete="off" readonly="readonly"/>
					</div>
				</div>            
				<div class="form_section">
					<div class="form_section_title">
						<label>출판사</label>
					</div>
					<div class="form_section_content">
						<input name="publisher"/>
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
					</div>
				</div>          
				<div class="form_section">
					<div class="form_section_title">
						<label>상품 가격</label>
					</div>
					<div class="form_section_content">
						<input name="book_price" value="0"/>
					</div>
				</div>               
				<div class="form_section">
					<div class="form_section_title">
						<label>상품 재고</label>
					</div>
					<div class="form_section_content">
						<input name="book_stock" value="0"/>
					</div>
				</div>          
				<div class="form_section">
					<div class="form_section_title">
						<label>상품 할인율</label>
					</div>
					<div class="form_section_content">
						<input name="book_discount" value="0"/>
					</div>
				</div>          		
				<div class="form_section">
					<div class="form_section_title">
						<label>책 소개</label>
					</div>
					<div class="form_section_content">
						<textarea name="book_intro" id="book_intro_textarea"></textarea>
					</div>
				</div>        		
				<div class="form_section">
					<div class="form_section_title">
						<label>책 목차</label>
					</div>
					<div class="form_section_content">
						<textarea name="book_contents" id="book_contents_textarea"></textarea>
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
		enrollForm.submit();
		
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
	$()
	
	
	
</script>

</body>
</html>
