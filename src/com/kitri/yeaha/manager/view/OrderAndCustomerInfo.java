package com.kitri.yeaha.manager.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import com.yeahha.amountbtn.OrderService;
//import com.yeahha.menuorder.detailview.MainMenuTab;
//import com.yeahha.menuorder.panel.CustomerInfo;
//import com.yeahha.menuorder.panel.MenuOrderPrice;

public class OrderAndCustomerInfo extends JFrame {

	private JPanel contentPane;
	// MainMenuTab mmt = new MainMenuTab();
	// CustomerInfo ci = new CustomerInfo();
	// MenuOrderPrice mop = new MenuOrderPrice();
	CustoInfoView cv = new CustoInfoView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderAndCustomerInfo frame = new OrderAndCustomerInfo();
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

	public OrderAndCustomerInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane orderandinfotab = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(orderandinfotab, BorderLayout.CENTER);
		// orderandinfotab.add("주문/결제", mop);
		// orderandinfotab.add("회원정보", ci);
		orderandinfotab.add("회원정보", cv);

	}
}
