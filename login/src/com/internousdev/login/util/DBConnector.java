//�f�[�^�x�[�X���g���K�v������ꍇ�ADB�ڑ��̐ݒ���s���B
//DBConnector�ł͐ڑ�����DB�́u�ꏊ�v�u���O�v�u���[�U�[���v�u�p�X���[�h�v�̐ݒ���s���B

package com.internousdev.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL�ڑ��ɕK�v�ȏ���ݒ�
public class DBConnector {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost/logindb_takizawa";

	private static String user ="root";
	private static String password ="mysql";

	public Connection getConnection(){
		Connection con = null;

		//�ݒ肵�������g���ăC���X�g�[������Ă���MySQL�T�[�o�[�֐ڑ����邽�߂̋L�q�B
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
