package com.internousdev.webproj5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//MySQL接続に必要な情報を設定。
	private static String driverName = "com.mysql.jdbc.Driver";
	//接続先のデータベース名を指定。
	private static String url = "jdbc:mysql://localhost/testdb1";
	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(driverName);
			//設定した情報を使って自分のパソコンにインストールされてるMySQLサーバへ接続するための記述。
			con = DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		//MySQLサーバに接続した結果をメソッドの呼び出し元に渡す。
		return con;
	}
}
