//データベースを使う必要がある場合、DB接続の設定を行う。
//DBConnectorでは接続するDBの「場所」「名前」「ユーザー名」「パスワード」の設定を行う。

package com.internousdev.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL接続に必要な情報を設定
public class DBConnector {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost/logindb_takizawa1";

	private static String user ="root";
	private static String password ="mysql";

	public Connection getConnection(){
		Connection con = null;

		//設定した情報を使ってインストールされているMySQLサーバーへ接続するための記述。
		try{
			Class.forName(driverName);
			con = (Connection)DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}

}
