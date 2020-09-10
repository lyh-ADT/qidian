package com.zll.qidian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zll.qidian.bean.Account;
import com.zll.qidian.service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private IAccountService accountService;
	
	@PutMapping("")
	public String register(HttpServletRequest request, @RequestBody Account account) {
		if(accountService.register(account, account.getAid(), (Integer)request.getSession().getAttribute("emailCode"))) {
			return "success";
		}
		return "注册失败";
	}
	
	@PostMapping("")
	public String login(HttpServletRequest request, @RequestBody Account account) {
		account = accountService.login(account);
		if(account == null) {
			return "登录失败";
		}
		request.getSession().setAttribute("currentLoginAccount", account);
		return "success";
	}
	
	@GetMapping("")
	public Object getAccount(HttpSession session) {
		return session.getAttribute("currentLoginAccount");
	}
	
	@GetMapping("/checkEmail")
	public void checkEmail(HttpServletRequest request, String email) {
		Integer code = accountService.checkEmail(email);
		request.getSession().setAttribute("emailCode", code);
	}
}
