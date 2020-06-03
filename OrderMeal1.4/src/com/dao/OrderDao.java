
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
	 * @Description:�����Ʒ
	 */
	int order_goodsAdd(Connection con ,Order order) throws SQLException;
	
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:���Ӷ���
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
	 * @Description:����order������goods
	 */
	ResultSet orderGoodsList(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:�ı䶩��״̬
	 */
	int orderStatusModify(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:ɾ��order
	 */
	int deleteOrder(Connection con,Order order) throws SQLException;
	/**
	 * @param con
	 * @param order
	 * @return
	 * @throws SQLException
	 * @Description:���ض���+��ƷString
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
	 * �����û�����ȡ���µĶ���
	 * @param con
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	String getOrderId(Connection con,String name) throws SQLException;
	
	/**
	 * ���ݶ����Ż�ȡ��Ӧ����Ʒ��Ϣ��
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
	 * @Description:���ؽ����ؼ۲ˣ�����+ԭ��+�ּۣ�
	 */
	String forSaleToday(Connection con)throws SQLException;
	
	/**
	 * @param con
	 * @return 
	 * @throws SQLException
	 * @Description:�������ؼ۲˵Ĳ˼ۻָ�ԭ״
	 */
	int returnPrice(Connection con)throws SQLException;
}
