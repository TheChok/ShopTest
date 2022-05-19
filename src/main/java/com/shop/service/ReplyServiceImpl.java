package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.ReplyMapper;
import com.shop.model.ReplyDTO;


//-------------------------------------------------------------------------------------------------------------//
// End - public class ReplyServiceImpl implements ReplyService
//-------------------------------------------------------------------------------------------------------------//
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	//--------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------//
	@Override
	public int enrollReply(ReplyDTO dto) {
		
		int result = replyMapper.enrollReply(dto);
		
		return result;
	}

} // End - public class ReplyServiceImpl implements ReplyService
