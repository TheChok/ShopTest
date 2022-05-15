package com.shop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//-----------------------------------------------------------------------------------------------//
// public class CartServiceTests
//-----------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartServiceTests {
	
	@Autowired
	private CartService service;
	
/*
	@Test
	public void addCartTest() {
		//given
		String memberId = "test5";
		int bookId = 7;
		int count = 2;
		
		CartDTO dto = new CartDTO(); 
		dto.setMember_id(memberId);
		dto.setBook_id(bookId);
		dto.setBook_count(count);
		
		//when
		int result = service.addCart(dto);
		
		//then
		System.out.println("** result : " + result);
		
	}
*/	
/*	
	// 카트 삭제
	@Test
	public void cartDeleteTest() {
		int cart_id = 4;
		service.deleteCart(cart_id);
	}
*/	
	
	
	
	
	
	
	
} // End - public class CartServiceTests
