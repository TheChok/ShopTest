package com.shop.service;

import com.shop.model.Criteria;
import com.shop.model.ReplyDTO;
import com.shop.model.ReplyPageDTO;

//--------------------------------------------------------------------------------------------------------------//
// public interface ReplyService
//--------------------------------------------------------------------------------------------------------------//
public interface ReplyService {
	
	// 댓글 등록
	public int enrollReply(ReplyDTO dto);
	
	// 댓글 존재 체크
	public String checkReply(ReplyDTO dto);
	
	// 댓글 페이징
	public ReplyPageDTO replyList(Criteria cri);
	
	
	
	
	
} // End - public interface ReplyService
