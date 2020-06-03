/**   
 * @author: 林俊威 16130110026 734608679@qq.com
 * @date: 2018年12月2日 上午11:13:54 
 * @Description:
 */
package com.util;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String password= null;
	
	//在程序初始化之前导入配置文件内容
	static{
		try {
			//1. 创建一个属性配置对象
			Properties properties = new Properties();
			InputStream is = new FileInputStream("resources/jdbc.properties");
			
			//导入输入流。
			properties.load(is);

			//读取配置文件中的信息
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param Connection
	 * @param Statement
	 * @param ResultSet
	 */
	public static void release(Connection conn , Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}

	/**
	 * 释放资源
	 * @param Statement
	 * @param ResultSet
	 */
	public static void release(Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
	}
	
	/**
	 * 释放资源
	 * @param Connection
	 */
	public static void release(Connection conn){
		closeConn(conn);
	}
	
	/**
	 * 释放资源
	 * @param Statement
	 */
	public static void release(Statement st){
		closeSt(st);
	}
	
	private static void closeRs(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if(st != null){
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
	

}
