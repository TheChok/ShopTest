package com.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//---------------------------------------------------------------------------------------------------//
// 
//---------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class PageDTO {
	
	private int 		pageStart;		// 페이지 시작 번호 
	private int 		pageEnd;		// 페이지 끝 번호
	private boolean		prev, next;		// 이전, 다음 버튼 존재 유무
	private int			total;			// 행 전체 개수
	private Criteria	cri;			// 현재페이지 번호, 행 표시 수, 검색키워드, 검색종류
	
	// 생성자 - 클래스 호출 시 각 변수 값 초기화
	public PageDTO(Criteria cri, int total) {
		
		this.cri		= cri;
		this.total		= total;
		
		this.pageEnd	= (int)(Math.ceil(cri.getPageNum()/10.0))*10;	// 페이지 끝 번호
		this.pageStart	= this.pageEnd-9;								// 페이지 시작 번호
		
		int realEnd		= (int)(Math.ceil(total*1.0/cri.getAmount()));	// 페이지 호출마다 확인할 끝 번호
		
		if(realEnd < pageEnd) {											// 페이지 끝 번호 유효성 체크
			this.pageEnd = realEnd;
		}
		
		this.prev		= this.pageStart > 1;
		this.next		= this.pageEnd	< realEnd;
		
	}
	
	
	
} // End - public class PageDTO
