import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnector{
	private static String driverName = "com.mysql.jdbc.Driver";
		//�h���C�o�[�̖��O��ϐ��ɑ��
	private static String url ="jdbc:mysql://localhost/testdb123?autoReconnect=true&useSSL=false";
		//mysql�p��URL�̎w��
	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;
			//�ڑ���Ԃɂ������1�x������

		try{	//��O����
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFoundException e){	//�N���X��������Ȃ��ꍇ
			e.printStackTrace();
		}
		catch(SQLException e){	//�f�[�^�x�[�X�����Ɋւ����O
			e.printStackTrace();
		}
		return con;
	}
}
