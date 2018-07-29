package com.kitri.yeaha.customer.view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UseDateTable extends JFrame {

	public String colName[] = { "입장시간", "퇴장시간" };
	public DefaultTableModel dm;
	public JPanel contentPane;
	public JTable usedatetable;

	public UseDateTable(UseDataView udv) {
		super("방문기록");
		setBounds(145, 355, 300, 400);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		dm = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		usedatetable = new JTable(dm);
		usedatetable.setEnabled(false);
		usedatetable.setRowSelectionAllowed(false);
		usedatetable.setShowGrid(false);
		usedatetable.setShowVerticalLines(false);
		usedatetable.setShowHorizontalLines(false);
		scrollPane.setViewportView(usedatetable);
		usedatetable.setRowHeight(25);
		usedatetable.getColumnModel().getColumn(0).setPreferredWidth(107);
		usedatetable.getColumnModel().getColumn(1).setPreferredWidth(66);
		usedatetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
}