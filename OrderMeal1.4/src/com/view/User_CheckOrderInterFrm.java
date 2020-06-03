/*
 * checkOrderInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.sql.Connection;
import java.sql.ResultSet;
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
//import net.miginfocom.swing.MigLayout;

/**
 * LB 2018.05.19
 */
public class User_CheckOrderInterFrm extends javax.swing.JInternalFrame
{
	private static final JTable j_orderTable = null;
	DbUtil dbUtil = new DbUtil();
	OrderDao orderDao = new OrderDaoImpl();
	GoodsDao goodsDao = new GoodsDaoImpl();

	public User_CheckOrderInterFrm()
	{
		setIconifiable(true);
		setResizable(true);
		setMaximizable(true);
		initComponents();
		this.setLocation(320, 25);
		this.userNameTxt.setText(LogOnFrm.s_currentUser.getUserName());
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(jLabel5)
					.addGap(42)
					.addComponent(orderIdTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(jb_search)
					.addGap(495)
					.addComponent(jLabel4)
					.addGap(12)
					.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(489)
					.addComponent(jLabel3)
					.addGap(11)
					.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(jLabel2)
					.addGap(12)
					.addComponent(totalNumTxt, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(jLabel1)
					.addGap(13)
					.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(489)
					.addComponent(jb_status))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1064, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(jLabel5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(orderIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(jb_search))
						.addComponent(jLabel4)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel3))
						.addComponent(orderStatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel2))
						.addComponent(totalNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(jLabel1))
						.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(jb_status)
					.addGap(4)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		pack();
	}

	private void initComponents()
	{

		jScrollPane2 = new javax.swing.JScrollPane();
		cartTable = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		totalNumTxt = new javax.swing.JTextField();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		orderStatusTxt = new javax.swing.JTextField();
		jb_status = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		userNameTxt = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		orderIdTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		orderTable = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		iamgeLb = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u67e5\u770b\u8ba2\u5355");

		cartTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "序号", "套餐", "份数", "单价", "总价","地址" }) {
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

		jb_status.setText("\u53d6\u6d88\u8ba2\u5355");
		jb_status.setFocusPainted(false);
		jb_status.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_statusActionPerformed(evt);
			}
		});

		jLabel4.setText("\u70b9\u9910\u4eba\uff1a");

		userNameTxt.setEditable(false);

		jLabel5.setText("\u8ba2\u5355\u53f7\uff1a");

		jb_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
		jb_search.setText("\u8ba2\u5355\u67e5\u8be2");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_searchActionPerformed(evt);
			}
		});

		orderTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		} ,new String[] { "订单", "份数", "总价", "订单状态" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

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

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("\u5957\u9910\u56fe\u7247"));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addComponent(iamgeLb, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addComponent(iamgeLb, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
		);
		jPanel2.setLayout(jPanel2Layout);

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	//
	private void fillOrderTable()
	{
		String orderId = this.orderIdTxt.getText();
		String userName = this.userNameTxt.getText();
		Order order = new Order();
		order.setOrderId(orderId);
		order.setUserName(userName);
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
					v.add("已送达");
					break;
				case 3:
					v.add("已付款");
					break;
				case 4:
					v.add("已取餐");
					break;
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

	//
	private void cartTableMousePressed(java.awt.event.MouseEvent evt)
	{
		String picturePath = null;
		//
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
		if (StringUtil.isNotEmpty(picturePath))
		{
			Icon icon = new ImageIcon(picturePath);
			this.iamgeLb.setIcon(icon);
			iamgeLb.setPreferredSize(getPreferredSize());
		} else
		{
			this.iamgeLb.setIcon(null);
		}
	}

	//
	private void jb_statusActionPerformed(java.awt.event.ActionEvent evt)
	{
		//
		int row = orderTable.getSelectedRow();//
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "123456");
			return;
		}
		//
		String orderId = (String) orderTable.getValueAt(row, 0);
		Order order = new Order();
		order.setOrderId(orderId);
		order.setOrderStatus(4);//
		try
		{
			Connection con = dbUtil.getCon();
			int modifyNum = orderDao.orderStatusModify(con, order);
			if (modifyNum == 1)
			{
				JOptionPane.showMessageDialog(null, "789789");
				this.orderStatusTxt.setText("789456");
				this.jb_status.setEnabled(false);
				fillOrderTable();
			} else
			{
				JOptionPane.showMessageDialog(null, "12345456");
			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	private void orderTableMousePressed(java.awt.event.MouseEvent evt)
	{
		//
		int row = orderTable.getSelectedRow();
		String orderId = (String) orderTable.getValueAt(row, 0);
		this.totalNumTxt.setText(orderTable.getValueAt(row, 1) + "");//
		this.totalMoneyTxt.setText(orderTable.getValueAt(row, 2) + "");
		String orderStatus = (String) orderTable.getValueAt(row, 3);
		this.orderStatusTxt.setText(orderStatus);
		this.iamgeLb.setIcon(null);

		if (!orderStatus.equals("1"))
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

	//
	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt)
	{
		fillOrderTable();

	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable cartTable;
	private javax.swing.JLabel iamgeLb;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_search;
	private javax.swing.JButton jb_status;
	private javax.swing.JTextField orderIdTxt;
	private javax.swing.JTextField orderStatusTxt;
	private javax.swing.JTable orderTable;
	private javax.swing.JTextField totalMoneyTxt;
	private javax.swing.JTextField totalNumTxt;
	private javax.swing.JTextField userNameTxt;
	// End of variables declaration//GEN-END:variables

}