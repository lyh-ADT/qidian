package com.zll.qidian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zll.qidian.bean.Book;
import com.zll.qidian.service.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private IBookService bookService; 
	
	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable("bookId") Integer bookId) {
		return bookService.getBookById(bookId);
	}
}
