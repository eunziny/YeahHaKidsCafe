package com.kitri.yeaha.manager.service;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kitri.yeaha.manager.data.CouponDto;

public class CouponService {
	ManagerService ms;
	List<CouponDto> list;

	public CouponService(ManagerService ms) {
		// TODO Auto-generated constructor stub
		this.ms = ms;
	}

	public void setCouponList() {
		// TODO Auto-generated method stub
		ms.tv.cv.model.setRowCount(0);
		list = ms.td.getcouponList();
		System.out.println(list.size());
		for (CouponDto cd : list) {
			Vector<String> rowdata = new Vector<String>();
			rowdata.add(Integer.toString(cd.getCoupon_type()));
			rowdata.add(cd.getCoupon_name());
			rowdata.add(Integer.toString(cd.getDiscount_rate()));
			ms.tv.cv.model.addRow(rowdata);
		}
	}

	public void addCoupon() {
		// TODO Auto-generated method stub
		String cpname = ms.tv.cv.cpnameTf.getText().trim();
		String dcrate = ms.tv.cv.dcrateTf.getText().trim();
		if (cpname.isEmpty() || dcrate.isEmpty() || Integer.parseInt(dcrate) >= 100) {
			JOptionPane.showMessageDialog(ms.tv.cv, "이름과 할인율을 정확하게 입력해 주세요.");
		} else {
			ms.td.addCoupon(cpname, Integer.parseInt(dcrate));
			JOptionPane.showMessageDialog(ms.tv.cv, "쿠폰 생성 완료!");
		}
	}

	public void delCoupon() {
		int row = ms.tv.cv.table.getSelectedRow();
		int ctype = Integer.parseInt(ms.tv.cv.model.getValueAt(row, 0).toString());
		ms.tv.cv.model.removeRow(row);
		// ms.tv.cpm.couponList.remove(row-1);
		System.out.println(ctype);
		ms.td.delCoupon(ctype);
	}
}
