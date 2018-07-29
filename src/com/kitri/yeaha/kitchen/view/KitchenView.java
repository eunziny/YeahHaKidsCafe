package com.kitri.yeaha.kitchen.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import com.kitri.yeaha.kitchen.service.KitchenService;

public class KitchenView extends JFrame {

	public JPanel contentPane;
	public JButton kitchenOkB;
	public JScrollPane scrollPane;
	public DefaultTableModel model;
	public JTable kitchentable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KitchenView frame = new KitchenView();
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
	public KitchenView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		kitchenOkB = new JButton("\uC644 \uB8CC");
		kitchenOkB.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		kitchenOkB.setBounds(229, 440, 328, 68);
		contentPane.add(kitchenOkB);

		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 754, 374);
		contentPane.add(panel);
		String header[] = { "테이블번호", "메뉴이름", "수량" };
		String contents[][] = {};
		Dimension dim = new Dimension(754, 374);
		panel.setPreferredSize(dim);
		panel.setLayout(new BorderLayout(0, 0));

		model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		kitchentable = new JTable(model);
		kitchentable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		kitchentable.setRowHeight(33);

		scrollPane = new JScrollPane(kitchentable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);

		// 테이블 내용 가운데 정렬
		DefaultTableCellRenderer cellrender = new DefaultTableCellRenderer();
		cellrender.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = kitchentable.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(cellrender);
		}

		kitchentable.getTableHeader().setBackground(new Color(255, 221, 221));
		kitchentable.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 17));
		kitchentable.getTableHeader().setReorderingAllowed(false);
		kitchentable.getTableHeader().setResizingAllowed(false);
		// panel.pack();
		panel.setVisible(true);
		KitchenService ks = new KitchenService(this);
		kitchenOkB.addActionListener(ks);

	}
}
