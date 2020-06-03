
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.model.Order;

public interface OrderDao {
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:添加商品
	 */
	int order_goodsAdd(Connection con ,Order order) throws SQLException;
	
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:增加订单
	 */
	int order_infoAdd(Connection con ,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:
	 */
	ResultSet orderList(Connection con,Order order) throws SQLException;
	
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:返回order中所有goods
	 */
	ResultSet orderGoodsList(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:改变订单状态
	 */
	int orderStatusModify(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:删除order
	 */
	int deleteOrder(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:返回订单+商品String
	 */
	String orderAndGoodsToString(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param dish
	 * @throws SQLException
	 * @Description:
	 */
	void GetOrderDish(Connection con,LinkedList<String> dish)throws SQLException;
	
	/**
	 * 根据用户名获取最新的订单
	 * @param con
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	String getOrderId(Connection con,String name) throws SQLException;
	
	/**
	 * 根据订单号获取相应的商品信息。
	 * @param con
	 * @param orderID
	 * @return
	 * @throws SQLException
	 */
	ResultSet getOrderId4goods(Connection con,String orderID) throws SQLException;
	
	/**
	 * @param con
	 * @return
	 * @throws SQLException
	 * @Description:返回今日特价菜（名字+原价+现价）
	 */
	String forSaleToday(Connection con)throws SQLException;
	
	/**
	 * @param con
	 * @return 
	 * @throws SQLException
	 * @Description:将今日特价菜的菜价恢复原状
	 */
	int returnPrice(Connection con)throws SQLException;
}
