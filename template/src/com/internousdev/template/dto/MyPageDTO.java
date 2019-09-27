package com.internousdev.template.dto;

public class MyPageDTO {
	private String itemName;
	private String totalPrice;
	private String totalCount;
	private String payment;

	public String getItemName(){
		return this.itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getTotalPrice(){
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice){
		this.totalPrice = totalPrice;
	}

	public String getTotalCount(){
		return this.totalCount;
	}

	public void setTotalCount(String totalCount){
		this.totalCount = totalCount;
	}

	public String getPayment(){
		return this.payment;
	}

	public void setPayment(String payment){
		this.payment = payment;
	}

}
