<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="/resources/css/admin/goodsEnroll.css?after">
	
	<script
	  	src="https://code.jquery.com/jquery-3.4.1.js"
	  	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  	crossorigin="anonymous">
	</script>

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
						<input name="book_name">
					</div>
				</div>
				<div class="form_section">
					<div class="form_section_title">
						<label>작가</label>
					</div>
					<div class="form_section_content">
						<input name="author_id" value="0">
					</div>
				</div>            
				<div class="form_section">
					<div class="form_section_title">
						<label>출판일</label>
					</div>
					<div class="form_section_content">
						<input name="publeYear">
					</div>
				</div>            
				<div class="form_section">
					<div class="form_section_title">
						<label>출판사</label>
					</div>
					<div class="form_section_content">
						<input name="publisher">
					</div>
				</div>             
				<div class="form_section">
					<div class="form_section_title">
						<label>책 카테고리</label>
					</div>
					<div class="form_section_content">
						<input name="cateCode">
					</div>
				</div>          
				<div class="form_section">
					<div class="form_section_title">
						<label>상품 가격</label>
					</div>
					<div class="form_section_content">
						<input name="book_price" value="0">
					</div>
				</div>               
				<div class="form_section">
					<div class="form_section_title">
						<label>상품 재고</label>
					</div>
					<div class="form_section_content">
						<input name="book_stock" value="0">
					</div>
				</div>          
				<div class="form_section">
					<div class="form_section_title">
						<label>상품 할인율</label>
					</div>
					<div class="form_section_content">
						<input name="book_discount" value="0">
					</div>
				</div>          		
				<div class="form_section">
					<div class="form_section_title">
						<label>책 소개</label>
					</div>
					<div class="form_section_content">
						<input name="book_intro">
					</div>
				</div>        		
				<div class="form_section">
					<div class="form_section_title">
						<label>책 목차</label>
					</div>
					<div class="form_section_content">
						<input name="book_contents">
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
	
	
</script>

</body>
</html>