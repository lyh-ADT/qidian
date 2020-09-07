package com.zll.qidian.service;

import com.zll.qidian.bean.Book;

public interface IBookService {
	/**
	 * 根据书籍编号返回书籍信息
	 * @param bookId 书籍编号
	 * @return 书籍实体类
	 */
	Book getBookById(Integer bookId);
}
