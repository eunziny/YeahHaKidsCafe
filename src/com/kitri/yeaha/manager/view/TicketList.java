package com.kitri.yeaha.manager.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TicketList extends JPanel {
	public JTable table;
	public JScrollPane scrollPane;
	public JPanel panel;
	public JButton t_pch_accp;
	public JButton t_pch_can;
	public JLabel lblNewLabel;
	public JLabel t_price;
	public DefaultTableModel model;
	// public String[] colName = { "Ç×¸ñ", "¼ö·®", "°¡°Ý" };
	// public Object[][] rowData = {};
	public Vector<String> userColum = new Vector<String>();
	public Vector<String> userRow = new Vector<String>();
	// List<String> rowData = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public TicketList() {
		setLayout(null);

		t_pch_can = new JButton("\uCDE8\uC18C");
		t_pch_can.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		t_pch_can.setBackground(new Color(192, 192, 192));
		t_pch_can.setBounds(14, 336, 122, 52);
		add(t_pch_can);

		t_pch_accp = new JButton("\uACB0\uC81C");
		t_pch_accp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		t_pch_accp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		t_pch_accp.setBackground(new Color(65, 105, 225));
		t_pch_accp.setBounds(155, 336, 131, 52);
		add(t_pch_accp);

		panel = new JPanel();
		panel.setBounds(14, 287, 272, 38);
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		lblNewLabel = new JLabel("\uAE08\uC561 : ");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);

		t_price = new JLabel("");
		t_price.setHorizontalAlignment(SwingConstants.CENTER);
		t_price.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		panel.add(t_price);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 27, 272, 246);
		add(scrollPane);
		userColum.addElement("Ç×¸ñ");
		userColum.addElement("¼ö·®");
		userColum.addElement("°¡°Ý");
		model = new DefaultTableModel(userColum, 0);
		table = new JTable(model);
		// table.setBackground(UIManager.getColor("activeCaption"));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setRowSelectionAllowed(false);
		table.setDragEnabled(false);
		scrollPane.setViewportView(table);

	}
}
