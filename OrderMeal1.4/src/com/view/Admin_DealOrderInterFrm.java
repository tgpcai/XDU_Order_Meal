/*
 * checkOrderInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.GoodsDao;
import com.dao.OrderDao;
import com.dao.impl.GoodsDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.model.Goods;
import com.model.Order;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author __USER__
 */
public class Admin_DealOrderInterFrm extends javax.swing.JInternalFrame
{
	private static final JTable j_orderTable = null;
	DbUtil dbUtil = new DbUtil();
	OrderDao orderDao = new OrderDaoImpl();
	GoodsDao goodsDao = new GoodsDaoImpl();
	public static ArrayList<String> message = new ArrayList<>();

	/** Creates new form checkOrderInterFrm */
	public Admin_DealOrderInterFrm()
	{
		initComponents();
		this.setLocation(320, 100);

	}
	

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		buttonGroup1 = new javax.swing.ButtonGroup();
		jScrollPane2 = new javax.swing.JScrollPane();
		cartTable = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		totalNumTxt = new javax.swing.JTextField();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		orderStatusTxt = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		orderIdTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		orderTable = new javax.swing.JTable();
		jrb_1 = new javax.swing.JRadioButton();
		jrb_2 = new javax.swing.JRadioButton();
		jrb_3 = new javax.swing.JRadioButton();
		jrb_4 = new javax.swing.JRadioButton();
		jButton1 = new javax.swing.JButton();
		jb_status = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u67e5\u770b\u8ba2\u5355");

		cartTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "套餐编号", "套餐名称", "套餐数量", "套餐单价", "套餐金额","地址","送餐时间" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return canEdit[columnIndex];
			}
		});
		cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt)
			{
				cartTableMousePressed(evt);
			}
		});
		jScrollPane2.setViewportView(cartTable);

		jLabel2.setText("\u603b\u6570\u91cf\uff1a");

		totalNumTxt.setEditable(false);

		totalMoneyTxt.setEditable(false);

		jLabel1.setText("\u603b\u91d1\u989d\uff1a");

		jLabel3.setText("\u8ba2\u5355\u72b6\u6001\uff1a");

		orderStatusTxt.setEditable(false);

		jLabel4.setText("\u70b9\u9910\u4eba\uff1a");

		userNameTxt.setEditable(false);

		jLabel5.setText("\u8ba2\u5355\u53f7\uff1a");

		jb_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
		jb_search.setText("\u8ba2\u5355\u67e5\u8be2");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_searchActionPerformed(evt);
			}
		});

		orderTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "订单编号", "商品总数量", "总金额", "点餐人", "订单状态" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return canEdit[columnIndex];
			}
		});
		orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt)
			{
				orderTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(orderTable);

		buttonGroup1.add(jrb_1);
		jrb_1.setText("\u786e\u8ba4\u8ba2\u5355");

		buttonGroup1.add(jrb_2);
		jrb_2.setText("\u53bb\u9001\u9910");

		buttonGroup1.add(jrb_3);
		jrb_3.setText("\u5df2\u5b8c\u6210");

		buttonGroup1.add(jrb_4);
		jrb_4.setText("\u5220\u9664\u8ba2\u5355");

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
		jButton1.setText("\u63d0\u4ea4");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton1ActionPerformed(evt);
			}
		});

		jb_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
		jb_status.setText("\u53d6\u6d88\u8ba2\u5355");
		jb_status.setFocusPainted(false);
		jb_status.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_statusActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(79)
							.addComponent(jLabel5)
							.addGap(36)
							.addComponent(orderIdTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(jb_search)
							.addGap(107))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
							.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGap(35))
							.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(orderStatusTxt, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jLabel2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(totalNumTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
									.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
											.addComponent(jrb_1)
											.addComponent(jrb_3))
										.addGap(12)
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
											.addComponent(jrb_2)
											.addComponent(jrb_4))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jButton1))
									.addComponent(jb_status))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jLabel1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(orderIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5)
								.addComponent(jb_search)))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(23)
							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1)
								.addComponent(totalNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)
								.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(jb_status)
									.addGap(13)
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jrb_1)
										.addComponent(jrb_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jrb_4)
										.addComponent(jrb_3)))
								.addComponent(jButton1)))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	// 填充ordertable
	private void fillOrderTable()
	{
		// 填充ordertable
		String orderId = this.orderIdTxt.getText();
		Order order = new Order();
		order.setOrderId(orderId);
		DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try
		{
			con = dbUtil.getCon();
			ResultSet rs = orderDao.orderList(con, order);
			while (rs.next())
			{
				Vector v = new Vector();
				v.add(rs.getString("orderId"));
				v.add(rs.getInt("orderNum"));
				v.add(rs.getFloat("orderTotalMoney"));
				v.add(rs.getString("userName"));
				int status = rs.getInt("orderStatus");
				switch (status)
				{
				case 0:
					v.add("未处理");
					break;
				case 1:
					v.add("烹饪中");
					break;
				case 2:
					v.add("配送中");
					break;
				case 3:
					v.add("已送达");
					break;
				case 4:
					v.add("已取消");
				}

				dtm.addRow(v);
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

	// 重置carttable
	private void resetCartTable()
	{

		this.totalNumTxt.setText("");
		this.totalMoneyTxt.setText("");
		this.userNameTxt.setText("");
		this.orderStatusTxt.setText("");

		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		dtm.setRowCount(0);

	}

	// 订单处理操作
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
	{
		// 获取选中的行
		int row = orderTable.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "请选择一个订单");
			return;
		}
		// 获取订单编号
		String orderId = (String) orderTable.getValueAt(row, 0);
		Order order = new Order();
		order.setOrderId(orderId);
		//
		String orderStatus = this.orderStatusTxt.getText();
		int statusNum = 0;// 是否为删除订单或者处理订单的标志位
		if (this.jrb_1.isSelected())
		{// 确定订单
			orderStatus = "烹饪中";
			order.setOrderStatus(1);
			JOptionPane.showMessageDialog(null, "已将订单信息发送至客户邮箱！");
			//message.add("商家已接单！请耐心等候");
		} else if (this.jrb_2.isSelected())
		{// 去送餐
			orderStatus = "配送中";
			order.setOrderStatus(2);
			state = 1;
			
		} else if (this.jrb_3.isSelected())
		{// 已付款
			orderStatus = "已送达";
			order.setOrderStatus(3);
		} else if (this.jrb_4.isSelected())
		{// 删除订单
			orderStatus = "";
			statusNum = 1;
		} else
		{
			return;
		}

		if (statusNum != 1)
		{
			try
			{
				Connection con = dbUtil.getCon();
				int modifyNum = orderDao.orderStatusModify(con, order);
				if (modifyNum == 1)
				{
					JOptionPane.showMessageDialog(null, "操作成功！");
					fillOrderTable();
					this.orderStatusTxt.setText(orderStatus);
					this.jb_status.setEnabled(false);
				} else
				{
					JOptionPane.showMessageDialog(null, "订单操作失败！");
				}

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (statusNum == 4)
		{
			try
			{
				Connection con = dbUtil.getCon();
				int modifyNum = orderDao.deleteOrder(con, order);
				if (modifyNum == 1)
				{
					JOptionPane.showMessageDialog(null, "删除成功！");
					fillOrderTable();
					this.jb_status.setEnabled(false);
					resetCartTable();
				} else
				{
					JOptionPane.showMessageDialog(null, "订单删除失败！");
				}

			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 取消订单操作
	private void jb_statusActionPerformed(java.awt.event.ActionEvent evt)
	{
		// 获取选中的行，如果为选中，row默认为-1
		int row = orderTable.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "请选择一个订单");
			return;
		}
		// 获取订单编号
		String orderId = (String) orderTable.getValueAt(row, 0);
		Order order = new Order();
		order.setOrderId(orderId);
		order.setOrderStatus(4);// 取消订单
		try
		{
			Connection con = dbUtil.getCon();
			int modifyNum = orderDao.orderStatusModify(con, order);
			if (modifyNum == 1)
			{
				JOptionPane.showMessageDialog(null, "取消成功！");
				message.add("商家已取消订单！");
				this.orderStatusTxt.setText("已取消");
				this.jb_status.setEnabled(false);
				fillOrderTable();
			} else
			{
				JOptionPane.showMessageDialog(null, "取消订单失败！");
			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 购物车点击显示商品图片
	private void cartTableMousePressed(java.awt.event.MouseEvent evt)
	{
		String picturePath = null;
		// 获取选中的行
		int row = cartTable.getSelectedRow();
		int goodsId = Integer.parseInt((String) cartTable.getValueAt(row, 0));
		Goods goods = new Goods();
		goods.setId(goodsId);
		Connection con = null;
		try
		{
			con = dbUtil.getCon();
			ResultSet rs = goodsDao.goodsList(con, goods);
			while (rs.next())
			{
				picturePath = rs.getString("imageLink");

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
//		if (StringUtil.isNotEmpty(picturePath))
//		{
//			// Icon icon = new ImageIcon(picturePath);
//			// this.iamgeLb.setIcon(icon);
//			this.iamgeLb.setIcon(null);
//		} else
//		{
//			this.iamgeLb.setIcon(null);
//		}
	}

	// 点击订单表，显示购物车表内容
	private void orderTableMousePressed(java.awt.event.MouseEvent evt)
	{
		// 获取选中的行
		int row = orderTable.getSelectedRow();
		String orderId = (String) orderTable.getValueAt(row, 0);
		this.totalNumTxt.setText(orderTable.getValueAt(row, 1) + "");// 把int，float型转化为string
		this.totalMoneyTxt.setText(orderTable.getValueAt(row, 2) + "");
		this.userNameTxt.setText((String) orderTable.getValueAt(row, 3));
		String orderStatus = (String) orderTable.getValueAt(row, 4);
		this.orderStatusTxt.setText(orderStatus);
		// 修改取消订单按钮状态
		if (!orderStatus.equals("未处理"))
		{
			jb_status.setEnabled(false);
		} else
		{
			jb_status.setEnabled(true);
		}
		Order order = new Order();
		order.setOrderId(orderId);
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try
		{
			con = dbUtil.getCon();
			ResultSet rs = orderDao.orderGoodsList(con, order);
			while (rs.next())
			{
				Vector v = new Vector();
				v.add(rs.getString("goodsId"));
				v.add(rs.getString("goodsName"));
				v.add(rs.getInt("goodsNum"));
				v.add(rs.getFloat("goodsPrice"));
				v.add(rs.getFloat("goodsTotalPrice"));
				v.add(rs.getString("destination"));
				v.add(rs.getString("sendTime"));
				dtm.addRow(v);
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

	// 查找显示订单列表
	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt)
	{
		fillOrderTable();
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JTable cartTable;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_search;
	private javax.swing.JButton jb_status;
	private javax.swing.JRadioButton jrb_1;
	private javax.swing.JRadioButton jrb_2;
	private javax.swing.JRadioButton jrb_3;
	private javax.swing.JRadioButton jrb_4;
	private javax.swing.JTextField orderIdTxt;
	private javax.swing.JTextField orderStatusTxt;
	private javax.swing.JTable orderTable;
	private javax.swing.JTextField totalMoneyTxt;
	private javax.swing.JTextField totalNumTxt;
	public static javax.swing.JTextField userNameTxt;
	public static int state = 0;
	// End of variables declaration//GEN-END:variables

}