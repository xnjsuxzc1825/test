/*1.DAOクラスでselectされた値を格納する。
 *2.フィールドで格納する値を宣言
 *3.2の各フィールドのgetterとsetterを定義
 *getter:Actionクラスから呼び出され、Actionへ値を渡す。
 *setter:DAOクラスから呼び出され、テーブルの値をDTOのフィールドに格納。 */

package com.internousdev.webproj5.dto;

public class LoginDTO {
	/*テーブルから取得するデータに対応したフィールド変数を宣言する。*/
	private String username;
	private String password;

	/*フィールド変数に対応したgetterとsetterを定義する。*/

	/*Actionクラスから呼び出され、usernameフィールドの値をActionに渡す。*/
	public String getUsername(){
		return username;
	}

	/*DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のusernameフィールドに格納する。*/
	public void setUsername(String username){
		this.username = username;
	}

	/*Actionクラスから呼び出され、passwordフィールドの値をActionに渡す。*/
	public String getPassword(){
		return password;

	}

	/*DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordフィールドに格納する。*/
	public void setPassword(String password){
		this.password = password;
	}
}
