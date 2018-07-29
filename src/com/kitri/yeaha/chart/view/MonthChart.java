package com.kitri.yeaha.chart.view;

import java.awt.*;

import javax.swing.*;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class MonthChart extends JPanel {
	private JLabel saleL = new JLabel("매출", JLabel.CENTER);
	public JLabel dayTicket;
	public JLabel dayTSale;
	public JLabel seasonTicket;
	public JLabel seasonTSale;
	public JLabel meals;
	public JLabel mealsSale;
	public JPanel p2;
	public JPanel p3;
	public JPanel p4;
	public JLabel presentL;
	public JLabel presentSale;
	public JLabel lastMonL;
	public JLabel lastMonSale;
	public JPanel pChart1;
	public JPanel pChart2;
	public JPanel pChart3;
	public JButton newBtn;

	VisitorMChart vMLine = new VisitorMChart();
	SalesBarChart sBar = new SalesBarChart();
	SalesMPieChart sMPie = new SalesMPieChart();
	ChartMainCont mc = new ChartMainCont();

	/**
	 * Create the panel.
	 */
	public MonthChart() {
		setBackground(Color.ORANGE);
		setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBounds(10, 10, 200, 150);
		add(p1);
		p1.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		p1.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));

		panel_1.add(new JLabel(""));
		panel_1.add(saleL);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		p1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 0, 0));

		dayTicket = new JLabel("일일권", JLabel.CENTER);
		panel_2.add(dayTicket);

		dayTSale = new JLabel();
		dayTSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(dayTSale);
		dayTSale.setText(String.format("%,d", mc.DayTicketMSales().getAvg_01()));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		p1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));

		seasonTicket = new JLabel("정기권", JLabel.CENTER);
		panel_3.add(seasonTicket);

		seasonTSale = new JLabel();
		seasonTSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(seasonTSale);
		seasonTSale.setText(String.format("%,d", mc.TicketMSales().getAvg_02()));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		p1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));

		meals = new JLabel("식당", JLabel.CENTER);
		panel_4.add(meals);

		mealsSale = new JLabel();
		mealsSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(mealsSale);
		mealsSale.setText(String.format("%,d", mc.FoodMSales().getAvg_03()));

		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setBounds(220, 12, 200, 113);
		add(p2);
		p2.setLayout(new GridLayout(3, 1, 0, 0));

		p2.add(new JLabel("전월대비 매출현황", JLabel.CENTER));

		p3 = new JPanel();
		p3.setBackground(Color.WHITE);
		p2.add(p3);
		p3.setLayout(new GridLayout(1, 2, 0, 0));

		presentL = new JLabel("현재", JLabel.CENTER);
		p3.add(presentL);

		presentSale = new JLabel();
		presentSale.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(presentSale); // ******************
		int preSale = mc.MonthSales().getAvg_01() + mc.MonthSales().getAvg_02() + mc.MonthSales().getAvg_03();
		presentSale.setText(String.format("%,d", preSale));

		p4 = new JPanel();
		p4.setBackground(Color.WHITE);
		p2.add(p4);
		p4.setLayout(new GridLayout(1, 2, 0, 0));

		lastMonL = new JLabel();
		lastMonL.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(lastMonL);
		lastMonL.setText(mc.LastMonth().getBefMonth());

		lastMonSale = new JLabel();
		lastMonSale.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(lastMonSale); // ********************
		int lastSale = mc.LastMonthSales().getAvg_01() + mc.LastMonthSales().getAvg_02()
				+ mc.LastMonthSales().getAvg_03();
		lastMonSale.setText(String.format("%,d", lastSale));

		pChart1 = new JPanel();
		pChart1.setBounds(430, 10, 310, 220);
		add(pChart1);
		pChart1.setLayout(new BorderLayout(0, 0));
		pChart1.add("Center", vMLine);

		pChart2 = new JPanel();
		pChart2.setBounds(10, 190, 410, 260);
		add(pChart2);
		pChart2.setLayout(new BorderLayout(0, 0));
		pChart2.add("Center", sBar);

		pChart3 = new JPanel();
		pChart3.setBounds(430, 235, 310, 215);
		add(pChart3);
		pChart3.setLayout(new BorderLayout(0, 0));
		pChart3.add("Center", sMPie);

		newBtn = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		newBtn.setBounds(220, 133, 200, 27);
		add(newBtn);

	}

}