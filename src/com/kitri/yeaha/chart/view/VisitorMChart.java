package com.kitri.yeaha.chart.view;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class VisitorMChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public VisitorMChart() {
		setLayout(null);

		// dataset 만들기
		XYDataset dataset = createDataset();

		// chart 만들기
		JFreeChart chart = ChartFactory.createXYLineChart("Average Number of Visitors", "time", "visitors", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		setLayout(null);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 310, 220);
		add(panel);
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("visitor");
		ChartMainCont mc = new ChartMainCont();
		series.add(10, mc.MonthVisitor().getCnt_01());
		series.add(11, mc.MonthVisitor().getCnt_02());
		series.add(12, mc.MonthVisitor().getCnt_03());
		series.add(13, mc.MonthVisitor().getCnt_04());
		series.add(14, mc.MonthVisitor().getCnt_05());
		series.add(15, mc.MonthVisitor().getCnt_06());
		series.add(16, mc.MonthVisitor().getCnt_07());
		series.add(17, mc.MonthVisitor().getCnt_08());
		series.add(18, mc.MonthVisitor().getCnt_09());
		series.add(19, mc.MonthVisitor().getCnt_10());
		series.add(20, mc.MonthVisitor().getCnt_11());
		series.add(21, mc.MonthVisitor().getCnt_12());
		series.add(22, mc.MonthVisitor().getCnt_13());

		dataset.addSeries(series);
		return dataset;
	}

}
