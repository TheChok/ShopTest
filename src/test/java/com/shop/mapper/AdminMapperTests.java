package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.BookVO;
import com.shop.service.AdminService;

//-------------------------------------------------------------------------------------------------------------//
// public class AdminMapperTests
//-------------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTests {
	
	@Autowired
	private AdminService adminService;
	
	// 상품 등록
	@Test
	public void bookEnrollTest() throws Exception {
		
		BookVO book = new BookVO();
		
		book.setBook_name("mapper 테스트");
		book.setAuthor_id(123);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("0231");
		book.setBook_price(20000);
		book.setBook_stock(300);
		book.setBook_discount(0.23);
		book.setBook_intro("책 소개");
		book.setBook_contents("책 목차");
		
		adminService.bookEnroll(book);
		
		
	}
	
	
	
	
	
	
	
	
} // End - public class AdminMapperTests
