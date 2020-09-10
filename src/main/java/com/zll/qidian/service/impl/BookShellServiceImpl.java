package com.zll.qidian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zll.qidian.bean.Account;
import com.zll.qidian.bean.Book;
import com.zll.qidian.mapper.IBookShellMapper;
import com.zll.qidian.service.IBookShellService;

@Service
public class BookShellServiceImpl implements IBookShellService {
	
	@Autowired
	private IBookShellMapper bookShellMapper;

	@Override
	public List<Book> getBooksByAid(Account account) {
		if(account == null || account.getAid() == null)
			return null;
		return bookShellMapper.getBooksByAid(account.getAid());
	}

	@Override
	public int add(Account account, Integer bid) {
		if(account == null || account.getAid() == null)
			return -1;
		return bookShellMapper.add(account.getAid(), bid);
	}

}
