package com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.DataBufferByte;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.impl.UserDaoImpl;
import com.util.DbUtil;

public class User_OnlineRecharge extends JFrame
{
	public UserDaoImpl userDaoImpl = new UserDaoImpl();
	public DbUtil dbUtil = new DbUtil();
	private JPanel contentPane;
	private JTextField userName;
	private JTextField charge_money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					User_OnlineRecharge frame = new User_OnlineRecharge();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User_OnlineRecharge()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 409, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUsername = new JLabel("userName:");
		lblUsername.setIcon(new ImageIcon(User_OnlineRecharge.class.getResource("/images/userName.png")));
		lblUsername.setBounds(56, 72, 103, 18);
		contentPane.add(lblUsername);
		
		userName = new JTextField();
		userName.setBounds(167, 69, 154, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel label = new JLabel("\u5145\u503C\u91D1\u989D\uFF1A");
		label.setIcon(new ImageIcon(User_OnlineRecharge.class.getResource("/images/search1.png")));
		label.setBounds(56, 131, 95, 18);
		contentPane.add(label);
		
		charge_money = new JTextField();
		charge_money.setColumns(10);
		charge_money.setBounds(168, 127, 154, 24);
		contentPane.add(charge_money);
		
		JButton button = new JButton("\u5145\u503C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = changer();
				if (flag == 1)
				{
					JOptionPane.showMessageDialog(null, "充值成功");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "充值失败");
				}
			}
		});
		button.setIcon(new ImageIcon(User_OnlineRecharge.class.getResource("/images/add.png")));
		button.setBounds(129, 187, 113, 29);
		contentPane.add(button);
	}

	public int changer()
	{
		Connection con = null;
		try
		{
			con = dbUtil.getCon();
			String name = userName.getText();
			float money = Float.parseFloat(charge_money.getText());
			int i = userDaoImpl.changeUserMoney(con, name, money, true);
			return i;
		} catch (Exception e)
		{		
			e.printStackTrace();
			return 0;
		}
		finally 
		{
			try
			{
				if (con != null)
				{
					con.close();
				}
			} catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}	
	}
}
