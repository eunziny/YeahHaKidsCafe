package com.kitri.yeaha.manager.data;

public class CustomerDto {
	private int customer_number;
	private String c_id;
	private String c_password;
	private String parents_name;
	private String kids_name;
	private String phone_number;
	private String kids_birthday;
	private String last_visit;
	private int remain_amount;

	public int getRemain_amount() {
		return remain_amount;
	}

	public void setRemain_amount(int remain_amount) {
		this.remain_amount = remain_amount;
	}

	public int getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getParents_name() {
		return parents_name;
	}

	public void setParents_name(String parents_name) {
		this.parents_name = parents_name;
	}

	public String getKids_name() {
		return kids_name;
	}

	public void setKids_name(String kids_name) {
		this.kids_name = kids_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getKids_birthday() {
		return kids_birthday;
	}

	public void setKids_birthday(String kids_birthday) {
		this.kids_birthday = kids_birthday;
	}

	public String getLast_visit() {
		return last_visit;
	}

	public void setLast_visit(String last_visit) {
		this.last_visit = last_visit;
	}

}
