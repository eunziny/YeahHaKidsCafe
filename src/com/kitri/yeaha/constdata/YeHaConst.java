package com.kitri.yeaha.constdata;

public class YeHaConst {
	public static final int CPORT = 1234;// 고객 접속 포트번호
	// public static final int KPORT = 2345;// 주방 접속 포트번호
	public static final int CS_CONNECT = 100;// 고객 접속 프로토콜 100||customer_id
	public static final int CS_DISCONNECT = 200;// 고객 접속 종료 프로토콜 200||customer_id

	public static final int MS_SEND_COUPON = 300;//
	public static final int MS_SELL_TICKET = 350;
	public static final int MS_SEND_INTIME = 400;
	public static final int MS_SEND_OUTTIME = 500;
	public static final int MS_SEND_ORDER = 600;// 주방에 음식 주문 전달 300||주문번호||음식이름||수량
	public static final int MS_USE_TICKET = 700;

	public static final int SC_CONNECT = 100;
	public static final int SC_DISCONNECT = 200;
	public static final int SC_SEND_COUPON = 300;
	public static final int SC_SELL_TICKET = 350;// 티켓 팔아씀
	public static final int SC_SEND_INTIME = 400;
	public static final int SC_SEND_OUTTIME = 500;
	public static final int SC_USE_TICKET = 700;

	public static final int SM_CONNECT = 100;
	public static final int SM_SUCCESS = 600;
	// public static final int SC_SEND_MENU = 600;

	public static final int KS_CONNECT = 100;// 주방 접속 프로토콜 100||
	public static final int KS_SUCCESS = 250;// 음식 제조 완료 프로토콜 200||주문번호
	public static final int SK_CONNECT = 100;// 음식 제조 완료 프로토콜 200||주문번호
	public static final int SK_SEND_ORDER = 300;// 주방에 음식 주문 전달 300||주문번호||음식이름||수량

	public static final int DAY_TICKET = 0;
	public static final int REGULAR_TICKET = 1;
	public static final int FOOD = 2;
}
