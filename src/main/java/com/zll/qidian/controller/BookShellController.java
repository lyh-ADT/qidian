package com.zll.qidian.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zll.qidian.bean.Account;
import com.zll.qidian.bean.Book;
import com.zll.qidian.service.IBookShellService;

@RestController
@RequestMapping("/shell")
public class BookShellController {
	
	@Autowired
	private IBookShellService bookShellService;
	
	@GetMapping("/books")
	public List<Book> getAccountBooks(HttpSession session) {
		return bookShellService.getBooksByAid((Account) session.getAttribute("currentLoginAccount"));
	}
	
	@PutMapping("/book")
	public String addBookToShell(HttpSession session, Book book) {
		Account account = (Account) session.getAttribute("currentLoginAccount");
		if(bookShellService.add(account, book.getBid()) == 1)
			return "success";
		return "添加失败";
	}

}
