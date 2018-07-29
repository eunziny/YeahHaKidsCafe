package com.kitri.yeaha.customer.service;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.kitri.yeaha.constdata.YeHaConst;
import com.kitri.yeaha.customer.data.CustomerBean;
import com.kitri.yeaha.customer.data.CustomerDao;
import com.kitri.yeaha.customer.view.*;

public class CustomerService extends Thread implements ActionListener, WindowListener {

	CustomerViewLogon logon;
	CustomerViewMain main;
	CustomerViewCoupon coupon;
	CustomerDao cd = new CustomerDao();
	UseDataView visit_calendar;
	Socket s;
	BufferedReader in;
	OutputStream out;
	String customer_number;

	public CustomerService(CustomerViewMain main) {
		this.main = main;
	}

	private void connectProcess() {
		String host = "localhost";
		try {
			System.out.println("연결시도");
			s = new Socket(host, YeHaConst.CPORT);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			sendMsg(YeHaConst.CS_CONNECT + "||" + customer_number);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		System.out.println(ob);
		// System.out.println("이벤트");
		if (ob == main.logon.couponB) { // 내 쿠폰함 버튼을 눌렀을 때 이동필요!!
			System.out.println("쿠폰");
			main.logon.coupon.pCoupon.removeAll();
			couponProcess();
		} else if (ob == main.logon.historyB) {
			System.out.println("히스토리");
			main.logon.visit_calendar.setLocation(main.loginB.getLocation());
			main.logon.visit_calendar.setVisible(true);

		} else if (ob == main.loginB || ob == main.pwTF) {
			main_login();

		} else if (ob == main.logon.infoModifyB) {
			// 회원정보수정 뷰로 이동.
			main.modify.setLocation(main.getLocation());
			main.modify.setVisible(true);
			main.logon.setVisible(false);
			modifyProcess();

		} else if (ob == main.joinB) {
			main.join.setLocation(main.getLocation());
			main.join.setVisible(true);

		} else if (ob == main.join.okB) {
			joinProcess();

		} else if (ob == main.modify.okB2) {
			modifyProcess2();

		} else if (ob == main.modify.cancelB2) {
			modifyProcessCancel();

		} else if (ob == main.modify.withdrawalB) {
			modifyWithDrawal();
			main.setVisible(true);
			JOptionPane.showMessageDialog(main.modify, "탈퇴되었습니다.");
			main.idTF.setText("");
			main.pwTF.setText("");
		} else if (ob == main.logon.coupon.backB) {
			main.logon.coupon.setVisible(false);
			main.logon.coupon.pCoupon.removeAll();
			main.logon.setVisible(true);
		} else if (ob == main.join.cancelB) { // *****회원가입 취소버튼
			main.join.setVisible(false);
			main.setVisible(true);
		} else if (ob == main.logon.logoutBtn) { // *****로그아웃 버튼 -> logon 화면 안보이기만 + 메인 초기화
			main.logon.setVisible(false);
			exitProcess();
			main.setVisible(true);
			main.idTF.setText("");
			main.pwTF.setText("");
		} else if (ob == main.join.duplicateB) {
			idDuplProcess();
		}
		// else if(ob == modify.okB2) {
		//// 확인버튼을 눌럿을 경우
		// } else if(ob == modify.cancelB2) {
		//// 취소버튼을 눌럿을 경우
		// } else if(ob == modify.withdrawalB) {
		//// 회원탈퇴버튼을 눌렀을 경우
		// }
	}

	public void idDuplProcess() {
		// TODO Auto-generated method stub
		String c_id = main.join.inputIdTF.getText().trim();
		CustomerBean cb = new CustomerBean();
		CustomerDao cd = new CustomerDao();
		cb.setC_ID(c_id);
		int x = cd.checkIdDuplicate(cb);
		if (x == 1) {
			System.out.println("사용가능한 아이디입니다.");
			JOptionPane.showMessageDialog(main.join, "사용가능한 아이디입니다.");
		} else {
			System.out.println("사용할 수 없는 아이디입니다.");
			JOptionPane.showMessageDialog(main.join, "사용할 수 없는 아이디입니다.");
		}
	}

	public void modifyWithDrawal() {
		// TODO Auto-generated method stub

		String c_id = main.idTF.getText().trim();
		CustomerBean cb = new CustomerBean();
		CustomerDao cd = new CustomerDao();
		cb.setC_ID(c_id);
		cd.deleteCustomer(cb);
		main.modify.setVisible(false);
	}

	public void modifyProcessCancel() {
		// TODO Auto-generated method stub
		main.modify.setVisible(false);
		main.logon.setLocation(main.getLocation());
		main.logon.setVisible(true);
		// main.modify.inputIdTF2.setText("");
		main.modify.inputPwTF2.setText("");
		main.modify.inputChildTF2.setText("");
		// main.modify.inputBirthTF2.setText("");
		main.modify.inputParentTF2.setText("");
		main.modify.inputPhoneTf2.setText("");

	}

	public void joinProcess() {
		// TODO Auto-generated method stub
		main.setVisible(false);
		String c_id = main.join.inputIdTF.getText().trim();
		String c_password = main.join.inputPwTF.getText().trim();
		String parents_name = main.join.inputParentTF.getText().trim();
		String kids_name = main.join.inputChildTF.getText().trim();
		String kids_birthday = main.join.inputBirthTF.getText().trim();
		String phone_number = main.join.inputPhoneTF.getText().trim();
		CustomerBean cb = new CustomerBean();

		cb.setC_ID(c_id);
		cb.setC_PassWord(c_password);
		cb.setParents_Name(parents_name);
		cb.setKids_Name(kids_name);
		cb.setKids_Birthday(kids_birthday);
		cb.setPhone_Number(phone_number);
		int x = cd.addCustomer(cb);
		if (x == 1) {

			CustomerDao cd = new CustomerDao();
			cd.addCustomer(cb);
			main.join.setVisible(false);
			main.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(main.join, "사용할 수 없는 아이디입니다.");
			return;
		}

		main.join.inputIdTF.setText("");
		main.join.inputPwTF.setText("");
		main.join.inputParentTF.setText("");
		main.join.inputChildTF.setText("");
		main.join.inputBirthTF.setText("");
		main.join.inputPhoneTF.setText("");

	}

	public void main_login() {
		String c_id = main.idTF.getText().trim();
		String c_password = main.pwTF.getText().trim();
		CustomerBean cb = new CustomerBean();
		CustomerDao cd = new CustomerDao();
		cb.setC_ID(c_id);
		cb = cd.loginIDCheck(cb);
		System.out.println(cb);
		if (cb.getC_PassWord() != null && cb.getC_PassWord().equals(c_password)) {
			main.logon.setLocation(main.getLocation());
			main.logon.setVisible(true);
			main.setVisible(false);
			main.logon.cntL.setText(cb.getRemain_Amount());
			main.logon.cnameLabel.setText(cb.getParents_Name());
			customer_number = Integer.toString(cb.getCustomer_number());
			main.logon.visit_calendar.customer_number = Integer.parseInt(customer_number);
			connectProcess();
		} else {
			JOptionPane.showMessageDialog(main, "아이디나 비밀번호를 확인하세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void couponProcess() {
		// TODO Auto-generated method stub
		main.logon.setLocation(main.getLocation());
		main.logon.coupon.setVisible(true);

		String c_id = main.idTF.getText().trim();
		List<CustomerBean> list = cd.getCouponInfo(c_id);

		for (int i = 0; i < list.size(); i++) {
			CouponCont ca = new CouponCont();
			String period = list.get(i).getStart_Date() + "~" + list.get(i).getEnd_Date();
			ca.cpnumL.setText(Integer.toString(list.get(i).getCoupon_Number()));
			ca.cpnameL.setText(list.get(i).getCoupon_Name());
			ca.cpdiscountL.setText(Integer.toString(list.get(0).getDiscount_Rate()) + "% 할인");
			ca.cpPeridL.setText(period);

			main.logon.coupon.pCoupon.add(ca);
		}

	}

	public void modifyProcess() {
		String c_id = main.idTF.getText();
		System.out.println(c_id);
		CustomerBean cb = cd.getEachInfo(c_id);
		main.modify.inputIdTF2.setText(cb.getC_ID());
		main.modify.inputPwTF2.setText(cb.getC_PassWord());
		main.modify.inputParentTF2.setText(cb.getParents_Name());
		main.modify.inputChildTF2.setText(cb.getKids_Name());
		main.modify.inputBirthTF2.setText(cb.getKids_Birthday());
		main.modify.inputPhoneTf2.setText(cb.getPhone_Number());
	}

	public void modifyProcess2() {
		String c_id = main.idTF.getText();
		CustomerBean mod_cb = cd.getEachInfo(c_id);
		mod_cb.setC_ID(main.modify.inputIdTF2.getText());//
		mod_cb.setC_PassWord(main.modify.inputPwTF2.getText());
		mod_cb.setParents_Name(main.modify.inputParentTF2.getText());
		mod_cb.setKids_Name(main.modify.inputChildTF2.getText());
		mod_cb.setPhone_Number(main.modify.inputPhoneTf2.getText());
		mod_cb.setKids_Birthday(main.modify.inputBirthTF2.getText());

		cd.setNewInfo(mod_cb, c_id);
		main.logon.cnameLabel.setText(mod_cb.getParents_Name());
		main.modify.setVisible(false);
		main.logon.setLocation(main.getLocation());
		main.logon.setVisible(true);

	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			try {
				String msg = in.readLine();
				System.out.println("S>>C" + msg);
				StringTokenizer st = new StringTokenizer(msg, "||");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case YeHaConst.SC_CONNECT: {
					System.out.println(customer_number + "번 고객님 환영합니다");
				}
					break;
				case YeHaConst.SC_SEND_COUPON: {// 프로토콜//쿠폰번호
					String str = st.nextToken();
					JOptionPane.showMessageDialog(main.logon, str + "도착!");
				}
					break;
				case YeHaConst.SC_SELL_TICKET: {
					String remainticket = st.nextToken();
					main.logon.cntL.setText(
							Integer.parseInt(main.logon.cntL.getText()) + (Integer.parseInt(remainticket) * 10) + "");
					main.logon.cntL.updateUI();
				}
					break;
				case YeHaConst.SC_USE_TICKET: {
					int amount = Integer.parseInt(st.nextToken());
					main.logon.cntL.setText(Integer.parseInt(main.logon.cntL.getText()) - amount + "");
					main.logon.cntL.updateUI();
				}
					break;
				case YeHaConst.SC_DISCONNECT: {
					String tmp = st.nextToken();
					if (tmp.equals(customer_number)) {
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

	private void exitProcess() {
		// TODO Auto-generated method stub
		sendMsg(YeHaConst.CS_DISCONNECT + "||" + customer_number);
		// main.setVisible(false);
	}
}