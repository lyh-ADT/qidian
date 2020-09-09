package com.zll.qidian.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zll.qidian.bean.Account;

@Mapper
public interface IAccountMapper {
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
	 * 注册添加账户
	 * @param account 账户信息
	 * @return 添加成功返回1，否则返回0
	 */
	int add(Account account);
}
