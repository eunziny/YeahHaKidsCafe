package com.kitri.yeaha.order.data;

public class ChoiceBean {

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	String menuname;
	int price;
	int account;

	public ChoiceBean(String menuname, int price) {
		this.menuname = menuname;
		this.price = price;
		this.account = 1;

	}
}
