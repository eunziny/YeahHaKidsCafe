package com.kitri.yeaha.customer.service;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CouponCont extends JPanel {
	JLabel cpnumL = new JLabel();
	JLabel cpnameL = new JLabel();
	JLabel cpdiscountL = new JLabel();
	JLabel cpPeridL = new JLabel();

	public CouponCont() {
		// TODO Auto-generated constructor stub
		cpPeridL.setForeground(new Color(255, 0, 0));

		this.setLayout(new GridLayout(4, 1));
		this.add(cpnumL);
		this.add(cpnameL);
		this.add(cpdiscountL);
		this.add(cpPeridL);
		this.setBackground(new Color(102, 205, 170));
	}

}
