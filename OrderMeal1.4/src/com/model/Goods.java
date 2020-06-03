package com.model;

public class Goods {
	private int id;
	private String goodsName;
	private String goodsDesc;
	private float price;//查询价格低高价格
	private float price1;//查询价格高价格
	private String imageLink;
	public static int forSale = -1;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(int id, String goodsName, String goodsDesc, float price,
			String imageLink) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.price = price;
		this.imageLink = imageLink;
	}

	public Goods(String goodsName, String goodsDesc, float price,
			String imageLink) {
		super();
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.price = price;
		this.imageLink = imageLink;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice1() {
		return price1;
	}
	public void setPrice1(float price1) {
		this.price1 = price1;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public static int getForSale() {
		return forSale;
	}

	public static void setForSale(int forSale) {
		Goods.forSale = forSale;
	}	
}
