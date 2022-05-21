package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.ReplyMapper;
import com.shop.model.Criteria;
import com.shop.model.PageDTO;
import com.shop.model.ReplyDTO;
import com.shop.model.ReplyPageDTO;


//-------------------------------------------------------------------------------------------------------------//
// End - public class ReplyServiceImpl implements ReplyService
//-------------------------------------------------------------------------------------------------------------//
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	//--------------------------------------------------------------------------------------//
	// 댓글 등록
	//--------------------------------------------------------------------------------------//
	@Override
	public int enrollReply(ReplyDTO dto) {
		
		int result = replyMapper.enrollReply(dto);
		
		return result;
	}
	
	//--------------------------------------------------------------------------------------//
	// 댓글 존재 체크
	//--------------------------------------------------------------------------------------//
	@Override
	public String checkReply(ReplyDTO dto) {
		
		Integer result = replyMapper.checkReply(dto);
		
		if(result != null) {
			return "1";
		} else {
			return "0";
		}
		
		
		
	}

	//--------------------------------------------------------------------------------------//
	// 댓글 페이징
	//--------------------------------------------------------------------------------------//
	@Override
	public ReplyPageDTO replyList(Criteria cri) {
		ReplyPageDTO dto = new ReplyPageDTO();
		
		dto.setList(replyMapper.getReplyList(cri));
		dto.setPageInfo(new PageDTO(cri, replyMapper.getReplyTotal(cri.getBook_id())));
		
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // End - public class ReplyServiceImpl implements ReplyService




























