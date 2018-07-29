package com.kitri.yeaha.manager.view;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CouponSendView extends JFrame implements ListSelectionListener {
	public JLabel l1;
	public JList<String> customerList;
	public JList<String> couponList;
	public JLabel customer;
	public JLabel coupon;
	public JLabel l2;
	public JButton sendBnt;
	public JButton couponexB;
	public Vector<String> cstmlistData;
	public Vector<String> couponlistData;
	public JPanel contentPane;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	public JLabel l3;
	public JPanel panel;
	public JLabel l4;

	/**
	 * Create the panel.
	 */
	public CouponSendView() {
		initGUI();
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);

		l1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		l1.setBounds(79, 72, 80, 30);
		getContentPane().add(l1);

		scrollPane.setBounds(159, 72, 203, 276);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(customerList);

		l2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		l2.setBounds(384, 72, 80, 30);
		getContentPane().add(l2);

		scrollPane_1.setBounds(466, 72, 190, 276);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(couponList);

		panel.setBounds(159, 380, 497, 55);
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);

		customer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		customer.setForeground(Color.BLACK);
		customer.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(customer);

		l3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(l3);

		coupon.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		coupon.setForeground(Color.BLACK);
		coupon.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(coupon);

		l4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(l4);

		sendBnt.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		sendBnt.setBackground(new Color(250, 244, 192));
		sendBnt.setBounds(346, 465, 141, 55);
		getContentPane().add(sendBnt);

		couponexB.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		couponexB.setBackground(new Color(250, 244, 192));
		couponexB.setBounds(14, 12, 50, 50);
		contentPane.add(couponexB);

		customerList.addListSelectionListener(this);
		couponList.addListSelectionListener(this);

	}

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// contentPane.setLayout(new BorderLayout(0, 0));
		l1 = new JLabel("\uACE0\uAC1D ID : ", JLabel.CENTER);
		l2 = new JLabel("\uCFE0\uD3F0\uBA85 : ", JLabel.CENTER);
		scrollPane = new JScrollPane();
		customerList = new JList<String>(cstmlistData);
		cstmlistData = new Vector<String>();
		scrollPane_1 = new JScrollPane();
		couponList = new JList<String>(couponlistData);
		couponlistData = new Vector<String>();
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		customer = new JLabel();
		l3 = new JLabel("\uC5D0\uAC8C");
		coupon = new JLabel();
		l4 = new JLabel("\uC744");
		sendBnt = new JButton("\uBCF4\uB0B4\uAE30");
		couponexB = new JButton("<");

		// contentPane.add(l1);
		// contentPane.add(customerList);
		// contentPane.add(couponList);
		// contentPane.add(customer);
		// contentPane.add(coupon);
		// contentPane.add(sendBnt);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object ob = e.getSource();
		if (ob == customerList) {
			String selcstm = customerList.getSelectedValue();
			customer.setText(selcstm);
		} else if (ob == couponList) {
			String selcstm = couponList.getSelectedValue();
			coupon.setText(selcstm);
		}

	}

}