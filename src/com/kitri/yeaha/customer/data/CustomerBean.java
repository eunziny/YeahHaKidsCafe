package com.kitri.yeaha.customer.data;

import com.kitri.yeaha.customer.view.CustomerViewJoin;
import com.kitri.yeaha.customer.view.CustomerViewMain;

public class CustomerBean {
	private int customer_number;
	private String c_ID;
	private String c_PassWord;
	private String parents_Name;
	private String kids_Name;
	private String phone_Number;
	private String kids_Birthday;
	private String last_Visit;

	private String remain_amount;

	private String coupon_type;
	private int coupon_number;
	private String coupon_name;
	private String start_date;
	private String end_date;
	private String today_date;

	private int discount_rate;

	public CustomerViewMain main;
	public CustomerViewJoin join;

	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	public int getCustomer_number() {
		return customer_number;
	}

	public void setC_ID(String c_ID) {
		this.c_ID = c_ID;
	}

	public String getC_ID() {
		return c_ID;
	}

	public void setC_PassWord(String c_PassWord) {
		this.c_PassWord = c_PassWord;
	}

	public String getC_PassWord() {
		return c_PassWord;
	}

	public void setParents_Name(String parents_Name) {
		this.parents_Name = parents_Name;
	}

	public String getParents_Name() {
		return parents_Name;
	}

	public void setKids_Name(String kids_Name) {
		this.kids_Name = kids_Name;
	}

	public String getKids_Name() {
		return kids_Name;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setKids_Birthday(String kids_Birthday) {
		this.kids_Birthday = kids_Birthday;
	}

	public String getKids_Birthday() {
		return kids_Birthday;
	}

	public void setLast_Visit(String last_Visit) {
		this.last_Visit = last_Visit;
	}

	public String getLast_Visit() {
		return last_Visit;
	}

	// -----------------------------------------------------------------
	public void setRemain_Amount(String remain_amount) {
		this.remain_amount = remain_amount;
	}

	public String getRemain_Amount() {
		return remain_amount;
	}

	// -----------------------------------------------------------------
	public void setCoupon_Number(int coupon_number) {
		this.coupon_number = coupon_number;
	}

	public int getCoupon_Number() {
		return coupon_number;
	}

	public void setCoupon_Name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public String getCoupon_Name() {
		return coupon_name;
	}

	public void setCoupon_Type(String coupon_type) {
		this.coupon_type = coupon_type;
	}

	public String getCoupon_Type() {
		return coupon_type;
	}

	public void setStart_Date(String start_date) {
		this.start_date = start_date;
	}

	public String getStart_Date() {
		return start_date;
	}

	public void setEnd_Date(String end_date) {
		this.end_date = end_date;
	}

	public String getEnd_Date() {
		return end_date;
	}

	public void setDiscount_Rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}

	public int getDiscount_Rate() {
		return discount_rate;
	}

	public String getToday_date() {
		return today_date;
	}

	public void setToday_date(String today_date) {
		this.today_date = today_date;
	}
}
