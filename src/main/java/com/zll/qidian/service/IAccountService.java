package com.zll.qidian.service;

import com.zll.qidian.bean.Account;

public interface IAccountService {
	/**
	 * 根据账号编号查询账号
	 * @param aid 账号编号
	 * @return 账号实体类
	 */
	Account getAccountById(Integer aid);
	
	/**
	 * 登录查询
	 * @param account 账号信息
	 * @return 成功返回对应的账号，否则返回空
	 */
	Account login(Account account);
	
	/**
	 * 注册
	 * @param account 账号
	 * @param code 用户输入的邮箱验证码
	 * @param expectedCode 正确的邮箱验证码
	 * @return 成功信息
	 */
	boolean register(Account account, Integer code, Integer expectedCode);
	
	/**
	 * 验证邮箱
	 * @param email 邮箱地址
	 * @return 验证码
	 */
	Integer checkEmail(String email);
}
