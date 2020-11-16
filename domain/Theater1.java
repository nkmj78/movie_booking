package edu.spring.posco.domain;

public class Theater1 {

	private int theatercd; // 상영관 코드
	private int seat; // 좌석 개수
	private String moviesite; // 영화관 이름
	private String movienm; // 영화 제목
	private String starttime; // 영화 상영 시작시간 
	private String showdate; // 영화상영날짜 
	private String price; // 영화 가격 
	
	public Theater1 () {}

	public Theater1(int theatercd, String moviesite, String movienm, String starttime, String showdate, int seat,
			String price) {
		
		this.theatercd = theatercd;
		this.moviesite = moviesite;
		this.movienm = movienm;
		this.starttime = starttime;
		this.showdate = showdate;
		this.seat = seat;
		this.price = price;
	}

	public int getTheatercd() {
		return theatercd;
	}

	public void setTheatercd(int theatercd) {
		this.theatercd = theatercd;
	}

	public String getMoviesite() {
		return moviesite;
	}

	public void setMoviesite(String moviesite) {
		this.moviesite = moviesite;
	}

	public String getMovienm() {
		return movienm;
	}

	public void setMovienm(String movienm) {
		this.movienm = movienm;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getShowdate() {
		return showdate;
	}

	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Theater1 [theatercd=" + theatercd + ", seat=" + seat + ", moviesite=" + moviesite + ", movienm="
				+ movienm + ", starttime=" + starttime + ", showdate=" + showdate + ", price=" + price + "]";
	}
	
	
	
}
