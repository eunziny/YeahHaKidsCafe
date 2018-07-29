package com.kitri.yeaha.chart.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class Chartmain extends JPanel {
	private JTabbedPane tabbedPane;
	public DayChart dc = new DayChart();
	public MonthChart mc = new MonthChart();

	/**
	 * Create the panel.
	 */
	public Chartmain() {
		setBackground(Color.ORANGE);
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(8, 12, 755, 488);
		add(tabbedPane);
		dc.pChart1.setBounds(430, 10, 310, 220);
		dc.pChart3.setBounds(430, 235, 310, 215);
		tabbedPane.addTab("  일별   ", dc);
		mc.p2.setLocation(220, 10);
		mc.pChart1.setLocation(430, 10);
		mc.pChart1.setSize(310, 220);
		mc.pChart2.setLocation(10, 190);
		mc.pChart2.setSize(410, 260);
		mc.pChart3.setLocation(430, 235);
		mc.pChart3.setSize(310, 215);
		tabbedPane.addTab("  월별   ", mc);

	}

}
