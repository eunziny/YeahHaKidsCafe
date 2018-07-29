package com.kitri.yeaha.chart.view;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kitri.yeaha.kitchen.data.ChartMainCont;

public class SalesBarChart extends JPanel {

	/**
	 * Create the panel.
	 */
	public SalesBarChart() {
		setLayout(null);

		JFreeChart chart = ChartFactory.createBarChart("Monthly Sales", "Category", "Sales", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBounds(0, 0, 410, 260);
		add(panel);
	}

	private CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ChartMainCont mc = new ChartMainCont();
		for (int i = 0; i < mc.BeforeMonth().size(); i++) {
			int sales = mc.MonthlySales().get(i).getAvg_01() + mc.MonthlySales().get(i).getAvg_02()
					+ mc.MonthlySales().get(i).getAvg_03();
			dataset.addValue(sales, "Monthly Sales", mc.BeforeMonth().get(i).getBefMonth());
		}
		return dataset;
	}

}
