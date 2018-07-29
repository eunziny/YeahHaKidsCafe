package com.kitri.yeaha.chart.view;

import java.awt.*;

import javax.swing.*;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class DayChart extends JPanel {
	private JLabel saleL = new JLabel("매출", JLabel.CENTER);
	public JLabel dayTicket;
	public JLabel dayTSale;
	public JLabel seasonTicket;
	public JLabel seasonTSale;
	public JLabel meals;
	public JLabel mealsSale;
	public JPanel p2;
	public JLabel dayVisitMemL;
	public JLabel dayVisitMem;
	public JLabel dayAllMoney;
	public JPanel pChart1;
	public JPanel pChart2;
	public JPanel pChart3;
	public JButton newBtn;

	VisitorChart vLine = new VisitorChart();
	CumulativeLine sLine = new CumulativeLine();
	SalesPieChart sPie = new SalesPieChart();
	ChartMainCont mc = new ChartMainCont();

	/**
	 * Create the panel.
	 */
	public DayChart() {
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
		dayTSale.setText(String.format("%,d", mc.DayTicketSales().getD_ticket_sales()));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		p1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));

		seasonTicket = new JLabel("정기권", JLabel.CENTER);
		panel_3.add(seasonTicket);

		seasonTSale = new JLabel("");
		seasonTSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(seasonTSale);
		seasonTSale.setText(String.format("%,d", mc.TicketSales().getTicket_sales()));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		p1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));

		meals = new JLabel("식당", JLabel.CENTER);
		panel_4.add(meals);

		mealsSale = new JLabel("");
		mealsSale.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(mealsSale);
		mealsSale.setText(String.format("%,d", mc.FoodSales().getFood_sales()));

		p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setBounds(220, 12, 200, 113);
		add(p2);
		p2.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel p2_2 = new JPanel();
		p2_2.setBackground(Color.WHITE);
		p2.add(p2_2);
		p2_2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

		dayVisitMemL = new JLabel("\uAE08\uC77C \uBC29\uBB38 \uACE0\uAC1D");
		p2_2.add(dayVisitMemL);

		dayVisitMem = new JLabel("");
		p2_2.add(dayVisitMem);
		dayVisitMem.updateUI();
		dayVisitMem.setText(mc.TodayVisitor().getCnt_01() + "");

		JLabel dayAllSale = new JLabel("금일 매출", JLabel.CENTER);
		p2.add(dayAllSale);

		dayAllMoney = new JLabel();
		dayAllMoney.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(dayAllMoney);
		int daySale = mc.DaySales().getD_ticket_sales() + mc.DaySales().getTicket_sales()
				+ mc.DaySales().getFood_sales();
		dayAllMoney.setText(String.format("%,d", daySale));

		pChart1 = new JPanel();
		pChart1.setBounds(430, 10, 310, 220);
		add(pChart1);
		pChart1.setLayout(new BorderLayout(0, 0));
		pChart1.add("Center", vLine);

		pChart2 = new JPanel();
		pChart2.setBounds(10, 190, 410, 260);
		add(pChart2);
		pChart2.setLayout(new BorderLayout());
		pChart2.add("Center", sLine);

		pChart3 = new JPanel();
		pChart3.setBounds(430, 235, 310, 215);
		add(pChart3);
		pChart3.setLayout(new BorderLayout());
		pChart3.add("Center", sPie);

		newBtn = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		newBtn.setBounds(220, 133, 200, 27);
		add(newBtn);

	}
}