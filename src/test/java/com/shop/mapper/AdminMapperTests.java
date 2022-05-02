package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.BookVO;

//----------------------------------------------------------------------------------------------------------//
// public class AdminMapperTests
//----------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {
	
	@Autowired
	private AdminMapper adminMapper;

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
	
	// 카테고리 리스트
	@Test
	public void cateListTest() throws Exception {
		
		System.out.println("cateList().........." + adminMapper.cateList());
		
	}
	
	
	
	
} // End - public class AdminMapperTests
