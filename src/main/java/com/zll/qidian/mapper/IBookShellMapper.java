package com.zll.qidian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zll.qidian.bean.Book;

@Mapper
public interface IBookShellMapper {
	/**
	 * 获取用户的书架中的书籍
	 * @param aid 用户编号
	 * @return 书籍列表
	 */
	List<Book> getBooksByAid(Integer aid);
	
	/**
	 * 添加一本书到用户书架
	 * @param aid 用户编号
	 * @param bid 书籍编号
	 * @return 更新条数
	 */
	int add(Integer aid, Integer bid);
}
