package com.shop.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//-------------------------------------------------------------------------------------------------------------------------//
// public class ReplyPageDTO
//-------------------------------------------------------------------------------------------------------------------------//
@Getter
@Setter
@ToString
public class ReplyPageDTO {
	
	List<ReplyDTO> 	list;
	PageDTO			pageInfo;
	
} // End - public class ReplyPageDTO
