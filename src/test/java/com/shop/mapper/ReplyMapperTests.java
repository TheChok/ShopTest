package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.controller.AdminController;
import com.shop.model.ReplyDTO;

//---------------------------------------------------------------------------------------------------//
// public class ReplyMapperTests
//---------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests extends AdminController{
	
	@Autowired
	private ReplyMapper mapper;
	
	
	
	@Test
	public void enrollReplyTest() {
		
		String 	id 		= "admin";
		int		book_id = 13;
		double	rating	= 3.5;
		String	content = "댓글 테스트";
		
		ReplyDTO dto	= new ReplyDTO();
		dto.setBook_id(book_id);
		dto.setMember_id(id);
		dto.setRating(rating);
		dto.setContent(content);
		
		mapper.enrollReply(dto);
		
		try {
			super.adminMainGET();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
} // End - public class ReplyMapperTests
