//Action�N���X���瑗���Ă��������g����DB�֖₢���킹���s���B
//�₢���킹�Ď擾�����l��DTO�N���X�Ɋi�[����B
//DBConnector�̃C���X�^���X����DB�Ɛڑ���SQL���̋L�q���l��set����
//�����s�A�擾�����l��DTO�Ɋi�[���ڑ���؂�B

package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
		//LoginDTO�^���Ō�ɌĂяo�����ɓn���̂ŁALoginDTO�^��߂�l�ɂ������\�b�h���쐬�B
		//Action�N���X�̒l�������Ƃ��Ď󂯎��B
		public LoginDTO select(String name,String password) throws SQLException{
			LoginDTO dto = new LoginDTO();
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();

			String sql = "select * from user where user_name=? and password=?";
			try{
				//��`����SQL����1�ڂ�?��Action���瑗���Ă���name�A2�ڂ�Action���瑗���Ă���password������B
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, password);

				//select����SQL�������s���郁�\�b�h�B�߂�l��ResultSet
				ResultSet rs= ps.executeQuery();

				if(rs.next()){
					//select����DB����擾��������String�����ɕϊ����ADTO�N���X�Ɋi�[����B
					//LoginDTO�N���X��setName�AsetPassword(setter)�𗘗p����B
					dto.setName(rs.getString("user_name"));
					dto.setPassword(rs.getString("password"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				//DB�ڑ��C�����͕K�������B
				con.close();
			}
		//DTO�ɓ������l���Ăяo�����ł���Action�N���X�ɓn���B
		return dto;
		}
}