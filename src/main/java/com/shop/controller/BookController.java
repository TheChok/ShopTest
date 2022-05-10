package com.shop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.mapper.AttachMapper;
import com.shop.model.AttachImageVO;

//---------------------------------------------------------------------------//
// public class BookController
//---------------------------------------------------------------------------//
@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private AttachMapper attachMapper;
	
	//---------------------------------------------------------------------------//
	// 메인페이지로 이동
	//---------------------------------------------------------------------------//
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainPageGET() {
		
		logger.info("메인페이지 요청받음");
		
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName) {
		
		logger.info("getImage()...................fileName : " + fileName);
		
		File file	= new File("c:\\upload\\" + fileName);
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//---------------------------------------------------------------------------//
	// 이미지 정보 반환
	//---------------------------------------------------------------------------//
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> getAttachList(int book_id) {
		logger.info("getAttachList............... book_id : " + book_id);
		
		return new ResponseEntity<List<AttachImageVO>>(attachMapper.getAttachList(book_id), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
} // End - public class BookController
