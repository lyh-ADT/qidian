package com.zll.qidian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zll.qidian.bean.BookType;
import com.zll.qidian.service.IBookTypeService;

/**
 * 书籍类型
 * @author lyh-ADT
 *
 */
@RestController
@RequestMapping("/booktype")
public class BookTypeController {
	@Autowired
	private IBookTypeService bookTypeService;
	
	@GetMapping("/all")
	public List<BookType> getAll(){
		return bookTypeService.getAll();
	}
}
