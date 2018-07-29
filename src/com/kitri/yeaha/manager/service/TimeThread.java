package com.kitri.yeaha.manager.service;

import javax.swing.JLabel;

public class TimeThread extends Thread {
	ManagerService ms;
	public int index;

	public TimeThread(ManagerService ms) {
		this.ms = ms;
	}

	static String getTime(int sec) {
		int hours = 0;
		int remainderOfHours = 0;
		int minutes = 0;
		int seconds = 0;

		if (sec >= 3600) {
			hours = sec / 3600;
			remainderOfHours = sec % 3600;

			if (remainderOfHours >= 60) {
				minutes = remainderOfHours / 60;
				seconds = remainderOfHours % 60;
			} else {
				seconds = remainderOfHours;
			}
		} else if (sec >= 60) {
			hours = 0;
			minutes = sec / 60;
			seconds = sec % 60;
		} else if (sec < 60) {
			hours = 0;
			minutes = 0;
			seconds = sec;
		}
		String strHours;
		String strMins;
		String strSecs;

		if (seconds < 10)
			strSecs = "0" + Integer.toString(seconds);
		else
			strSecs = Integer.toString(seconds);

		if (minutes < 10)
			strMins = "0" + Integer.toString(minutes);
		else
			strMins = Integer.toString(minutes);

		if (hours < 10)
			strHours = "0" + Integer.toString(hours);
		else
			strHours = Integer.toString(hours);

		String time = strHours + ":" + strMins + ":" + strSecs;
		return time;
	}

	
	//int i = 5;
	int i = 7200;
	
	@Override
	public void run() {
		JLabel la = ms.tv.mv.mLTimeL[index];
		while (i > 0) {
			String time = getTime(i--);
			la.setText(time);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ms.tv.mv.mPNameL[index].setText("");
		ms.tv.mv.mLTimeL[index].setText("");
		ms.tv.mv.mainB[index].setEnabled(true);
	}

}
