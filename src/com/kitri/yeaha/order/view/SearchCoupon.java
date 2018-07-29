package com.kitri.yeaha.order.view;

import com.kitri.yeaha.order.data.*;

public class SearchCoupon {
	MenuAndCouponDao cd = new MenuAndCouponDao();

	public CouponBean searchCoupon(String couponnum) {
		CouponBean cb = cd.getCouponInfo(couponnum);
		return cb;
	}

	public CTypeBean searchDiscount(int coupontype) {
		CTypeBean ctb = cd.getdiscout_rateinfo(coupontype);
		return ctb;
	}

	public void updateCoupon(String couponnum) {
		cd.UseCouponInfo(couponnum);
	}
}
