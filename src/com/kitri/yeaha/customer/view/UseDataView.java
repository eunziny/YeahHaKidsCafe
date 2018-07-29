package com.kitri.yeaha.customer.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.yeaha.customer.data.CalDao;
import com.kitri.yeaha.customer.data.CalDto;

public class UseDataView extends JFrame implements ActionListener {

	String days[] = { "일", "월", "화", "수", "목", "금", "토" };
	int year, month, day, todays, visitday = 0;

	Calendar today;
	Calendar cal;

	private JPanel contentPane;
	public JTextField txtYear;
	public JTextField txtMon;
	public JButton prebtn;
	public JButton aftbtn;
	public JButton[] calBtn = new JButton[49];
	public JPanel pCal;
	public JPanel panel;
	public UseDateTable udt = new UseDateTable(this);
	public boolean checktime;
	CalDao cd = new CalDao();
	public int customer_number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseDataView frame = new UseDataView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UseDataView() {
		today = Calendar.getInstance();

		cal = new GregorianCalendar();

		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel customerMainL = new JLabel("YEAH-HA KIDS");
		customerMainL.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		customerMainL.setForeground(new Color(0, 51, 255));
		customerMainL.setHorizontalAlignment(SwingConstants.CENTER);
		customerMainL.setBounds(82, 5, 233, 45);
		contentPane.add(customerMainL);

		JButton bfBtn = new JButton("<");
		bfBtn.setBounds(23, 5, 45, 45);
		contentPane.add(bfBtn);
		bfBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		panel = new JPanel();
		panel.setBounds(0, 55, 396, 445);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 10));

		JPanel pMove = new JPanel();
		panel.add(pMove, BorderLayout.NORTH);
		pMove.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		prebtn = new JButton("<");
		pMove.add(prebtn);

		txtYear = new JTextField(year + "년");
		txtYear.setHorizontalAlignment(SwingConstants.CENTER);
		pMove.add(txtYear);
		txtYear.setColumns(5);
		txtYear.setEditable(false);

		txtMon = new JTextField(month + "월");
		txtMon.setHorizontalAlignment(SwingConstants.CENTER);
		pMove.add(txtMon);
		txtMon.setColumns(5);
		txtMon.setEditable(false);

		aftbtn = new JButton(">");
		pMove.add(aftbtn);

		pCal = new JPanel(new GridLayout(7, 7));
		panel.add(pCal, BorderLayout.CENTER);

		gridInit();
		calset();
		hideInit(); // 일이 찍히지 않는 나머지 버튼 비활성화

		prebtn.addActionListener(this);
		aftbtn.addActionListener(this);

	}

	private void gridInit() {
		for (int i = 0; i < days.length; i++)
			pCal.add(calBtn[i] = new JButton(days[i]));

		for (int i = days.length; i < 49; i++) {
			pCal.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}
	}

	private void calset() {
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DATE, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		int j = 0;
		int hopping = 0;
		calBtn[0].setForeground(new Color(255, 0, 0)); // 일요일
		calBtn[6].setForeground(new Color(0, 0, 255)); // 토요일
		for (int i = cal.getFirstDayOfWeek(); i < dayOfWeek; i++)
			j++;
		hopping = j;

		for (int kk = 0; kk < hopping; kk++)
			calBtn[kk + 7].setText("");

		for (int i = cal.getMinimum(Calendar.DAY_OF_MONTH); i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) {
			cal.set(Calendar.DATE, i);
			if (cal.get(Calendar.MONTH) != month - 1)
				break;
			todays = i;
			// 방문한 날짜 확인해서 방문일 초록색으로 바꾸고 입장, 퇴장시간 메세지 띄워주기
			Checkday(customer_number);
			if (visitday == 1) {
				calBtn[i + 6 + hopping].setForeground(new Color(50, 200, 100));
				calBtn[i + 6 + hopping].addActionListener(new ActionListener() {
					List<CalDto> list = Checkday(customer_number);
					CalDto cd = new CalDto();

					@Override
					public void actionPerformed(ActionEvent e) {
						String btnday = e.getActionCommand();
						udt.dm.setRowCount(0);
						for (int k = 0; k < list.size(); k++) {
							String str = list.get(k).getVisit_date();
							StringTokenizer stk = new StringTokenizer(str, "-");
							stk.nextToken();
							stk.nextToken();
							String dayy = stk.nextToken();

							if (Integer.parseInt(btnday) / 10 < 1) {
								btnday = "0" + btnday;
							}

							if (btnday.equals(dayy)) {
								cd = list.get(k);
								checktime = true;
								for (int i = 0; i < udt.usedatetable.getRowCount(); i++) {
									if (cd.getIn_time().equals(udt.usedatetable.getValueAt(i, 0))) {
										checktime = false;
									}
								}
								if (checktime == true) {
									udt.dm.addRow(new Object[] { cd.getIn_time(), cd.getOut_time() });
								}
								udt.setVisible(true);
							}

						}

					}
				});
				visitday = 0;
			} else {
				calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 0));
				if ((i + 6 + hopping) % 7 == 0) {// 일요일
					calBtn[i + 6 + hopping].setForeground(new Color(255, 0, 0));
				}
				if ((i + hopping) % 7 == 0) {// 토요일
					calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 255));
				}
			}
			calBtn[i + 6 + hopping].setText((i) + "");
		}

	}

	private void hideInit() {
		for (int i = 0; i < calBtn.length; i++) {
			if (calBtn[i].getText().equals(""))
				calBtn[i].setEnabled(false);
		}
	}

	public void calInput(int gap) {
		month += (gap);
		if (month <= 0) {
			month = 12;
			year -= 1;
		} else if (month >= 13) {
			month = 1;
			year += 1;
		}
	}

	public void panelInit() {
		GridLayout gridLayout1 = new GridLayout(7, 7);
		pCal.setLayout(gridLayout1);
		panel.add(pCal, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == prebtn) {
			this.pCal.removeAll();
			calInput(-1);
			gridInit();
			panelInit();
			calset();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMon.setText(month + "월");
		}
		if (ob == aftbtn) {
			this.pCal.removeAll();
			calInput(1);
			gridInit();
			panelInit();
			calset();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMon.setText(month + "월");
		}
	}

	public List<CalDto> Checkday(int customer_number) {
		Connection con = cd.getDbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select TO_CHAR(visit_date,'YYYY-MM-DD'), TO_CHAR(in_time, 'hh24:mi'), TO_CHAR(out_time, 'hh24:mi') from visit_history "
				+ "where TO_CHAR(visit_date, 'yyyymmdd') = ? and customer_number = ?";

		String sMonth = Integer.toString(month);
		String sToday = Integer.toString(todays);
		if (Integer.parseInt(sMonth) / 10 < 1) {
			sMonth = "0" + month;
		}
		if (Integer.parseInt(sToday) / 10 < 1) {
			sToday = "0" + todays;
		}

		List<CalDto> list = new ArrayList<CalDto>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(year) + sMonth + sToday);
			pstmt.setString(2, Integer.toString(customer_number));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				visitday = 1;
				CalDto cd = new CalDto();
				cd.setVisit_date(rs.getString(1));
				cd.setIn_time(rs.getString(2));
				cd.setOut_time(rs.getString(3));

				list.add(cd);
			}
			System.out.println(list.size());
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}