//DBから取得した情報(DAOクラスでSelectされた値)を格納する為のクラス
//DAO→DTO→Action
//各変数のgetterとsetterを定義
//getter:Actionクラスから呼び出され、Actionクラスへ値を渡す。
//setter:DAOクラスから呼び出され、テーブルの値を自身の変数に格納。

package com.internousdev.login.dto;

public class LoginDTO {
	private int id;
	private String name;
	private String password;

	//変数に対応したgetterとsetterを定義
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	//Actionクラスから呼び出され、nameの値を渡す。
	public String getName(){
		return name;
	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のnameに格納
	public void setName(String name){
		this.name = name;
	}

	//Actionクラスから呼び出され、passwordの値をActionクラスに渡す。
	public String getPassword(){
		return password;
	}

	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordに格納
	public void setPassword(String password){
		this.password = password;
	}


}
