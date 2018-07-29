package com.kitri.yeaha.manager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class LoginView extends JFrame {

	public JPanel contentPane;
	public JTextField pnTf1;
	public JTextField pnTf2;
	public JTextField pnTf3;
	public JLabel sepL1;
	public JLabel sepL2;
	public JButton loginB1;
	public JButton loginB2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel loginL = new JLabel("\u2665 \uD658\uC601\uD569\uB2C8\uB2E4 \u2665");
		loginL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		loginL.setHorizontalAlignment(SwingConstants.CENTER);
		loginL.setBounds(120, 17, 342, 37);
		contentPane.add(loginL);

		JPanel loginP = new JPanel();
		loginP.setBounds(48, 77, 495, 252);
		contentPane.add(loginP);
		loginP.setLayout(null);

		JLabel loginPNL = new JLabel("\uD734\uB300\uD3F0 \uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694!");
		loginPNL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		loginPNL.setHorizontalAlignment(SwingConstants.CENTER);
		loginPNL.setBounds(14, 12, 226, 34);
		loginP.add(loginPNL);

		pnTf1 = new JTextField(3);
		pnTf1.setBounds(51, 92, 90, 40);
		loginP.add(pnTf1);
		pnTf1.setColumns(10);

		pnTf2 = new JTextField(4);
		pnTf2.setBounds(204, 92, 90, 40);
		loginP.add(pnTf2);
		pnTf2.setColumns(10);

		pnTf3 = new JTextField(4);
		pnTf3.setBounds(364, 92, 90, 40);
		loginP.add(pnTf3);
		pnTf3.setColumns(10);

		sepL1 = new JLabel("-");
		sepL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		sepL1.setHorizontalAlignment(SwingConstants.CENTER);
		sepL1.setBounds(162, 95, 20, 26);
		loginP.add(sepL1);

		sepL2 = new JLabel("-");
		sepL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		sepL2.setHorizontalAlignment(SwingConstants.CENTER);
		sepL2.setBounds(320, 95, 20, 26);
		loginP.add(sepL2);

		loginB1 = new JButton("\uCDE8\uC18C");
		loginB1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		loginB1.setBounds(97, 170, 110, 50);
		loginP.add(loginB1);

		loginB2 = new JButton("\uD655\uC778");
		loginB2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		loginB2.setBounds(291, 170, 110, 50);
		loginP.add(loginB2);
		pnTf1.requestFocus();
		// pnTf1.setColumns(3);
		// pnTf2.setColumns(4);
		// pnTf3.setColumns(4);
	}

}
