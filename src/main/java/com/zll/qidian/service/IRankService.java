package com.zll.qidian.service;

import java.util.List;
import java.util.Map;

import com.zll.qidian.bean.Book;

public interface IRankService {
	/**
	 * 随机获取指定数量的书籍
	 * @param size 数量
	 * @return 书籍列表，当size > 数据库中的总数时返回所有的书籍
	 */
	List<Book> getRandomBooks(int size);

	/**
	 * 获取首页需要显示的书籍排名
	 * @return [{
	 * 		"name": 排名名称,
	 * 		"list": 书籍列表
	 * }]
	 */
	List<Map<String, Object>> getRanks();
}
