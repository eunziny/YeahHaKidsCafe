package com.kitri.yeaha.chart.view;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class CumulativeLine extends JPanel {

	/**
	 * Create the panel.
	 */
	public CumulativeLine() {
		setLayout(null);

		DefaultCategoryDataset dataset = createDataset();

		JFreeChart chart = ChartFactory.createLineChart("Cumulative Sales", "Date", "sales", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 410, 260);
		add(panel);

	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ChartMainCont mc = new ChartMainCont();
		for (int i = 0; i < mc.BeforeDays().size(); i++) {
			int sales = mc.WeekSales().get(i).getAvg_01() + mc.WeekSales().get(i).getAvg_02()
					+ mc.WeekSales().get(i).getAvg_03();
			dataset.addValue(sales, "Weekly Sales", mc.BeforeDays().get(i).getBefMonth());
		}
		return dataset;
	}

}
