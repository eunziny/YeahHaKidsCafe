package com.kitri.yeaha.manager.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.yeaha.manager.service.ManagerService;

public class YeHaTicketDao {
	List<String> cpnumlist = new ArrayList<String>();

	// List<CouponDto> cplist = new ArrayList<CouponDto>();

	public YeHaTicketDao() {
		// TODO Auto-generated constructor stub
	}

	public List<TicketDto> tickType() {
		List<TicketDto> tklist = new ArrayList<TicketDto>();
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ticket";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TicketDto t = new TicketDto();
				t.setTicket_type(rs.getInt(1));
				t.setTicket_name(rs.getString(2));
				t.setAmount(rs.getInt(3));
				t.setPrice(rs.getInt(4));

				tklist.add(t);
			}

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
		return tklist;
	}

	public String sendCoupon(int type, int customer_number) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		String cpnum = ManagerService.makeCouponNum();
		System.out.println("1=>" + cpnum);
		int suc = 0;
		while (searchCouPon(cpnum) > 0) {
			cpnum = ManagerService.makeCouponNum();
			System.out.println("2=>" + cpnum);
		}
		String sql = "insert into use_coupon values(?,?,?,sysdate,sysdate+60,'Y')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cpnum));
			pstmt.setInt(2, customer_number);
			pstmt.setInt(3, type);
			suc = pstmt.executeUpdate();
		} catch (SQLException e) {
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
		return cpnum;
	}

	public int searchCouPon(String cpnum) {
		CouponDto cd = new CouponDto();
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		String sql = "select coupon_number from use_coupon where coupon_number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cpnum));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// cplist.add(rs.getString(1));
				cnt++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public List<CustomerDto> getcstmList() {
		List<CustomerDto> ctlist = new ArrayList<CustomerDto>();
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select customer_number,c_id, kids_name from customers where useyn='Y'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerDto cd = new CustomerDto();
				cd.setCustomer_number(Integer.parseInt(rs.getString(1)));
				cd.setC_id(rs.getString(2));
				cd.setKids_name(rs.getString(3));
				ctlist.add(cd);
				System.out.println(cd.getC_id());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ctlist;
	}

	public List<CouponDto> getcouponList() {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from coupon where useyn='Y' order by coupon_type";
		List<CouponDto> cplist = new ArrayList<CouponDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CouponDto cpd = new CouponDto();
				cpd.setCoupon_type(rs.getInt(1));
				cpd.setCoupon_name(rs.getString(2));
				cpd.setDiscount_rate(rs.getInt(3));
				cplist.add(cpd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cplist;
	}

	public Connection getDbcon() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.12.15:1521:orcl";
			String id = "kitri";
			String pass = "kitri";
			conn = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void senlTicket(int tktype, int to) {
		// TODO Auto-generated method stub
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		// String cpnum = YeHaManagerService.makeCouponNum();
		// System.out.println("1=>" + cpnum);
		int suc = 0;
		// String sql = "insert into use_ticket values(?,sysdate+365,?)";
		String sql = "update customers set remain_amount = ? where customer_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			// pstmt.setInt(2, tktype);
			pstmt.setInt(2, to);
			suc = pstmt.executeUpdate();
		} catch (SQLException e) {
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
		// return cpnum;
	}

	public int identifyCustomer(int customer_number) {
		int n = -1;
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select remain_amount from customers where customer_number =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return n;
	}

	public void addAmount(int customer_number, int amount, int regular_amount) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		String sql = "update customers set remain_amount = ? where customer_number =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount + (10 * regular_amount));
			System.out.println(amount + (10 * regular_amount));
			pstmt.setInt(2, customer_number);
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

	public CustomerDto getCustInfo(int customer_number) {
		CustomerDto cd = new CustomerDto();
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select parents_name, remain_amount\r\n" + "from customers\r\n" + "where customer_number = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_number);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cd.setParents_name(rs.getString(1));
				cd.setRemain_amount(rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cd;
	}

	public void useTicket(int customer_number, int use_amount) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		int amount = identifyCustomer(customer_number);
		String sql = "update customers set remain_amount =? where customer_number=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount - use_amount);
			pstmt.setInt(2, customer_number);
			pstmt.executeUpdate();
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

	public int getData(int type, int sales) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pre_sales = 0;
		String sql = "select * from sales where TO_CHAR(sales_date,'yymmdd')=TO_CHAR(SYSDATE,'yymmdd')";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pre_sales = rs.getInt(4 - type);
			}
			// pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return pre_sales;
	}

	public void stackData(int type, int sales) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pre_sales = getData(type, sales);
		String name = "";
		switch (type) {
		case 0: {
			name = "D_TICKET_SALES";
		}
			break;
		case 1: {
			name = "TICKET_SALES";
		}
			break;
		case 2: {
			name = "FOOD_SALES";
		}
		}
		String sql = "update sales set " + name + "=" + (pre_sales + sales)
				+ " where TO_CHAR(sales_date,'yymmdd')=TO_CHAR(SYSDATE,'yymmdd')";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// pstmt.executeLargeUpdate();
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void addCoupon(String cpname, int dcrate) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		String sql = "insert into coupon(coupon_type, coupon_name, discount_rate) values(SEQ_COUPON_TYPE.NEXTVAL,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cpname);
			pstmt.setInt(2, dcrate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
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

	public void delCoupon(int ctype) {
		Connection conn = getDbcon();
		PreparedStatement pstmt = null;
		String sql = "update coupon set useyn='N' where coupon_type = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctype);
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
