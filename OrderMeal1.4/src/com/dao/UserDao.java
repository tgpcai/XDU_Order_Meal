package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.model.User;

public interface UserDao {
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:用户登陆
	 */
	User login(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:增加用户
	 */
	int userAdd(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:判断用户是否存在
	 */
	boolean isUserExist(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:修改用户信息
	 */
	int userModify(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return 
	 * @throws SQLException
	 * @Description:用户注册工资支付
	 */
	int register(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @return
	 * @throws SQLException
	 * @Description:获取用户数量
	 */
	int getUserNum(Connection con) throws SQLException;
	
	/**
	 * 改变用户余额
	 * @param con
	 * @param name
	 * @param moner
	 * @param add_money true为加钱，false为扣费
	 * @return
	 * @throws SQLException
	 */
	int changeUserMoney(Connection con,String name,float moner,boolean add_money) throws SQLException;
	
	/**
	 * 获取用户的余额
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	double getUserMoney(Connection con,String name) throws SQLException;
	
	/**
	 * 
	 * @param con
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	int getUserID(Connection con,String name) throws SQLException;
}
