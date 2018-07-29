package com.kitri.yeaha.customer.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomerViewLogon extends JFrame {

	public JPanel contentPane;
	public JButton infoModifyB;
	public JLabel customermainL;
	public JLabel cntL;
	public JLabel ticketInfoL;
	public JButton couponB;
	public JButton historyB;
	public JLabel lblNewLabel;
	public JPanel panel;
	public JLabel lblNewLabel_1;
	public JLabel cnameLabel;
	public CustomerViewCoupon coupon;
	public UseDataView visit_calendar;
	public JButton logoutBtn;
	public String imgpath;
	public Image image;
	public String menuimg;
	public JLabel imageL;
	public ImageIcon img;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CustomerViewLogon frame = new CustomerViewLogon();
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
	public CustomerViewLogon() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		customermainL = new JLabel("YEAH-HA KIDS");
		customermainL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		customermainL.setForeground(new Color(0, 51, 255));
		customermainL.setHorizontalAlignment(SwingConstants.CENTER);
		customermainL.setBounds(82, 15, 235, 55);
		contentPane.add(customermainL);

		infoModifyB = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		infoModifyB.setBounds(238, 80, 127, 23);
		contentPane.add(infoModifyB);

		cntL = new JLabel("");
		cntL.setForeground(UIManager.getColor("List.selectionBackground"));
		cntL.setBackground(UIManager.getColor("TextField.caretForeground"));
		cntL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		cntL.setHorizontalAlignment(SwingConstants.CENTER);
		cntL.setBounds(237, 181, 80, 65);
		contentPane.add(cntL);

		ticketInfoL = new JLabel("\uBCF4\uC720\uC815\uAE30\uAD8C : ");
		ticketInfoL.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		ticketInfoL.setBounds(123, 204, 102, 25);
		contentPane.add(ticketInfoL);

		// couponB = new JButton("\uB0B4 \uCFE0\uD3F0\uD568");
		couponB = new JButton(new ImageIcon(CustomerViewLogon.class.getResource("/com/kitri/yeaha/customer/view/couponImg.png")));
		// couponB = new JButton("ÄíÆù");
		couponB.setBackground(SystemColor.inactiveCaption);
		couponB.setBounds(50, 251, 145, 155);
		contentPane.add(couponB);

		// historyB = new JButton("\uBC29\uBB38 \uB0B4\uC5ED");
		historyB = new JButton(new ImageIcon(CustomerViewLogon.class.getResource("/com/kitri/yeaha/customer/view/historyImg.png")));
		historyB.setBackground(SystemColor.inactiveCaption);
		historyB.setBounds(220, 251, 145, 155);
		contentPane.add(historyB);

		panel = new JPanel();
		panel.setBounds(54, 135, 285, 47);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));

		lblNewLabel_1 = new JLabel("\uBC18\uAC11\uC2B5\uB2C8\uB2E4");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

		cnameLabel = new JLabel("");

		cnameLabel.setForeground(Color.BLUE);
		cnameLabel.setFont(new Font("±¼¸²", Font.BOLD, 18));
		cnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(cnameLabel);

		lblNewLabel = new JLabel("\uD68C\uC6D0\uB2D8!!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(50, 474, 317, 27);
		contentPane.add(logoutBtn);

		coupon = new CustomerViewCoupon();
		visit_calendar = new UseDataView();
	}
}