package com.zll.qidian.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zll.qidian.bean.Book;
import com.zll.qidian.service.IRankService;

/**
 * 首页排名
 * @author lyh-ADT
 *
 */
@RestController
@RequestMapping("/rank")
public class RankController {
	@Autowired
	private IRankService rankService;
	
	@GetMapping("/random")
	public List<Book> getRandomRank(@RequestParam(value="nums", required = false) Integer nums){
		if(nums == null) {
			nums = 10;
		}
		return rankService.getRandomBooks(nums);
	}
	
	@GetMapping("/ranks")
	public List<Map<String, Object>> getRanks() {
		return rankService.getRanks();
	}
}
