package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;

import com.model.Goods;
import com.model.Order;
import com.dao.OrderDao;
import com.util.JDBCUtil;
import com.util.StringUtil;

public class OrderDaoImpl implements OrderDao{
	@Override
	public int order_goodsAdd(Connection con ,Order order) throws SQLException{
		String sql="insert into `order_goods` values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, order.getOrderId());
		pstmt.setFloat(2, order.getGoodsTotalPrice());		
		pstmt.setInt(3, order.getGoodsId());
		pstmt.setFloat(4, order.getGoodsPrice());
		pstmt.setInt(5, order.getGoodsNum());
		pstmt.setString(6, order.getGoodsName());
		pstmt.setString(7, order.getDestinaton());
		pstmt.setString(8, order.getSendTime());
		return pstmt.executeUpdate();
	}
	@Override
	public int order_infoAdd(Connection con ,Order order) throws SQLException{
		String sql="insert into `order_info` values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, order.getOrderId());
		pstmt.setInt(2, order.getOrderStatus());
		pstmt.setInt(3, order.getOrderNum());
		pstmt.setFloat(4, order.getOrderTotalMoney());
		pstmt.setString(5, order.getUserName());
		pstmt.setInt(6, order.getUserid());
		return pstmt.executeUpdate();
	}
	@Override
	public ResultSet orderList(Connection con,Order order) throws SQLException{	
		StringBuffer sb=new StringBuffer("select * from `order_info`");
		if(StringUtil.isNotEmpty(order.getOrderId())){
			sb.append(" and orderId like '%"+order.getOrderId()+"%'");
		}
		if(StringUtil.isNotEmpty(order.getUserName())){
			sb.append(" and userName like '%"+order.getUserName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	@Override
	public ResultSet orderGoodsList(Connection con,Order order) throws SQLException{	
		StringBuffer sb=new StringBuffer("select * from `order_goods`");
		if(StringUtil.isNotEmpty(order.getOrderId())){
			sb.append(" and orderId like '%"+order.getOrderId()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	@Override
	public int orderStatusModify(Connection con,Order order) throws SQLException{
		String sql="update order_info set orderStatus=? where orderId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, order.getOrderStatus());
		pstmt.setString(2, order.getOrderId());
		return pstmt.executeUpdate();
	}
	@Override
	public int deleteOrder(Connection con,Order order) throws SQLException{
			String sql="delete from order_goods where orderId=?";
			PreparedStatement pstmt1=con.prepareStatement(sql);
			pstmt1.setString(1, order.getOrderId());
			pstmt1.executeUpdate();
			sql="delete from order_info where orderId=?";
			PreparedStatement pstmt2=con.prepareStatement(sql);
			pstmt2.setString(1, order.getOrderId());
			return pstmt2.executeUpdate();
		}
	@Override
	public String orderAndGoodsToString(Connection con, Order order) throws SQLException {
		String sql = "select * from order_goods where orderId = ?";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,order.getOrderId());
		ResultSet rs = pstmt.executeQuery();
//		StringBuffer sb = new StringBuffer(order.getId()+" "+order.getOrderTotalMoney() + " ");
		StringBuffer sb = new StringBuffer();
		while(rs.next()) {
			sb.append("菜名：" + rs.getString("goodsName") + " " + "份数： " + rs.getInt("goodsNum") + "单价："
					+ rs.getFloat("goodsPrice") + " " + "总价：" + rs.getFloat("goodsTotalPrice")+"\r\n");
//			System.out.println(" " + rs.getString("goodsId") + " " + rs.getString("goodsName") + " "
//					+ rs.getInt("goodsNum") + " " + rs.getFloat("goodsPrice") + " " + rs.getFloat("goodsTotalPrice"));
		}
		JDBCUtil.release(pstmt, rs);
		return sb.toString();
	}
	@Override
	public void GetOrderDish(Connection con,LinkedList<String> dish)throws SQLException
	{
		String sql = "select goodsName from order_goods";
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rs = pStatement.executeQuery();
		while(rs.next())
		{
			String p = rs.getString("goodsName");
			dish.add(p);
		}
	}
	@Override
	public String getOrderId(Connection con, String name) throws SQLException
	{
		String ss ="";
		String sql = "select orderId from order_info where userName = ?";
		PreparedStatement pStatement = con.prepareStatement(sql);
		pStatement.setString(1, name);
		ResultSet rs = pStatement.executeQuery();
		while(rs.next())
		{
			ss = rs.getString("orderId");
		}
		return ss;
	}
	@Override
	public ResultSet getOrderId4goods(Connection con, String orderID) throws SQLException
	{
		
		return null;
	}
	
	@Override
	public String forSaleToday(Connection con) throws SQLException {
		String sql = "select count(*) from goods";
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rs = pStatement.executeQuery();
		int i1 = 0;
		if(rs.next()) {
			int count = rs.getInt("count(*)");
			Random rd = new Random();
			i1 = rd.nextInt(count);
		}
		Goods.forSale = i1;
		JDBCUtil.release(pStatement,rs);
		
		float priceT = 0;
		sql = "select * from goods where id = ?";
		pStatement = con.prepareStatement(sql);
		pStatement.setInt(1,i1);
		rs = pStatement.executeQuery();
		StringBuffer sb = new StringBuffer();
		while(rs.next()) {
			priceT = rs.getFloat("price")/2;
			sb.append( "" + rs.getInt("id") + " " + rs.getString("goodsName") + " 原价：" + rs.getFloat("price") + " 现价：" + priceT);
		}
		JDBCUtil.release(pStatement,rs);
		
		sql = "update goods set price = ? where id = ?";
		pStatement = con.prepareStatement(sql);
		pStatement.setFloat(1,priceT);
		pStatement.setInt(2,i1);
		pStatement.executeUpdate();
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	@Override
	public int returnPrice(Connection con) throws SQLException {
		String sql = "update goods set price = price*2 where id = ?";
		PreparedStatement pStatement = con.prepareStatement(sql);
		pStatement.setInt(1,Goods.getForSale());
		return pStatement.executeUpdate();
	}
	
}

