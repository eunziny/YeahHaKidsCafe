package com.kitri.yeaha.kitchen.data;

import java.util.List;

import com.kitri.yeaha.manager.data.YeahhaBean;
import com.kitri.yeaha.manager.data.YeahhaDao;

public class YeahhaCont {

	// �߰� �޴� �Է°� DB�� �ݿ��ϵ��� �����ϱ�
	public void addYeahha(YeahhaBean yb) {
		// YeahhaDao�� yb�� �����ϱ�
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
