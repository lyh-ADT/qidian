package com.zll.qidian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zll.qidian.bean.Book;

@Mapper
public interface IBookMapper {
	List<Book> getAllBooks();

	/**
	 * 根据书籍编号返回书籍信息
	 * @param bookId 书籍编号
	 * @return 书籍实体类
	 */
	Book getBookById(Integer bookId);
}
