package com.kitri.yeaha.chart.view;

import java.text.DecimalFormat;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class SalesMPieChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public SalesMPieChart() {
		setLayout(null);

		PieDataset dataset = createDataset();

		JFreeChart chart = ChartFactory.createPieChart("This Month Sales", dataset, true, true, false);

		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} : ({2})",
				new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 310, 215);
		add(panel);

	}

	private PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		ChartMainCont mc = new ChartMainCont();
		dataset.setValue("Food", mc.MonthSales().getAvg_01());
		dataset.setValue("Season Ticket", mc.MonthSales().getAvg_02());
		dataset.setValue("Day Ticket", mc.MonthSales().getAvg_03());

		return dataset;
	}

}
