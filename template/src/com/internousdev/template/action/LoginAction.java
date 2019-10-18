/*1.setterを定義することでJSPでユーザーが入力した値がフィールドに格納される。*/
package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/*struts2が持つActionSupportというクラスを継承。SessionAwareというインターフェイスの実装。*/
public class LoginAction extends ActionSupport implements SessionAware{
	/*フィールド変数。JSPから受け取る値loginUserId、loginPasswordを定義
	 * 必ずJSPでの定義と同じ名前にする。*/
	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String, Object>session;

	public String execute(){
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		result = ERROR;
		/*JSPから送られてきたloginUserIdとloginPasswordを引数として、LoginDAOクラスのgetLoginUserInfoメソッドを呼び出す。
		 *その後DAOで取得した結果をLoginDTOに代入する。 */
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		/*Mapを使い、putメソッドで要素を記憶*/
		session.put("loginUser",loginDTO);

		/*ユーザーが入力したログインID(loginUserId)とパスワード(loginPassword)がDTOに記憶し、取得した値とそれぞれ一致するか確認する。*/
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			/*ログインに成功した場合、商品情報を記憶する。*/
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId= loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public Map<String,Object>getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}
