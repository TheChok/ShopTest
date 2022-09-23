package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.mapper.ReplyMapper;
import com.shop.model.Criteria;
import com.shop.model.PageDTO;
import com.shop.model.ReplyDTO;
import com.shop.model.ReplyPageDTO;
import com.shop.model.UpdateReplyDTO;


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
		setRating(dto.getBook_id());
		return result;
	}
	
	//--------------------------------------------------------------------------------------//
	// 댓글 존재여부 확인
	//--------------------------------------------------------------------------------------//
	@Override
	public String checkReply(ReplyDTO dto) {
		Integer result = replyMapper.checkReply(dto);
		if(result != null) 	return "1";
		else 				return "0";
		
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
	
	//--------------------------------------------------------------------------------------//
	// 댓글 수정
	//--------------------------------------------------------------------------------------//
	@Override
	public int updateReply(ReplyDTO dto) {
		int result = replyMapper.updateReply(dto);
		setRating(dto.getBook_id());
		return result;
	}

	//--------------------------------------------------------------------------------------//
	// 댓글 한 개 정보(수정페이지)
	//--------------------------------------------------------------------------------------//
	@Override
	public ReplyDTO getUpdateReply(int reply_id) {
		return replyMapper.getUpdateReply(reply_id);
	}
	
	//--------------------------------------------------------------------------------------//
	// 댓글 삭제
	//--------------------------------------------------------------------------------------//
	@Override
	public int deleteReply(ReplyDTO dto) {
		int result = replyMapper.deleteReply(dto.getReply_id());
		setRating(dto.getBook_id());
		return result;
	}
	
	//--------------------------------------------------------------------------------------//
	// 평점 평균 반영 및 등록
	//--------------------------------------------------------------------------------------//
	@Transactional
	public void setRating(int book_id) {
		Double ratingAvg = replyMapper.getRatingAverage(book_id);
		
		if(ratingAvg == null) ratingAvg = 0.0;
		
		ratingAvg = (double)(Math.round(ratingAvg*10));
		ratingAvg = ratingAvg / 10;
		
		UpdateReplyDTO urd = new UpdateReplyDTO();
		urd.setBook_id(book_id);
		urd.setRatingAvg(ratingAvg);
		
		replyMapper.updateRating(urd);
		
	}
	
	
	
} // End - public class ReplyServiceImpl implements ReplyService




























