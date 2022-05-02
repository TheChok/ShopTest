package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.AdminMapper;
import com.shop.model.BookVO;

import lombok.extern.log4j.Log4j;


//----------------------------------------------------------------------------------------------------------------//
// public class AdminServiceImpl implements AdminService
//----------------------------------------------------------------------------------------------------------------//
@Service
@Log4j
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	
	// 상품 등록
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(service)bookEnroll....");
		
		adminMapper.bookEnroll(book);
		
	}

} // End - public class AdminServiceImpl implements AdminService














