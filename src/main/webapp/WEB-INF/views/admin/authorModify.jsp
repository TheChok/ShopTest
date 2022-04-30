<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="/resources/css/admin/authorModify.css?after">
	
	<script
  		src="https://code.jquery.com/jquery-3.4.1.js"
  		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  		crossorigin="anonymous">
	</script>
	
</head>
<body>

	<%@ include file="../includes/admin/header.jsp" %>
		
		<div class="admin_content_wrap">
			<div class="admin_content_subject"><span>작가 상세</span></div>
			<div class="admin_content_main">
			
				<form id="modifyForm" action="/admin/authorModify" method="post">
					<div class="form_section">
						<div class="form_section_title">
							<label>작가 번호</label>
						</div>
						<div class="form_section_content">
							<input class="input_block" name="author_id" readonly="readonly" value="<c:out value='${authorInfo.author_id }'></c:out>"/>
						</div>
					</div>
					<div class="form_section">
						<div class="form_section_title">
							<label>작가 이름</label>
						</div>
						<div class="form_section_content">
							<input name="author_name" value="<c:out value='${authorInfo.author_name }'></c:out>"/>
							<span id="warn_author_name">작가 이름을 입력해주세요.</span>
						</div>
					</div>
					<div class="form_section">
						<div class="form_section_title">
							<label>소속 국가</label>
						</div>
						<div class="form_section_content">
							<select class="input_block" name="nation_id">
								<option value="none" disabled="disabled">=== 선택 ===</option>
								<option value="01" <c:out value="${authorInfo.nation_id eq '01' ? 'selected' : ''}"/>>국내</option>
								<option value="02" <c:out value="${authorInfo.nation_id eq '02' ? 'selected' : ''}"/>>국외</option>
							</select>
						</div>
					</div>
					<div class="form_section">
						<div class="form_section_title">
							<label>작가 소개</label>
						</div>
						<div class="form_section_content">
							<textarea name="author_intro"><c:out value='${authorInfo.author_intro }'></c:out></textarea>
							<span id="warn_author_intro">작가 소개를 입력해주세요</span>
						</div>
					</div>
					<div class="form_section">
						<div class="form_section_title">
							<label>등록 날짜</label>
						</div>
						<div class="form_section_content">
							<input class="input_block" type="text" readonly="readonly" value="<fmt:formatDate value='${authorInfo.regdate }' pattern='yyyy-MM-dd' />"/>
						</div>
					</div>
					<div class="form_section">
						<div class="form_section_title">
							<label>수정 날짜</label>
						</div>
						<div class="form_section_content">
							<input class="input_block" type="text" readonly="readonly" value="<fmt:formatDate value='${authorInfo.updatedate }' pattern='yyyy-MM-dd' />"/>
						</div>
					</div>
					<div class="btn_section">
						<button id="cancelBtn" class="btn">작가 목록</button>
						<button id="modifyBtn" class="btn modify_btn">수 정</button>
					</div>
				</form>
				
			</div>
		</div>	<!-- End - class="admin_content_wrap" -->
	    
	    <form id="moveForm" method="get">
	    	<input type="hidden" name="author_id" 	value="<c:out value='${authorInfo.author_id }'></c:out>"/>
	    	<input type="hidden" name="pageNum" 	value="<c:out value='${cri.pageNum }'></c:out>"/>
	    	<input type="hidden" name="amount" 		value="<c:out value='${cri.amount }'></c:out>"/>
	    	<input type="hidden" name="keyword" 	value="<c:out value='${cri.keyword }'></c:out>"/>
	    </form>
		
	<%@ include file="../includes/admin/footer.jsp" %>

<script>
	
	let moveForm	= $("#moveForm");
	let modifyForm	= $("#modifyForm");
	
	/* 작가 상세 페이지 이동 버튼 */
	$(".cancelBtn").on("click", function(e){
		
		e.preventDafualt();
		
		moveForm.attr("action", "/admin/authorDetail");
		moveForm.submit();
		
	});
	
	/* 작가 수정 버튼 작동 및 유효성 검사 */
	$("#modifyBtn").on("click", function(e){
		
		let author_name		= $(".form_section_content input[name='author_name']").val();
		let author_intro	= $(".form_section_content textarea").val();
		
		let nameCk	= false;
		let introCk	= false;
		
		e.preventDafault();
		
		if(!author_name) {
			$("#warn_author_name").css("display", "block");
		} else {
			$("#warn_author_name").css("display", "none");
			nameCk = true;
		}
		
		if(!author_intro) {
			$("#warn_author_intro").css("display", "block");
		} else {
			$("#warn_author_intro").css("display", "none");
			introCk = true;
		}
		
		if(nameCk && introCk) {
			modifyForm.submit();
		} else {
			return false;
		}
		
	});
	
	
	
</script>


</body>
</html>