package com.kitri.yeaha.manager.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TicketSelView extends JFrame {

	private JPanel contentPane;
	public PurchaseTicket pt;
	public UseTicket ut;
	// public CouponMaker cm;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// TicketView frame = new TicketView();
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
	public TicketSelView() {
		super("Yeah-HA!");
		setBackground(Color.orange);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tpan = new JTabbedPane(JTabbedPane.TOP);
		tpan.setBackground(Color.orange);
		contentPane.add(tpan, BorderLayout.CENTER);
		pt = new PurchaseTicket();
		ut = new UseTicket();
		// csv = new CouponSendView();

		// csv.setTitle("쿠폰보내기");
		pt.setBackground(Color.ORANGE);
		tpan.addTab("구매", pt);
		tpan.addTab("사용", ut);
		// cm = new CouponMaker();
		// tpan.add("쿠폰", cm);

		// YeHaManagerService ys = new YeHaManagerService(this);
		// pt.ticket.addActionListener(ys);
		// pt.d_ticket.addActionListener(ys);
		// pt.cpBtn.addActionListener(ys);
		// // cm.sendBnt.addActionListener(ys);
		// pt.pl.t_pch_accp.addActionListener(ys);
		// ut.plus.addActionListener(ys);
		// ut.minus.addActionListener(ys);
		// ut.use_acc.addActionListener(ys);
	}
}
