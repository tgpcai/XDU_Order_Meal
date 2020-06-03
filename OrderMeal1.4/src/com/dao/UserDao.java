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
	 * @Description:�û���½
	 */
	User login(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:�����û�
	 */
	int userAdd(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:�ж��û��Ƿ����
	 */
	boolean isUserExist(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 * @Description:�޸��û���Ϣ
	 */
	int userModify(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @param user
	 * @return 
	 * @throws SQLException
	 * @Description:�û�ע�Ṥ��֧��
	 */
	int register(Connection con,User user) throws SQLException;
	/**
	 * @param con
	 * @return
	 * @throws SQLException
	 * @Description:��ȡ�û�����
	 */
	int getUserNum(Connection con) throws SQLException;
	
	/**
	 * �ı��û����
	 * @param con
	 * @param name
	 * @param moner
	 * @param add_money trueΪ��Ǯ��falseΪ�۷�
	 * @return
	 * @throws SQLException
	 */
	int changeUserMoney(Connection con,String name,float moner,boolean add_money) throws SQLException;
	
	/**
	 * ��ȡ�û������
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
