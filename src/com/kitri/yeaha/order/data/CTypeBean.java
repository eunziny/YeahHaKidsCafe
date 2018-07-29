package com.kitri.yeaha.order.data;

public class CTypeBean {

	public int coupon_type;
	public String coupon_name;
	public int discount_rate;
	public String couponuseyn;

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

	public CTypeBean() {
		this.coupon_type = coupon_type;
		this.coupon_name = coupon_name;
		this.discount_rate = discount_rate;
	}

}
