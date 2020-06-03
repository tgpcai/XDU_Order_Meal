package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.GoodsDao;
import com.model.Goods;
import com.util.StringUtil;

public class GoodsDaoImpl implements GoodsDao{
	@Override
	public int GoodsAdd(Connection con,Goods goods) throws Exception{
		String sql="insert into goods values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, goods.getGoodsName());
		pstmt.setFloat(2, goods.getPrice());
		pstmt.setString(3, goods.getGoodsDesc());
		pstmt.setString(4, goods.getImageLink());
		return pstmt.executeUpdate();
	}
	@Override
	public ResultSet goodsList(Connection con,Goods goods) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from `goods`");
		if(StringUtil.isNotEmpty(goods.getGoodsName())){
			sb.append(" and goodsName like '%"+goods.getGoodsName()+"%'");
		}
		if((goods.getPrice1()!=0)&&(goods.getPrice()==0) ){//�ͼ۸��У��߼۸���
			sb.append(" and price>="+goods.getPrice1());
		}else if(goods.getPrice()>goods.getPrice1()){//�м�۸�
			sb.append(" and price between "+goods.getPrice1()+" and "+goods.getPrice());
		}
		else if((goods.getPrice()!=0)){//�߼۸��У��ͼ۸��޻��ߺ͸߼۸�һ��
			sb.append(" and price<="+goods.getPrice());
		}
		if(goods.getId()!=0){
			sb.append(" and id="+goods.getId());
		}
		//System.out.println(sb.toString().replaceFirst("and", "where"));
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	@Override
	public int goodsDelete(Connection con,String id) throws Exception{
		String sql="delete from goods where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	@Override
	public int goodsModify(Connection con,Goods goods) throws Exception{
		String sql="update goods set goodsName=?,goodsDesc=?,price=?,imageLink=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, goods.getGoodsName());
		pstmt.setString(2, goods.getGoodsDesc());
		pstmt.setFloat(3, goods.getPrice());
		pstmt.setString(4, goods.getImageLink());
		pstmt.setInt(5, goods.getId());
		return pstmt.executeUpdate();
	}
}
