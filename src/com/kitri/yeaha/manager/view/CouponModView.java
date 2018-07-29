package com.kitri.yeaha.manager.view;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CouponModView extends JFrame {

	public JPanel contentPane;
	public JPanel addCoupon = new JPanel();
	public JPanel delCoupon = new JPanel();
	public JTabbedPane tp;
	public JButton cancel = new JButton("\uB098 \uAC00 \uAE30");
	public JButton addcpbtn = new JButton("\uD655    \uC778");
	public JButton delcpbtn = new JButton("\uC0AD    \uC81C");
	public JTextField dcrateTf;
	public JTextField cpnameTf;
	public JTable table;
	public Vector<String> userColum = new Vector<String>();
	public DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// CouponModView frame = new CouponModView();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public CouponModView() {
		super("ModifyCoupon!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tp = new JTabbedPane(JTabbedPane.TOP);
		tp.setBounds(14, 12, 554, 317);
		contentPane.add(tp);
		addCoupon.setBackground(Color.ORANGE);
		tp.addTab("√ﬂ∞°", addCoupon);
		addCoupon.setLayout(null);
		addcpbtn.setForeground(Color.WHITE);
		addcpbtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		addcpbtn.setBackground(new Color(100, 149, 237));
		addcpbtn.setBounds(118, 223, 305, 50);

		addCoupon.add(addcpbtn);

		JLabel lblNewLabel = new JLabel("\uCFE0\uD3F0\uC774\uB984");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 52, 82, 39);
		addCoupon.add(lblNewLabel);

		JLabel label = new JLabel("\uD560\uC778\uC728");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		label.setBounds(118, 119, 82, 39);
		addCoupon.add(label);

		cpnameTf = new JTextField();
		cpnameTf.setHorizontalAlignment(SwingConstants.CENTER);
		cpnameTf.setBounds(214, 54, 208, 39);
		addCoupon.add(cpnameTf);
		cpnameTf.setColumns(10);

		dcrateTf = new JTextField();
		dcrateTf.setHorizontalAlignment(SwingConstants.CENTER);
		dcrateTf.setColumns(10);
		dcrateTf.setBounds(214, 121, 208, 39);
		addCoupon.add(dcrateTf);
		delCoupon.setBackground(Color.ORANGE);
		tp.addTab("ªË¡¶", delCoupon);
		delCoupon.setLayout(null);

		delcpbtn.setForeground(Color.WHITE);
		delcpbtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		delcpbtn.setBackground(new Color(100, 149, 237));
		delcpbtn.setBounds(118, 223, 305, 50);
		delCoupon.add(delcpbtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 35, 396, 165);
		delCoupon.add(scrollPane);
		cancel.setForeground(new Color(255, 255, 255));
		cancel.setBackground(new Color(100, 149, 237));
		cancel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		cancel.setBounds(135, 341, 305, 50);
		contentPane.add(cancel);
		userColum.add("ƒÌ∆˘≈∏¿‘");
		userColum.add("ƒÌ∆˘¿Ã∏ß");
		userColum.add("«“¿Œ¿≤");
		model = new DefaultTableModel(userColum, 0);
		table = new JTable(model);
		table.getTableHeader().setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		// table.setShowVerticalLines(false);
		// table.setShowHorizontalLines(false);
		// table.setRowSelectionAllowed(false);
		table.setDragEnabled(false);
		scrollPane.setViewportView(table);

	}
}
