package com.kitri.yeaha.order.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TotalPayView extends JFrame {

	public JPanel contentPane;
	public JButton coupon_btn;
	public JTextField coupon_num_Tf2;
	public String couponnum;
	public int cpnum;
	public JButton paycard;
	public JButton paycash;
	public int coupontype;
	public int discountrate;
	public JLabel discount_label2;
	public JLabel price_label2;
	public double discountprice;
	public JLabel t_price_label2;
	public int price;
	public JButton notpay;
	MenuOrderPrice mop;

	// public TotalPay(MenuOrderPrice mop) {
	public TotalPayView(MenuOrderPrice mop) {
		this.mop = mop;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(48, 12, 519, 317);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel price_label = new JLabel("\uCD1D \uAE08\uC561");
		price_label.setBounds(55, 37, 125, 43);
		panel.add(price_label);

		JLabel coupon_num_label = new JLabel("\uCFE0\uD3F0 \uBC88\uD638");
		coupon_num_label.setBounds(55, 101, 125, 43);
		panel.add(coupon_num_label);

		JLabel discount_label = new JLabel("\uD560\uC778 \uAE08\uC561");
		discount_label.setBounds(55, 171, 125, 43);
		panel.add(discount_label);

		JLabel t_price_label = new JLabel("\uACB0\uC81C \uAE08\uC561");
		t_price_label.setBounds(55, 240, 125, 43);
		panel.add(t_price_label);

		price_label2 = new JLabel("");
		price_label2.setBounds(190, 37, 217, 43);
		panel.add(price_label2);

		discount_label2 = new JLabel("");
		discount_label2.setBounds(190, 171, 217, 43);
		panel.add(discount_label2);

		t_price_label2 = new JLabel("");
		t_price_label2.setBounds(190, 240, 217, 43);
		panel.add(t_price_label2);

		coupon_btn = new JButton("\uCFE0\uD3F0\uC870\uD68C");
		coupon_btn.setBounds(417, 101, 89, 43);
		panel.add(coupon_btn);

		coupon_num_Tf2 = new JTextField();
		coupon_num_Tf2.setBounds(188, 101, 219, 43);
		panel.add(coupon_num_Tf2);
		coupon_num_Tf2.setColumns(10);

		price_label2.setText(mop.totalprice2.getText());
		t_price_label2.setText(mop.totalprice2.getText());

		paycard = new JButton("\uCE74\uB4DC");
		paycard.setBounds(325, 341, 114, 52);
		contentPane.add(paycard);

		paycash = new JButton("\uD604\uAE08");
		paycash.setBounds(453, 341, 114, 52);
		contentPane.add(paycash);

		notpay = new JButton("\uACB0\uC81C\uCDE8\uC18C");
		notpay.setBounds(197, 341, 114, 52);
		contentPane.add(notpay);

		// coupon_btn.addActionListener(this);
		// paycash.addActionListener(this);
		// paycard.addActionListener(this);
		// notpay.addActionListener(this);
	}

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// Object ob = e.getSource();
	// couponnum = coupon_num_Tf2.getText();
	// SearchCoupon sc = new SearchCoupon();
	// CouponBean cb = sc.searchCoupon(couponnum);
	// if (ob == coupon_btn) {
	// cpnum = sc.searchCoupon(couponnum).getCoupon_number();
	// if (Integer.toString(cpnum).equals(couponnum)) {
	// coupontype = sc.searchCoupon(couponnum).getCoupon_type();
	// discountrate = sc.searchDiscount(coupontype).getDiscount_rate();
	// price = Integer.parseInt(price_label2.getText());
	// discountprice = price * ((double) discountrate / 100);
	// discount_label2.setText(Integer.toString((int) discountprice));
	// t_price_label2.setText(Integer.toString(price - (int) discountprice));
	// } else {
	// JOptionPane.showMessageDialog(null, "없는 쿠폰입니다.");
	// discount_label2.setText("");
	// }
	// } else if (ob == paycash) {
	// JOptionPane.showMessageDialog(null, "현금결제가 완료되었습니다.");
	// sc.updateCoupon(couponnum);
	// setVisible(false);
	// } else if (ob == paycard) {
	// JOptionPane.showMessageDialog(null, "카드결제가 완료되었습니다.");
	// sc.updateCoupon(couponnum);
	// setVisible(false);
	// } else if(ob == notpay) {
	// setVisible(false);
	// }
	// }
}
