package com.kitri.yeaha.manager.data;

public class CouponDto {
	// private int customer_id;
	private int coupon_type;
	private String coupon_name;
	private int discount_rate;

	public int getCoupon_type() {
		return coupon_type;
	}

	public void setCoupon_type(int coupon_type) {
		this.coupon_type = coupon_type;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public int getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}

}
