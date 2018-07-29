package com.kitri.yeaha.kitchen.service;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.yeaha.constdata.YeHaConst;
//import com.kitri.net.data.YeHaConst;
import com.kitri.yeaha.kitchen.view.KitchenView;

public class KitchenService extends Thread implements ActionListener, WindowListener {
	Socket s;
	BufferedReader in;
	OutputStream out;
	String customer_number = "주방";
	KitchenView kv;

	public KitchenService(KitchenView kv) {
		this.kv = kv;
		connectProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == kv.kitchenOkB) {
			int row = kv.kitchentable.getSelectedRow();
			if (row >= 0) {
				// out.write((YeHaConst.KS_SUCCESS + "||\n").getBytes());
				System.out.println(kv.model.getValueAt(row, 0));
				System.out.println(kv.model.getValueAt(row, 1));
				sendMsg(YeHaConst.KS_SUCCESS + "||" + kv.model.getValueAt(row, 0) + "||" + kv.model.getValueAt(row, 1));
				kv.model.removeRow(row);

			} else {
				JOptionPane.showMessageDialog(kv, "완료된 메뉴를 선택하세요");
			}
		}
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			try {
				String msg = in.readLine();
				System.out.println("S>>C" + msg);
				StringTokenizer st = new StringTokenizer(msg, "||");
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case YeHaConst.SC_CONNECT: {
					JOptionPane.showMessageDialog(kv, "홀과 연결 되었습니다.");
				}
					break;
				case YeHaConst.SK_SEND_ORDER: {
					System.out.println("주문을 받았따");
					String table = st.nextToken();
					String menu = st.nextToken();
					String amount = st.nextToken();
					DefaultTableModel model = kv.model;
					Vector<String> row = new Vector<String>();
					row.addElement(table);
					row.addElement(menu);
					row.addElement(amount);
					model.addRow(row);
					JOptionPane.showMessageDialog(kv, "주문이 도착했습니다");
				}
					break;
				case YeHaConst.SC_DISCONNECT: {
					String tmp = st.nextToken();
					if (tmp.equals(customer_number)) {
						flag = false;
						in.close();
						out.close();
						s.close();
						System.exit(0);
						break;
					}
				}
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void connectProcess() {
		String host = "localhost";
		try {
			System.out.println("연결시도");
			s = new Socket(host, YeHaConst.CPORT);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			sendMsg(YeHaConst.CS_CONNECT + "||" + customer_number);
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMsg(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 200||안녕하셍요
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		exitProcess();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	private void exitProcess() {
		// TODO Auto-generated method stub
		sendMsg(YeHaConst.CS_DISCONNECT + "||");
		kv.setVisible(false);
	}

}
