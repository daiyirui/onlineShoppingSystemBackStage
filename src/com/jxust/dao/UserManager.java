package com.jxust.dao;

import java.util.List;


import com.jxust.entity.User;


/**
 * @author shymain
 *
 */
public interface UserManager {

	
	
	/**
	 * 检测登录
	 * @param username
	 * @param userpassword
	 */
	public int checkLogin(String username, String userpassword);

	/**
	 * 查找所有会员
	 * @return
	 */
	public List<User> findAllUser();

	/**
	 * 根据id删除会员
	 * @param id
	 */
	public void deleteUserById(int id);

	/**
	 * 根据id查找会员
	 * @param id
	 * @return
	 */
	public User findUserById(int id);

	/**
	 * 更新会员信息
	 * @param user
	 */
	public void updateUserById(User user);

	/**
	 * 添加会员
	 * @param user
	 */
	public void addUser(User user);

	
	
	
}