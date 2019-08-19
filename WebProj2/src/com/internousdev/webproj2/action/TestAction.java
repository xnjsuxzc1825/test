package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.TestDAO;

public class TestAction  extends ActionSUpport{
	private String username;
	private String password;

	public String execute(){
		String ret = ERROR;
		TestDAO dao = new testDAO();
		int count = dao.insert(username, password);
		if(count > 0){
				ret =SUCCESS;
		}
		return ret;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

}
