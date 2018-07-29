package com.kitri.yeaha.kitchen.data;

import java.util.List;

import com.kitri.yeaha.manager.data.*;

public class ChartMainCont {

	// YeahHaMain yeahhaMain;
	//
	// public ChartMainCont(YeahHaMain yeahhaMain) {
	// this.yeahhaMain = yeahhaMain;
	// }

	public ChartCountDto VisitorNum() {

		ChartDao cd = new ChartDao();
		ChartCountDto ccd = cd.getDayVisitInfo();

		return ccd;
	} // VisitorNum() 종료지점

	public ChartCountDto MonthVisitor() {
		ChartDao cd = new ChartDao();
		ChartCountDto ccd = cd.getMonthVisitInfo();

		return ccd;
	}

	public ChartSalesDto DaySales() {
		ChartDao cd = new ChartDao();
		ChartSalesDto csd = cd.getDaySalesInfo();

		return csd;
	}

	public SalesAvgDto MonthSales() {
		ChartDao cd = new ChartDao();
		SalesAvgDto sad = cd.getMonthSalesInfo();

		return sad;
	}

	public ChartSalesDto DayTicketSales() {
		ChartDao cd = new ChartDao();
		ChartSalesDto csd = cd.getDayTicketInfo();

		return csd;
	}

	public ChartSalesDto TicketSales() {
		ChartDao cd = new ChartDao();
		ChartSalesDto csd = cd.getTicketInfo();

		return csd;
	}

	public ChartSalesDto FoodSales() {
		ChartDao cd = new ChartDao();
		ChartSalesDto csd = cd.getFoodInfo();

		return csd;
	}

	public SalesAvgDto DayTicketMSales() {
		ChartDao cd = new ChartDao();
		SalesAvgDto sad = cd.getDayTicketMInfo();

		return sad;
	}

	public SalesAvgDto TicketMSales() {
		ChartDao cd = new ChartDao();
		SalesAvgDto sad = cd.getTicketMInfo();

		return sad;
	}

	public SalesAvgDto FoodMSales() {
		ChartDao cd = new ChartDao();
		SalesAvgDto sad = cd.getFoodMInfo();

		return sad;
	}

	public SalesAvgDto LastMonth() {
		ChartDao cd = new ChartDao();
		SalesAvgDto sad = cd.getMonthInfo();

		return sad;
	}

	public SalesAvgDto LastMonthSales() {
		ChartDao cd = new ChartDao();
		SalesAvgDto sad = cd.getLastMonthSalesInfo();

		return sad;
	}

	public ChartCountDto TodayVisitor() {
		ChartDao cd = new ChartDao();
		ChartCountDto ccd = cd.getTodayVisitorInfo();

		return ccd;
	}

	public List<SalesAvgDto> BeforeMonth() {
		ChartDao cd = new ChartDao();
		List<SalesAvgDto> allMon = cd.getMonthsInfo();

		return allMon;
	}

	public List<SalesAvgDto> MonthlySales() {
		ChartDao cd = new ChartDao();
		List<SalesAvgDto> allMon = cd.getAllSalesInfo();

		return allMon;
	}

	public List<SalesAvgDto> BeforeDays() {
		ChartDao cd = new ChartDao();
		List<SalesAvgDto> allDay = cd.getDaysInfo();

		return allDay;
	}

	public List<SalesAvgDto> WeekSales() {
		ChartDao cd = new ChartDao();
		List<SalesAvgDto> allDay = cd.getWeekSalesInfo();

		return allDay;
	}
}
