package com.kitri.yeaha.manager.view;

import java.awt.*;

import javax.swing.*;

public class ManagerMainView extends JPanel {

	public JButton[] mainB = new JButton[8];
	public JLabel[] mTNumL = new JLabel[8];
	public JLabel[] mPNameL = new JLabel[8];
	public JLabel[] mLTimeL = new JLabel[8];
	public JButton[] exitB = new JButton[8];
	public int[] customer_number = new int[8];
	public JLabel[] exitL = new JLabel[8];

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public ManagerMainView() {
		setBackground(Color.ORANGE);
		setLayout(null);

		mainB[0] = new JButton("0");
		mainB[0].setBounds(15, 39, 165, 160);
		mainB[0].setBackground(new Color(250, 244, 192));
		mainB[0].setForeground(new Color(250, 244, 192));
		mainB[0].setLayout(new GridLayout(3, 1));
		mTNumL[0] = new JLabel("[1]");
		mTNumL[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[0] = new JLabel("");
		mPNameL[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[0] = new JLabel("");
		mLTimeL[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[0].add(mTNumL[0]);
		mainB[0].add(mPNameL[0]);
		mainB[0].add(mLTimeL[0]);
		add(mainB[0]);

		mainB[1] = new JButton("1");
		mainB[1].setBounds(205, 39, 165, 160);
		mainB[1].setBackground(new Color(250, 244, 192));
		mainB[1].setForeground(new Color(250, 244, 192));
		mainB[1].setLayout(new GridLayout(3, 1));
		mTNumL[1] = new JLabel("[2]");
		mTNumL[1].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[1] = new JLabel("");
		mPNameL[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[1] = new JLabel("");
		mLTimeL[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[1].add(mTNumL[1]);
		mainB[1].add(mPNameL[1]);
		mainB[1].add(mLTimeL[1]);
		add(mainB[1]);

		mainB[2] = new JButton("2");
		mainB[2].setBounds(393, 39, 165, 160);
		mainB[2].setBackground(new Color(250, 244, 192));
		mainB[2].setForeground(new Color(250, 244, 192));
		mainB[2].setLayout(new GridLayout(3, 1));
		mTNumL[2] = new JLabel("[3]");
		mTNumL[2].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[2] = new JLabel("");
		mPNameL[2].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[2] = new JLabel("");
		mLTimeL[2].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[2].add(mTNumL[2]);
		mainB[2].add(mPNameL[2]);
		mainB[2].add(mLTimeL[2]);
		add(mainB[2]);

		mainB[3] = new JButton("3");
		mainB[3].setBounds(583, 39, 165, 160);
		mainB[3].setBackground(new Color(250, 244, 192));
		mainB[3].setForeground(new Color(250, 244, 192));
		mainB[3].setLayout(new GridLayout(3, 1));
		mTNumL[3] = new JLabel("[4]");
		mTNumL[3].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[3] = new JLabel("");
		mPNameL[3].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[3] = new JLabel("");
		mLTimeL[3].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[3].add(mTNumL[3]);
		mainB[3].add(mPNameL[3]);
		mainB[3].add(mLTimeL[3]);
		add(mainB[3]);

		mainB[4] = new JButton("4");
		mainB[4].setBounds(14, 273, 165, 160);
		mainB[4].setBackground(new Color(250, 244, 192));
		mainB[4].setForeground(new Color(250, 244, 192));
		mainB[4].setLayout(new GridLayout(3, 1));
		mTNumL[4] = new JLabel("[5]");
		mTNumL[4].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[4] = new JLabel("");
		mPNameL[4].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[4] = new JLabel("");
		mLTimeL[4].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[4].add(mTNumL[4]);
		mainB[4].add(mPNameL[4]);
		mainB[4].add(mLTimeL[4]);
		add(mainB[4]);

		mainB[5] = new JButton("5");
		mainB[5].setBounds(205, 273, 165, 160);
		mainB[5].setBackground(new Color(250, 244, 192));
		mainB[5].setForeground(new Color(250, 244, 192));
		mainB[5].setLayout(new GridLayout(3, 1));
		mTNumL[5] = new JLabel("[6]");
		mTNumL[5].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[5] = new JLabel("");
		mPNameL[5].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[5] = new JLabel("");
		mLTimeL[5].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[5].add(mTNumL[5]);
		mainB[5].add(mPNameL[5]);
		mainB[5].add(mLTimeL[5]);
		add(mainB[5]);

		mainB[6] = new JButton("6");
		mainB[6].setBounds(393, 273, 165, 160);
		mainB[6].setBackground(new Color(250, 244, 192));
		mainB[6].setForeground(new Color(250, 244, 192));
		mainB[6].setLayout(new GridLayout(3, 1));
		mTNumL[6] = new JLabel("[7]");
		mTNumL[6].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[6] = new JLabel("");
		mPNameL[6].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[6] = new JLabel("");
		mLTimeL[6].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[6].add(mTNumL[6]);
		mainB[6].add(mPNameL[6]);
		mainB[6].add(mLTimeL[6]);
		add(mainB[6]);

		mainB[7] = new JButton("7");
		mainB[7].setBounds(583, 273, 165, 160);
		mainB[7].setBackground(new Color(250, 244, 192));
		mainB[7].setForeground(new Color(250, 244, 192));
		mainB[7].setLayout(new GridLayout(3, 1));
		mTNumL[7] = new JLabel("[8]");
		mTNumL[7].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		mPNameL[7] = new JLabel("");
		mPNameL[7].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mLTimeL[7] = new JLabel("");
		mLTimeL[7].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		mainB[7].add(mTNumL[7]);
		mainB[7].add(mPNameL[7]);
		mainB[7].add(mLTimeL[7]);
		add(mainB[7]);

		exitB[0] = new JButton("0");
		exitB[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[0].setBounds(115, 202, 65, 27);
		exitB[0].setBackground(new Color(250, 244, 192));
		exitL[0] = new JLabel("Åð½Ç");
		exitL[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[0].setForeground(new Color(250, 244, 192));
		exitL[0].setBackground(new Color(250, 244, 192));
		exitL[0].setForeground(Color.black);
		exitB[0].add(exitL[0]);
		add(exitB[0]);

		exitB[1] = new JButton("1");
		exitB[1].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[1].setBounds(305, 202, 65, 27);
		exitB[1].setBackground(new Color(250, 244, 192));
		exitL[1] = new JLabel("Åð½Ç");
		exitL[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[1].setForeground(new Color(250, 244, 192));
		exitL[1].setBackground(new Color(250, 244, 192));
		exitL[1].setForeground(Color.black);
		exitB[1].add(exitL[1]);
		add(exitB[1]);

		exitB[2] = new JButton("2");
		exitB[2].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[2].setBounds(493, 202, 65, 27);
		exitB[2].setBackground(new Color(250, 244, 192));
		exitL[2] = new JLabel("Åð½Ç");
		exitL[2].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[2].setForeground(new Color(250, 244, 192));
		exitL[2].setBackground(new Color(250, 244, 192));
		exitL[2].setForeground(Color.black);
		exitB[2].add(exitL[2]);
		add(exitB[2]);

		exitB[3] = new JButton("3");
		exitB[3].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[3].setBounds(683, 202, 65, 27);
		exitB[3].setBackground(new Color(250, 244, 192));
		exitL[3] = new JLabel("Åð½Ç");
		exitL[3].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[3].setForeground(new Color(250, 244, 192));
		exitL[3].setBackground(new Color(250, 244, 192));
		exitL[3].setForeground(Color.black);
		exitB[3].add(exitL[3]);
		add(exitB[3]);

		exitB[4] = new JButton("4");
		exitB[4].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[4].setBounds(115, 435, 65, 27);
		exitB[4].setBackground(new Color(250, 244, 192));
		exitL[4] = new JLabel("Åð½Ç");
		exitL[4].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[4].setForeground(new Color(250, 244, 192));
		exitL[4].setBackground(new Color(250, 244, 192));
		exitL[4].setForeground(Color.black);
		exitB[4].add(exitL[4]);
		add(exitB[4]);

		exitB[5] = new JButton("5");
		exitB[5].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[5].setBounds(305, 435, 65, 27);
		exitB[5].setBackground(new Color(250, 244, 192));
		exitL[5] = new JLabel("Åð½Ç");
		exitL[5].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[5].setForeground(new Color(250, 244, 192));
		exitL[5].setBackground(new Color(250, 244, 192));
		exitL[5].setForeground(Color.black);
		exitB[5].add(exitL[5]);
		add(exitB[5]);

		exitB[6] = new JButton("6");
		exitB[6].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[6].setBounds(493, 435, 65, 27);
		exitB[6].setBackground(new Color(250, 244, 192));
		exitL[6] = new JLabel("Åð½Ç");
		exitL[6].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[6].setForeground(new Color(250, 244, 192));
		exitL[6].setBackground(new Color(250, 244, 192));
		exitL[6].setForeground(Color.black);
		exitB[6].add(exitL[6]);
		add(exitB[6]);

		exitB[7] = new JButton("7");
		exitB[7].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 0));
		exitB[7].setBounds(683, 435, 65, 27);
		exitB[7].setBackground(new Color(250, 244, 192));
		exitL[7] = new JLabel("Åð½Ç");
		exitL[7].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		// exitL[7].setForeground(new Color(250, 244, 192));
		exitL[7].setBackground(new Color(250, 244, 192));
		exitL[7].setForeground(Color.black);
		exitB[7].add(exitL[7]);
		add(exitB[7]);

	}
}
