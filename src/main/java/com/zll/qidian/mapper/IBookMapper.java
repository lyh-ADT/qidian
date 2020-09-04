package com.zll.qidian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zll.qidian.bean.Book;

@Mapper
public interface IBookMapper {
	List<Book> getAllBooks();
}
