package com.kitri.yeaha.order.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OrderView extends JFrame {

	public JPanel contentPane;
	public CustoInfoView ci = new CustoInfoView();
	public MenuOrderPrice mop = new MenuOrderPrice();
	// TabView tv;

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// OrderView frame = new OrderView();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	public OrderView() {
		// this.tv = tv;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane orderandinfotab = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(orderandinfotab, BorderLayout.CENTER);
		mop.setBackground(Color.ORANGE);
		orderandinfotab.add("주문/결제", mop);
		orderandinfotab.add("회원정보", ci);

		// MenuOrderService mos = new MenuOrderService(this);

		// mop.rbtn.addActionListener(tv.ms);
		// mop.lbtn.addActionListener(tv.ms);
		// mop.pricecancel.addActionListener(tv.ms);
		// mop.inc.addActionListener(tv.ms);
		// mop.desc.addActionListener(tv.ms);
		// mop.up.addActionListener(tv.ms);
		// mop.down.addActionListener(tv.ms);
		// mop.pay.addActionListener(tv.ms);
		// mop.mmt.maintable.addMouseListener(tv.ms);
		// mop.dmt.drinktable.addMouseListener(tv.ms);
		// mop.smt.sidetable.addMouseListener(tv.ms);
		// mop.tp.coupon_btn.addActionListener(tv.ms);
		// mop.tp.paycash.addActionListener(tv.ms);
		// mop.tp.paycard.addActionListener(tv.ms);
		// mop.tp.notpay.addActionListener(tv.ms);
	}
}
