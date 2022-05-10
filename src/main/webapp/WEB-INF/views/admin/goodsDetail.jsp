<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 조회 페이지</title>
	
	<link rel="stylesheet" type="text/css" href="/resources/css/admin/goodsDetail.css?after">
	
	<script
	  	src="https://code.jquery.com/jquery-3.4.1.js"
	  	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  	crossorigin="anonymous">
	</script>
	<script src="https://cdn.ckeditor.com/ckeditor5/26.0.0/classic/ckeditor.js"></script>
	
	<style type="text/css">
		#result_card img{
			max-width:	100%;
			height:		auto;
			display:	block;
			padding:	5px;
			margin-top:	10px;
			margin:		auto;
		}
	</style>
	
</head>
<body>
	
	<%@ include file="../includes/admin/header.jsp" %>
		
	    <div class="admin_content_wrap">
	    	<div class="admin_content_subject">
	    		<span>제품 상세</span>
	    	</div>
	    	<div class="admin_content_main">
	    		
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>책 제목</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input name="book_name" value="<c:out value='${goodsInfo.book_name }'/>" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>등록 날짜</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input value="<fmt:formatDate value='${goodsInfo.regDate }' pattern='yyyy-MM-dd'/>"  disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>최근 수정 날짜</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input value="<fmt:formatDate value='${goodsInfo.updateDate }' pattern='yyyy-MM-dd'/>" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>작가</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input id="author_name" readonly="readonly" value="${goodsInfo.author_name }" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>출판일</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input name="publeYear" autocomplete="off" readonly="readonly" value="<c:out value='${goodsInfo.publeYear }'/>" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>출판사</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input name="publisher" value="<c:out value='${goodsInfo.publisher }'/>" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>책 카테고리</label>
	    			</div>
	    			<div class="form_section_content">
	    				<div class="cate_wrap">
	    					<span>대분류</span>
	    					<select class="cate1" disabled>
	    						<option value="none">선택</option>
	    					</select>
	    				</div>
	    				<div class="cate_wrap">
	    					<span>중분류</span>
	    					<select class="cate2" disabled>
	    						<option value="none">선택</option>
	    					</select>
	    				</div>
	    				<div class="cate_wrap">
	    					<span>소분류</span>
	    					<select class="cate3" disabled>
	    						<option value="none">선택</option>
	    					</select>
	    				</div>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>상품 가격</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input name="book_price" value="<c:out value='${goodsInfo.book_price }'/>" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>상품 재고</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input name="book_stock" value="<c:out value='${goodsInfo.book_stock }'/>" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>상품 할인율</label>
	    			</div>
	    			<div class="form_section_content">
	    				<input id="discount_interface" maxlength="2" disabled/>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>책 소개</label>
	    			</div>
	    			<div class="form_section_content bit">
	    				<textarea name="book_intro" id="book_intro_textarea" disabled>${goodsInfo.book_intro }</textarea>
	    			</div>
	    		</div>
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>책 목차</label>
	    			</div>
	    			<div class="form_section_content bct">
	    				<textarea name="book_contents" id="book_contents_textarea">${goodsInfo.book_contents }</textarea>
	    			</div>
	    		</div>
	    		
	    		<div class="form_section">
	    			<div class="form_section_title">
	    				<label>상품 이미지</label>
	    			</div>
	    			<div class="form_section_content">
	    				
	    				<div id="uploadReslut">
	    					
	    				</div>
	    			</div>
	    		</div>
	    		
	    		<div class="btn_section">
	    			<button id="cancelBtn" class="btn">상품 목록</button>
	    			<button id="modifyBtn" class="btn enroll_btn">수정</button>
	    		</div>
	    	</div>	<!-- End - class="admin_content_main" -->

	    	<form id="moveForm" action="/admin/goodsManage" method="get">
	    		<input type="hidden" name="pageNum" value="${cri.pageNum }"/>
	    		<input type="hidden" name="amount" value="${cri.amount }"/>
	    		<input type="hidden" name="keyword" value="${cri.keyword }"/>
	    	</form>
	    	
	    </div>	<!-- End - class="admin_content_wrap" -->
	    
	    
		
	<%@ include file="../includes/admin/footer.jsp" %>
	
	
	
<script>
	
	$(document).ready(function() {
		
		/* 할인율 값 삽입 */
		let bookDiscount	= '<c:out value="${goodsInfo.book_discount}"/>' * 100;
		$("#discount_interface").attr("value", bookDiscount);
		
		/* 출판일 값 삽입 */
		let publeYear 		= '${goodsInfo.publeYear}';
		let length			= publeYear.indexOf(" ");
		
		publeYear			= publeYear.substring(0, length);
		
		$("input[name='publeYear']").attr("value", publeYear)
		
		/* 책 소개 */
		ClassicEditor
			.create(document.querySelector('#book_intro_textarea'))
			.then(editor=>{
				console.log(editor)
				editor.isReadOnly = true;
			})
			.catch(error=>{
				console.error(error);
			});
		
		/* 책 목차 */
		ClassicEditor
			.create(document.querySelector('#book_contents_textarea'))
			.then(editor=>{
				console.log(editor)
				editor.isReadOnly = true;
			})
			.catch(error=>{
				console.error(error);
			});
		
		/* 카테고리 */
		let cateList = JSON.parse('${cateList}');

		let cate1Array = new Array();
		let cate2Array = new Array();
		let cate3Array = new Array();
		let cate1Obj = new Object();
		let cate2Obj = new Object();
		let cate3Obj = new Object();
		
		let cateSelect1 = $(".cate1");		
		let cateSelect2 = $(".cate2");
		let cateSelect3 = $(".cate3");
		
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
		
		/* 배열 정리 */
		let targetCate2 = '';
		let targetCate3 = '${goodsInfo.cateCode}';
		
		for(let i = 0; i < cate3Array.length; i++){
			if(targetCate3 == cate3Array[i].cateCode){
				targetCate3 = cate3Array[i];
			}
		}// for		
		
		/* 소분류 카테고리 */
		for(let i = 0; i < cate3Array.length; i++) {
			if(targetCate3.cate_parent === cate3Array[i].cate_parent) {
				cateSelect3.append("<option value='"+cate3Array[i].cateCode+"'>" + cate3Array[i].cate_name + "</option>");
			}
		}
		$(".cate3 option").each(function(i, obj) {
			if(targetCate3.cateCode === obj.value) {
				$(obj).attr("selected", "selected");
			}
		});
		
		/* 중분류 카테고리 */
		for(let i=0; i<cate2Array.length; i++) {
			if(targetCate3.cate_parent === cate2Array[i].cateCode) {
				targetCate2 = cate2Array[i];
			}
		}
		
		for(let i = 0; i < cate2Array.length; i++) {
			if(targetCate2.cate_parent === cate2Array[i].cate_parent) {
				cateSelect2.append("<option value='"+cate2Array[i].cateCode+"'>" + cate2Array[i].cate_name + "</option>");
			}
		}		
		$(".cate2 option").each(function(i, obj) {
			if(targetCate2.cateCode === obj.value) {
				$(obj).attr("selected", "selected");
			}
		});
		
		/* 대분류 */
		for(let i=0; i<cate1Array.length; i++){
			cateSelect1.append("<option value='" + cate1Array[i].cateCode + "'>" + cate1Array[i].cate_name + "</option>");
		}
		$(".cate1 option").each(function(i, obj){
			if(targetCate2.cate_parent === obj.value){
				$(obj).attr("selected", "selected");
			}
		});	
		
		
		console.log('targetCate3 : ' + targetCate3);
		console.log('targetCate3.cate_name : ' 	+ targetCate3.cate_name);
		console.log('targetCate3.cateCode : ' 	+ targetCate3.cateCode);
		console.log('targetCate3.cate_parent : ' + targetCate3.cate_parent);
		
		/* 목록 이동 버튼 */
		$("#cancelBtn").on("click", function(e){
			e.preventDefault();
			$("#moveForm").submit();	
		});
		
		/* 수정 페이지 이동 */
		$("#modifyBtn").on("click", function(e){
			e.preventDefault();
			let addInput = '<input type="hidden" name="book_id" value="${goodsInfo.book_id}">';
			$("#moveForm").append(addInput);
			$("#moveForm").attr("action", "/admin/goodsModify");
			$("#moveForm").submit();
		});
		
		/* 이미지 정보 호출 */
		let book_id = '<c:out value="${goodsInfo.book_id}"/>';
		let uploadReslut = $("#uploadReslut");			
		
		$.getJSON("/getAttachList", {book_id : book_id}, function(arr){	
			
			if(arr.length == 0) {
				
				let str = "";
				str += "<div id='result_card'>";
				str += "<img src='../resources/img/goodsNoImage.png'>";
				str += "</div>";
				
				uploadReslut.html(str);	
				
				return;
			}
			
			let str = "";
			let obj = arr[0];	
			
			let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
			str += "<div id='result_card'";
			str += "data-path='" + obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "'";
			str += ">";
			str += "<img src='/display?fileName=" + fileCallPath +"'>";
			str += "</div>";		
			
			uploadReslut.html(str);						
			
		});	
		
		
	});	// End - $(document).ready(function())
	
	
	
	
</script>
	
	
</body>
</html>