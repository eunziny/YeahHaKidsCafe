package com.kitri.yeaha.manager.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YeahhaDao {

	public List<YeahhaBean> getAllInfo() {

		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<YeahhaBean> list = new ArrayList<YeahhaBean>();

		return list;
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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void addYeahha(YeahhaBean yb) {
		Connection con = null;
		con = getDbCon();
		PreparedStatement pstmt = null;
		String sql = "insert into menu(menu_id,categorys,menu_name,price,useyn) values (SEQ_MENU_ID.nextval,?,?,?,'Y')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, yb.getCategorys());
			pstmt.setString(2, yb.getMenu_name());
			pstmt.setInt(3, yb.getPrice());

			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<YeahhaBean> getMenuInfo() {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select menu_name " + "from menu where useyn='Y'";
		List<YeahhaBean> list = new ArrayList<YeahhaBean>();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				YeahhaBean yb = new YeahhaBean();
				yb.setMenu_name(rs.getString(1));
				list.add(yb);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delYeahha(String yb) {
		Connection con = null;
		con = getDbCon();
		PreparedStatement pstmt = null;
		String sql = "update menu set useyn='N' where menu_name = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, yb);

			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public CustoInfoBean getEachInfo(String fullnum) {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustoInfoBean cb = new CustoInfoBean();
		String sql = "select customer_number, parents_name, kids_name, phone_number\r\n" + "from customers\r\n"
				+ "where phone_number = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fullnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cb.setCustomer_number(rs.getInt(1));
				cb.setParents_name(rs.getString(2));
				cb.setKids_name(rs.getString(3));
				cb.setPhone_number(rs.getString(4));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;

	}

	public int loginCheck(String fullnum) {
		Connection con = getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustoInfoBean cb = new CustoInfoBean();
		int x = 0;
		String sql = "select phone_number\r\n" + "from customers\r\n" + "where phone_number = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fullnum);
			rs = pstmt.executeQuery();
			if (fullnum.isEmpty()) {
				x = 2;
			} else if (rs.next()) {
				cb.setPhone_number(rs.getString(1));
				if (fullnum.equals(rs.getString("phone_number"))) {
					x = 1;
				} else {
					x = 0;
				}
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;

	}

	public void setIntime(int customer_number) {
		Connection conn = getDbCon();
		PreparedStatement pstmt = null;
		String sql = "insert into visit_history (customer_number,visit_date,in_time) " + "values (?,sysdate,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setOutTime(int customer_number) {
		Connection conn = getDbCon();
		PreparedStatement pstmt = null;
		String sql = "update visit_history set out_time = sysdate where customer_number = ? and out_time is null "
				+ "and to_char(sysdate,'yymmdd') = to_char(sysdate,'yymmdd')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
