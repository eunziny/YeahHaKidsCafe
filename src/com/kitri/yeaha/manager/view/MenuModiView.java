package com.kitri.yeaha.manager.view;

import java.awt.Color;

import javax.swing.*;

public class MenuModiView extends JPanel {
	public JPanel panel1;
	public JPanel panel2;
	public JLabel mNameL;
	public JLabel mPriceL;
	public JLabel mCateL;
	public JTextField mNameTf;
	public JTextField mPriceTf;
	public JTextField mCateTf;
	public JButton mCancleB;
	public JButton mAddB;
	public JComboBox comboBox;
	public JLabel mDelL;
	public JButton mCancleB2;
	public JButton mDelB;

	/**
	 * Create the panel.
	 */
	public MenuModiView() {
		setBackground(Color.ORANGE);
		setLayout(null);

		panel1 = new JPanel();
		panel1.setBounds(46, 48, 310, 410);
		add(panel1);
		panel1.setLayout(null);

		mNameL = new JLabel("\uBA54\uB274 \uC774\uB984");
		mNameL.setHorizontalAlignment(SwingConstants.CENTER);
		mNameL.setBounds(14, 138, 89, 35);
		panel1.add(mNameL);

		mPriceL = new JLabel("\uBA54\uB274 \uAC00\uACA9");
		mPriceL.setHorizontalAlignment(SwingConstants.CENTER);
		mPriceL.setBounds(14, 222, 89, 35);
		panel1.add(mPriceL);

		mCateL = new JLabel("\uCE74\uD14C\uACE0\uB9AC \uBC88\uD638");
		mCateL.setHorizontalAlignment(SwingConstants.CENTER);
		mCateL.setBounds(0, 56, 124, 35);
		panel1.add(mCateL);

		mNameTf = new JTextField();
		mNameTf.setBounds(117, 143, 163, 40);
		panel1.add(mNameTf);
		mNameTf.setColumns(10);

		mPriceTf = new JTextField();
		mPriceTf.setBounds(117, 227, 163, 40);
		panel1.add(mPriceTf);
		mPriceTf.setColumns(10);

		mCancleB = new JButton("\uCDE8\uC18C");
		mCancleB.setForeground(Color.BLACK);
		mCancleB.setBounds(33, 349, 105, 48);
		panel1.add(mCancleB);

		mAddB = new JButton("\uCD94\uAC00");
		mAddB.setBounds(165, 349, 105, 48);
		panel1.add(mAddB);

		mCateTf = new JTextField();
		mCateTf.setBounds(117, 54, 163, 40);
		panel1.add(mCateTf);
		mCateTf.setColumns(10);

		panel2 = new JPanel();
		panel2.setBounds(409, 48, 310, 410);
		add(panel2);
		panel2.setLayout(null);

		mCancleB2 = new JButton("\uCDE8\uC18C");
		mCancleB2.setBounds(34, 349, 105, 49);
		panel2.add(mCancleB2);

		mDelB = new JButton("\uC0AD\uC81C");
		mDelB.setBounds(163, 349, 111, 49);
		panel2.add(mDelB);

		comboBox = new JComboBox();
		comboBox.setBounds(36, 58, 238, 49);
		panel2.add(comboBox);

		mDelL = new JLabel("");
		mDelL.setBounds(40, 148, 145, 38);
		panel2.add(mDelL);

	}
}
