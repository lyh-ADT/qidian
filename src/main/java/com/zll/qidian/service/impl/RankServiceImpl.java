package com.zll.qidian.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zll.qidian.bean.Book;
import com.zll.qidian.mapper.IBookMapper;
import com.zll.qidian.service.IRankService;

@Service
public class RankServiceImpl implements IRankService {
	
	@Autowired
	private IBookMapper bookMapper;

	@Override
	public List<Book> getRandomBooks(int size) {
		List<Book> selectedBooks = new LinkedList<>();
		List<Book> allBooks = bookMapper.getAllBooks();
		Random random = new Random();
		for(int i=0; i < size; i++) {
			int index = random.nextInt(allBooks.size());
			selectedBooks.add(allBooks.get(index));
		}
		return selectedBooks;
	}

}
