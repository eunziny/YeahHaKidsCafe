package com.kitri.yeaha.manager.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CouponPanel extends JPanel {
	public JButton sendcpBtn;
	public JButton makecpBtn;

	/**
	 * Create the panel.
	 */
	public CouponPanel() {
		setBackground(Color.ORANGE);
		setLayout(null);

		sendcpBtn = new JButton("\uCFE0\uD3F0\uBC1C\uC1A1");
		sendcpBtn.setForeground(new Color(255, 255, 255));
		sendcpBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		sendcpBtn.setBackground(new Color(100, 149, 237));
		sendcpBtn.setBounds(92, 118, 255, 255);
		add(sendcpBtn);

		makecpBtn = new JButton("\uCFE0\uD3F0\uAD00\uB9AC");
		makecpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		makecpBtn.setForeground(new Color(255, 255, 255));
		makecpBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		makecpBtn.setBackground(new Color(100, 149, 237));
		makecpBtn.setBounds(401, 118, 255, 255);
		add(makecpBtn);

	}
}
