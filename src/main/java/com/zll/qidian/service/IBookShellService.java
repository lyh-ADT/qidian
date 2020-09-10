package com.zll.qidian.service;

import java.util.List;

import com.zll.qidian.bean.Account;
import com.zll.qidian.bean.Book;

public interface IBookShellService {
	/**
	 * 获取用户的书架中的书籍
	 * @param account 用户
	 * @return 书籍列表
	 */
	List<Book> getBooksByAid(Account account);
	
	/**
	 * 添加一本书到用户书架
	 * @param aid 用户
	 * @param bid 书籍编号
	 * @return 更新条数
	 */
	int add(Account account, Integer bid);
}
