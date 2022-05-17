package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.AttachMapper;
import com.shop.mapper.OrderMapper;
import com.shop.model.AttachImageVO;
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
	
	
} // End - public class OrderServiceImpl implements OrderService




















