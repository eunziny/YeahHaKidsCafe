package com.kitri.yeaha.order.data;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class MenuAndCouponDao {

	public CouponBean getCouponInfo(String couponnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CouponBean cb = new CouponBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.12.15:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			String sql = "select coupon_number, customer_number, coupon_type, start_date, end_date,couponuseyn\r\n"
					+ "from use_coupon \r\n" + "where coupon_number = ? AND couponuseyn = 'Y'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(couponnum));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cb.setCoupon_number(Integer.parseInt(rs.getString(1)));
				cb.setCustomer_number(Integer.parseInt(rs.getString(2)));
				cb.setCoupon_type(Integer.parseInt(rs.getString(3)));
				cb.setStart_date(rs.getString(4));
				cb.setEnd_date(rs.getString(5));
				cb.setCouponuseyn(rs.getString(6));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cb;
	}

	public CTypeBean getdiscout_rateinfo(int coupontype) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CTypeBean ctb = new CTypeBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			String sql = "select coupon_type,coupon_name,discount_rate\r\n" + "from coupon\r\n"
					+ "where coupon_type = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, coupontype);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ctb.setCoupon_type(Integer.parseInt(rs.getString(1)));
				ctb.setCoupon_name(rs.getString(2));
				ctb.setDiscount_rate(Integer.parseInt(rs.getString(3)));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ctb;
	}

	public void UseCouponInfo(String couponnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			String sql = "update use_coupon set couponuseyn ='N' where coupon_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(couponnum));
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public DefaultTableModel getMainMenuname(DefaultTableModel dm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			String sql = "SELECT MENU_NAME, PRICE FROM MENU where categorys = 1 AND useyn='Y'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dm.addRow(new Object[] { rs.getString(1), String.format("%,d", rs.getInt(2)) });
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dm;
	}

	public DefaultTableModel getDrinkMenuname(DefaultTableModel dm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			String sql = "SELECT MENU_NAME, PRICE FROM MENU where categorys = 3 AND useyn='Y'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dm.addRow(new Object[] { rs.getString(1), String.format("%,d", rs.getInt(2)) });
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dm;
	}

	public DefaultTableModel getSideMenuname(DefaultTableModel dm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
			String sql = "SELECT MENU_NAME, PRICE FROM MENU where categorys = 2 AND useyn='Y'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dm.addRow(new Object[] { rs.getString(1), String.format("%,d", rs.getInt(2)) });
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dm;
	}
}