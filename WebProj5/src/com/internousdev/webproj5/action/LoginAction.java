/*1.setterを定義することでJSPでユーザーが入力した値がフィールドに格納される。
 *2.execute()メソッドを定義
 *3.条件分岐でSUCCESSかERRORか判断
 *4.execute()メソッドの結果SUCCESS,ERRORを返す。
 *(struts.xmlに返り値として定義したそれぞれのJSPに振り分けられる) */
package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.LoginDAO;
import com.internousdev.webproj5.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/*struts2が持つActionSupportというクラスを継承。SessionAwareというインターフェイスの実装。*/
public class LoginAction extends ActionSupport implements SessionAware{
	/*フィールド変数。JSPから受け取る値username、passwordを定義
	 * 必ずJSPでの定義と同じ名前にする。*/
	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;

	public String execute(){
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();

		/*JSPから送られてきたusernameとpasswordを引数として、LoginDAOクラスのselectメソッドを呼び出す。
		 *その後DAOで取得した結果をLoginDTOに代入する。 */
		loginDTOList = dao.select(username, password);

		/*ユーザーが入力したログインID(username)とパスワード(password)がDTOから持ってきた値にそれぞれ一致するか確認する。*/
		if(this.username.equals(loginDTOList.get(0).getUsername()) && this.password.equals(loginDTOList.get(0).getPassword())){
			/*putメソッドで要素を記憶*/
			session.put("loginDTOList", loginDTOList);
			ret = SUCCESS;
		}
		else{
			session.put("loginDTOList", loginDTOList);
			ret = ERROR;
		}
		return ret;
	}


	public String getUsername(){
		return username;
	}
	/*setUsername,setpasswordを定義することでJSPでユーザーが入力したUsernameと
	 * Passwordの値が各フィールド定数に格納される。*/
	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Map<String, Object>getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
