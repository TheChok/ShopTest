package com.shop.mapper;

import java.util.List;

import com.shop.model.BookVO;
import com.shop.model.Criteria;

//-------------------------------------------------------------------------------------------------------------------//
// public interface BookMapper
//-------------------------------------------------------------------------------------------------------------------//
public interface BookMapper {
	
	// 상품 검색
	public List<BookVO> getGoodsList(Criteria cri);
	
	// 상품 총 갯수
	public int goodsGetTotal(Criteria cri);
	
	
	
	
	
	
	
	
} // End - public interface BookMapper
