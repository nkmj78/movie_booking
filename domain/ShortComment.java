package edu.spring.posco.domain;

import java.util.Date;

public class ShortComment {

	private int moviecd; // 영화 코드
	private String memberid; // 사용자 닉네임  
	private Date commdate; // 한줄 평 작성날짜
	private String commcontent; // 한줄 평 내용
	private int commcd; // 한줄평 코드
	
	public ShortComment() {}

	public ShortComment(int moviecd, String memberid, Date commdate, String commcontent, int commcd) {
		super();
		this.moviecd = moviecd;
		this.memberid = memberid;
		this.commdate = commdate;
		this.commcontent = commcontent;
		this.commcd = commcd;
	}

	public int getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(int moviecd) {
		this.moviecd = moviecd;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public Date getCommdate() {
		return commdate;
	}

	public void setCommdate(Date commdate) {
		this.commdate = commdate;
	}

	public String getCommcontent() {
		return commcontent;
	}

	public void setCommcontent(String commcontent) {
		this.commcontent = commcontent;
	}



	public int getCommcd() {
		return commcd;
	}

	public void setCommcd(int commcd) {
		this.commcd = commcd;
	}

	@Override
	public String toString() {
		return "ShortComment [moviecd=" + moviecd + ", memberid=" + memberid + ", commdate=" + commdate
				+ ", commcontent=" + commcontent + ", commcd="
				+ commcd + "]";
	}

	
}
