package com.kitri.yeaha.manager.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UseTicket extends JPanel {
	public JTextField textField;
	public JButton minus;
	public JButton plus;
	public JButton use_cancel;
	public JButton use_acc;
	public JLabel amount;
	public JLabel name;

	/**
	 * Create the panel.
	 */
	public UseTicket() {
		setBackground(Color.ORANGE);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(130, 88, 500, 333);
		add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 40));
		textField.setText("1");
		textField.setBounds(163, 131, 175, 56);
		panel.add(textField);
		textField.setColumns(10);

		minus = new JButton("-");
		minus.setFont(new Font("±¼¸²", Font.BOLD, 40));
		minus.setBackground(new Color(100, 149, 237));
		minus.setBounds(70, 119, 79, 81);
		panel.add(minus);

		plus = new JButton("+");
		plus.setFont(new Font("±¼¸²", Font.BOLD, 40));
		plus.setBackground(new Color(100, 149, 237));
		plus.setBounds(352, 119, 79, 81);
		panel.add(plus);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(14, 259, 472, 62);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 10, 10));

		use_cancel = new JButton("\uCDE8\uC18C");
		use_cancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		use_cancel.setBackground(new Color(220, 220, 220));
		use_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(use_cancel);

		use_acc = new JButton("\uC0AC\uC6A9");
		use_acc.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		use_acc.setBackground(new Color(100, 149, 237));
		panel_1.add(use_acc);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(70, 63, 359, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB2D8\uC758 \uC794\uC5EC \uC815\uAE30\uAD8C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(124, 0, 117, 42);
		panel_2.add(lblNewLabel);

		name = new JLabel("\uD669\uBBFC\uD604");
		name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(49, -2, 77, 42);
		panel_2.add(name);

		amount = new JLabel("0");
		amount.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setBounds(237, 4, 30, 30);
		panel_2.add(amount);

		JLabel label = new JLabel("\uD68C");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label.setBounds(261, 4, 30, 30);
		panel_2.add(label);

		// this.setBounds(10, 10, 500, 400);

	}
}
