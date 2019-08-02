//画面から送られてきたリクエストを取得
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返す。
//setterを定義することでJSPでユーザーが入力した値が変数に格納される。
//executeを定義し、条件分岐でSUCCESSかERRORかを決め、戻り値を返す。
package com.internousdev.login.action;

import java.sql.SQLException;
import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//struts2が持つActionSupportというクラスを継承
public class LoginAction extends ActionSupport{
		private String name;
		private String password;

		public String execute() throws SQLException{
			String ret = ERROR;

			LoginDAO dao = new LoginDAO();
			LoginDTO dto = new LoginDTO();

			//JSPから送られてきたnameとpasswordを引数としてLoginDAOクラスのselectメソッドを呼び出す。
			//その後DAOで取得した結果をLoginDTOに代入する。
			dto = dao.select(name, password);

			//ユーザーが入力したログインID(name)とパスワード(password)が
			//DTOから持ってきた値(dto.getName())及び(dto.getPassword())と一致するか確認する。
			if(name.equals(dto.getName())){
				if(password.equals(dto.getPassword())){
					ret = SUCCESS;
					//両方が一致したときのみretの内容をSUCCESSに書き換える。
				}
			}
			return ret;
		}

		//setName、setPassowrd(setter)を定義することでJSPでユーザーが入力したnameとpasswordの値がそれぞれの変数に格納される。
		public String getName(){
			return name;
		}

		public void setName(String name){
			this.name = name;
		}

		public String getPassword(){
			return password;
		}

		public void setPassword(String password){
			this.password = password;
		}
}
