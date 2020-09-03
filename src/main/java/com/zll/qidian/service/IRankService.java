package com.zll.qidian.service;

import java.util.List;

import com.zll.qidian.bean.Book;

public interface IRankService {
	/**
	 * 随机获取指定数量的书籍
	 * @param size 数量
	 * @return 书籍列表，当size > 数据库中的总数时返回所有的书籍
	 */
	List<Book> getRandomBooks(int size);
}
