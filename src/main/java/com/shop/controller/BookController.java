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
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.mapper.AttachMapper;
import com.shop.model.AttachImageVO;
import com.shop.model.BookVO;
import com.shop.model.Criteria;
import com.shop.model.PageDTO;
import com.shop.model.ReplyDTO;
import com.shop.service.BookService;
import com.shop.service.ReplyService;

//---------------------------------------------------------------------------//
// public class BookController
//---------------------------------------------------------------------------//
@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private AttachMapper 	attachMapper;
	
	@Autowired
	private BookService 	bookService;
	
	@Autowired
	private ReplyService 	replyService;
	
	
	//---------------------------------------------------------------------------//
	// 메인페이지로 이동
	//---------------------------------------------------------------------------//
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainPageGET(Model model) {
		logger.info("메인페이지 요청받음");
		
		model.addAttribute("cate1", bookService.getCateCode1());
		model.addAttribute("cate2", bookService.getCateCode2());
		model.addAttribute("ls", 	bookService.likeSelect());
		
		System.out.println("ls 요청 결과 값 : " + bookService.likeSelect());
	}
	
	
	//---------------------------------------------------------------------------//
	// display 요청처리
	//---------------------------------------------------------------------------//
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
	
	//------------------------------------------------------------------------------------------//
	// 상품 검색
	//------------------------------------------------------------------------------------------//
	@GetMapping("search")
	public String searchGoodsGET(Criteria cri, Model model) {
		logger.info("cri : " + cri);
		
		List<BookVO> list = bookService.getGoodsList(cri);
		logger.info("pre list : " + list);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			logger.info("list : " + list);
			
		} else {
			model.addAttribute("listcheck", "empty");
			
			return "search";
		}
		
		model.addAttribute("pageMaker", new PageDTO(cri, bookService.goodsGetTotal(cri)));
		
		String[] typeArr = cri.getType().split("");
		
		for(String s : typeArr) {
			if(s.equals("T") || s.equals("A")) {
				model.addAttribute("filter_info", bookService.getCateInfoList(cri));
			}
		}
		
		return "search";
	}
	
	//------------------------------------------------------------------------------------------//
	// 상품 검색
	//------------------------------------------------------------------------------------------//
	@GetMapping("/goodsDetail/{book_id}")
	public String goodsDetailGET(@PathVariable("book_id")int book_id, Model model) {
		logger.info("goodsDetailGET().................");
		
		model.addAttribute("goodsInfo", bookService.getGoodsInfo(book_id));
		
		return "goodsDetail";
	}
	
	//------------------------------------------------------------------------------------------//
	// 리뷰 쓰기
	//------------------------------------------------------------------------------------------//
	@GetMapping("/replyEnroll/{member_id}")
	public String replyEnrollWindowGET(@PathVariable("member_id")String member_id, int book_id, Model model) {
		BookVO book = bookService.getBookIdName(book_id);
		model.addAttribute("bookInfo", book);
		model.addAttribute("memberId", member_id);
		
		return "/replyEnroll";
	}	
	
	//------------------------------------------------------------------------------------------//
	// 리뷰 수정 팝업창
	//------------------------------------------------------------------------------------------//
	@GetMapping("/replyUpdate")
	public String replyUpdateWindowGET(ReplyDTO dto, Model model) {
		System.out.println("리뷰 수정 컨트롤러에 진입했습니다.");
		
		BookVO book = bookService.getBookIdName(dto.getBook_id());
		model.addAttribute("bookInfo", book);
		model.addAttribute("replyInfo", replyService.getUpdateReply(dto.getReply_id()));
		model.addAttribute("member_id", dto.getMember_id());
		
		return "/replyUpdate";
	}
	
	
	
} // End - public class BookController










