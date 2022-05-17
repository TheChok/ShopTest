package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.CartDTO;

//----------------------------------------------------------------------------------------------------------//
// public class CartMapperTests
//----------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartMapperTests {
	
	@Autowired
	private CartMapper mapper;
	
/*	
	// 카트 추가
	@Test
	public void addCartTest() {
		String 	memeber_id 	= "test5";
		int		book_id		= 6;
		int		count		= 2;
		
		CartDTO cart		= new CartDTO();
		cart.setMember_id(memeber_id);
		cart.setBook_id(book_id);
		cart.setBook_count(count);
		
		int result = 0;
		result = mapper.addCart(cart);
		
		System.out.println("카트 추가, 테스트 결과 : " + result);
	}
*/
/*	
	// 카트 삭제
	@Test
	public void deleteCartTest() {
		int cart_id = 7;
		mapper.deleteCart(cart_id);
	
	}
*/	
/*	
	// 카트 수량 수정
	@Test
	public void modifyCartTest() {
		int cart_id = 8;
		int count 	= 10;
		
		CartDTO cart = new CartDTO();
		cart.setCart_id(cart_id);
		cart.setBook_count(count);
		
		mapper.modifyCount(cart);
	}
*/	
/*	
	// 카트 목록
	@Test
	public void getCartTest() {
		String member_id = "test5";
		
		List<CartDTO> list = mapper.getCart(member_id);
		for(CartDTO cart : list) {
			System.out.println(cart);
			cart.initSaleTotal();
			System.out.println("init cart  ==>" + cart);
		}
	}
*/	
/*	
	// 카트 확인
	@Test
	public void checkCartTest() {
		String member_id = "test5";
		int book_id = 6;
		
		CartDTO cart = new CartDTO();
		cart.setMember_id(member_id);
		cart.setBook_id(book_id);
		
		CartDTO resultCart = mapper.checkCart(cart);
		System.out.println("결과 ==>" + resultCart);
	}
*/	
/*	
	// 장바구니 제거
	@Test
	public void deleteOrderCartTest() {
		String 	member_id 	= "admin";
		int 	book_id		= 5;
		
		CartDTO dto = new CartDTO();
		dto.setMember_id(member_id);
		dto.setBook_id(book_id);
		
		mapper.deleteCart(book_id);
	}
*/	
	
	
	
	
} // End - public class CartMapperTests
