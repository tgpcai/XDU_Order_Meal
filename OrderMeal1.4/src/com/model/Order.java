package com.model;

import com.mysql.jdbc.EscapeTokenizer;

public class Order {

	private int id;
	private String orderId;
	private float goodsTotalPrice;
	private int goodsId;
	private float goodsPrice;
	private int goodsNum;
	private String goodsName;
	private int orderStatus;
	private int orderNum;
	private float orderTotalMoney;
	private String userName;
	private String destinaton;
	private int userid;
	private String SendTime;
	
	
	public Order()
	{
		super();		
	}
	
	public Order(String orderId, int orderStatus, int orderNum,
			float orderTotalMoney, String userName,String destination,int id,String SendTime) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderNum = orderNum;
		this.orderTotalMoney = orderTotalMoney;
		this.userName = userName;
		this.destinaton = destination;
		this.userid = id;
		this.SendTime = SendTime;
	}
	public Order(String orderId, float goodsTotalPrice, int goodsId,
			float goodsPrice, int goodsNum, String goodsName,String destination,int id,String SendTime) {
		super();
		this.orderId = orderId;
		this.goodsTotalPrice = goodsTotalPrice;
		this.goodsId = goodsId;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.goodsName = goodsName;
		this.destinaton = destination;
		this.userid = id;
		this.SendTime = SendTime;
	}
	
	public String getSendTime()
	{
		return SendTime;
	}

	public void setSendTime(String sendTime)
	{
		SendTime = sendTime;
	}

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getOrderId()
	{
		return orderId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	public float getGoodsTotalPrice()
	{
		return goodsTotalPrice;
	}
	public void setGoodsTotalPrice(float goodsTotalPrice)
	{
		this.goodsTotalPrice = goodsTotalPrice;
	}
	public int getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}
	public float getGoodsPrice()
	{
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice)
	{
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsNum()
	{
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum)
	{
		this.goodsNum = goodsNum;
	}
	public String getGoodsName()
	{
		return goodsName;
	}
	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}
	public int getOrderStatus()
	{
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus)
	{
		this.orderStatus = orderStatus;
	}
	public int getOrderNum()
	{
		return orderNum;
	}
	public void setOrderNum(int orderNum)
	{
		this.orderNum = orderNum;
	}
	public float getOrderTotalMoney()
	{
		return orderTotalMoney;
	}
	public void setOrderTotalMoney(float orderTotalMoney)
	{
		this.orderTotalMoney = orderTotalMoney;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getDestinaton()
	{
		return destinaton;
	}
	public void setDestinaton(String destinaton)
	{
		this.destinaton = destinaton;
	}
	
	
	
	
	
	
	
	
	
}
