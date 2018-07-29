package com.kitri.yeaha.chart.view;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class VisitorChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public VisitorChart() {
		setLayout(null);

		// dataset 만들기
		XYDataset dataset = createDataset();

		// chart 만들기
		JFreeChart chart = ChartFactory.createXYLineChart("Today's Number of Visitors", "time", "visitors", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 310, 220);
		add(panel);
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("visitor");
		ChartMainCont mc = new ChartMainCont();
		series.add(10, mc.VisitorNum().getCnt_01());
		series.add(11, mc.VisitorNum().getCnt_02());
		series.add(12, mc.VisitorNum().getCnt_03());
		series.add(13, mc.VisitorNum().getCnt_04());
		series.add(14, mc.VisitorNum().getCnt_05());
		series.add(15, mc.VisitorNum().getCnt_06());
		series.add(16, mc.VisitorNum().getCnt_07());
		series.add(17, mc.VisitorNum().getCnt_08());
		series.add(18, mc.VisitorNum().getCnt_09());
		series.add(19, mc.VisitorNum().getCnt_10());
		series.add(20, mc.VisitorNum().getCnt_11());
		series.add(21, mc.VisitorNum().getCnt_12());
		series.add(22, mc.VisitorNum().getCnt_13());

		dataset.addSeries(series);
		return dataset;
	}

}
