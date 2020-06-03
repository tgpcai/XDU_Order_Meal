/*
 * OrderGoodsFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.dao.GoodsDao;
import com.dao.OrderDao;
import com.dao.impl.GoodsDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.model.Goods;
import com.model.Order;
import com.util.DbUtil;
import com.util.JDBCUtil;
import com.util.StringUtil;
import com.util.regularUtil;

/**
 *
 * @author __USER__
 */
public class User_OrderGoodsInterFrm extends javax.swing.JInternalFrame
{

	GoodsDao goodsDao = new GoodsDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();

	/** Creates new form OrderGoodsFrm */
	public User_OrderGoodsInterFrm()
	{
			setIconifiable(true);
			setResizable(true);
			setMaximizable(true);
			initComponents();
			this.setLocation(320, 25);
			this.fillGoodsTable(new Goods());
	}

	private void fillGoodsTable(Goods goods)
	{
		DefaultTableModel dtm = (DefaultTableModel) goodsTable.getModel();
		// ���֮ǰ��ʾ
		dtm.setRowCount(0);
		Connection con = null;
		try
		{
			con = JDBCUtil.getConn();
			ResultSet rs = goodsDao.goodsList(con, goods);
			while (rs.next())
			{
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("goodsName"));
				v.add(rs.getString("goodsDesc"));
				v.add(rs.getString("price"));
				v.add(rs.getString("imageLink"));
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
				JDBCUtil.release(con);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{
		jScrollPane2 = new javax.swing.JScrollPane();
		cartTable = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		iamgeLb = new javax.swing.JLabel();
		jb_add = new javax.swing.JButton();
		jb_ok = new javax.swing.JButton();
		jb_delete = new javax.swing.JButton();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		totalNumTxt = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		goodsTable = new javax.swing.JTable();
	
		gui_lv_order();
		setClosable(true);
		setDefaultLocale(getDefaultLocale());
		setTitle("\u7528\u6237\u70b9\u9910\u4e3b\u754c\u9762");

		cartTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "�ײͱ��", "�ײ�����", "�ײ�����", "�ײ͵���", "�ײͽ��" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(cartTable);

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("\u5957\u9910\u56fe\u7247"));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(iamgeLb, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(iamgeLb, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE));

		jb_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cart.png"))); // NOI18N
		jb_add.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_addActionPerformed(evt);
			}
		});

		jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
		jb_ok.setText("\u7ed3\u7b97");
		jb_ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_okActionPerformed(evt);
			}
		});

		jb_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
		jb_delete.setText("\u5220\u9664");
		jb_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_deleteActionPerformed(evt);
			}
		});

		totalMoneyTxt.setEditable(false);

		jLabel1.setText("\u603b\u91d1\u989d\uff1a");

		jLabel2.setText("\u603b\u6570\u91cf\uff1a");

		totalNumTxt.setEditable(false);

		goodsTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "���", "�ײ�����", "�ײ�����", "�ײͼ۸�", "ͼƬ��ַ" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return canEdit[columnIndex];
			}
		});
		goodsTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt)
			{
				goodsTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(goodsTable);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui_lv_order();
			}
		});
		button.setIcon(new ImageIcon(User_OrderGoodsInterFrm.class.getResource("/images/cart.png")));
		button.setText("\u89C4\u5F8B\u70B9\u9910");
		
		JButton button_1 = new JButton("\u4ECA\u65E5\u7279\u4EF7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select_forsale();
			}
		});
		button_1.setIcon(new ImageIcon(User_OrderGoodsInterFrm.class.getResource("/images/modify.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(988)
					.addComponent(jb_ok))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1047, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button)
							.addGap(18)
							.addComponent(jb_add)
							.addGap(18)
							.addComponent(jb_delete))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(jScrollPane1)))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jLabel2)
							.addGap(18)
							.addComponent(totalNumTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(jLabel1)
							.addGap(6)
							.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jb_delete)
							.addComponent(jb_add)
							.addComponent(button)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(totalNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(jLabel1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(totalMoneyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addComponent(jb_ok)
					.addGap(14)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);

		pack();
	}
	
	public void select_forsale()
	{
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		Connection con = null;
		try
		{
			con = JDBCUtil.getConn();
			JOptionPane.showMessageDialog(null, orderDaoImpl.forSaleToday(con));
			fillGoodsTable(new Goods());
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
		finally {
			try
			{
				con.close();
			} catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			
		}
	}

	public void gui_lv_order()
	{
		LinkedList<String> dish = new LinkedList<>();
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		Connection con = null;
		try
		{
			con = JDBCUtil.getConn();
			orderDao.GetOrderDish(con, dish);
			String[] good = new String[dish.size()];
			for(int i = 0; i < dish.size(); i++)
			{
				good[i] = dish.get(i);
			}
			String[] result = regularUtil.regular(good);
			for(int i = 0; i < result.length; i++)
			{
				System.out.println(result[i]);
			}		
			int rowNum = goodsTable.getRowCount();
			System.out.println("for (int i = 0; i < rowNum; i++)");
			for (int i = 0; i < rowNum; i++)
			{
				String pp = (String)goodsTable.getValueAt(i, 1);
				if (pp.equals(result[0]))
				{
					Vector v = new Vector();
					v.add((String) goodsTable.getValueAt(i, 0));
					v.add((String) goodsTable.getValueAt(i, 1));
					v.add("1");
					v.add((String) goodsTable.getValueAt(i, 3));
					v.add((String) goodsTable.getValueAt(i, 3));
					dtm.addRow(v);
				}
				else if (pp.equals(result[1]))
				{
					Vector v = new Vector();
					v.add((String) goodsTable.getValueAt(i, 0));
					v.add((String) goodsTable.getValueAt(i, 1));
					v.add("1");
					v.add((String) goodsTable.getValueAt(i, 3));
					v.add((String) goodsTable.getValueAt(i, 3));
					dtm.addRow(v);
				}
			}				
			fillCartTable();
		} catch (Exception e)
		{		
			e.printStackTrace();
		}
	}

		// GEN-END:initComponents

	private void jb_okActionPerformed(java.awt.event.ActionEvent evt)
	{
		String userName = LogOnFrm.s_currentUser.getUserName();//
		// ���ɶ�����
		String orderId = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());// ����ǰʱ����Ϊ��������
		float orderTotalMoney = Float.parseFloat(this.totalMoneyTxt.getText());//
		int orderNum = Integer.parseInt(this.totalNumTxt.getText());//

		int rowNum = cartTable.getRowCount();// ��������
		if (rowNum == 0)
		{
			JOptionPane.showMessageDialog(null, "���������Ʒ���ٽ��㣡");
			return;
		}
		Connection con = null;
		try
		{
			String destination = JOptionPane.showInputDialog(null, "�������Ͳ͵�ַ��"); //��ȡ�Ͳ͵�ַ
//			Object[] obj2 ={ "11:00-12:00", "5:00-6:00","21:00-22:00"};  
//			String s = (String) JOptionPane.showInoutDialog(null,"��ѡ���Ͳ�ʱ��:\n", "���", JOptionPane.PLAIN_MESSAGE);
			
			Object[] obj2 ={"11:00-12:00", "17:00-18:00","21:00-22:00" };  
			String Send_Time = (String) JOptionPane.showInputDialog(null,"��ѡ���Ͳ�ʱ��:\n", "�Ͳ�ʱ��", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), obj2, "����");


			int flag = -1;
			int n = -1;
			float money = -1;
			String name = LogOnFrm.userNameTxt.getText();
			con = JDBCUtil.getConn();
			int userid = userDaoImpl.getUserID(con, name);
			Order order = new Order(orderId, 0, orderNum, orderTotalMoney, userName,destination,userid,Send_Time);
			int addNum = orderDao.order_infoAdd(con, order);// �������ݵ�order_info��
			ReturnPrice();
			if (addNum == 1)
			{
				for (int i = 0; i < rowNum; i++)
				{

					int goodsId = Integer.parseInt((String) cartTable.getValueAt(i, 0));
					String goodsName = (String) cartTable.getValueAt(i, 1);
					int goodsNum = Integer.parseInt((String) cartTable.getValueAt(i, 2));
					float goodsPrice = Float.parseFloat((String) cartTable.getValueAt(i, 3));
					float goodsTotalPrice = Float.parseFloat((String) cartTable.getValueAt(i, 4));
					order = new Order(orderId, goodsTotalPrice, goodsId, goodsPrice, goodsNum, goodsName,destination,userid,Send_Time);
					// ѭ���������ݵ�order_goods��
					addNum += orderDao.order_goodsAdd(con, order);
				}
				money = Float.parseFloat(totalMoneyTxt.getText());
				n = JOptionPane.showConfirmDialog(null, "�Ƿ�Ϊ����֧����");
				
			} else
			{
				JOptionPane.showMessageDialog(null, "�����ύʧ��");
			}
			if ( n == 0)
			{
				flag = userDaoImpl.changeUserMoney(con, name, money, false);
				if (addNum == (1 + rowNum) && flag == 1)
				{
					JOptionPane.showMessageDialog(null, "�۷ѳɹ�");
					JOptionPane.showMessageDialog(null, "�����ύ�ɹ������ס���Ķ����ţ�" + orderId);
				} 
				else
				{
					JOptionPane.showMessageDialog(null, "�����ύʧ��,���㣬���ֵ");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "���۳����ã������Ͳ�Ա������ȡ�ֽ�");
				JOptionPane.showMessageDialog(null, "�����ύ�ɹ������ס���Ķ����ţ�" + orderId);
			}
//			if (addNum == (1 + rowNum) && flag == 1)
//			{
//				JOptionPane.showMessageDialog(null, "�۷ѳɹ�");
//				JOptionPane.showMessageDialog(null, "�����ύ�ɹ������ס���Ķ����ţ�" + orderId);
//			} 
//			else
//			{
//				JOptionPane.showMessageDialog(null, "�����ύʧ��,���㣬���ֵ");
//			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�����ύʧ��");
		} finally
		{
			try
			{
				JDBCUtil.release(con);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		// ɾ��ѡ�����
		dtm.setRowCount(0);
		fillCartTable();
	}

	public void ReturnPrice()
	{
		Connection con = null;
		try
		{
			con = JDBCUtil.getConn();
			orderDao.returnPrice(con);
		} catch (SQLException e)
		{	
			e.printStackTrace();
		}finally {
			try
			{
				con.close();
			} catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
	}

	private void fillCartTable()
	{
		// �޸���Ʒ�������ܽ��
		int rowNum = cartTable.getRowCount();// ��������
		int totalNum = 0;// ������
		float totalMoney = 0;// �ܽ��
		// �ۼ����������ܽ��
		for (int i = 0; i < rowNum; i++)
		{
			totalNum += Integer.parseInt((String) cartTable.getValueAt(i, 2));
			totalMoney += Float.parseFloat((String) cartTable.getValueAt(i, 4));
		}
		// �ı���ֵ
		this.totalNumTxt.setText(Integer.toString(totalNum));
		this.totalMoneyTxt.setText(Float.toString(totalMoney));
	}

	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt)
	{
		int row = cartTable.getSelectedRow();
		if (row == -1)
		{
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
		} else
		{
			DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
			// ɾ��ѡ�����
			dtm.removeRow(row);
		}
		fillCartTable();
	}

	private void jb_addActionPerformed(java.awt.event.ActionEvent evt)
	{
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		// ��ȡѡ�е���
		int row = goodsTable.getSelectedRow();
		if (row < 0)
		{
			JOptionPane.showMessageDialog(null, "��ѡ��һ���ײ�");
			return;
		}
		// �ڱ��й��ﳵtable����ʾ���������
		int i = 0, flag = 0;// ����Ƿ��Ѿ�����
		int rowNum = cartTable.getRowCount();
		for (i = 0; i < rowNum; i++)
		{
			if (goodsTable.getValueAt(row, 0).equals(cartTable.getValueAt(i, 0)))
			{
				flag = 1;
				break;
			}
		}
		if (flag == 0)
		{
			Vector v = new Vector();
			v.add((String) goodsTable.getValueAt(row, 0));
			v.add((String) goodsTable.getValueAt(row, 1));
			v.add("1");
			v.add((String) goodsTable.getValueAt(row, 3));
			v.add((String) goodsTable.getValueAt(row, 3));
			dtm.addRow(v);
		} else
		{

			int goodsNum = Integer.parseInt((String) cartTable.getValueAt(i, 2)) + 1;// ��ȡ��ǰ����
			float goodsPrice = Float.parseFloat((String) cartTable.getValueAt(i, 3));// ��ȡ��ǰ����

			goodsPrice = goodsPrice + Float.parseFloat((String) cartTable.getValueAt(i, 4));// ��ȡ�����޸��Ժ���ܼ�
			this.cartTable.setValueAt(Integer.toString(goodsNum), i, 2);
			this.cartTable.setValueAt(Float.toString(goodsPrice), i, 4);
		}
		fillCartTable();
	}

	private void goodsTableMousePressed(java.awt.event.MouseEvent evt)
	{
		// ��ȡѡ�е���
		int row = goodsTable.getSelectedRow();

		String picturePath = (String) goodsTable.getValueAt(row, 4);
		if (StringUtil.isNotEmpty(picturePath))
		{
			Icon icon = new ImageIcon(picturePath);
			this.iamgeLb.setIcon(icon);
		} else
		{
			this.iamgeLb.setIcon(null);
		}

	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable cartTable;
	private javax.swing.JTable goodsTable;
	private javax.swing.JLabel iamgeLb;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_add;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_ok;
	private javax.swing.JTextField totalMoneyTxt;
	private javax.swing.JTextField totalNumTxt;
	public UserDaoImpl userDaoImpl = new UserDaoImpl();
}