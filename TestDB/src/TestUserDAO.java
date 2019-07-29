import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestUserDAO {
	String name ="";
	String password = "";

	public void select(String name,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
			//DB�֐ڑ����鏀��

		String sql = "select * from test_table where user_name=? and password=?";
			//user_name�Apassword�ɓ���2�̏����𖞂������f�[�^��sql�ɑ�������B
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
				//executeQuery();�͎��s���\�b�h�B�K��ResultSet���Ԃ��Ă���B
			if(rs.next()){	//�f�[�^�����݂��Ă����true�B���Ă��Ȃ����false
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
			//DB�Ƃ̐ڑ��I��
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
	public void selectAll(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){	//�J�[�\����1�s�����s���A�f�[�^���Ȃ��Ȃ�����I��
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
	public void selectByName(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select * from test_table where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));

			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
	public void selectByPassword(String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
	public void updateUserNameByUserName(String oldName,String newName){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "update test_table set user_name=? where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);
			int i = ps.executeUpdate();
				//�f�[�^�̌���(���l)��Ԃ��Ă���
			if(i>0){
				System.out.println(i + "���X�V����܂���");
			}
			else{
				System.out.println("�Y������f�[�^�͂���܂���ł����B");
			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
	public void insert(int user_id, String name, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into test_table values(?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,  user_id);
			ps.setString(2, name);
			ps.setString(3, password);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println(i + "���o�^����܂����B");
			}
;		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
	public void delete(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from test_table where user_name=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println(i+"���폜����܂����B");
			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
}

