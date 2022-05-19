package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.model.ReplyDTO;
import com.shop.service.ReplyService;

//-----------------------------------------------------------------------------------------------------//
// public class ReplyController
//-----------------------------------------------------------------------------------------------------//
@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	//------------------------------------------------------------------------------------//
	// 댓글 등록
	//------------------------------------------------------------------------------------//
	@PostMapping("/enroll")
	public void enrollReplyPOST(ReplyDTO dto) {
		
		replyService.enrollReply(dto);
		
	}
	
	
	
	
	
	
	
} // End - public class ReplyController
