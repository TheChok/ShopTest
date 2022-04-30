package com.shop.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.AuthorMapper;
import com.shop.model.AuthorVO;
import com.shop.model.Criteria;


//--------------------------------------------------------------------------------------------------//
// public class AuthorServiceImpl implements AuthorService
//--------------------------------------------------------------------------------------------------//
@Service
public class AuthorServiceImpl implements AuthorService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);
	
	@Autowired
	AuthorMapper authorMapper;
	
	//--------------------------------------------------------------------------------------------------//
	// 작가 등록
	//--------------------------------------------------------------------------------------------------//
	@Override
	public void authorEnroll(AuthorVO author) throws Exception {
		
		authorMapper.authorEnroll(author);

	}
	
	//--------------------------------------------------------------------------------------------------//
	// 작가 목록
	//--------------------------------------------------------------------------------------------------//
	@Override
	public List<AuthorVO> authorGetList(Criteria cri) throws Exception {
		
		logger.info("(Service)authorGetList().................." + cri);
		
		return authorMapper.authorGetList(cri);
	}

	//--------------------------------------------------------------------------------------------------//
	// 작가 총 수
	//--------------------------------------------------------------------------------------------------//
	@Override
	public int authorGetTotal(Criteria cri) throws Exception {
		logger.info("(Service)authorGetTotal().................." + cri);
		return authorMapper.authorGetTotal(cri);
	}
	
	//--------------------------------------------------------------------------------------------------//
	// 작가 상세 페이지
	//--------------------------------------------------------------------------------------------------//	
	@Override
	public AuthorVO authorGetDetail(int author_id) throws Exception {
		logger.info("authorGetDetail 실행..... author_id : " + author_id);
		return authorMapper.authorGetDetail(author_id);
	}
	
	//--------------------------------------------------------------------------------------------------//
	// 작가 정보 수정
	//--------------------------------------------------------------------------------------------------//
	@Override
	public int authorModify(AuthorVO author) throws Exception {
		logger.info("authorModify 실행...... author 정보 : " + author);
		return authorMapper.authorModify(author);
	}
	
	
	
	
	
	
	
	
	
} // End - public class AuthorServiceImpl implements AuthorService
