//DB����擾�������(DAO�N���X��Select���ꂽ�l)���i�[����ׂ̃N���X
//DAO��DTO��Action
//�e�ϐ���getter��setter���`
//getter:Action�N���X����Ăяo����AAction�N���X�֒l��n���B
//setter:DAO�N���X����Ăяo����A�e�[�u���̒l�����g�̕ϐ��Ɋi�[�B

package com.internousdev.login.dto;

public class LoginDTO {
	private int id;
	private String name;
	private String password;

	//�ϐ��ɑΉ�����getter��setter���`
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	//Action�N���X����Ăяo����Aname�̒l��n���B
	public String getName(){
		return name;
	}

	//DAO�N���X����Ăяo����A�����Ƃ��Ď󂯎�����e�[�u���̒l�����g��name�Ɋi�[
	public void setName(String name){
		this.name = name;
	}

	//Action�N���X����Ăяo����Apassword�̒l��Action�N���X�ɓn���B
	public String getPassword(){
		return password;
	}

	//DAO�N���X����Ăяo����A�����Ƃ��Ď󂯎�����e�[�u���̒l�����g��password�Ɋi�[
	public void setPassword(String password){
		this.password = password;
	}


}
