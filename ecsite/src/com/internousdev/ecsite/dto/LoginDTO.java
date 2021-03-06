/*1.DAOクラスでselectされた値を格納する。*/
package com.internousdev.ecsite.dto;


public class LoginDTO {
	/*テーブルから取得するデータに対応したフィールド変数を宣言する。*/
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;

	/*Actionクラスから呼び出され、loginIdフィールドの値をActionに渡す。*/
	public String getLoginId(){
		return loginId;
	}
	/*DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginIdフィールドに格納する。*/
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}
}
