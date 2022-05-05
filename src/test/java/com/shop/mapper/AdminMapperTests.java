package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.BookVO;
import com.shop.model.Criteria;

//----------------------------------------------------------------------------------------------------------//
// public class AdminMapperTests
//----------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	BookVO book;

/*	
	// 상품 등록
	@Test
	public void bookEnrllTest() throws Exception {
		
		BookVO book = new BookVO();
		
		book.setBook_name("테스트");
		book.setAuthor_id(123);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("0231");
		book.setBook_price(25000);
		book.setBook_stock(250);
		book.setBook_discount(0.23);
		book.setBook_intro("책 소개");
		book.setBook_contents("책 목차");
		
		System.out.println("등록 요청할 book 정보 : " + book);
		
		adminMapper.bookEnroll(book);
		
	}
*/
/*	
	// 카테고리 리스트
	@Test
	public void cateListTest() throws Exception {
		
		System.out.println("cateList().........." + adminMapper.cateList());
		
	}
*/
/*
	// 상품 리스트 및 상품 총 갯수
	@Test
	public void goodsGetListTest() {
		
		Criteria cri = new Criteria();
		
		
		// 검색 조건
		cri.setKeyword("테스트");
		
		// 검색 리스트
		List list = adminMapper.goodsGetList(cri);
		for(int i=0; i<list.size(); i++) {
			System.out.println("result......... ==> " + i + " : " + list.get(i));
		}
	
	
		// 상품 총 갯수
		int result = adminMapper.goodsGetTotal(cri);
		System.out.println("result....... ==> " + result);
	}
*/		
/*	
	// 상품 상세 정보
	@Test
	public void goodsGetDetailTest() {
		
		int book_id	= 5;
		
		BookVO result = adminMapper.goodsGetDetail(book_id);
		
		System.out.println("상품 조회 데이터 : " + result);
	}
*/	
/*
	// 상품 정보 수정
	@Test
	public void goodsModifyTest() {
		
		BookVO book = new BookVO();
		
		book.setBook_id(1);
		book.setBook_name("아 테스형!");
		book.setAuthor_id(66);
		book.setPubleYear("2022-02-22");
		book.setPublisher("나훈출판사");
		book.setCateCode("103002");
		book.setBook_price(20000);
		book.setBook_discount(0.23);
		book.setBook_intro("세상이 왜이래~~");
		book.setBook_contents("왜 이렇게 힘들어~♬");
		
		adminMapper.goodsModify(book);
		
		
	}
*/
	// 상품 정보 삭제
	@Test
	public void goodsDeleteTest() {
		
		int bookId = 7;
		
		int result 	= adminMapper.goodsDelete(bookId); 
		
		if(result == 1) {
			System.out.println("삭제 성공");
		}
		
	}
		
		
		
		
} // End - public class AdminMapperTests
