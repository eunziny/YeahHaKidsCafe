package com.kitri.yeaha.manager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.yeaha.chart.view.Chartmain;
import com.kitri.yeaha.manager.service.ManagerService;
import com.kitri.yeaha.order.view.OrderView;

public class MainView extends JFrame {
	public JPanel contentPane;
	public JTabbedPane tab;
	public ManagerMainView mv;
	public MenuModiView mmv;
	public LoginView lv;
	public Chartmain cm;
	public CustoInfoView civ;
	public CouponSendView cpm;
	public CouponModView cv;
	public CouponPanel cp;
	public TicketSelView tsv;
	public OrderView ov;
	public ManagerService ms;
	// public OrderPane op;
	// public MenuOrderPrice ov.mop;

	public MainView() {
		mv = new ManagerMainView();
		mmv = new MenuModiView();
		lv = new LoginView();
		cm = new Chartmain();
		civ = new CustoInfoView();
		tsv = new TicketSelView();
		ov = new OrderView();
		cp = new CouponPanel();
		cv = new CouponModView();
		tab = new JTabbedPane(JTabbedPane.TOP);
		cpm = new CouponSendView();
		// op = new OrderPane();
		// ov.mop = new MenuOrderPrice();
		initGUI();

		ms = new ManagerService(this);
		// MainView Event Listener등록
		for (int i = 0; i < 8; i++) {
			mv.mainB[i].addActionListener(ms);
		}
		for (int i = 0; i < 8; i++) {
			mv.exitB[i].addActionListener(ms);
		}

		// MenuModiView Event Listener등록
		mmv.mCancleB.addActionListener(ms);
		mmv.mAddB.addActionListener(ms);
		mmv.comboBox.addActionListener(ms);
		mmv.mCancleB2.addActionListener(ms);
		mmv.mDelB.addActionListener(ms);

		// LoginView 취소,확인 Event Listener등록
		lv.loginB1.addActionListener(ms);
		lv.loginB2.addActionListener(ms);
		lv.pnTf3.addActionListener(ms);

		tsv.pt.ticket.addActionListener(ms);
		tsv.pt.d_ticket.addActionListener(ms);
		// tsv.pt.cpBtn.addActionListener(ms);
		cpm.sendBnt.addActionListener(ms);
		tsv.pt.pl.t_pch_accp.addActionListener(ms);
		tsv.pt.pl.t_pch_can.addActionListener(ms);
		tsv.ut.plus.addActionListener(ms);
		tsv.ut.minus.addActionListener(ms);
		tsv.ut.use_acc.addActionListener(ms);
		tsv.ut.use_cancel.addActionListener(ms);
		ov.mop.rbtn.addActionListener(ms);
		ov.mop.lbtn.addActionListener(ms);
		ov.mop.pricecancel.addActionListener(ms);
		ov.mop.inc.addActionListener(ms);
		ov.mop.desc.addActionListener(ms);
		ov.mop.up.addActionListener(ms);
		ov.mop.down.addActionListener(ms);
		ov.mop.pay.addActionListener(ms);
		ov.mop.mmt.maintable.addMouseListener(ms);
		ov.mop.dmt.drinktable.addMouseListener(ms);
		ov.mop.smt.sidetable.addMouseListener(ms);
		ov.mop.tp.coupon_btn.addActionListener(ms);
		ov.mop.tp.paycash.addActionListener(ms);
		ov.mop.tp.paycard.addActionListener(ms);
		ov.mop.tp.notpay.addActionListener(ms);
		cm.dc.newBtn.addActionListener(ms);
		cm.mc.newBtn.addActionListener(ms);
		cp.makecpBtn.addActionListener(ms);
		cp.sendcpBtn.addActionListener(ms);
		cv.addcpbtn.addActionListener(ms);
		cv.cancel.addActionListener(ms);
		cv.delcpbtn.addActionListener(ms);
		cpm.couponexB.addActionListener(ms);
		// op.selBtn.addActionListener(ms);
	}

	/**
	 * Create the frame.
	 */
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tab.addTab("매장", mv);
		tab.addTab("메뉴관리", mmv);
		tab.addTab("매출현황", cm);
		// tab.addTab("회원정보", civ);
		tab.addTab("쿠폰", cp);
		// tab.addTab("주문내역", op);
		contentPane.add(tab, BorderLayout.CENTER);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView tv = new MainView();
					tv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}