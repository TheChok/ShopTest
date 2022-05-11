package com.shop.service;

import java.util.List;

import com.shop.model.BookVO;
import com.shop.model.CateVO;
import com.shop.model.Criteria;

//-------------------------------------------------------------------------------------------------------------//
// public interface BookService
//-------------------------------------------------------------------------------------------------------------//
public interface BookService {
	
	// 상품 검색
	public List<BookVO> getGoodsList(Criteria cri);
	
	// 상품 총 갯수
	public int goodsGetTotal(Criteria cri);
	
	// 국내 카테고리 리스트
	public List<CateVO> getCateCode1();
	
	// 외국 카테고리 리스트
	public List<CateVO> getCateCode2();
	
	
	
	
	
} // End - public interface BookService
