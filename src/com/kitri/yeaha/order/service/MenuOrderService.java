package com.kitri.yeaha.order.service;

import javax.swing.JOptionPane;

import com.kitri.yeaha.manager.service.ManagerService;
import com.kitri.yeaha.order.data.CouponBean;
import com.kitri.yeaha.order.view.SearchCoupon;

public class MenuOrderService {
	// OrderDao od = new OrderDao();

	public YeahaImageService yhmimg;
	ManagerService ms;

	public MenuOrderService(ManagerService ms) {
		this.ms = ms;
	}

	public void downOrder() {
		++ms.tv.ov.mop.row;
		ms.tv.ov.mop.choicetable.changeSelection(ms.tv.ov.mop.row, ms.tv.ov.mop.col, false, false);
	}

	public void upOrder() {
		--ms.tv.ov.mop.row;
		ms.tv.ov.mop.choicetable.changeSelection(ms.tv.ov.mop.row, ms.tv.ov.mop.col, false, false);
	}

	public void descAmount() {
		int num = (int) ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 1);
		if (num > 1) {
			--num;
			if (num > 0) {
				ms.tv.ov.mop.menuprice = Integer
						.parseInt(ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 2).toString().replaceAll(",", ""))
						- Integer.parseInt(
								ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 2).toString().replaceAll(",", ""))
								/ (num + 1);

			}
			ms.tv.ov.mop.dm.setValueAt(num, ms.tv.ov.mop.row, 1);
			ms.tv.ov.mop.dm.setValueAt(String.format("%,d", ms.tv.ov.mop.menuprice), ms.tv.ov.mop.row, 2);
			ms.tv.ov.mop.totalprice2.setText(String.format("%,d", ms.tv.ov.mop.show_t_price()));
		}
	}

	public void incAmount() {
		int num = (int) ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 1);
		++num;
		if (num > 1) {
			ms.tv.ov.mop.menuprice = Integer
					.parseInt(ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 2).toString().replaceAll(",", ""))
					+ Integer.parseInt(ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 2).toString().replaceAll(",", ""))
							/ (num - 1);
		} else {
			ms.tv.ov.mop.menuprice = Integer
					.parseInt(ms.tv.ov.mop.dm.getValueAt(ms.tv.ov.mop.row, 2).toString().replaceAll(",", ""));
		}
		ms.tv.ov.mop.dm.setValueAt(num, ms.tv.ov.mop.row, 1);
		ms.tv.ov.mop.dm.setValueAt(String.format("%,d", ms.tv.ov.mop.menuprice), ms.tv.ov.mop.row, 2);
		ms.tv.ov.mop.totalprice2.setText(String.format("%,d", ms.tv.ov.mop.show_t_price()));
	}

	public void incMenu(int index) {
		// if (ms.tv.ov.mop.menutab.getTitleAt(index).equals("메인")) {
		// ms.tv.ov.mop.inputObj[0] = ms.tv.ov.mop.mmt.menuname;
		// ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
		// ms.tv.ov.mop.inputObj[2] = ms.tv.ov.mop.mmt.price;
		// ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
		// ms.tv.ov.mop.totalprice2.setText(Integer.toString(ms.tv.ov.mop.show_t_price()));
		int checkrow = ms.tv.ov.mop.choicetable.getRowCount();
		if (ms.tv.ov.mop.menutab.getTitleAt(index).equals("메인")) {
			ms.tv.ov.mop.inputObj[0] = ms.tv.ov.mop.mmt.menuname;
			ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
			if (checkrow == 0) {
				// System.out.println("처음부터시작");
				ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
				ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.mmt.price);
				ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
			} else {
				for (int i = 0; i < checkrow; i++) {
					ms.checkmenu = true;
					if (ms.tv.ov.mop.mmt.menuname.equals(ms.tv.ov.mop.choicetable.getValueAt(i, 0))) {
						ms.checkmenu = false;
						ms.selectedrow = i;
						break;
					}
				}
				if (ms.checkmenu == false) {
					ms.tv.ov.mop.inputObj[1] = ((int) ms.tv.ov.mop.choicetable.getValueAt(ms.selectedrow, 1) + 1);
					ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.mmt.price
							* (((int) ms.tv.ov.mop.choicetable.getValueAt(ms.selectedrow, 1) + 1)));
					ms.tv.ov.mop.choicetable.setValueAt(ms.tv.ov.mop.inputObj[1], ms.selectedrow, 1);
					ms.tv.ov.mop.choicetable.setValueAt(ms.tv.ov.mop.inputObj[2], ms.selectedrow, 2);
				} else if (ms.checkmenu == true) {
					ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.mmt.price);
					ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
				}
			}
			ms.tv.ov.mop.totalprice2.setText(String.format("%,d", ms.tv.ov.mop.show_t_price()));
			// System.out.println(ms.tv.ov.mop.inputObj[0]);
		} else if (ms.tv.ov.mop.menutab.getTitleAt(index).equals("사이드")) {
			// ms.tv.ov.mop.inputObj[0] = ms.tv.ov.mop.smt.sidemenu;
			// ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
			// ms.tv.ov.mop.inputObj[2] = ms.tv.ov.mop.smt.sideprice;
			// ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
			// ms.tv.ov.mop.totalprice2.setText(Integer.toString(ms.tv.ov.mop.show_t_price()));
			ms.tv.ov.mop.inputObj[0] = ms.tv.ov.mop.smt.sidemenu;
			ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
			if (checkrow == 0) {
				System.out.println("처음부터시작");
				ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
				ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.smt.sideprice);
				ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
			} else {
				for (int i = 0; i < checkrow; i++) {
					ms.checkmenu = true;
					if (ms.tv.ov.mop.smt.sidemenu.equals(ms.tv.ov.mop.choicetable.getValueAt(i, 0))) {
						ms.checkmenu = false;
						ms.selectedrow = i;
						break;
					}
				}
				if (ms.checkmenu == false) {
					ms.tv.ov.mop.inputObj[1] = ((int) ms.tv.ov.mop.choicetable.getValueAt(ms.selectedrow, 1) + 1);
					ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.smt.sideprice
							* (((int) ms.tv.ov.mop.choicetable.getValueAt(ms.selectedrow, 1) + 1)));
					ms.tv.ov.mop.choicetable.setValueAt(ms.tv.ov.mop.inputObj[1], ms.selectedrow, 1);
					ms.tv.ov.mop.choicetable.setValueAt(ms.tv.ov.mop.inputObj[2], ms.selectedrow, 2);
				} else if (ms.checkmenu == true) {
					ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.smt.sideprice);
					ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
				}
			}
			ms.tv.ov.mop.totalprice2.setText(String.format("%,d", ms.tv.ov.mop.show_t_price()));
		} else if (ms.tv.ov.mop.menutab.getTitleAt(index).equals("음료")) {
			// ms.tv.ov.mop.inputObj[0] = ms.tv.ov.mop.dmt.drinkmenu;
			// ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
			// ms.tv.ov.mop.inputObj[2] = ms.tv.ov.mop.dmt.drinkprice;
			// ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
			// ms.tv.ov.mop.totalprice2.setText(Integer.toString(ms.tv.ov.mop.show_t_price()));

			ms.tv.ov.mop.inputObj[0] = ms.tv.ov.mop.dmt.drinkmenu;
			ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
			if (checkrow == 0) {
				System.out.println("처음부터시작");
				ms.tv.ov.mop.inputObj[1] = ms.tv.ov.mop.account;
				ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.dmt.drinkprice);
				ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
			} else {
				for (int i = 0; i < checkrow; i++) {
					ms.checkmenu = true;
					if (ms.tv.ov.mop.dmt.drinkmenu.equals(ms.tv.ov.mop.choicetable.getValueAt(i, 0))) {
						ms.checkmenu = false;
						ms.selectedrow = i;
						break;
					}
				}
				if (ms.checkmenu == false) {
					ms.tv.ov.mop.inputObj[1] = ((int) ms.tv.ov.mop.choicetable.getValueAt(ms.selectedrow, 1) + 1);
					ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.dmt.drinkprice
							* (((int) ms.tv.ov.mop.choicetable.getValueAt(ms.selectedrow, 1) + 1)));
					ms.tv.ov.mop.choicetable.setValueAt(ms.tv.ov.mop.inputObj[1], ms.selectedrow, 1);
					ms.tv.ov.mop.choicetable.setValueAt(ms.tv.ov.mop.inputObj[2], ms.selectedrow, 2);
				} else if (ms.checkmenu == true) {
					ms.tv.ov.mop.inputObj[2] = String.format("%,d", ms.tv.ov.mop.dmt.drinkprice);
					ms.tv.ov.mop.dm.addRow(ms.tv.ov.mop.inputObj);
				}
			}
			ms.tv.ov.mop.totalprice2.setText(String.format("%,d", ms.tv.ov.mop.show_t_price()));
		}
	}

	// public void checkCoupon(SearchCoupon sc) {
	// System.out.println("asd");
	// CouponBean cb = sc.searchCoupon(ms.tv.ov.mop.tp.couponnum);
	// ms.tv.ov.mop.tp.cpnum =
	// sc.searchCoupon(ms.tv.ov.mop.tp.couponnum).getCoupon_number();
	// if
	// (Integer.toString(ms.tv.ov.mop.tp.cpnum).equals(ms.tv.ov.mop.tp.couponnum)) {
	// ms.tv.ov.mop.tp.coupontype =
	// sc.searchCoupon(ms.tv.ov.mop.tp.couponnum).getCoupon_type();
	// ms.tv.ov.mop.tp.discountrate =
	// sc.searchDiscount(ms.tv.ov.mop.tp.coupontype).getDiscount_rate();
	// ms.tv.ov.mop.tp.price =
	// Integer.parseInt(ms.tv.ov.mop.tp.price_label2.getText().replaceAll(",", ""));
	// ms.tv.ov.mop.tp.discountprice = ms.tv.ov.mop.tp.price * ((double)
	// ms.tv.ov.mop.tp.discountrate / 100);
	// ms.tv.ov.mop.tp.discount_label2.setText(String.format("%,d", (int)
	// ms.tv.ov.mop.tp.discountprice));
	// ms.tv.ov.mop.tp.t_price_label2
	// .setText(String.format("%,d", ms.tv.ov.mop.tp.price - (int)
	// ms.tv.ov.mop.tp.discountprice));
	// } else {
	// JOptionPane.showMessageDialog(null, "없는 쿠폰입니다.");
	// ms.tv.ov.mop.tp.discount_label2.setText("");
	// }
	// }
	public void checkCoupon(SearchCoupon sc) {
		ms.tv.ov.mop.tp.couponnum = ms.tv.ov.mop.tp.coupon_num_Tf2.getText();
		CouponBean cb = sc.searchCoupon(ms.tv.ov.mop.tp.couponnum);
		ms.tv.ov.mop.tp.cpnum = sc.searchCoupon(ms.tv.ov.mop.tp.couponnum).getCoupon_number();
		if (Integer.toString(ms.tv.ov.mop.tp.cpnum).equals(ms.tv.ov.mop.tp.couponnum)
				&& cb.getCouponuseyn().equals("Y")) {
			ms.tv.ov.mop.tp.coupontype = sc.searchCoupon(ms.tv.ov.mop.tp.couponnum).getCoupon_type();
			ms.tv.ov.mop.tp.discountrate = sc.searchDiscount(ms.tv.ov.mop.tp.coupontype).getDiscount_rate();
			ms.tv.ov.mop.tp.price = Integer.parseInt(ms.tv.ov.mop.tp.price_label2.getText().replaceAll(",", ""));
			ms.tv.ov.mop.tp.discountprice = ms.tv.ov.mop.tp.price * ((double) ms.tv.ov.mop.tp.discountrate / 100);
			ms.tv.ov.mop.tp.discount_label2.setText(String.format("%,d", (int) ms.tv.ov.mop.tp.discountprice));
			ms.tv.ov.mop.tp.t_price_label2
					.setText(String.format("%,d", ms.tv.ov.mop.tp.price - (int) ms.tv.ov.mop.tp.discountprice));
		} else {
			JOptionPane.showMessageDialog(ms.tv.ov.mop.tp, "없는 쿠폰입니다.");
			ms.tv.ov.mop.tp.discount_label2.setText("");
		}
	}

	public void payCash(SearchCoupon sc) {
		ms.tv.ov.mop.tp.couponnum = ms.tv.ov.mop.tp.coupon_num_Tf2.getText();
		if (ms.tv.ov.mop.tp.coupon_num_Tf2.getText().trim().isEmpty() == true) {
			JOptionPane.showMessageDialog(ms.tv.ov, "현금결제가 완료되었습니다.");
			ms.tv.ov.mop.tp.coupon_num_Tf2.setText("");
			ms.tv.ov.mop.tp.discount_label2.setText("");
			ms.tv.ov.mop.totalprice2.setText("0");
			ms.tv.tsv.setVisible(false);
			ms.tv.ov.mop.tp.setVisible(false);
			ms.tv.ov.mop.setVisible(false);
			ms.tv.ov.setVisible(false);
			ms.tableSet();
			tableInit();

		} else {
			sc.updateCoupon(ms.tv.ov.mop.tp.couponnum);
			JOptionPane.showMessageDialog(ms.tv.ov, "현금결제가 완료되었습니다.");
			ms.tv.ov.mop.tp.coupon_num_Tf2.setText("");
			ms.tv.ov.mop.tp.discount_label2.setText("");
			ms.tv.ov.mop.totalprice2.setText("0");
			ms.tv.tsv.setVisible(false);
			ms.tv.ov.mop.tp.setVisible(false);
			ms.tv.ov.mop.setVisible(false);
			ms.tv.ov.setVisible(false);
			ms.tableSet();
			tableInit();

		}

	}

	public void payCard(SearchCoupon sc) {
		ms.tv.ov.mop.tp.couponnum = ms.tv.ov.mop.tp.coupon_num_Tf2.getText();
		if (ms.tv.ov.mop.tp.coupon_num_Tf2.getText().trim().isEmpty() == true) {
			JOptionPane.showMessageDialog(ms.tv.ov, "카드결제가 완료되었습니다.");
			ms.tv.ov.mop.tp.coupon_num_Tf2.setText("");
			ms.tv.ov.mop.tp.discount_label2.setText("");
			ms.tv.ov.mop.totalprice2.setText("0");
			ms.tv.tsv.setVisible(false);
			ms.tv.ov.mop.tp.setVisible(false);
			ms.tv.ov.mop.setVisible(false);
			ms.tv.ov.setVisible(false);
			ms.tableSet();
			tableInit();

		} else {
			sc.updateCoupon(ms.tv.ov.mop.tp.couponnum);
			JOptionPane.showMessageDialog(ms.tv.ov, "카드결제가 완료되었습니다.");
			ms.tv.ov.mop.tp.coupon_num_Tf2.setText("");
			ms.tv.ov.mop.tp.discount_label2.setText("");
			ms.tv.ov.mop.totalprice2.setText("0");
			ms.tv.tsv.setVisible(false);
			ms.tv.ov.mop.tp.setVisible(false);
			ms.tv.ov.mop.setVisible(false);
			ms.tv.ov.setVisible(false);
			ms.tableSet();
			tableInit();
		}
	}

	public void tableInit() {
		ms.tv.ov.mop.mmt.maintable.clearSelection();
		ms.tv.ov.mop.mmt.requestFocus();
		// yhmimg.menuimage_p.removeAll();
	}
	//
	// public void addOrder(int customer_number, int table) {
	// // 주문번호, 고객번호, 테이블번호, 시간
	// od.addOrder(customer_number, table);
	// // od.addDetail_Order(table, menu_id, amount, total_price);
	// }
	//
	// public void addOrderDetail(int customer_number, int table, String menu_name,
	// int amount) {
	// od.addDetail_Order(customer_number, table, menu_name, amount);
	// }
	//
	// public void getOrder() {
	// ms.tv.op.table.removeAll();
	// List<OrderDto> list = od.getOrderRow();
	// for (int i = 0; i < list.size(); i++) {
	// Vector<String> rowData = new Vector<String>();
	// rowData.add(Integer.toString(list.get(i).getNum()));
	// rowData.add(Integer.toString(list.get(i).getTable()));
	// rowData.add(list.get(i).getMenuname());
	// rowData.add(Integer.toString(list.get(i).getAmount()));
	// rowData.add(list.get(i).getTime());
	// ms.tv.op.model.addRow(rowData);
	// }
	// }

}
