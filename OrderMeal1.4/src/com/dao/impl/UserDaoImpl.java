package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.User;
import com.dao.UserDao;

public class UserDaoImpl implements UserDao{
	@Override
	public User login(Connection con,User user) throws SQLException{
		User resultUser = null;
		String sql="select *from user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser = new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setSalary(rs.getFloat("salary"));
			resultUser.setId(rs.getInt("id"));
			resultUser.setRank(rs.getInt("rank"));
			resultUser.setRegistered(rs.getBoolean("registered"));
			resultUser.setEmail(rs.getString("email"));
		}
		return resultUser;
	}
	@Override
	public int userAdd(Connection con,User user) throws SQLException{
		String sql="insert into `user` values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		int count = getUserNum(con);
		user.setId(count);
		pstmt.setInt(1, user.getId());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getEmail());
		pstmt.setInt(5, 0);
		pstmt.setDouble(6, user.getSalary());
		pstmt.setBoolean(7,user.isRegistered());
		return pstmt.executeUpdate();
	}
	@Override
	public boolean isUserExist(Connection con,User user) throws SQLException{
		String sql="select *from user where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		ResultSet rs =pstmt.executeQuery();
		return rs.next();
	}
	@Override
	public int userModify(Connection con,User user) throws SQLException{
		String sql="update `user` set userName=?,password=?,email=?,salary=?,registered=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setDouble(4,user.getSalary());
		pstmt.setBoolean(5,user.isRegistered());
		pstmt.setInt(6, user.getId());
		return pstmt.executeUpdate();
	}
	@Override
	public int register(Connection con, User user) throws SQLException {
		String sql="update `user` set registered=1 where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		return pstmt.executeUpdate();
	}
	@Override
	public int getUserNum(Connection con) throws SQLException{
		int number = 0;
		Statement stmt = con.createStatement();
		String sql = "select count(*) from user";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			number = rs.getInt("count(*)");
		}
		return number;
	}
	@Override
	public int changeUserMoney(Connection con, String name, float moner,boolean add_money) throws SQLException
	{
		String sql="update `user` set salary=? where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		double left_money = getUserMoney(con, name);
		if (add_money == false)
		{
			if (left_money - moner < 0)
			{
				return 0;
			}
			else
			{
				pstmt.setDouble(1, left_money - moner);
				pstmt.setString(2, name);
				return pstmt.executeUpdate();
			}
		}
		else
		{
			pstmt.setDouble(1, left_money + moner);
			pstmt.setString(2, name);
			return pstmt.executeUpdate();
		}

	}
	@Override
	public double getUserMoney(Connection con,String name) throws SQLException
	{
		String sql = "select salary from user where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		double aa = -1;
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			aa = rs.getDouble("salary");
		}
		return aa;
	}
	@Override
	public int getUserID(Connection con, String name) throws SQLException
	{
		String sql = "select id from user where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		int aa = -1;
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			aa = rs.getInt("id");
		}
		return aa;
	}
}
