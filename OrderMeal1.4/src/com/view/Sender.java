/**   
 * @author: 林俊威 16130110026 734608679@qq.com
 * @date: 2018年12月16日 下午1:05:28 
 * @Description:
 */
package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.dao.impl.OrderDaoImpl;
import com.model.Order;
import com.util.DbUtil;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Sender extends JFrame {

	private JPanel contentPane;
	private JTable cartTable;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sender frame = new Sender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sender() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 644, 321);
		getContentPane().add(scrollPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane.setBounds(0, 0, 719, 317);
		contentPane.add(scrollPane);
		
		cartTable = new JTable();
		scrollPane.setViewportView(cartTable);

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {"套餐编号", "套餐名称", "套餐数量", "套餐单价", "套餐金额","地址","送餐时间"});
		
		table = new JTable(model);
		table.setRowHeight(25);
		contentPane.add(scrollPane,BorderLayout.CENTER);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		System.out.println(Admin_DealOrderInterFrm.state);
		
		if(Admin_DealOrderInterFrm.state == 0)
		{
			DbUtil dbUtil = new DbUtil();
			Connection con = null;
			OrderDaoImpl orderDao = new OrderDaoImpl();
			try
			{
				con = dbUtil.getCon();
//				String orderId = orderDao.getOrderId(con,userNameTxt.getText());
				String orderId = orderDao.getOrderId(con,"aaa");
				System.out.println("String orderId = orderDao.getOrderId(con,userNameTxt.getText());");
				Order order = new Order();
				order.setOrderId(orderId);
//				DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
//				dtm.setRowCount(0);
				ResultSet rs = orderDao.orderGoodsList(con, order);
				while (rs.next())
				{
					System.out.println("while (rs.next())");
					Vector v = new Vector();
					v.add(rs.getString("goodsId"));
					v.add(rs.getString("goodsName"));
					v.add(rs.getInt("goodsNum"));
					v.add(rs.getFloat("goodsPrice"));
					v.add(rs.getFloat("goodsTotalPrice"));
					v.add(rs.getString("destination"));
					v.add(rs.getString("sendTime"));
					model.addRow(v);
				}
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally
			{
				try
				{
					dbUtil.closeCon(con);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
}