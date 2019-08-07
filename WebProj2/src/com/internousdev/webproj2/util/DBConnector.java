package com.internousdev.webproj2.util;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/testdb";
	private static String user = "root";
	private static String pasword = "mysql";

	public Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFOuondException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}

}
