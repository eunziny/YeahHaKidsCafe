package com.kitri.yeaha.manager.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import com.kitri.yeaha.constdata.YeHaConst;

public class YeHaServer implements Runnable {
	ServerSocket ss = null;
	List<CsApp> list = new ArrayList<CsApp>();
	BufferedReader sin;
	OutputStream sout;

	public YeHaServer() {
		try {
			ss = new ServerSocket(YeHaConst.CPORT);
			System.out.println("접속대기");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket s2 = ss.accept();
				System.out.println("App실행");
				CsApp ca = new CsApp(s2);
				ca.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class CsApp extends Thread {
		Socket s;
		BufferedReader in;
		OutputStream out;
		String customer_id;

		public CsApp(Socket s) {
			this.s = s;

			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = s.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		@Override
		public void run() {
			boolean flag = true;
			while (flag) {
				try {
					String msg = in.readLine();
					System.out.println("C>>S" + msg);
					if (msg != null) {
						StringTokenizer st = new StringTokenizer(msg, "||");
						int protocol = Integer.parseInt(st.nextToken());
						switch (protocol) {
						case YeHaConst.CS_CONNECT: {
							customer_id = st.nextToken();
							if (customer_id.equals("주방")) {
								System.out.println("주방연결");
								out.write((YeHaConst.SC_CONNECT + "||\n").getBytes());
							} else if (customer_id.equals("매니저")) {
								out.write((YeHaConst.SM_CONNECT + "||\n").getBytes());
								System.out.println("매니저 연결");
							} else {
								System.out.println(customer_id + "번 고갱님 접속");
							}
							list.add(this);
						}
							break;
						case YeHaConst.MS_SEND_COUPON: {
							String to = st.nextToken();
							String cpname = st.nextToken();
							try {
								for (CsApp ca : list) {
									if (ca.customer_id.equals(to)) {
										ca.out.write((YeHaConst.SC_SEND_COUPON + "||" + cpname + "\n").getBytes());
										break;
									}
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
							break;
						case YeHaConst.MS_SEND_ORDER: {
							String table = st.nextToken();
							String menu = st.nextToken();
							String amount = st.nextToken();
							sendOrder(table, menu, amount);
						}
							break;
						case YeHaConst.MS_SELL_TICKET: {
							String to = st.nextToken();
							String amount = st.nextToken();
							sellTicket(to, amount);
						}
							break;
						case YeHaConst.KS_SUCCESS: {
							String table = st.nextToken();
							String menuname = st.nextToken();
							successOrder(table, menuname);
						}
							break;
						case YeHaConst.MS_USE_TICKET: {
							String to = st.nextToken();
							String amount = st.nextToken();
							useTicket(to, amount);
						}
							break;
						case YeHaConst.CS_DISCONNECT: {
							// broadcast(YeHaConst.SC_DISCONNECT + "||" + );
							String customer_number = st.nextToken();
							for (int i = 0; i < list.size(); i++) {
								CsApp ca = list.get(i);
								if (ca.customer_id.equals(customer_number))
									ca.out.write((YeHaConst.SC_DISCONNECT + "||" + ca.customer_id + "\n").getBytes());
							}
							list.remove(this);
							flag = false;
							in.close();
							out.close();
							s.close();
							break;
						}
						}
						// break;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void useTicket(String to, String amount) {
		try {
			for (CsApp ca : list) {
				if (ca.customer_id.equals(to)) {
					ca.out.write((YeHaConst.SC_USE_TICKET + "||" + amount + "\n").getBytes());
					// System.out.println(msg + "을" + to + "에게");
					break;
				} else {
					System.out.println("티켓사용실패");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void makeCoupon(String to, String msg) {
		try {
			for (CsApp ca : list) {
				if (ca.customer_id.equals(to)) {
					ca.out.write((YeHaConst.SC_SEND_COUPON + "||" + msg + "\n").getBytes());
					// System.out.println(msg + "을" + to + "에게");
					break;
				} else {
					System.out.println("쿠폰생성실패");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void successOrder(String table, String menuname) {
		try {
			for (CsApp ca : list) {
				if (ca.customer_id.equals("매니저")) {
					ca.out.write((YeHaConst.SM_SUCCESS + "||" + table + "||" + menuname + "\n").getBytes());
					// System.out.println(msg + "을" + to + "에게");
					break;
				} else {
					System.out.println("흠");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sellTicket(String to, String amount) {

		try {
			for (CsApp ca : list) {
				if (ca.customer_id.equals(to)) {
					ca.out.write((YeHaConst.SC_SELL_TICKET + "||" + amount + "\n").getBytes());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendOrder(String table, String menu, String amount) {
		try {
			for (CsApp ca : list) {
				if (ca.customer_id.equals("주방")) {
					ca.out.write(
							(YeHaConst.SK_SEND_ORDER + "||" + table + "||" + menu + "||" + amount + "\n").getBytes());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Thread(new YeHaServer()).start();
	}
}
