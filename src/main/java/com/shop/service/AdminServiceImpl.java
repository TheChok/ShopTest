package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.mapper.AdminMapper;
import com.shop.model.BookVO;
import com.shop.model.CateVO;
import com.shop.model.Criteria;

import lombok.extern.log4j.Log4j;


//----------------------------------------------------------------------------------------------------------------//
// public class AdminServiceImpl implements AdminService
//----------------------------------------------------------------------------------------------------------------//
@Service
@Log4j
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	//--------------------------------------------------------------------------------//
	// 상품 등록
	//--------------------------------------------------------------------------------//
	@Transactional
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(service)bookEnroll....");
		
		adminMapper.bookEnroll(book);
		
		if(book.getImageList() == null || book.getImageList().size() <= 0) {
			return;
		}
		
		book.getImageList().forEach(attach ->{
			
			System.out.println("book.getBook_id ==> " + book.getBook_id());
			
			attach.setBook_id(book.getBook_id());
			adminMapper.imageEnroll(attach);
			
		});
		
	}
	
	//--------------------------------------------------------------------------------//
	// 카테고리 리스트
	//--------------------------------------------------------------------------------//
	@Override
	public List<CateVO> cateList() {
		
		log.info("(service)cateList.........");
		
		return adminMapper.cateList();
	}

	//--------------------------------------------------------------------------------//
	// 상품 리스트
	//--------------------------------------------------------------------------------//
	@Override
	public List<BookVO> goodsGetList(Criteria cri) {
		log.info("goodsGetList...............");
		return adminMapper.goodsGetList(cri);
	}
	
	//--------------------------------------------------------------------------------//
	// 상품 총 개수
	//--------------------------------------------------------------------------------//
	@Override
	public int goodsGetTotal(Criteria cri) {
		log.info("goodsGetTotal.............");
		return adminMapper.goodsGetTotal(cri);
	}

	//--------------------------------------------------------------------------------//
	// 상품 조회 페이지
	//--------------------------------------------------------------------------------//
	@Override
	public BookVO goodsGetDetail(int book_id) {
		log.info("(service)bookGetDetail....... bookId : " + book_id);
		return adminMapper.goodsGetDetail(book_id);
	}
	
	//--------------------------------------------------------------------------------//
	// 상품 정보 수정
	//--------------------------------------------------------------------------------//
	@Transactional
	@Override
	public int goodsModify(BookVO vo) {
		log.info("goodsModify.................");
		
		int result = adminMapper.goodsModify(vo);
		
		if(result == 1 && vo.getImageList() != null && vo.getImageList().size() > 0) {
			adminMapper.deleteImageAll(vo.getBook_id());
			
			vo.getImageList().forEach(attach -> {
				attach.setBook_id(vo.getBook_id());
				adminMapper.imageEnroll(attach);
				
			});
			
		}
		
		return result;
	}

	//--------------------------------------------------------------------------------//
	// 상품 정보 삭제
	//--------------------------------------------------------------------------------//
	@Override
	public int goodsDelete(int book_id) {
		log.info("goodsDelete.................");
		return adminMapper.goodsDelete(book_id);
	}
	
	
	
	
	
	
	
	
	
	
	

} // End - public class AdminServiceImpl implements AdminService














