package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	public BuyItemDTO getBuyItemInfo(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO buyItemDTO = new BuyItemDTO();

		//商品情報をすべて取得する
		String sql ="SELECT id, item_name, item_price FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				//データベースから取得した情報をDTOに記憶
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}
}
