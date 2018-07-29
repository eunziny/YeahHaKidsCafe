package com.kitri.yeaha.order.view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kitri.yeaha.order.data.MenuAndCouponDao;

public class MainMenuTab extends JPanel {
	public JScrollPane scrollPane;
	public DefaultTableModel dm;
	public JTable maintable;
	public String colName[] = { "메뉴이름", "가격" };
	public Object value;
	public int row = 0;
	public int col = 0;
	public int price = 0;
	public JButton inc;
	public JButton desc;
	public JButton del;
	public String menuname = "";

	public MainMenuTab() {
		MenuAndCouponDao cd = new MenuAndCouponDao();
		setLayout(new BorderLayout(0, 0));
		dm = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		maintable = new JTable(dm);
		maintable.setShowGrid(false);
		maintable.setFillsViewportHeight(true);
		maintable.getColumnModel().getColumn(0).setPreferredWidth(107);
		maintable.getColumnModel().getColumn(1).setPreferredWidth(66);
		maintable.getTableHeader().setReorderingAllowed(false);
		maintable.getTableHeader().setResizingAllowed(false);
		maintable.setRowHeight(25);
		scrollPane = new JScrollPane(maintable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
		cd.getMainMenuname(dm);
		maintable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
