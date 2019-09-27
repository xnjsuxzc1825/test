package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {
	public MyPageDTO getMyPageUserInfo(String item_transaction_id, String user_master_id)
	throws SQLException{
		DBConnector dbConnctor = new DBConnector();
		Connection connection = dbConnector.getConnection();
		MyPageDTO mypageDTO = new MyPageDTO();

		String sql = "SELECT iit.item_name, ubit.total_price, uvit.total_count, ubit.pay FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iitON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY ubit.insert_date DESC";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  item_transaction_id);
			preparedStatement.setString(2,  user_master_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(result.next()){
				myPageDTO.setItemName(resultSet.getString("item_name"));
				myPageDTO.setTotalPrice(resultSet.getString("total_price"));
				myPageDTO.setTotalCount(resultSet.getString("total_count"));
				mypageDTO.setPayment(resultSet.getString("pay"));
			}
		}

	}
}
