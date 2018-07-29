package com.kitri.yeaha.manager.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChartDao {

	public Connection getDbCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.12.15:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			con = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}// getDbCon() 종료지점

	public ChartCountDto getDayVisitInfo() {

		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartCountDto ccd = new ChartCountDto();
		String sql = "select COUNT(decode(TO_CHAR(IN_TIME,'hh24'),10,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),11,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),12,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),13,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),14,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),15,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),16,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),17,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),18,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),19,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),20,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),21,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),22,1))"
				+ "from visit_history "
				// + "where visit_date = '18/03/28'"
				+ "where TO_CHAR(visit_date, 'yyyy/mm/dd') = TO_CHAR(sysdate, 'yyyy/mm/dd')";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ccd.setCnt_01(rs.getInt(1));
				ccd.setCnt_02(rs.getInt(2));
				ccd.setCnt_03(rs.getInt(3));
				ccd.setCnt_04(rs.getInt(4));
				ccd.setCnt_05(rs.getInt(5));
				ccd.setCnt_06(rs.getInt(6));
				ccd.setCnt_07(rs.getInt(7));
				ccd.setCnt_08(rs.getInt(8));
				ccd.setCnt_09(rs.getInt(9));
				ccd.setCnt_10(rs.getInt(10));
				ccd.setCnt_11(rs.getInt(11));
				ccd.setCnt_12(rs.getInt(12));
				ccd.setCnt_13(rs.getInt(13));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ccd;

	}

	public ChartCountDto getMonthVisitInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartCountDto ccd = new ChartCountDto();
		String sql = "select COUNT(decode(TO_CHAR(IN_TIME,'hh24'),10,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),11,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),12,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),13,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),14,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),15,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),16,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),17,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),18,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),19,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),20,1)), "
				+ "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),21,1)), " + "COUNT(decode(TO_CHAR(IN_TIME,'hh24'),22,1))"
				+ "from visit_history "
				// + "where TO_CHAR(visit_date, 'yyyy/mm') = '2018/03'";
				+ "where TO_CHAR(visit_date, 'yyyy/mm') = TO_CHAR(sysdate, 'yyyy/mm')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ccd.setCnt_01(rs.getInt(1));
				ccd.setCnt_02(rs.getInt(2));
				ccd.setCnt_03(rs.getInt(3));
				ccd.setCnt_04(rs.getInt(4));
				ccd.setCnt_05(rs.getInt(5));
				ccd.setCnt_06(rs.getInt(6));
				ccd.setCnt_07(rs.getInt(7));
				ccd.setCnt_08(rs.getInt(8));
				ccd.setCnt_09(rs.getInt(9));
				ccd.setCnt_10(rs.getInt(10));
				ccd.setCnt_11(rs.getInt(11));
				ccd.setCnt_12(rs.getInt(12));
				ccd.setCnt_13(rs.getInt(13));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ccd;
	}

	public ChartSalesDto getDaySalesInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartSalesDto csd = new ChartSalesDto();
		String sql = "select food_sales, ticket_sales, d_ticket_sales\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm/dd') = TO_CHAR(sysdate, 'yyyy/mm/dd')";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				csd.setFood_sales(rs.getInt(1));
				csd.setTicket_sales(rs.getInt(2));
				csd.setD_ticket_sales(rs.getInt(3));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return csd;
	}

	public SalesAvgDto getMonthSalesInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesAvgDto sad = new SalesAvgDto();
		String sql = "select SUM(food_sales), SUM(ticket_sales), SUM(d_ticket_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm') = TO_CHAR(sysdate, 'yyyy/mm')";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sad.setAvg_01(rs.getInt(1));
				sad.setAvg_02(rs.getInt(2));
				sad.setAvg_03(rs.getInt(3));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sad;
	}

	public ChartSalesDto getDayTicketInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartSalesDto csd = new ChartSalesDto();
		String sql = "select d_ticket_sales\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm/dd') = TO_CHAR(sysdate, 'yyyy/mm/dd')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				csd.setD_ticket_sales(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return csd;
	}

	public ChartSalesDto getTicketInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartSalesDto csd = new ChartSalesDto();
		String sql = "select ticket_sales\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm/dd') = TO_CHAR(sysdate, 'yyyy/mm/dd')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				csd.setTicket_sales(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return csd;
	}

	public ChartSalesDto getFoodInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartSalesDto csd = new ChartSalesDto();
		String sql = "select food_sales\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm/dd') = TO_CHAR(sysdate, 'yyyy/mm/dd')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				csd.setFood_sales(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return csd;
	}

	public SalesAvgDto getDayTicketMInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesAvgDto sad = new SalesAvgDto();
		String sql = "select SUM(d_ticket_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm') = TO_CHAR(sysdate, 'yyyy/mm')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sad.setAvg_01((rs.getInt(1)));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sad;
	}

	public SalesAvgDto getTicketMInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesAvgDto sad = new SalesAvgDto();
		String sql = "select SUM(ticket_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm') = TO_CHAR(sysdate, 'yyyy/mm')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sad.setAvg_02((rs.getInt(1)));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sad;
	}

	public SalesAvgDto getFoodMInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesAvgDto sad = new SalesAvgDto();
		String sql = "select SUM(food_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm') = TO_CHAR(sysdate, 'yyyy/mm')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sad.setAvg_03((rs.getInt(1)));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sad;
	}

	public SalesAvgDto getMonthInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesAvgDto sad = new SalesAvgDto();
		String sql = "select TO_CHAR(add_months(sysdate, -1), 'yyyy/mm') from dual";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sad.setBefMonth(rs.getString(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sad;
	}

	public SalesAvgDto getLastMonthSalesInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesAvgDto sad = new SalesAvgDto();
		String sql = "select SUM(food_sales), SUM(ticket_sales), SUM(d_ticket_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm') = TO_CHAR(add_months(sysdate, -1), 'yyyy/mm')";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sad.setAvg_01(rs.getInt(1));
				sad.setAvg_02(rs.getInt(2));
				sad.setAvg_03(rs.getInt(3));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sad;
	}

	public ChartCountDto getTodayVisitorInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ChartCountDto ccd = new ChartCountDto();
		String sql = "select COUNT(customer_number)\r\n" + "from visit_history "
		// + "where visit_date = '18/03/28'";
				+ "where TO_CHAR(visit_date, 'yyyy/mm/dd') = TO_CHAR(sysdate, 'yyyy/mm/dd')";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ccd.setCnt_01(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ccd;
	}

	public List<SalesAvgDto> getMonthsInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SalesAvgDto> list = new ArrayList<SalesAvgDto>();
		String sql = "select TO_CHAR(add_months(sysdate, ?), 'yyyy/mm') from dual";
		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i > -4; i--) {
				pstmt.setInt(1, i);
				rs = pstmt.executeQuery();
				rs.next();
				SalesAvgDto sad = new SalesAvgDto();
				sad.setBefMonth(rs.getString(1));
				list.add(sad);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<SalesAvgDto> getAllSalesInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SalesAvgDto> list = new ArrayList<SalesAvgDto>();
		String sql = "select SUM(food_sales), SUM(ticket_sales), SUM(d_ticket_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm') = TO_CHAR(add_months(sysdate, ?), 'yyyy/mm')";

		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i > -4; i--) {
				pstmt.setInt(1, i);
				rs = pstmt.executeQuery();
				rs.next();
				SalesAvgDto sad = new SalesAvgDto();
				sad.setAvg_01(rs.getInt(1));
				sad.setAvg_02(rs.getInt(2));
				sad.setAvg_03(rs.getInt(3));
				list.add(sad);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<SalesAvgDto> getDaysInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SalesAvgDto> list = new ArrayList<SalesAvgDto>();
		String sql = "select TO_CHAR((sysdate - ?), 'mm/dd') from dual";
		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 6; i > -1; i--) {
				pstmt.setInt(1, i);
				rs = pstmt.executeQuery();
				rs.next();
				SalesAvgDto sad = new SalesAvgDto();
				sad.setBefMonth(rs.getString(1));
				list.add(sad);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<SalesAvgDto> getWeekSalesInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SalesAvgDto> list = new ArrayList<SalesAvgDto>();
		String sql = "select SUM(food_sales), SUM(ticket_sales), SUM(d_ticket_sales)\r\n" + "from sales\r\n"
				+ "where TO_CHAR(sales_date, 'yyyy/mm/dd') = TO_CHAR((sysdate - ?), 'yyyy/mm/dd')";

		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 6; i > -1; i--) {
				pstmt.setInt(1, i);
				rs = pstmt.executeQuery();
				rs.next();
				SalesAvgDto sad = new SalesAvgDto();
				sad.setAvg_01(rs.getInt(1));
				sad.setAvg_02(rs.getInt(2));
				sad.setAvg_03(rs.getInt(3));
				list.add(sad);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
