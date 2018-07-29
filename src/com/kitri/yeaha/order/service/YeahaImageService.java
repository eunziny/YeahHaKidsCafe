package com.kitri.yeaha.order.service;

import java.awt.Component;
import java.awt.Image;

import javax.swing.*;

import com.kitri.yeaha.order.view.MenuOrderPrice;

public class YeahaImageService extends MenuOrderPrice {

	public String imgpath;
	public Image image;
	public String menuimg;
	public JLabel imageL;
	public ImageIcon custoiamge;

	public YeahaImageService(String menuimg) {
		this.menuimg = menuimg;
	}

	public JLabel menuicon() {
		custoiamge = new ImageIcon("../YeaHaKidsCafe/src/com/kitri/yeaha/order/service/yhmenuimg/" + menuimg + ".jpg");
		imageL = new JLabel();
		imageL.setIcon(custoiamge);
		return imageL;
	}

	public Component iconp(JPanel menuimage_p) {
		menuimage_p.removeAll();
		if (menuimg != null)
			menuimage_p.add(menuicon());
		else
			menuimage_p.add(new JLabel("이미지준비중"));
		return menuimage_p;
	}
}
