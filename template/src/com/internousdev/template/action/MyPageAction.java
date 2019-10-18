package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	private Map<String,Object>session;
	private String deleteFlg;
	private String result;
	public String execute()throws SQLException{
			MyPageDAO myPageDAO = new MyPageDAO();
			MyPageDTO myPageDTO = new MyPageDTO();

			//商品を削除しない場合
			if(deleteFlg == null){
				String item_transaction_id = session.get("id").toString();
				String user_master_id = session.get("login_user_id").toString();
				//データベースから取得した履歴情報をDTOに格納
				myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

				session.put("buyItem_name", myPageDTO.getItemName());
				session.put("total_price", myPageDTO.getTotalPrice());
				session.put("total_count", myPageDTO.getTotalCount());
				session.put("total_payment", myPageDTO.getPayment());
				session.put("message", "");
			//商品履歴を削除する場合
			}else if(deleteFlg.equals("1")){
				delete();//deleteメソッドを実行
			}
			result = SUCCESS;
			return result;
	}

	public void delete(){
		MyPageDAO myPageDAO = new MyPageDAO();

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		/*myPageDAOクラスのbuyItemHistoryDeleteメソッドを呼び出す。引数はitem_transaction_idとuser_master_id
		 * 実行結果をint型resに代入。実行結果は削除した処理した行数を返す為、0なら処理失敗となる。*/
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

		if (res > 0){
			session.put("message","商品情報を正しく削除しました。");
		}
		else if(res==0){
			session.put("message", "商品情報の削除に失敗しました。");
		}
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public Map<String, Object>getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;
	}
}
