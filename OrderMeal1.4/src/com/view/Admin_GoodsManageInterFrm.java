/*
 * GoodsManageInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.dao.GoodsDao;
import com.dao.impl.GoodsDaoImpl;
import com.model.Goods;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

/**
 *
 * @author __USER__
 */
public class Admin_GoodsManageInterFrm extends javax.swing.JInternalFrame
{
	DbUtil dbUtil = new DbUtil();
	GoodsDao goodsDao = new GoodsDaoImpl();

	/** Creates new form GoodsManageInterFrm */
	public Admin_GoodsManageInterFrm()
	{
		initComponents();
		this.setLocation(320, 100);
		this.filltable(new Goods());
	}

	// 填充table操作,刷新内容
	private void filltable(Goods goods)
	{
		DefaultTableModel dtm = (DefaultTableModel) goodsTable.getModel();
		// 清空之前显示
		dtm.setRowCount(0);
		Connection con = null;
		try
		{
			con = dbUtil.getCon();
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
				dbUtil.closeCon(con);
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

		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jb_search = new javax.swing.JButton();
		s_goodsName = new javax.swing.JTextField();
		s_price_1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		goodsTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		goodsNameTxt = new javax.swing.JTextField();
		priceTxt = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		goodsDescTxt = new javax.swing.JTextArea();
		jLabel6 = new javax.swing.JLabel();
		imageLinkTxt = new javax.swing.JTextField();
		jb_modify = new javax.swing.JButton();
		jb_delete = new javax.swing.JButton();
		jb_chooser = new javax.swing.JButton();
		jLabel7 = new javax.swing.JLabel();
		goodsIdTxt = new javax.swing.JTextField();
		s_price_2 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();

		jButton1.setText("jButton1");

		setClosable(true);
		setIconifiable(true);
		setTitle("\u5957\u9910\u4fe1\u606f\u7ef4\u62a4");

		jLabel1.setText("\u5957\u9910\u540d\u79f0\uff1a");

		jb_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
		jb_search.setText("\u67e5\u8be2");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_searchActionPerformed(evt);
			}
		});

		jLabel2.setText("\u5957\u9910\u4ef7\u683c\u533a\u95f4\uff1a");

		goodsTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "序号", "套餐名称", "套餐描述", "套餐价格", "图片地址" }) {
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

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("\u8868\u5355\u64cd\u4f5c"));

		jLabel3.setText("\u5957\u9910\u540d\u79f0\uff1a");

		jLabel4.setText("\u5957\u9910\u4ef7\u683c\uff1a");

		jLabel5.setText("\u5957\u9910\u63cf\u8ff0\uff1a");

		goodsDescTxt.setColumns(20);
		goodsDescTxt.setRows(5);
		jScrollPane2.setViewportView(goodsDescTxt);

		jLabel6.setText("\u5957\u9910\u56fe\u7247\uff1a");

		imageLinkTxt.setEnabled(false);

		jb_modify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modify.png"))); // NOI18N
		jb_modify.setText("\u4fee\u6539");
		jb_modify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_modifyActionPerformed(evt);
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

		jb_chooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
		jb_chooser.setText("\u8bf7\u9009\u62e9");
		jb_chooser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jb_chooserActionPerformed(evt);
			}
		});

		jLabel7.setText("\u7f16\u53f7\uff1a");

		goodsIdTxt.setEditable(false);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(jLabel4).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jLabel7)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(goodsIdTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(37).addComponent(jLabel6))
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel5)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jScrollPane2,
										GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(
						ComponentPlacement.RELATED)
				.addGroup(
						jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jb_modify)
														.addPreferredGap(ComponentPlacement.RELATED, 34,
																Short.MAX_VALUE)
														.addComponent(jb_chooser))
												.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE, 214,
														GroupLayout.PREFERRED_SIZE))
								.addComponent(jb_delete))
				.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
				.createSequentialGroup().addGap(
						20)
				.addGroup(
						jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel3)
								.addGroup(
										jPanel1Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4)
												.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel7).addComponent(jLabel6)
												.addComponent(imageLinkTxt, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(goodsIdTxt, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(33)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel5)
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jb_chooser).addComponent(jb_modify)))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jb_delete))
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(57, Short.MAX_VALUE)));
		jPanel1.setLayout(jPanel1Layout);

		jLabel8.setText("\u2014\u2014");
		jPanel2 = new javax.swing.JPanel();
		iamgeLb = new javax.swing.JLabel();

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("\u5957\u9910\u56fe\u7247"));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap().addComponent(iamgeLb, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(iamgeLb,
				GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE));
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addGap(51).addComponent(jLabel1).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_goodsName, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(jLabel2).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_price_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addGap(2).addComponent(jLabel8).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_price_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGap(33).addComponent(jb_search))
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 737,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(52, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap(113, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1)
												.addComponent(s_goodsName, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2)
												.addComponent(s_price_2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(s_price_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel8).addComponent(jb_search))
										.addGap(27)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 122,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(
										Alignment.TRAILING, layout
												.createSequentialGroup().addComponent(jPanel2,
														GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
												.addGap(22)))));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	/**
	 * @param evt
	 */
	// 修改操作
	private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt)
	{
		String id = this.goodsIdTxt.getText();
		if (StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String goodsName = this.goodsNameTxt.getText();
		String goodsDesc = this.goodsDescTxt.getText();
		String imageLink = this.imageLinkTxt.getText();
		String price = this.priceTxt.getText();
		if (StringUtil.isEmpty(goodsName))
		{
			JOptionPane.showMessageDialog(null, "套餐名称不能为空");
			return;
		}
		if (StringUtil.isEmpty(price))
		{
			JOptionPane.showMessageDialog(null, "套餐价格不能为空");
			return;
		}
		if (!StringUtil.isNum(price))
		{
			JOptionPane.showMessageDialog(null, "请重新输入套餐价格");
			return;
		}
		Goods goods = new Goods(Integer.parseInt(id), goodsName, goodsDesc, Float.parseFloat(price), imageLink);
		Connection con = null;
		try
		{
			con = dbUtil.getCon();
			int modifyNum = goodsDao.goodsModify(con, goods);
			if (modifyNum == 1)
			{
				JOptionPane.showMessageDialog(null, "修改成功");
				this.filltable(new Goods());//
				resetValues();
			} else
				JOptionPane.showMessageDialog(null, "修改失败");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
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

	// 删除操作
	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt)
	{
		String id = this.goodsIdTxt.getText();
		if (StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
		if (n == 0)
		{
			Connection con = null;
			try
			{
				con = dbUtil.getCon();
				int deleteNum = goodsDao.goodsDelete(con, id);
				if (deleteNum == 1)
				{
					JOptionPane.showMessageDialog(null, "删除成功");
					this.filltable(new Goods());
					resetValues();
				} else
					JOptionPane.showMessageDialog(null, "删除失败");
			} catch (Exception e)
			{

				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
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

	// 选择图片
	private void jb_chooserActionPerformed(java.awt.event.ActionEvent evt)
	{
		JFileChooser chooser = new JFileChooser();// 创建文件对话框
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");// 创建文件过滤器
		chooser.setFileFilter(filter);// 为文件对话框设置文件过滤器
		int returnValue = chooser.showOpenDialog(getParent());// 打开文件选择对话框
		if (returnValue == JFileChooser.APPROVE_OPTION)
		{ // 判断是否选择了文件
			File file = chooser.getSelectedFile(); // 获得文件对象
			if (file.length() / 1024.0 > 50.0)
			{
				JOptionPane.showMessageDialog(null, "请选择小于等于50KB的图片文件。");
				return;
			}
			String picturePath = file.getAbsolutePath();
			// System.out.println(picturePath);
			Icon icon = new ImageIcon(picturePath);
			this.iamgeLb.setIcon(icon);
			this.imageLinkTxt.setText(picturePath);
		}
	}

	// 点击table中某一种套餐
	private void goodsTableMousePressed(java.awt.event.MouseEvent evt)
	{
		// 获取选中的行
		int row = goodsTable.getSelectedRow();
		// 在表单中写入选中的数据
		this.goodsIdTxt.setText((String) goodsTable.getValueAt(row, 0));
		this.goodsNameTxt.setText((String) goodsTable.getValueAt(row, 1));
		this.goodsDescTxt.setText((String) goodsTable.getValueAt(row, 2));
		this.priceTxt.setText((String) goodsTable.getValueAt(row, 3));
		this.imageLinkTxt.setText((String) goodsTable.getValueAt(row, 4));
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

	// 搜索操作
	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt)
	{
		Goods goods = new Goods();
		String s_goodsName = this.s_goodsName.getText();
		String s_price1 = this.s_price_1.getText();
		String s_price2 = this.s_price_2.getText();
		if (StringUtil.isNotEmpty(s_price1))
		{// price_1低价格非空
			if (!StringUtil.isNum(s_price1))
			{
				JOptionPane.showMessageDialog(null, "请重新输入套餐价格范围");
				return;
			} else
			{
				goods.setPrice1(Float.parseFloat(s_price1));
			}
		}
		if (StringUtil.isNotEmpty(s_price2))
		{// price_2高价格非空
			if (!StringUtil.isNum(s_price2))
			{
				JOptionPane.showMessageDialog(null, "请重新输入套餐价格范围");
				return;
			} else
			{
				goods.setPrice(Float.parseFloat(s_price2));
			}
		}
		if (StringUtil.isNotEmpty(s_price1) && StringUtil.isNotEmpty(s_price2))
		{// 若都为非空
			if (goods.getPrice() < goods.getPrice1())
			{
				JOptionPane.showMessageDialog(null, "请重新输入套餐价格范围");
				return;
			} else if (goods.getPrice() == goods.getPrice1())
			{
				goods.setPrice(Float.parseFloat(s_price2));
			} else
			{
				goods.setPrice1(Float.parseFloat(s_price1));
				goods.setPrice(Float.parseFloat(s_price2));

			}
		}
		// 若都为空则不作为查询条件
		goods.setGoodsName(s_goodsName);
		this.filltable(goods);
		System.out.println(goods.getPrice1());
		System.out.println(goods.getPrice());

	}

	private void resetValues()
	{
		this.goodsNameTxt.setText("");
		this.goodsDescTxt.setText("");
		this.priceTxt.setText("");
		this.imageLinkTxt.setText("");
		this.iamgeLb.setIcon(null);
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea goodsDescTxt;
	private javax.swing.JTextField goodsIdTxt;
	private javax.swing.JTextField goodsNameTxt;
	private javax.swing.JTable goodsTable;
	private javax.swing.JLabel iamgeLb;
	private javax.swing.JTextField imageLinkTxt;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_chooser;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_modify;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextField priceTxt;
	private javax.swing.JTextField s_goodsName;
	private javax.swing.JTextField s_price_1;
	private javax.swing.JTextField s_price_2;
	// End of variables declaration//GEN-END:variables

}