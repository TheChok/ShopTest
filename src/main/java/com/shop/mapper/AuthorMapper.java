package com.shop.mapper;

import java.util.List;

import com.shop.model.AuthorVO;
import com.shop.model.Criteria;

//-------------------------------------------------------------------------------------------------//
// public interface AuthorMapper
//-------------------------------------------------------------------------------------------------//
public interface AuthorMapper {
	
	// 작가 등록
	public void authorEnroll(AuthorVO author);
	
	// 작가 목록
	public List<AuthorVO> authorGetList(Criteria cri);
	
	// 작가 총 수
	public int authorGetTotal(Criteria cri);
	
	// 작가 상세
	public AuthorVO authorGetDetail(int author_id);
	
	// 작가 정보 수정
	public int authorModify(AuthorVO author);
	
	// 작가 정보 삭제
	public int authorDelete(int author_id);
	
	
	
	
	
	
	
	
}// End - public interface AuthorMapper
