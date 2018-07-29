package com.kitri.yeaha.manager.service;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.yeaha.chart.view.*;
import com.kitri.yeaha.constdata.YeHaConst;
import com.kitri.yeaha.kitchen.data.ChartMainCont;
import com.kitri.yeaha.kitchen.data.YeahhaCont;
import com.kitri.yeaha.manager.data.*;
import com.kitri.yeaha.manager.view.LoginView;
import com.kitri.yeaha.manager.view.MainView;
import com.kitri.yeaha.order.service.MenuOrderService;
import com.kitri.yeaha.order.service.YeahaImageService;
import com.kitri.yeaha.order.view.SearchCoupon;

public class ManagerService extends Thread implements ActionListener, MouseListener, WindowListener {
	int idx;
	public MainView tv;
	LoginView lv;
	String menuname;
	TimeThread tt[] = new TimeThread[8];
	YeahhaDao yd = new YeahhaDao();
	YeHaTicketDao td = new YeHaTicketDao();
	public boolean checkmenu;
	public int selectedrow;
	int customer_number = 0;
	int totalprice;
	Socket s;
	BufferedReader in;
	OutputStream out;
	String myname = "매니저";

	public ManagerService(MainView tv) {
		this.tv = tv;
		setMenu();
		// new Thread(cs).start();
		connectProcess();
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			try {
				String msg = in.readLine();
				System.out.println("S>>M" + msg);
				StringTokenizer st = new StringTokenizer(msg, "||");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case YeHaConst.SM_CONNECT: {
					JOptionPane.showMessageDialog(tv, "POS-서버 연결 완료");
				}
					break;
				case YeHaConst.SM_SUCCESS: {
					String table = st.nextToken();
					String menuname = st.nextToken();
					JOptionPane.showMessageDialog(tv, table + "번 테이블" + menuname + "(이)가 완성되었습니다.");
				}
					break;
				case YeHaConst.SC_DISCONNECT: {
					String tmp = st.nextToken();
					if (tmp.equals(myname)) {
						flag = false;
						in.close();
						out.close();
						s.close();
						System.exit(0);
						break;
					}
				}
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		// System.out.println(ob.toString());
		tv.ov.mop.account = 1;
		tv.ov.mop.row = tv.ov.mop.choicetable.getSelectedRow();
		tv.ov.mop.col = tv.ov.mop.choicetable.getSelectedColumn();
		tv.ov.mop.tp.couponnum = tv.ov.mop.tp.coupon_num_Tf2.getText();
		int index = tv.ov.mop.menutab.getSelectedIndex();
		SearchCoupon sc = new SearchCoupon();
		MenuOrderService mos = new MenuOrderService(this);
		CouponService cs = new CouponService(this);
		mos = new MenuOrderService(this);
		// System.out.println(index);//버튼의 숫자(인덱스) 받아오는 구문.
		if (ob == tv.mv.mainB[0] || ob == tv.mv.mainB[1] || ob == tv.mv.mainB[2] || ob == tv.mv.mainB[3]
				|| ob == tv.mv.mainB[4] || ob == tv.mv.mainB[5] || ob == tv.mv.mainB[6] || ob == tv.mv.mainB[7]) {
			idx = Integer.parseInt(e.getActionCommand());
			System.out.println("index = " + index);
			tv.lv.setLocation(tv.getLocation());
			tv.lv.setVisible(true);

		} else if (ob == tv.lv.loginB1) {// 로그인 버튼 누를때
			tv.lv.pnTf1.setText("");
			tv.lv.pnTf2.setText("");
			tv.lv.pnTf3.setText("");
			tv.lv.setVisible(false);
		} else if (ob == tv.lv.loginB2 || ob == tv.lv.pnTf3) {////// 여기서 고객 정보 가져옴
			loginok();
			tv.lv.pnTf1.setText(" ");
			tv.lv.pnTf2.setText(" ");
			tv.lv.pnTf3.setText(" ");
			// tv.tsv.ut.revalidate();
			// tv.tsv.ut.repaint();
			// 메인 테이블에 남은 시간 출력(지웅오빠꺼에 연결하기)

		} else if (ob == tv.mmv.mCancleB) {
			tv.mmv.mNameTf.setText("");
			tv.mmv.mPriceTf.setText("");
			tv.mmv.mCateTf.setText("");
		} else if (ob == tv.mmv.mAddB) {
			menuadd();
		} else if (ob == tv.mmv.mCancleB2) {
			tv.mmv.mDelL.setText("");
		} else if (ob == tv.mmv.mDelB) {
			System.out.println(menuname);
			memudel(menuname);
		} else if (ob == tv.mmv.comboBox) {
			JComboBox cb = (JComboBox) e.getSource();
			String mn = (String) cb.getSelectedItem();
			menuname = mn;
			tv.mmv.mDelL.setText(mn);
		} else if (ob == tv.mv.exitB[0] || ob == tv.mv.exitB[1] || ob == tv.mv.exitB[2] || ob == tv.mv.exitB[3]
				|| ob == tv.mv.exitB[4] || ob == tv.mv.exitB[5] || ob == tv.mv.exitB[6] || ob == tv.mv.exitB[7]) {
			// System.out.println(e.getActionCommand());
			tv.lv.pnTf1.requestFocus();
			int exitidx = Integer.parseInt(e.getActionCommand());
			tv.mv.mPNameL[exitidx].setText("");
			tv.mv.mLTimeL[exitidx].setText("");
			tt[exitidx].i = 0;
			yd.setOutTime(tv.mv.customer_number[exitidx]);
		} else if (ob == tv.tsv.pt.ticket) {// 정기권 추가
			System.out.println("정기권임다");
			setTicketList(YeHaConst.REGULAR_TICKET);
		} else if (ob == tv.tsv.pt.d_ticket) {// 일일권 추가
			System.out.println("일일권임다");
			setTicketList(YeHaConst.DAY_TICKET);
		} else if (ob == tv.cpm.sendBnt) {// 쿠폰 보내기 버튼
			sendCoupon();
		} else if (ob == tv.tsv.pt.pl.t_pch_accp) {// 티켓 구매 결제 버튼
			selTicket();
		} else if (ob == tv.tsv.pt.pl.t_pch_can) {
			// System.out.println("취소한다");
			tv.mv.mPNameL[idx].setText("");
			tv.tsv.pt.pl.model.setRowCount(0);
			tv.tsv.setVisible(false);
		} else if (ob == tv.tsv.ut.plus) {// 티켓사용 더하기버튼
			tv.tsv.ut.textField.setText(String.format("%,d", Integer.parseInt(tv.tsv.ut.textField.getText()) + 1));
		} else if (ob == tv.tsv.ut.minus) {// 티켓사용 빼기버튼
			tv.tsv.ut.textField.setText(String.format("%,d", Integer.parseInt(tv.tsv.ut.textField.getText()) - 1));
		} else if (ob == tv.tsv.ut.use_acc) {
			td.useTicket(customer_number, Integer.parseInt(tv.tsv.ut.textField.getText()));
			sendMsg(YeHaConst.MS_USE_TICKET + "||" + customer_number + "||" + tv.tsv.ut.textField.getText());
			tv.tsv.ut.textField.setText("1");
			tv.tsv.pt.requestFocus();
			tv.tsv.setVisible(false);
			tv.ov.setLocation(tv.getLocation());
			tv.ov.setVisible(true);
			////////////////// 이제 주문기능 //////////////////////////////////////////////
		} else if (ob == tv.tsv.ut.use_cancel) {
			tv.mv.mPNameL[idx].setText("");
			tv.tsv.ut.textField.setText("1");
			tv.tsv.setVisible(false);
		} else if (ob == tv.ov.mop.rbtn) {
			mos.incMenu(index);
		} else if (ob == tv.ov.mop.lbtn) {
			if (tv.ov.mop.choicetable.getSelectedRow() >= 0) {
				tv.ov.mop.dm.removeRow(tv.ov.mop.choicetable.getSelectedRow());
				tv.ov.mop.totalprice2.setText(String.format("%,d", tv.ov.mop.show_t_price()));
			}
		} else if (ob == tv.ov.mop.inc) {
			mos.incAmount();
		} else if (ob == tv.ov.mop.desc) {
			mos.descAmount();
		} else if (ob == tv.ov.mop.up) {
			mos.upOrder();
		} else if (ob == tv.ov.mop.down) {
			mos.downOrder();
		} else if (ob == tv.ov.mop.pricecancel) {
			tv.ov.mop.dm.setRowCount(0);
			tv.ov.mop.setVisible(false);
		} else if (ob == tv.ov.mop.pay) {
			tv.ov.mop.tp.price_label2.setText(tv.ov.mop.totalprice2.getText());
			tv.ov.mop.tp.t_price_label2.setText(tv.ov.mop.totalprice2.getText());
			tv.ov.mop.tp.setLocation(tv.ov.getLocation());
			tv.ov.mop.tp.setVisible(true);
		} else if (ob == tv.ov.mop.tp.coupon_btn) {
			mos.checkCoupon(sc);
		} else if (ob == tv.ov.mop.tp.paycash) {// 300||테이블번호||메뉴이름||수량
			// int fprice=0;
			for (int i = 0; i < tv.ov.mop.dm.getRowCount(); i++) {
				sendMsg(YeHaConst.MS_SEND_ORDER + "||" + Integer.toString(idx + 1) + "||"
						+ tv.ov.mop.dm.getValueAt(i, 0).toString() + "||" + tv.ov.mop.dm.getValueAt(i, 1).toString());

			}
			td.stackData(YeHaConst.FOOD, tv.ov.mop.show_t_price());
			mos.payCash(sc);
			// mos.addOrder(customer_number, idx + 1);
			// for (int i = 0; i < tv.ov.mop.dm.getRowCount(); i++) {
			// mos.addOrderDetail(customer_number, idx + 1, tv.ov.mop.dm.getValueAt(i,
			// 0).toString(),
			// Integer.parseInt(tv.ov.mop.dm.getValueAt(i, 1).toString()));
			// }
			tv.ov.mop.dm.setRowCount(0);
		} else if (ob == tv.ov.mop.tp.paycard) {
			for (int i = 0; i < tv.ov.mop.dm.getRowCount(); i++) {
				sendMsg(YeHaConst.MS_SEND_ORDER + "||" + Integer.toString(idx + 1) + "||"
						+ tv.ov.mop.dm.getValueAt(i, 0).toString() + "||" + tv.ov.mop.dm.getValueAt(i, 1).toString());
			}
			td.stackData(YeHaConst.FOOD, tv.ov.mop.show_t_price());
			mos.payCard(sc);
			// mos.addOrder(customer_number, idx + 1);
			// for (int i = 0; i < tv.ov.mop.dm.getRowCount(); i++) {
			// mos.addOrderDetail(customer_number, idx + 1, tv.ov.mop.dm.getValueAt(i,
			// 0).toString(),
			// Integer.parseInt(tv.ov.mop.dm.getValueAt(i, 1).toString()));
			// }
			tv.ov.mop.dm.setRowCount(0);
		} else if (ob == tv.ov.mop.tp.notpay) {
			tv.ov.mop.tp.setVisible(false);
		} else if (ob == tv.cm.dc.newBtn) { // **************
			VisitorChart vc = new VisitorChart();
			tv.cm.dc.pChart1.add(vc);
			CumulativeLine cl = new CumulativeLine();
			tv.cm.dc.pChart2.add(cl);
			SalesPieChart sPie = new SalesPieChart();
			tv.cm.dc.pChart3.add(sPie);
			ChartMainCont mc = new ChartMainCont();
			tv.cm.dc.dayTSale.setText(String.format("%,d", mc.DayTicketSales().getD_ticket_sales()));
			tv.cm.dc.seasonTSale.setText(String.format("%,d", mc.TicketSales().getTicket_sales()));
			tv.cm.dc.mealsSale.setText(String.format("%,d", mc.FoodSales().getFood_sales()));
			tv.cm.dc.dayVisitMem.setText(mc.TodayVisitor().getCnt_01() + "");
			int daySale = mc.DaySales().getD_ticket_sales() + mc.DaySales().getTicket_sales()
					+ mc.DaySales().getFood_sales();
			tv.cm.dc.dayAllMoney.setText(String.format("%,d", daySale));
		} else if (ob == tv.cm.mc.newBtn) {
			VisitorMChart vmc = new VisitorMChart();
			tv.cm.mc.pChart1.add(vmc);
			SalesBarChart sb = new SalesBarChart();
			tv.cm.mc.pChart2.add(sb);
			SalesMPieChart smp = new SalesMPieChart();
			tv.cm.mc.pChart3.add(smp);
			ChartMainCont mc = new ChartMainCont();
			tv.cm.mc.dayTSale.setText(String.format("%,d", mc.DayTicketMSales().getAvg_01()));
			tv.cm.mc.seasonTSale.setText(String.format("%,d", mc.TicketMSales().getAvg_02()));
			tv.cm.mc.mealsSale.setText(String.format("%,d", mc.FoodMSales().getAvg_03()));
			int preSale = mc.MonthSales().getAvg_01() + mc.MonthSales().getAvg_02() + mc.MonthSales().getAvg_03();
			tv.cm.mc.presentSale.setText(String.format("%,d", preSale));
			int lastSale = mc.LastMonthSales().getAvg_01() + mc.LastMonthSales().getAvg_02()
					+ mc.LastMonthSales().getAvg_03();
			tv.cm.mc.lastMonSale.setText(String.format("%,d", lastSale));
		} else if (ob == tv.cp.sendcpBtn) {// 쿠폰발송뷰 출력 버튼
			setListData();
			tv.cpm.setLocation(tv.getLocation());
			tv.cpm.setVisible(true);
		} else if (ob == tv.cp.makecpBtn) {// 쿠폰관리뷰 출력 버튼
			cs.setCouponList();
			tv.cv.setLocation(tv.getLocation());
			tv.cv.setVisible(true);
		} else if (ob == tv.cv.addcpbtn) {
			cs.addCoupon();
			cs.setCouponList();
			tv.cv.cpnameTf.setText(" ");
			tv.cv.dcrateTf.setText(" ");
		} else if (ob == tv.cv.delcpbtn) {
			cs.delCoupon();
			JOptionPane.showMessageDialog(tv.cv, "쿠폰 삭제 완료!");
		} else if (ob == tv.cv.cancel) {
			tv.cv.cpnameTf.setText(" ");
			tv.cv.dcrateTf.setText(" ");
			tv.cv.setVisible(false);
		} else if (ob == tv.cpm.couponexB) {
			tv.cpm.customerList.removeAll();
			tv.cpm.couponList.removeAll();
			tv.cpm.couponlistData.removeAllElements();
			tv.cpm.cstmlistData.removeAllElements();
			tv.cpm.couponList.setListData(tv.cpm.couponlistData);

			tv.cpm.setVisible(false);
		}
	}

	public void tableSet() {
		tt[idx] = new TimeThread(this);
		tt[idx].index = idx;
		tt[idx].start();
		tv.mv.mainB[idx].setEnabled(false);
		yd.setIntime(customer_number);
		// tv.mv.mPNameL[idx].setText();
		// tv.mv.mPNameL[idx].setText(yd.getEachInfo(Integer.toString(customer_number)).getParents_name());
	}

	public void loginok() {
		// 로그인 창에서 번호 입력 후 확인버튼 눌렀을 때 메소드
		// CustoInfoBean cb = new CustoInfoBean();
		String num = getLoginNum();
		int x = yd.loginCheck(num);
		if (x == 1) {
			System.out.println("로그인 성공!!!");
			tv.ov.ci.pNameL2.setText(yd.getEachInfo(num).getParents_name());
			tv.ov.ci.kNameL2.setText(yd.getEachInfo(num).getKids_name());
			tv.ov.ci.pNumL2.setText(yd.getEachInfo(num).getPhone_number());
			tv.mv.mPNameL[idx].setText(yd.getEachInfo(num).getParents_name());
			customer_number = yd.getEachInfo(num).getCustomer_number();
			tv.mv.customer_number[idx] = customer_number;

			tv.lv.setVisible(false);
			tv.tsv.setLocation(tv.getLocation());
			tv.tsv.setVisible(true);
			setCustomerInfo(customer_number);
			tv.tsv.ut.updateUI();

		} else if (x == 0) {
			System.out.println("로그인 실패!!!");
			JOptionPane.showMessageDialog(tv.lv, "Yeah-ha 회원이 아닙니다.");
		} else if (x == 2) {
			System.out.println("번호 입력해");
			JOptionPane.showMessageDialog(tv.lv, "휴대폰번호를 입력해주시기 바랍니다.");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		YeahaImageService yms;
		if (tv.ov.mop.menutab.getSelectedIndex() == 0) {
			tv.ov.mop.mmt.row = tv.ov.mop.mmt.maintable.getSelectedRow();
			tv.ov.mop.mmt.menuname = (String) tv.ov.mop.mmt.maintable.getValueAt(tv.ov.mop.mmt.row, 0);
			tv.ov.mop.mmt.price = Integer
					.parseInt(tv.ov.mop.mmt.maintable.getValueAt(tv.ov.mop.mmt.row, 1).toString().replaceAll(",", ""));
			yms = new YeahaImageService(tv.ov.mop.mmt.menuname);
			yms.menuicon();
			tv.ov.mop.menuimage_p.add(yms.iconp(tv.ov.mop.menuimage_p2));
			tv.ov.mop.menuimage_p.updateUI();
		} else if (tv.ov.mop.menutab.getSelectedIndex() == 1) {
			tv.ov.mop.smt.row = tv.ov.mop.smt.sidetable.getSelectedRow();
			tv.ov.mop.smt.sidemenu = (String) tv.ov.mop.smt.sidetable.getValueAt(tv.ov.mop.smt.row, 0);
			tv.ov.mop.smt.sideprice = Integer
					.parseInt(tv.ov.mop.smt.sidetable.getValueAt(tv.ov.mop.smt.row, 1).toString().replaceAll(",", ""));
			yms = new YeahaImageService(tv.ov.mop.smt.sidemenu);
			yms.menuicon();
			tv.ov.mop.menuimage_p.add(yms.iconp(tv.ov.mop.menuimage_p2));
			tv.ov.mop.menuimage_p.updateUI();
		} else if (tv.ov.mop.menutab.getSelectedIndex() == 2) {
			tv.ov.mop.dmt.row = tv.ov.mop.dmt.drinktable.getSelectedRow();
			tv.ov.mop.dmt.drinkmenu = (String) tv.ov.mop.dmt.drinktable.getValueAt(tv.ov.mop.dmt.row, 0);
			tv.ov.mop.dmt.drinkprice = Integer
					.parseInt(tv.ov.mop.dmt.drinktable.getValueAt(tv.ov.mop.dmt.row, 1).toString().replaceAll(",", ""));
			yms = new YeahaImageService(tv.ov.mop.dmt.drinkmenu);
			yms.menuicon();
			tv.ov.mop.menuimage_p.add(yms.iconp(tv.ov.mop.menuimage_p2));
			tv.ov.mop.menuimage_p.updateUI();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		exitProcess();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public String getLoginNum() {
		// 로그인 창에서 번호 입력 후 확인버튼 눌렀을 때 메소드
		String l_num1 = tv.lv.pnTf1.getText().trim();
		String l_num2 = tv.lv.pnTf2.getText().trim();
		String l_num3 = tv.lv.pnTf3.getText().trim();
		String fullnum = l_num1 + l_num2 + l_num3; // fullnum : 로그인 창에서 입력한 전화번호

		return fullnum;
	}

	public void memudel(String menuname) {
		// 메뉴삭제 메소드
		String mn = Yeahhadel();
		YeahhaCont yc = new YeahhaCont();

		DefaultTableModel mmodel = tv.ov.mop.mmt.dm;
		for (int i = 0; i < mmodel.getRowCount(); i++) {
			if (mmodel.getValueAt(i, 0).toString().equals(mn)) {
				mmodel.removeRow(i);
			}
		}
		DefaultTableModel smodel = tv.ov.mop.smt.dm;
		for (int i = 0; i < smodel.getRowCount(); i++) {
			if (smodel.getValueAt(i, 0).toString().equals(mn)) {
				smodel.removeRow(i);
			}
		}
		DefaultTableModel dmodel = tv.ov.mop.dmt.dm;
		for (int i = 0; i < dmodel.getRowCount(); i++) {
			if (dmodel.getValueAt(i, 0).toString().equals(mn)) {
				dmodel.removeRow(i);
			}
		}
		yc.delYeahha(menuname);
		tv.mmv.comboBox.setSelectedIndex(0);
		tv.mmv.comboBox.removeItem(mn);
		tv.mmv.comboBox.updateUI();
	}

	public String Yeahhadel() {
		// 삭제할 메뉴이름 입력받기
		String m_del_l = tv.mmv.mDelL.getText();

		return m_del_l;
	}

	public void menuadd() {
		// 메뉴추가 메소드
		YeahhaBean yb = Yeahhaadd();
		YeahhaCont yc = new YeahhaCont();
		yc.addYeahha(yb);
		Vector<String> rowdata = new Vector<String>();
		rowdata.add(yb.getMenu_name());
		rowdata.add(Integer.toString(yb.getPrice()));
		int category = yb.getCategorys();
		switch (category) {
		case 1: {
			tv.ov.mop.mmt.dm.addRow(rowdata);
		}
			break;
		case 2: {
			tv.ov.mop.smt.dm.addRow(rowdata);
		}
			break;
		case 3: {
			tv.ov.mop.dmt.dm.addRow(rowdata);
		}
		}
		tv.mmv.comboBox.addItem(yb.getMenu_name());
		tv.mmv.comboBox.updateUI();
		tv.mmv.mNameTf.setText("");
		tv.mmv.mPriceTf.setText("");
		tv.mmv.mCateTf.setText("");
		JOptionPane.showMessageDialog(tv.mmv, "메뉴가 추가되었습니다.");
	}

	public YeahhaBean Yeahhaadd() {
		// 추가할 메뉴이름 입력받기
		YeahhaBean yb = new YeahhaBean();
		String m_add_c = tv.mmv.mCateTf.getText();
		String m_add_n = tv.mmv.mNameTf.getText();
		String m_add_p = tv.mmv.mPriceTf.getText();
		yb.setCategorys(Integer.parseInt(m_add_c));
		yb.setMenu_name(m_add_n);
		yb.setPrice(Integer.parseInt(m_add_p));

		return yb;
	}

	public void setMenu() {
		YeahhaCont yc = new YeahhaCont();
		tv.mmv.comboBox.addItem("메뉴선택");
		int size = yc.comboBox().size();
		for (int i = 0; i < size; i++) {
			tv.mmv.comboBox.addItem(yc.comboBox().get(i).getMenu_name());
		}
	}

	int ticketPrice = 0;
	// int dayPrice = 0;
	// int regPrice = 0;

	private void setTicketList(int tktype) {
		List<TicketDto> tklist = td.tickType();

		TicketDto td = tklist.get(tktype);
		DefaultTableModel model = tv.tsv.pt.pl.model;
		Vector<String> row = new Vector<>();
		int amoun = 1;
		int day = 0;
		boolean flag = true;
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0).equals(tklist.get(tktype).getTicket_name())) {
				amoun = Integer.parseInt(model.getValueAt(i, 1).toString());
				model.setValueAt(++amoun, i, 1);
				// day += td.getPrice();
				// ticketPrice += td.getPrice();
				// if (model.getValueAt(i, 0).equals("정기권")) {
				// regPrice += td.getPrice();
				// } else {
				// dayPrice += td.getPrice();
				// }
				day = Integer.parseInt(model.getValueAt(i, 2).toString().replaceAll(",", ""));
				model.setValueAt(String.format("%,d", day * amoun), i, 2);
				flag = false;
				break;
			}
		}
		if (flag == true) {
			row.add(td.getTicket_name());
			row.add("1");
			row.add(String.format("%,d", td.getPrice()));
			tv.tsv.pt.pl.model.addRow(row);
			// if (td.getTicket_name().equals("정기권")) {
			// regPrice += td.getPrice();
			// } else {
			// dayPrice += td.getPrice();
			// }
			// day += td.getPrice();
			// ticketPrice += td.getPrice();
		}
		totalprice = 0;
		for (int i = 0; i < tv.tsv.pt.pl.model.getRowCount(); i++) {
			totalprice += Integer.parseInt(tv.tsv.pt.pl.model.getValueAt(i, 2).toString().replaceAll(",", ""));
		}

		tv.tsv.pt.pl.t_price.setText(String.format("%,d", totalprice));
	}

	private void sendCoupon() {
		List<CustomerDto> list = td.getcstmList();
		List<CouponDto> cplist = td.getcouponList();

		System.out.println("쿠폰을 보낸다");
		int to = 0;
		int cptype = 0;
		for (int i = 0; i < list.size(); i++) {
			CustomerDto cdto = list.get(i);
			if (cdto.getC_id().equals(tv.cpm.customer.getText())) {
				to = cdto.getCustomer_number();
				break;
			}
		}
		for (int i = 0; i < cplist.size(); i++) {
			CouponDto cpdto = cplist.get(i);
			if (cpdto.getCoupon_name().equals(tv.cpm.coupon.getText())) {
				cptype = cpdto.getCoupon_type();
				break;
			}
		}
		String cpnum = td.sendCoupon(cptype, to);// 어떤 쿠폰을 누구 에게.
		System.out.println(cpnum);
		// cs.makeCoupon(Integer.toString(to), tv.cpm.coupon.getText() + "이 도착했습니다");//
		// 누구에게 어떤 쿠폰을
		sendMsg(YeHaConst.MS_SEND_COUPON + "||" + Integer.toString(to) + "||" + tv.cpm.coupon.getText());
		System.out.println(to + "에게 " + tv.cpm.coupon.getText() + "을");
	}

	private void setListData() {
		List<CustomerDto> list = td.getcstmList();
		List<CouponDto> cplist = td.getcouponList();

		// tv.cpm.setLocation(tv.getLocation());
		// tv.cpm.setVisible(true);
		for (int i = 0; i < list.size(); i++) {
			CustomerDto cdto = list.get(i);
			tv.cpm.cstmlistData.add(cdto.getC_id());
		}
		tv.cpm.customerList.setListData(tv.cpm.cstmlistData);
		for (int i = 0; i < cplist.size(); i++) {
			CouponDto cpdto = cplist.get(i);
			tv.cpm.couponlistData.add(cpdto.getCoupon_name());
		}
		tv.cpm.couponList.setListData(tv.cpm.couponlistData);

	}

	private void selTicket() {
		System.out.println("티켓 파라씀");
		boolean flag = true;
		int dayprice = 0;
		int regularprice = 0;
		DefaultTableModel model = tv.tsv.pt.pl.model;
		int len = model.getRowCount();
		for (int i = 0; i < len; i++) {
			if (model.getValueAt(i, 0).equals("정기권")) {
				String regular_amount = model.getValueAt(i, 1).toString();
				td.addAmount(customer_number, td.identifyCustomer(customer_number), Integer.parseInt(regular_amount));
				// cs.sellTicket(Integer.toString(customer_number), regular_amount);// 티켓 메세지 전송
				sendMsg(YeHaConst.MS_SELL_TICKET + "||" + customer_number + "||" + regular_amount);
				regularprice = Integer.parseInt(model.getValueAt(i, 2).toString().replaceAll(",", ""));
			} else {
				dayprice = Integer.parseInt(model.getValueAt(i, 2).toString().replaceAll(",", ""));
				flag = false;
			}
		}
		for (int i = 0; i < len; i++) {
			if (model.getValueAt(i, 0).equals("일일권")) {
				tv.tsv.setVisible(false);
				tv.ov.setLocation(tv.getLocation());
				tv.ov.setVisible(true);
			}
		}
		setCustomerInfo(customer_number);
		model.setRowCount(0);
		JOptionPane.showMessageDialog(tv, Integer.toString(dayprice + regularprice) + " 원\n결제 되었습니다.");
		if (dayprice > 0)
			td.stackData(YeHaConst.DAY_TICKET, dayprice);
		if (regularprice > 0)
			td.stackData(YeHaConst.REGULAR_TICKET, regularprice);
		tv.tsv.pt.pl.t_price.setText("");
	}

	public void setCustomerInfo(int customer_number) {
		CustomerDto cd = td.getCustInfo(customer_number);
		tv.tsv.ut.name.setText(cd.getParents_name().toString());
		tv.tsv.ut.amount.setText(String.format("%,d", cd.getRemain_amount()));
	}

	public static String makeCouponNum() {
		String cpnum = "";
		for (int i = 0; i < 8; i++) {
			cpnum += (int) (Math.random() * 10);
		}
		return cpnum;
	}

	private void connectProcess() {
		String host = "localhost";
		try {
			System.out.println("연결시도");
			s = new Socket(host, YeHaConst.CPORT);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			sendMsg(YeHaConst.CS_CONNECT + "||" + myname);
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMsg(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 200||안녕하셍요
	}

	private void exitProcess() {
		// TODO Auto-generated method stub
		sendMsg(YeHaConst.CS_DISCONNECT + "||");
		tv.setVisible(false);
	}
}
