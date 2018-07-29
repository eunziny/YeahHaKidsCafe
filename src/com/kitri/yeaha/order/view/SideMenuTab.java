package com.kitri.yeaha.order.view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kitri.yeaha.order.data.MenuAndCouponDao;

public class SideMenuTab extends JPanel {
	private JScrollPane scrollPane;
	public DefaultTableModel dm;
	public JTable sidetable;
	public String colName[] = { "메뉴이름", "가격" };
	public String sidemenu;
	public int sideprice;
	public int row;
	public int col;

	public SideMenuTab() {
		MenuAndCouponDao cd = new MenuAndCouponDao();
		setLayout(new BorderLayout(0, 0));
		dm = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		sidetable = new JTable(dm); // 메뉴테이블생성
		sidetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sidetable.setShowGrid(false);
		sidetable.setFillsViewportHeight(true);
		sidetable.getColumnModel().getColumn(0).setPreferredWidth(107);
		sidetable.getColumnModel().getColumn(1).setPreferredWidth(66);
		sidetable.getTableHeader().setReorderingAllowed(false);
		sidetable.getTableHeader().setResizingAllowed(false);
		sidetable.setRowHeight(25);
		scrollPane = new JScrollPane(sidetable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
		cd.getSideMenuname(dm);
		sidetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
