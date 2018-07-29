package com.kitri.yeaha.order.view;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kitri.yeaha.order.data.MenuAndCouponDao;

public class DrinkMenuTab extends JPanel {
	private JScrollPane scrollPane;
	public DefaultTableModel dm;
	public JTable drinktable;
	public String drinkmenu;
	public int drinkprice;
	public int row;
	public String colName[] = { "메뉴이름", "가격" };

	public DrinkMenuTab() {
		MenuAndCouponDao cd = new MenuAndCouponDao();
		setLayout(new BorderLayout(0, 0));
		dm = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		drinktable = new JTable(dm); // 메뉴테이블생성

		drinktable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		drinktable.setShowGrid(false);
		drinktable.setFillsViewportHeight(true);
		drinktable.getColumnModel().getColumn(0).setPreferredWidth(107);
		drinktable.getColumnModel().getColumn(1).setPreferredWidth(66);
		drinktable.setRowHeight(30);
		drinktable.getTableHeader().setReorderingAllowed(false);
		drinktable.getTableHeader().setResizingAllowed(false);
		scrollPane = new JScrollPane(drinktable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
		cd.getDrinkMenuname(dm);
		drinktable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
