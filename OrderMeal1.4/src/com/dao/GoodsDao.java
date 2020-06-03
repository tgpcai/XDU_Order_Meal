/**   
 * @author: 林俊威 16130110026 734608679@qq.com
 * @date: 2018年12月10日 下午4:38:27 
 * @Description:
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.model.*;

public interface GoodsDao {
	/**
	 * @param con
	 * @param goods
	 * @return
	 * @throws Exception
	 * @Description:添加订单内商品
	 */
	int GoodsAdd(Connection con,Goods goods) throws Exception;
	/**
	 * @param con
	 * @param goods
	 * @return
	 * @throws Exception
	 * @Description:
	 */
	ResultSet goodsList(Connection con,Goods goods) throws Exception;
	/**
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 * @Description:删除id订单商品
	 */
	int goodsDelete(Connection con,String id) throws Exception;
	/**
	 * @param con
	 * @param goods
	 * @return
	 * @throws Exception
	 * @Description:修改商品
	 */
	int goodsModify(Connection con,Goods goods) throws Exception;
}
