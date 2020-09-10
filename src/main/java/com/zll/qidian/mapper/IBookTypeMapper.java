package com.zll.qidian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zll.qidian.bean.BookType;

@Mapper
public interface IBookTypeMapper {
	List<BookType> getAll();
}
