//Actionクラスから送られてきた情報を使ってDBへ問い合わせを行う。
//問い合わせて取得した値をDTOクラスに格納する。
//DBConnectorのインスタンス化→DBと接続→SQL文の記述→値をsetする
//→実行、取得した値をDTOに格納→接続を切る。

package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
		//LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作成。
		//Actionクラスの値を引数として受け取る。
		public LoginDTO select(String name,String password) throws SQLException{
			LoginDTO dto = new LoginDTO();
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();

			String sql = "select * from user where user_name=? and password=?";
			try{
				//定義したSQL文の1つ目の?にActionから送られてきたname、2つ目にActionから送られてきたpasswordが入る。
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,name);
				ps.setString(2,password);

				//select文のSQL文を実行するメソッド。戻り値はResultSet
				ResultSet rs= ps.executeQuery();

				if(rs.next()){
					//select文でDBから取得した情報をStringがたに変換し、DTOクラスに格納する。
					//LoginDTOクラスのsetName、setPassword(setter)を利用する。
					dto.setName(rs.getString("user_name"));
					dto.setPassword(rs.getString("password"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				//DB接続修了時は必ず書く。
				con.close();
			}
		//DTOに入った値を呼び出し元であるActionクラスに渡す。
		return dto;
		}
}
