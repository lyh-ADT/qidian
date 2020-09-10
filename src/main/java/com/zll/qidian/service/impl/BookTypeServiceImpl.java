package com.zll.qidian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zll.qidian.bean.BookType;
import com.zll.qidian.mapper.IBookTypeMapper;
import com.zll.qidian.service.IBookTypeService;

@Service
public class BookTypeServiceImpl implements IBookTypeService {
	
	@Autowired
	private IBookTypeMapper bookTypeMapper;

	@Override
	public List<BookType> getAll() {
		return bookTypeMapper.getAll();
	}

}
