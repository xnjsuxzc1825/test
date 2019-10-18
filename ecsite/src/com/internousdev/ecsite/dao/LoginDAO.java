package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try{
			/*定義したSQL文の1番目の?にActionから送られてきたloginUserId
			 * 2番目の?にActionから送られてきたloginPasswordがそれぞれ入る。*/
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  loginUserId);
			ps.setString(2, loginPassword);

			/*select文のSQL文を実行するメソッドで、戻り値はResultSetになる。*/
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				/*select文でDBから取得した情報をString型に変換してDTOクラスに格納する。
				 * LoginDTOクラスのsetLoginId、setLoginPassword、setUserNameを(setter)を利用する。*/
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

				if(rs.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	return loginDTO;
	}
}
