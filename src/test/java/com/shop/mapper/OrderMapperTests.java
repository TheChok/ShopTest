package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.BookVO;

//----------------------------------------------------------------------------------------------------------------------------//
// public class OrderMapperTests
//----------------------------------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class OrderMapperTests {
	
	@Autowired
	private OrderMapper 	orderMapper;
	
/*
	// 상품 정보(주문 처리)
	@Test
	public void getOrderInfoTest() {
		
		OrderItemDTO orderInfo = orderMapper.getOrderInfo(12);
		System.out.println("조회 결과 : " + orderInfo);
		
	}
*/
/*	
	// 테이블 등록
	@Test
	public void enrollOrderTest() {
		
		OrderDTO ord = new OrderDTO();
		List<OrderItemDTO> orders = new ArrayList();
		
		OrderItemDTO order1 = new OrderItemDTO();
		
		order1.setBook_id(14);
		order1.setBook_count(5);
		order1.setBook_price(70000);
		order1.setBook_discount(0.1);
		order1.initSaleTotal();
		
		ord.setOrders(orders);
		
		ord.setOrder_id("test1");
		ord.setAddressee("test");
		ord.setMember_id("admin");
		ord.setMember_addr1("test1");
		ord.setMember_addr2("test2");
		ord.setMember_addr3("test3");
		ord.setOrder_state("배송준비");
		ord.getOrderPriceInfo();
		ord.setUsePoint(1000);
		
		orderMapper.enrollOrder(ord);
		
	}
*/	
/*
	// orderItem 테이블 등록
	@Test
	public void enrollOrderItemTest() {
		
		OrderItemDTO oid = new OrderItemDTO();
		
		oid.setOrder_id("test1");
		oid.setBook_id(14);
		oid.setBook_count(5);
		oid.setBook_price(70000);
		oid.setBook_discount(0.1);
		
		oid.initSaleTotal();
		
		orderMapper.enrollOrderItem(oid);
		
	}
*/
/*
	// 회원 돈, 포인트 정보 변경
	@Test
	public void deductMoneyTest() {
		MemberVO member = new MemberVO();
		
		member.setMember_id("admin5");
		member.setMoney(500000000);
		member.setPoint(100000000);
		
		orderMapper.deductMoney(member);
	}
*/	
/*
	// 상품 재고 변경
	@Test
	public void deductStockTest() {
		BookVO book = new BookVO();
		
		book.setBook_id(14);
		book.setBook_stock(256);
		
		orderMapper.deductStock(book);
	}
*/
	
	
	
	
	
	
	
	
} // End - public class OrderMapperTests











