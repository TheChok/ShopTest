package com.shop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.AuthorVO;

//-----------------------------------------------------------------------------------------------------//
// public class AuthorServiceTests
//-----------------------------------------------------------------------------------------------------//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorServiceTests {
	
	// AuthorService 의존성 주입
	@Autowired
	private AuthorService service;
	
	@Test
	public void authorEnrollTest() throws Exception {
		
		AuthorVO author	= new AuthorVO();
		
		author.setNation_id("01");
		author.setAuthor_name("테스트");
		author.setAuthor_intro("테스트 소개");
		
		service.authorEnroll(author);
		
	}
	
	
	
	
} // End - public class AuthorServiceTests
