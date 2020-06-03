/**   
 * @author: �ֿ��� 16130110026 734608679@qq.com
 * @date: 2018��12��2�� ����11:13:54 
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
	
	//�ڳ����ʼ��֮ǰ���������ļ�����
	static{
		try {
			//1. ����һ���������ö���
			Properties properties = new Properties();
			InputStream is = new FileInputStream("resources/jdbc.properties");
			
			//������������
			properties.load(is);

			//��ȡ�����ļ��е���Ϣ
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
	 * �ͷ���Դ
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
	 * �ͷ���Դ
	 * @param Statement
	 * @param ResultSet
	 */
	public static void release(Statement st , ResultSet rs){
		closeRs(rs);
		closeSt(st);
	}
	
	/**
	 * �ͷ���Դ
	 * @param Connection
	 */
	public static void release(Connection conn){
		closeConn(conn);
	}
	
	/**
	 * �ͷ���Դ
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
