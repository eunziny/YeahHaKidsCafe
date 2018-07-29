package com.kitri.yeaha.manager.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.spi.CurrencyNameProvider;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Font;

public class PurchaseTicket extends JPanel {
	public JButton ticket;
	public JButton d_ticket;
	public JButton cpBtn;
	public TicketList pl;

	/**
	 * Create the panel.
	 */
	public PurchaseTicket() {
		setBackground(Color.ORANGE);
		setLayout(null);

		ticket = new JButton("\uC815\uAE30\uAD8C");
		ticket.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		ticket.setBackground(new Color(255, 140, 0));
		ticket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ticket.setBounds(76, 33, 212, 204);
		add(ticket);

		d_ticket = new JButton("\uC77C\uC77C\uAD8C");
		d_ticket.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		d_ticket.setBackground(new Color(255, 140, 0));
		d_ticket.setBounds(76, 270, 212, 204);
		add(d_ticket);

		JPanel vpan = new JPanel();
		vpan.setLayout(new BoxLayout(vpan, BoxLayout.X_AXIS));
		pl = new TicketList();
		pl.setBackground(new Color(192, 192, 192));
		vpan.add(pl);
		vpan.setBackground(Color.white);
		vpan.setBounds(399, 33, 301, 441);
		add(vpan);
	}
}
