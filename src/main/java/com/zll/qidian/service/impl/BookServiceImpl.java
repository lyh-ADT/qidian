package com.zll.qidian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zll.qidian.bean.Book;
import com.zll.qidian.mapper.IBookMapper;
import com.zll.qidian.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookMapper bookMapper;
	
	@Override
	public Book getBookById(Integer bookId) {
		return bookMapper.getBookById(bookId);
	}

	@Override
	public List<Book> search(String bookKey, Integer tid) {
		return bookMapper.search(bookKey, tid);
	}

}
