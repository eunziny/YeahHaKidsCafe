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

public class SalesPieChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public SalesPieChart() {
		setLayout(null);

		PieDataset dataset = createDataset();

		JFreeChart chart = ChartFactory.createPieChart("Today's Sales", dataset, true, true, false);

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
		dataset.setValue("Food", mc.DaySales().getFood_sales());
		dataset.setValue("Season Ticket", mc.DaySales().getTicket_sales());
		dataset.setValue("Day Ticket", mc.DaySales().getD_ticket_sales());

		return dataset;
	}

}
