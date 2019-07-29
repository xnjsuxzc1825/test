import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnector{
	private static String driverName = "com.mysql.jdbc.Driver";
		//ドライバーの名前を変数に代入
	private static String url ="jdbc:mysql://localhost/testdb123?autoReconnect=true&useSSL=false";
		//mysql用のURLの指定
	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;
			//接続状態にした後に1度初期化

		try{	//例外処理
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFoundException e){	//クラスが見つからない場合
			e.printStackTrace();
		}
		catch(SQLException e){	//データベース処理に関する例外
			e.printStackTrace();
		}
		return con;
	}
}
