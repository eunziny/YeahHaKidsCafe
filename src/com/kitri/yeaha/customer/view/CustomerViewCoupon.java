package com.kitri.yeaha.customer.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomerViewCoupon extends JFrame {
	public CustomerViewLogon logon;

	public JPanel contentPane;
	public JPanel pCoupon;
	public JButton backB;

	/**
	 * Launch the application. //
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CustomerViewCoupon frame = new CustomerViewCoupon();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public CustomerViewCoupon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel customerMainL = new JLabel("YEAH-HA KIDS");
		customerMainL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		customerMainL.setForeground(new Color(0, 51, 255));
		customerMainL.setHorizontalAlignment(SwingConstants.CENTER);
		customerMainL.setBounds(82, 15, 233, 45);
		contentPane.add(customerMainL);

		JLabel label = new JLabel("\uC0AC\uC6A9 \uAC00\uB2A5 \uCFE0\uD3F0 \uBAA9\uB85D");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		label.setBounds(12, 91, 187, 34);
		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(371, 364);
		scrollPane.setLocation(12, 137);
		contentPane.add(scrollPane);

		pCoupon = new JPanel();
		scrollPane.setViewportView(pCoupon);
		pCoupon.setLayout(new GridLayout(10, 1, 0, 10));

		backB = new JButton("<");
		backB.setBounds(23, 15, 45, 45);
		contentPane.add(backB);
	}
}
