package edu.spring.posco.domain;

public class Reservation {

	private int reservcd; // 예매번호 
	private String memberid; // 사용자 아이디
	private String theater; // 상영관
	private int seatnm; // 좌석 번호
	private String showdate; // 상영 날짜
	private String reservdate; // 예매 날짜
	private String movienm; // 영화 제목
	private String payment; // 결제 수단
	private String price; // 영화 가격 
	private int theatercd; // 상영관 코드 
	
	public Reservation () {}

	public Reservation(int reservcd, String memberid, String theater, int seatnm, String showdate, String reservdate,
			String movienm, String payment, String price, int theatercd) {
		
		this.reservcd = reservcd;
		this.memberid = memberid;
		this.theater = theater;
		this.seatnm = seatnm;
		this.showdate = showdate;
		this.reservdate = reservdate;
		this.movienm = movienm;
		this.payment = payment;
		this.price = price;
		this.theatercd = theatercd;
	}

	public int getReservcd() {
		return reservcd;
	}

	public void setReservcd(int reservcd) {
		this.reservcd = reservcd;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public int getSeatnm() {
		return seatnm;
	}

	public void setSeatnm(int seatnm) {
		this.seatnm = seatnm;
	}

	public String getShowdate() {
		return showdate;
	}

	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}

	public String getReservdate() {
		return reservdate;
	}

	public void setReservdate(String reservdate) {
		this.reservdate = reservdate;
	}

	public String getMovienm() {
		return movienm;
	}

	public void setMovienm(String movienm) {
		this.movienm = movienm;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getTheatercd() {
		return theatercd;
	}

	public void setTheatercd(int theatercd) {
		this.theatercd = theatercd;
	}
	
} // end class Reservation
