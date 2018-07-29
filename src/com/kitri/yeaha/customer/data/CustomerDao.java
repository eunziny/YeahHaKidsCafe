package com.kitri.yeaha.customer.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.yeaha.customer.view.*;

public class CustomerDao {
	CustomerViewMain main;
	CustomerViewJoin join;
	CustomerViewModify modify;
	CustomerViewLogon logon;

	public void deleteCustomer(CustomerBean cb) {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = getDbCon();

		PreparedStatement pstmt = null;
		String sql = "Update customers set useyn = 'N' where c_id = ?";

		try {
			// conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cb.getC_ID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// conn.setAutoCommit(true);
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int addCustomer(CustomerBean cb) {

		Connection conn = null;
		conn = getDbCon();

		PreparedStatement pstmt = null;
		PreparedStatement pstmtDupl = null;
		String sqlDupl = "select c_id from customers where c_id = ?";
		String sql = "insert into customers(customer_number, c_id, c_password,parents_name,kids_name,kids_birthday,phone_number,remain_amount) values(SEQ_CUSTOMER_ID.NEXTVAL, "
				+ "?, ?, ?, ?, ?, ?,0)";
		int x = 0;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmtDupl = conn.prepareStatement(sqlDupl);
			pstmtDupl.setString(1, cb.getC_ID());
			boolean cntDupl = pstmtDupl.executeQuery().next();
			if (cntDupl == false) {
				pstmt.setString(1, cb.getC_ID());
				pstmt.setString(2, cb.getC_PassWord());
				pstmt.setString(3, cb.getParents_Name());
				pstmt.setString(4, cb.getKids_Name());
				pstmt.setString(5, cb.getKids_Birthday());
				pstmt.setString(6, cb.getPhone_Number());
				// pstmt.executeUpdate();
				int cnt = pstmt.executeUpdate();

				if (cnt >= 1) {
					conn.commit();
				} else {
					conn.rollback();
				}
				x = 1;
			} else {
				// System.out.println(" 다른 아이디를 사용하세요.");
				x = 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// conn.setAutoCommit(true);
				pstmt.close();
				pstmtDupl.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return x;
	}

	public int checkIdDuplicate(CustomerBean cb) {
		// TODO Auto-generated method stub

		Connection conn = null;
		conn = getDbCon();
		int x = 0;
		ResultSet rs = null;
		PreparedStatement pstmtDupl = null;
		String sqlDupl = "select c_id from customers where c_id = ?";
		try {
			conn.setAutoCommit(false);
			pstmtDupl = conn.prepareStatement(sqlDupl);
			pstmtDupl.setString(1, cb.getC_ID());
			rs = pstmtDupl.executeQuery();
			if (rs.next()) {
				x = 0;
			} else {
				x = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				pstmtDupl.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return x;
	}

	public CustomerBean loginIDCheck(CustomerBean cb) {
		Connection conn = null;
		conn = getDbCon();
		// String sql = "select c_id, c_password , remain_amount, parents_name \r\n" +
		// "from customers \r\n"
		// + "where c_id = ? and c_password = ? \r\n" ;
		String sql = "select customer_number, c_id, c_password, remain_amount, parents_name \r\n"
				+ "from customers \r\n" + "where c_id = ? and useyn = 'Y'\r\n";

		// String dbid = "";
		// String dbpasswd = "";
		// String t_Remain = "";
		// String dbparents = "";
		// int x = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// System.out.println(cb.getC_ID() + " " + cb.getC_PassWord());
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cb.getC_ID());
			// pstmt.setString(2, cb.getC_PassWord());
			// pstmt.setString(3, cb.getRemain_Amount());
			rs = pstmt.executeQuery();
			// pstmt.executeQuery();
			while (rs.next()) {
				// dbid = rs.getString("c_id");
				// dbpasswd = rs.getString("c_password");
				// t_Remain = rs.getString("remain_amount");
				// dbparents = rs.getString("parents_name");
				// cb.setC_ID(rs.getString(1));
				cb.setCustomer_number(rs.getInt(1));
				cb.setC_ID(rs.getString(2));
				cb.setC_PassWord(rs.getString(3));
				cb.setRemain_Amount(rs.getString(4));
				cb.setParents_Name(rs.getString(5));
				// System.out.println(" >>>>>>>>>>>>>>>>>>>>>>> " + rs.getString("c_password"));
				// x = 1;

			}
			// else {
			// x = 0;
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cb;
	}

	public Connection getDbCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.12.15:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			con = DriverManager.getConnection(url, id, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	} // getDBCon() 종료지점

	public CustomerBean getEachInfo(String c_id) {
		// TODO Auto-generated method stub
		Connection conn = getDbCon();
		String sql = "SELECT c_id, c_password, parents_name, kids_name, phone_number, TO_CHAR(kids_birthday, 'yyyy.mm.dd')\r\n"
				+ "from customers\r\n" + "where c_id = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerBean cb = new CustomerBean();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cb.setC_ID(rs.getString(1));
				cb.setC_PassWord(rs.getString(2));
				cb.setParents_Name(rs.getString(3));
				cb.setKids_Name(rs.getString(4));
				cb.setPhone_Number(rs.getString(5));
				cb.setKids_Birthday(rs.getString(6));
			}

			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cb;
	}

	public CustomerBean setNewInfo(CustomerBean mod_cb, String c_id) {
		// TODO Auto-generated method stub
		Connection conn = getDbCon();
		String sql = "Update customers \r\n"
				+ "set c_id = ?, c_password = ?, parents_name = ?, kids_name =?, phone_number = ?,  kids_birthday = TO_DATE(?, 'yyyy.mm.dd')"
				+ "where c_id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("1");
			pstmt.setString(1, mod_cb.getC_ID());
			pstmt.setString(2, mod_cb.getC_PassWord());
			pstmt.setString(3, mod_cb.getParents_Name());
			pstmt.setString(4, mod_cb.getKids_Name());
			pstmt.setString(5, mod_cb.getPhone_Number());
			pstmt.setString(6, mod_cb.getKids_Birthday());
			System.out.println(">>>>>mod_cb.getC_ID() " + mod_cb.getC_ID());
			pstmt.setString(7, c_id);

			System.out.println("++++++" + pstmt.executeUpdate());
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mod_cb;
	}

	// public CustomerBean setNewInfo(CustomerBean mod_cb, String c_id) {
	// // TODO Auto-generated method stub
	// Connection conn = getDbCon();
	// String sql = "Update customers \r\n"
	// + "set c_id = ?, c_password = ?, parents_name = ?, kids_name =?, phone_number
	// = ?, kids_birthday = ? "
	// + "where c_id = ?";
	// PreparedStatement pstmt = null;
	//
	// try {
	// pstmt = conn.prepareStatement(sql);
	// System.out.println("1");
	// pstmt.setString(1, mod_cb.getC_ID());
	// pstmt.setString(2, mod_cb.getC_PassWord());
	// pstmt.setString(3, mod_cb.getParents_Name());
	// pstmt.setString(4, mod_cb.getKids_Name());
	// pstmt.setString(5, mod_cb.getPhone_Number());
	// pstmt.setString(6, mod_cb.getKids_Birthday());
	// System.out.println(">>>>>mod_cb.getC_ID() " + mod_cb.getC_ID());
	// pstmt.setString(7, c_id);
	//
	// System.out.println("++++++" + pstmt.executeUpdate());
	// pstmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return mod_cb;
	// }

	public List<CustomerBean> getCouponInfo(String c_id) {
		// TODO Auto-generated method stub
		Connection conn = getDbCon();
		String sql = "select uc.coupon_number, c.coupon_name, c.discount_rate, TO_char(uc.start_date, 'yy/MM/DD'), to_char(uc.end_date, 'yy/MM/DD'), cu.customer_number\r\n"
				+ "from coupon c, use_coupon uc, customers cu\r\n" + "where c.coupon_type = uc.coupon_type\r\n"
				+ "and uc.customer_number = cu.customer_number\r\n" + "and cu.c_id = ? " + "and couponuseyn = 'Y'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CustomerBean> list = new ArrayList<CustomerBean>();
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("1");
			pstmt.setString(1, c_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerBean cb = new CustomerBean();
				cb.setCoupon_Number(rs.getInt(1));
				cb.setCoupon_Name(rs.getString(2));
				cb.setDiscount_Rate(rs.getInt(3));
				cb.setStart_Date(rs.getString(4));
				cb.setEnd_Date(rs.getString(5));
				cb.setCustomer_number(rs.getInt(6));

				list.add(cb);
				// cb.setToday_date(rs.getString(7));

				// if
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}