package com.shop.mapper;

import java.util.List;

import com.shop.model.AttachImageVO;
import com.shop.model.BookVO;
import com.shop.model.CateVO;
import com.shop.model.Criteria;
import com.shop.model.OrderDTO;

//-----------------------------------------------------------------------------------------------------------//
// public interface AdminMapper
//-----------------------------------------------------------------------------------------------------------//
public interface AdminMapper {
	
	// 상품 등록
	public void bookEnroll(BookVO book);
	
	// 카테고리 리스트
	public List<CateVO> cateList();
	
	// 상품 리스트
	public List<BookVO> goodsGetList(Criteria cri);
	
	// 상품 총 개수
	public int goodsGetTotal(Criteria cri);
	
	// 상품 조회 페이지
	public BookVO goodsGetDetail(int book_id);
	
	// 상품 수정
	public int goodsModify(BookVO vo);
	
	// 상품 정보 삭제
	public int goodsDelete(int book_id);
	
	// 이미지 등록
	public void imageEnroll(AttachImageVO vo);
	
	// 지정 상품 이미지 전체 삭제(이미지만 삭제)
	public void deleteImageAll(int book_id);
	
	// 어제자 날짜 이미지 리스트
	public List<AttachImageVO> checkFileList();
	
	// 지정 상품 이미지 정보 얻기
	public List<AttachImageVO> getAttachInfo(int book_id);
	
	// 주문 상품 리스트
	public List<OrderDTO> getOrderList(Criteria cri);
	
	// 주문 총 갯수
	public int getOrderTotal(Criteria cri);
	
	
	
	
	
	
	
	
	
	
	
	
	
} // End - public interface AdminMapper












