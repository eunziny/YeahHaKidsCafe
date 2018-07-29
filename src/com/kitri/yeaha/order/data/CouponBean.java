package com.kitri.yeaha.order.data;

public class CouponBean {

	int coupon_number;
	int customer_number;
	int coupon_type;
	String start_date;
	String end_date;
	String couponuseyn;

	public String getCouponuseyn() {
		return couponuseyn;
	}

	public void setCouponuseyn(String couponuseyn) {
		this.couponuseyn = couponuseyn;
	}

	public int getCoupon_number() {
		return coupon_number;
	}

	public void setCoupon_number(int coupon_number) {
		this.coupon_number = coupon_number;
	}

	public int getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	public int getCoupon_type() {
		return coupon_type;
	}

	public void setCoupon_type(int coupon_type) {
		this.coupon_type = coupon_type;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public CouponBean() {
		this.coupon_number = coupon_number;
		this.customer_number = customer_number;
		this.coupon_type = coupon_type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.couponuseyn = couponuseyn;
	}
}
