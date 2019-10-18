package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		LoginDTO loginDTO = new LoginDTO();
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass= ?";

		try{
			/*定義したSQL文の1番目の?にActionから送られてきたloginUserId
			 * 2番目の?にActionから送られてきたloginPasswordがそれぞれ入る。*/
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			/*select文のSQL文を実行するメソッドで、戻り値はResultSetになる。*/
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				/*select文でDBから取得した情報をString型に変換してDTOクラスに格納する。
				 * LoginDTOクラスのsetLoginId、setLoginPassword、setUserNameを(setter)を利用する。*/
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

}
