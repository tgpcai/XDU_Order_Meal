/*
 * AdminFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author __USER__
 */
public class ManFram extends javax.swing.JFrame
{

	/** Creates new form AdminFrm */
	public ManFram()
	{
		initComponents();
		// 设置最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jmiDealOrder = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jmiModify = new javax.swing.JMenuItem();
		jmiExit = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u70b9\u9910\u7cfb\u7edf\u7ba1\u7406\u4e3b\u754c\u9762");

		jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookManager.png"))); // NOI18N
		jMenu3.setText("\u8ba2\u5355\u7ba1\u7406");

		jmiDealOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/order2.png"))); // NOI18N
		jmiDealOrder.setText("\u8ba2\u5355\u5904\u7406");
		jmiDealOrder.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jmiDealOrderActionPerformed(evt);
			}
		});
		jMenu3.add(jmiDealOrder);

		jMenuBar1.add(jMenu3);

		jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
		jMenu4.setText("\u5176\u4ed6");

		jmiModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modify.png"))); // NOI18N
		jmiModify.setText("\u4fee\u6539\u5bc6\u7801");
		jmiModify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jmiModifyActionPerformed(evt);
			}
		});
		jMenu4.add(jmiModify);

		jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
		jmiExit.setText("\u9000\u51fa\u7cfb\u7edf");
		jmiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jmiExitActionPerformed(evt);
			}
		});
		jMenu4.add(jmiExit);

		jMenuBar1.add(jMenu4);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	// 订单处理操作
	private void jmiDealOrderActionPerformed(java.awt.event.ActionEvent evt)
	{
		Admin_DealOrderInterFrm dealOrderInterFrm = new Admin_DealOrderInterFrm();
		dealOrderInterFrm.setVisible(true);
		this.table.add(dealOrderInterFrm);
	}

	// 修改用户信息操作
	void jmiModifyActionPerformed(java.awt.event.ActionEvent evt)
	{
		User_AccountModifyInterFrm accountModify = new User_AccountModifyInterFrm();
		accountModify.setVisible(true);
		this.table.add(accountModify);
	}

	// 退出系统
	private void jmiExitActionPerformed(java.awt.event.ActionEvent evt)
	{
		int result = JOptionPane.showConfirmDialog(null, "是否退出点餐系统？");
		// System.out.println(result);
		if (result == 0)
			this.dispose();

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[])
	{
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				new ManFram().setVisible(true);
			}
		});
	}
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jmiDealOrder;
	private javax.swing.JMenuItem jmiExit;
	private javax.swing.JMenuItem jmiModify;
	private javax.swing.JDesktopPane table;
	// End of variables declaration//GEN-END:variables

}