//��ʂ��瑗���Ă������N�G�X�g���擾
//���������ɉ�����DAO��DTO�N���X���Ăяo���A�ŏI�I�Ɏ���JSP�֒l��Ԃ��B
//setter���`���邱�Ƃ�JSP�Ń��[�U�[�����͂����l���ϐ��Ɋi�[�����B
//execute���`���A���������SUCCESS��ERROR�������߁A�߂�l��Ԃ��B
package com.internousdev.login.action;

import java.sql.SQLException;
import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//struts2������ActionSupport�Ƃ����N���X���p��
public class LoginAction extends ActionSupport{
		private String name;
		private String password;

		public String execute() throws SQLException{
			String ret = ERROR;

			LoginDAO dao = new LoginDAO();
			LoginDTO dto = new LoginDTO();

			//JSP���瑗���Ă���name��password�������Ƃ���LoginDAO�N���X��select���\�b�h���Ăяo���B
			//���̌�DAO�Ŏ擾�������ʂ�LoginDTO�ɑ������B
			dto = dao.select(name, password);

			//���[�U�[�����͂������O�C��ID(name)�ƃp�X���[�h(password)��
			//DTO���玝���Ă����l(dto.getName())�y��(dto.getPassword())�ƈ�v���邩�m�F����B
			if(name.equals(dto.getName())){
				if(password.equals(dto.getPassword())){
					ret = SUCCESS;
					//��������v�����Ƃ��̂�ret�̓��e��SUCCESS�ɏ���������B
				}
			}
			return ret;
		}

		//setName�AsetPassowrd(setter)���`���邱�Ƃ�JSP�Ń��[�U�[�����͂���name��password�̒l�����ꂼ��̕ϐ��Ɋi�[�����B
		public String getName(){
			return name;
		}

		public void setName(String name){
			this.name = name;
		}

		public String getPassword(){
			return password;
		}

		public void setPassword(String password){
			this.password = password;
		}
}
