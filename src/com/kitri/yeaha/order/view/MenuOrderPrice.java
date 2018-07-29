package com.kitri.yeaha.order.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuOrderPrice extends JPanel {
	public JPanel panel;
	public JTabbedPane menutab;
	public JPanel panel_1;
	public JButton rbtn;
	public JButton lbtn;
	public String menuname;
	public int price;
	public JLabel totalprice2;
	public JLabel totalprice;
	public MainMenuTab mmt = new MainMenuTab();
	public SideMenuTab smt = new SideMenuTab();
	public DrinkMenuTab dmt = new DrinkMenuTab();
	public JPanel panel_2;
	public JScrollPane scrollPane;
	public JTable choicetable;
	public JPanel panel_3;
	public JButton pricecancel;
	public JButton pay;
	public DefaultTableModel dm;
	public JButton del;
	public JButton inc;
	public JButton desc;
	public JButton up;
	public JButton down;
	public int t_price;
	public int t_price_count;
	public int menuprice;
	public int row;
	public int col;
	public int account;
	public JLabel imgbox;
	public Object inputObj[] = new Object[3];
	public JLabel imageL;
	public String colName[] = { "메뉴이름", "수량", "가격" };
	public Object contents[][] = {};
	public JPanel menuimage_p2;
	public JPanel menuimage_p;
	public String menuimg;
	public TotalPayView tp;

	/**
	 * Create the panel.
	 */

	public MenuOrderPrice() {

		setLayout(null);
		dm = new DefaultTableModel(contents, colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		choicetable = new JTable(dm);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(34, 38, 320, 237);
		add(panel);

		menutab = new JTabbedPane(JTabbedPane.TOP);
		menutab.setBounds(14, 25, 292, 200);
		panel.add(menutab);
		menutab.add("메인", mmt);
		menutab.add("사이드", smt);
		menutab.add("음료", dmt);

		panel_1 = new JPanel();
		panel_1.setBounds(438, 38, 320, 440);
		add(panel_1);
		panel_1.setLayout(null);

		choicetable.getColumnModel().getColumn(0).setPreferredWidth(100);
		choicetable.getColumnModel().getColumn(1).setPreferredWidth(48);
		choicetable.getColumnModel().getColumn(1).setMinWidth(50);
		choicetable.getColumnModel().getColumn(2).setPreferredWidth(64);
		choicetable.getTableHeader().setReorderingAllowed(false);
		choicetable.getTableHeader().setResizingAllowed(false);
		choicetable.setRowHeight(30);
		choicetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		choicetable.setShowGrid(false);
		choicetable.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(choicetable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 320, 236);

		panel_1.add(scrollPane);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 237, 320, 203);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 4, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));

		totalprice = new JLabel("총 결제 금액");
		panel_4.add(totalprice);

		totalprice2 = new JLabel("0");
		panel_4.add(totalprice2);

		panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));

		pricecancel = new JButton("\uC8FC\uBB38\uCDE8\uC18C");
		pricecancel.setForeground(Color.LIGHT_GRAY);
		pricecancel.setFont(new Font("굴림", Font.PLAIN, 20));
		panel_3.add(pricecancel);

		pay = new JButton("\uACB0\uC81C");
		pay.setForeground(Color.BLUE);
		pay.setFont(new Font("굴림", Font.PLAIN, 20));
		panel_3.add(pay);

		rbtn = new JButton("\uCD94\uAC00");
		rbtn.setFont(new Font("굴림", Font.PLAIN, 13));
		rbtn.setBounds(356, 151, 68, 45);
		add(rbtn);

		lbtn = new JButton("\uC0AD\uC81C");
		lbtn.setFont(new Font("굴림", Font.PLAIN, 13));
		lbtn.setBounds(356, 301, 68, 45);
		add(lbtn);

		inc = new JButton("+");
		panel_5.add(inc);

		desc = new JButton("-");
		panel_5.add(desc);

		up = new JButton("\u25B2");
		panel_5.add(up);

		down = new JButton("\u25BC");
		panel_5.add(down);

		menuimage_p2 = new JPanel();
		menuimage_p = new JPanel();
		menuimage_p.setBounds(34, 274, 320, 204);
		add(menuimage_p);
		tp = new TotalPayView(this);
	}

	public int show_t_price() {
		t_price_count = dm.getRowCount();
		t_price = 0;
		for (int i = 0; i < t_price_count; i++) {
			t_price += Integer.parseInt(choicetable.getValueAt(i, 2).toString().replaceAll(",", ""));
		}
		return t_price;
	}

}
