package com.zll.qidian.service.impl;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zll.qidian.bean.Account;
import com.zll.qidian.mapper.IAccountMapper;
import com.zll.qidian.service.IAccountService;
import com.zll.qidian.util.EmailUtil;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountMapper accountMapper;
	
	@Override
	public Account getAccountById(Integer aid) {
		return accountMapper.getAccountById(aid);
	}

	@Override
	public Account login(Account account) {
		return accountMapper.login(account);
	}

	@Override
	public boolean register(Account account, Integer code, Integer expectedCode) {
		System.out.println(code + "," + expectedCode);
		if(!code.equals(expectedCode)) {
			return false;
		}
		return accountMapper.add(account) == 1;
	}

	@Override
	public Integer checkEmail(String email) {
		int num = (int) Math.round(Math.random() * 1000000);
		String code = String.valueOf(num);
		try {
			EmailUtil.send(email, code);
			return num;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
