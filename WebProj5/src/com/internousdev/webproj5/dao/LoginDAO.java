/*1.クラス、メソッドの定義
 * 2.DBConnectorのインスタンス化
 * 3.getConnectionの呼び出し。(DBと接続)
 * 4.sql文を書く。値を?としておき、どのような値でも使いまわせるようにする。
 * 5.PreparedStatement(DBと接続)に代入
 * 6.set文の?に入れる値をsetする
 * 7.executeQuery()/executeUpdate()で実行
 * 8.結果の処理(select文で取得した値をDTOに格納)
 * 9.con.close()で接続を切る。*/
package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.LoginDTO;
import com.internousdev.webproj5.util.DBConnector;

public class LoginDAO {
	public String username;
	public String password;

	/*LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作る。
	 * Actionクラスの値を引数として受け取る。*/
	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	public List<LoginDTO> select(String username, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users where user_name=? and password=?";
		try{
			/*定義したSQL文の1番目の?にActionから送られてきたusername
			 * 2番目の?にActionから送られてきたpasswordがそれぞれ入る。*/
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			/*select文のSQL文を実行するメソッドで、戻り値はResultSetになる。*/
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				LoginDTO dto = new LoginDTO();
				/*select文でDBから取得した情報をString型に変換してDTOクラスに格納する。
				 * LoginDTOクラスのsetUsername、setPasswordを(setter)を利用する。*/
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				loginDTOList.add(dto);
			}

			if(loginDTOList.size()<=0){
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
			}
		}
		/*処理中にSQL関連のエラーが発生した際に実行する、*/
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			/*DB接続を終了*/
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		/*loginDTOListの情報を呼び出しもとのActionクラスに返す*/
		return loginDTOList;
	}

}
