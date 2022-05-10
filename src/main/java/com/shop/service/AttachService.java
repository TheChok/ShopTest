package com.shop.service;

import java.util.List;

import com.shop.model.AttachImageVO;

//---------------------------------------------------------------------------------------------------------------------------------------------//
// public interface AttachService
//---------------------------------------------------------------------------------------------------------------------------------------------//
public interface AttachService {
	
	// 이미지 데이터 반환
	public List<AttachImageVO> getAttachList(int book_id);
	
	
	
	
	
	
} // End - public interface AttachService
