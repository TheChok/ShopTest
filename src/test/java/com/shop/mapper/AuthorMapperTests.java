package com.shop.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.AuthorVO;

//------------------------------------------------------------------------------//
// public class AuthorMapperTests
//------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorMapperTests {
	
	@Autowired
	private AuthorMapper mapper;
	
	// 작가 등록 테스트
	@Test
	public void authorEnroll() throws Exception {
		
		AuthorVO author = new AuthorVO();
		
		author.setAuthor_name("테스트");
		author.setNation_id("01");
		author.setAuthor_intro("테스트 소개");
		
		mapper.authorEnroll(author);
		
	}
	
	
	
	
	
} // End - public class AuthorMapperTests
