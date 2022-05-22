package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Criteria;
import com.shop.model.ReplyDTO;
import com.shop.model.ReplyPageDTO;
import com.shop.service.ReplyService;

//-----------------------------------------------------------------------------------------------------//
// public class ReplyController
//-----------------------------------------------------------------------------------------------------//
@RestController
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
	
	//------------------------------------------------------------------------------------//
	// 댓글 존재 체크
	// member_id, book_id 파라미터
	// 댓글 있으면 1, 없으면 0
	//------------------------------------------------------------------------------------//
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public String replyCheckPOST(ReplyDTO dto) {
		return replyService.checkReply(dto);
	}
	
	//------------------------------------------------------------------------------------//
	// 댓글 페이징
	//------------------------------------------------------------------------------------//
	@GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ReplyPageDTO replyListPOST(Criteria cri) {
		return replyService.replyList(cri);
	}
	
	//------------------------------------------------------------------------------------//
	// 댓글 수정
	//------------------------------------------------------------------------------------//
	@PostMapping("/update")
	public void replyModifyPOST(ReplyDTO dto) {
		replyService.updateReply(dto);
	}
	
	//------------------------------------------------------------------------------------//
	// 댓글 삭제
	//------------------------------------------------------------------------------------//
	@PostMapping("/delete")
	public void replyDeletePOST(ReplyDTO dto) {
		System.out.println("댓글 삭제 컨트롤러에 진입했습니다.");
		replyService.deleteReply(dto);
	}
	
	
	
	
	
	
	
	
} // End - public class ReplyController
















