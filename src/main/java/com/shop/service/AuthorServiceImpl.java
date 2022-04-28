package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.AuthorMapper;
import com.shop.model.AuthorVO;


//--------------------------------------------------------------------------------------------------//
// public class AuthorServiceImpl implements AuthorService
//--------------------------------------------------------------------------------------------------//
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorMapper authorMapper;
	
	//--------------------------------------------------------------------------------------------------//
	// 작가 등록
	//--------------------------------------------------------------------------------------------------//
	@Override
	public void authorEnroll(AuthorVO author) throws Exception {
		
		authorMapper.authorEnroll(author);

	}

} // End - public class AuthorServiceImpl implements AuthorService
