package com.kitri.yeaha.kitchen.data;

import java.util.List;

import com.kitri.yeaha.manager.data.YeahhaBean;
import com.kitri.yeaha.manager.data.YeahhaDao;

public class YeahhaCont {

	// 추가 메뉴 입력값 DB에 반영하도록 전달하기
	public void addYeahha(YeahhaBean yb) {
		// YeahhaDao에 yb값 전달하기
		YeahhaDao yd = new YeahhaDao();
		yd.addYeahha(yb);
	}

	public List<YeahhaBean> comboBox() {
		YeahhaDao yd = new YeahhaDao();
		List<YeahhaBean> yb = yd.getMenuInfo();

		return yb;
	}

	public void delYeahha(String yb) {
		YeahhaDao yd = new YeahhaDao();
		yd.delYeahha(yb);
	}

}
