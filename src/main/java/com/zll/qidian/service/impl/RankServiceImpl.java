package com.zll.qidian.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

	@Override
	public List<Map<String, Object>> getRanks() {
		final int SIZE = 10;
		final String[] listNames = {"起点月票榜·新书", "24小时热销榜", "新增粉丝榜", "阅读指数榜", "签约作者新书榜"};
		List<Map<String, Object>> result = new LinkedList<>();
		for(String listName : listNames) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("name", listName);
			map.put("list", this.getRandomBooks(SIZE));
			result.add(map);
		}
		return result;
	}

}
