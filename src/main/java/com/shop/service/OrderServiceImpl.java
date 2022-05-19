package com.shop.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.mapper.AttachMapper;
import com.shop.mapper.BookMapper;
import com.shop.mapper.CartMapper;
import com.shop.mapper.MemberMapper;
import com.shop.mapper.OrderMapper;
import com.shop.model.AttachImageVO;
import com.shop.model.BookVO;
import com.shop.model.CartDTO;
import com.shop.model.MemberVO;
import com.shop.model.OrderCancelDTO;
import com.shop.model.OrderDTO;
import com.shop.model.OrderItemDTO;
import com.shop.model.OrderPageItemDTO;

//-----------------------------------------------------------------------------------------------------------------------//
// public class OrderServiceImpl implements OrderService
//-----------------------------------------------------------------------------------------------------------------------//
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper 	orderMapper;
	
	@Autowired
	private AttachMapper	attachMapper;
	
	@Autowired
	private MemberMapper	memberMapper;
	
	@Autowired
	private CartMapper		cartMapper;
	
	@Autowired
	private BookMapper		bookMapper;
	
	//-----------------------------------------------------------------------------------------//
	// 주문상품 정보
	//-----------------------------------------------------------------------------------------//
	@Override
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
		
		List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();
		
		for(OrderPageItemDTO ord : orders) {
			
			OrderPageItemDTO goodsInfo = orderMapper.getGoodsInfo(ord.getBook_id());
			
			goodsInfo.setBook_count(ord.getBook_count());
			goodsInfo.initSaleTotal();
			
				// 이미지 추가
				List<AttachImageVO> imageList = attachMapper.getAttachList(goodsInfo.getBook_id());
				goodsInfo.setImageList(imageList);
			
			result.add(goodsInfo);
		}
		
		return result;
	}
	
	//-----------------------------------------------------------------------------------------//
	// 주문
	//-----------------------------------------------------------------------------------------//
	@Override
	@Transactional
	public void order(OrderDTO ord) {
		/* 사용할 데이터가져오기 */
		/* 회원 정보 */
		MemberVO member = memberMapper.getMemberInfo(ord.getMember_id());
		/* 주문 정보 */
		List<OrderItemDTO> ords = new ArrayList<>();
		for(OrderItemDTO oit : ord.getOrders()) {
			OrderItemDTO orderItem = orderMapper.getOrderInfo(oit.getBook_id());
			// 수량 셋팅
			orderItem.setBook_count(oit.getBook_count());
			// 기본정보 셋팅
			orderItem.initSaleTotal();
			//List객체 추가
			ords.add(orderItem);
		}
		/* OrderDTO 셋팅 */
		ord.setOrders(ords);
		ord.getOrderPriceInfo();
		
	/*DB 주문,주문상품(,배송정보) 넣기*/
		
		/* orderId만들기 및 OrderDTO객체 orderId에 저장 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderId = member.getMember_id() + format.format(date);
		ord.setOrder_id(orderId);
		
		/* db넣기 */
		orderMapper.enrollOrder(ord);		//vam_order 등록
		for(OrderItemDTO oit : ord.getOrders()) {		//vam_orderItem 등록
			oit.setOrder_id(orderId);
			orderMapper.enrollOrderItem(oit);			
		}

	/* 비용 포인트 변동 적용 */
		
		/* 비용 차감 & 변동 돈(money) Member객체 적용 */
		int calMoney = member.getMoney();
		calMoney -= ord.getOrderFinalSalePrice();
		member.setMoney(calMoney);
		
		/* 포인트 차감, 포인트 증가 & 변동 포인트(point) Member객체 적용 */
		int calPoint = member.getPoint();
		calPoint = calPoint - ord.getUsePoint() + ord.getOrderSavePoint();	// 기존 포인트 - 사용 포인트 + 획득 포인트
		member.setPoint(calPoint);
			
		/* 변동 돈, 포인트 DB 적용 */
		orderMapper.deductMoney(member);
		
	/* 재고 변동 적용 */
		for(OrderItemDTO oit : ord.getOrders()) {
			/* 변동 재고 값 구하기 */
			BookVO book = bookMapper.getGoodsInfo(oit.getBook_id());
			book.setBook_stock(book.getBook_stock() - oit.getBook_count());
			/* 변동 값 DB 적용 */
			orderMapper.deductStock(book);
		}			
		
	/* 장바구니 제거 */
		for(OrderItemDTO oit : ord.getOrders()) {
			CartDTO dto = new CartDTO();
			dto.setMember_id(ord.getMember_id());
			dto.setBook_id(oit.getBook_id());
			
			cartMapper.deleteOrderCart(dto);
		}
	}
	
	//-----------------------------------------------------------------------------------------//
	// 주문 취소
	//-----------------------------------------------------------------------------------------//
	@Override
	@Transactional
	public void orderCancel(OrderCancelDTO dto) {
		// 주문, 주문상품 객체
			// 회원
			MemberVO member = memberMapper.getMemberInfo(dto.getMember_id());
			
			// 주문상품
			List<OrderItemDTO> ords = orderMapper.getOrderItemInfo(dto.getOrder_id());
			for(OrderItemDTO ord : ords) {
				ord.initSaleTotal();
			}
			
			// 주문
			OrderDTO orw = orderMapper.getOrder(dto.getOrder_id());
			orw.setOrders(ords);
			orw.getOrderPriceInfo();
			
		// 주문상품 취소 DB
		orderMapper.orderCancle(dto.getOrder_id());
		
		// 돈, 포인트, 재고 변환
			// 돈
			int calMoney = member.getMoney();
			calMoney += orw.getOrderFinalSalePrice();
			member.setMoney(calMoney);
			
			// 포인트
			int calPoint = member.getPoint();
			calPoint = calPoint = orw.getUsePoint() - orw.getOrderSavePoint();
			
				// DB 적용
				orderMapper.deductMoney(member);
			
			// 재고
			for(OrderItemDTO ord : orw.getOrders()) {
				BookVO book = bookMapper.getGoodsInfo(ord.getBook_id());
				book.setBook_stock(book.getBook_stock() + ord.getBook_count());
				orderMapper.deductStock(book);
			}
			
		
	}
	
	
	
	
	
	
	
	
	
} // End - public class OrderServiceImpl implements OrderService




















