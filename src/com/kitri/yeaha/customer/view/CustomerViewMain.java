package com.kitri.yeaha.customer.view;

import java.awt.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.yeaha.customer.service.CustomerService;

public class CustomerViewMain extends JFrame {

	public JPanel mainP;
	public JTextField idTF;
	public JPasswordField pwTF;
	public JButton loginB;
	public JButton joinB;
	public CustomerViewLogon logon;
	public CustomerViewJoin join;
	public CustomerViewModify modify;
	public CustomerViewCoupon coupon;
	public UseDataView visit_calendar;
	public JLabel idL;
	public JLabel pwL;
	BufferedReader br;

	/**
	 * Create the frame.
	 */
	public String customerInput() {
		br = new BufferedReader(new InputStreamReader(System.in));
		String s_code = "";

		try {
			s_code = br.readLine();
		} catch (IOException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		return s_code;
	}

	public CustomerViewMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 560);
		mainP = new JPanel();
		mainP.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainP);
		mainP.setLayout(null);

		JLabel customerMainL = new JLabel("YEAH-HA KIDS");
		customerMainL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		customerMainL.setForeground(new Color(0, 51, 255));
		customerMainL.setHorizontalAlignment(SwingConstants.CENTER);
		customerMainL.setBounds(82, 25, 233, 45);
		mainP.add(customerMainL);

		idTF = new JTextField();
		idTF.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		idTF.setText("");
		idTF.setBounds(112, 164, 203, 45);
		mainP.add(idTF);
		idL = new JLabel("ID");
		idL.setBounds(82, 164, 30, 45);
		mainP.add(idL);
		idTF.setColumns(10);

		pwTF = new JPasswordField();
		pwTF.setText("");
		pwTF.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pwTF.setColumns(10);
		pwTF.setBounds(112, 231, 203, 45);
		pwL = new JLabel("PW");
		pwL.setBounds(82, 231, 30, 45);
		mainP.add(pwL);
		mainP.add(pwTF);

		loginB = new JButton("LOGIN");
		loginB.setBackground(UIManager.getColor("Menu.selectionBackground"));
		loginB.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		loginB.setBounds(82, 298, 105, 40);
		mainP.add(loginB);

		joinB = new JButton("JOIN");
		joinB.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		joinB.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
		joinB.setBounds(210, 298, 105, 40);
		mainP.add(joinB);

		// CustomerViewLogon cvl = new CustomerViewLogon();
		CustomerService cs = new CustomerService(this);
		// coupon = new CustomerViewCoupon();
		logon = new CustomerViewLogon();
		join = new CustomerViewJoin();
		loginB.addActionListener(cs);
		joinB.addActionListener(cs);
		logon.infoModifyB.addActionListener(cs);
		logon.logoutBtn.addActionListener(cs);
		join.okB.addActionListener(cs);
		join.cancelB.addActionListener(cs);
		modify = new CustomerViewModify();
		modify.okB2.addActionListener(cs);
		modify.cancelB2.addActionListener(cs);
		modify.withdrawalB.addActionListener(cs);
		logon.couponB.addActionListener(cs);
		logon.historyB.addActionListener(cs);
		logon.coupon.backB.addActionListener(cs);
		join.duplicateB.addActionListener(cs);
		pwTF.addActionListener(cs);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerViewMain frame = new CustomerViewMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}