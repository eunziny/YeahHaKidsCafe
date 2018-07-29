package com.kitri.yeaha.order.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import com.kitri.yeaha.manager.data.YeahhaDao;

public class CustoInfoView extends JPanel {
	public JLabel imageL;
	public JLabel pNameL;
	public JLabel kNameL;
	public JLabel pNumL;
	public JLabel pNameL2;
	public JLabel kNameL2;
	public JLabel pNumL2;
	public ImageIcon custoiamge;

	YeahhaDao yd = new YeahhaDao();

	/**
	 * Create the panel.
	 */
	public CustoInfoView() {
		setBackground(Color.ORANGE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(110, 78, 541, 360);
		add(panel);
		panel.setLayout(null);

		ImageIcon custoiamge = new ImageIcon("../YeaHaKidsCafe/src/com/kitri/yeaha/manager/view/yeha.png");
		imageL = new JLabel();
		imageL.setIcon(custoiamge);
		imageL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		imageL.setHorizontalAlignment(SwingConstants.CENTER);
		imageL.setBounds(41, 50, 153, 251);
		panel.add(imageL);

		pNameL = new JLabel("\uBD80\uBAA8\uC774\uB984");
		pNameL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		pNameL.setHorizontalAlignment(SwingConstants.CENTER);
		pNameL.setBounds(232, 107, 85, 30);
		panel.add(pNameL);

		kNameL = new JLabel("\uC544\uC774\uC774\uB984");
		kNameL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		kNameL.setHorizontalAlignment(SwingConstants.CENTER);
		kNameL.setBounds(232, 162, 85, 30);
		panel.add(kNameL);

		pNumL = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		pNumL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		pNumL.setHorizontalAlignment(SwingConstants.CENTER);
		pNumL.setBounds(232, 224, 85, 30);
		panel.add(pNumL);

		// ºÎ¸ðÀÌ¸§ Ãâ·ÂµÇ´Â ¶óº§
		pNameL2 = new JLabel("");
		pNameL2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pNameL2.setHorizontalAlignment(SwingConstants.CENTER);
		pNameL2.setBounds(353, 107, 153, 35);
		panel.add(pNameL2);

		// ¾ÆÀÌÀÌ¸§ Ãâ·ÂµÇ´Â ¶óº§
		kNameL2 = new JLabel("");
		kNameL2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		kNameL2.setHorizontalAlignment(SwingConstants.CENTER);
		kNameL2.setBounds(353, 162, 153, 35);
		panel.add(kNameL2);

		// ÈÞ´ëÆù¹øÈ£ Ãâ·ÂµÇ´Â ¶óº§
		pNumL2 = new JLabel("");
		pNumL2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pNumL2.setHorizontalAlignment(SwingConstants.CENTER);
		pNumL2.setBounds(350, 224, 153, 35);
		panel.add(pNumL2);

	}
}
