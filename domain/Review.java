package edu.spring.posco.domain;

import java.util.Date;

// 리뷰 - 모델
public class Review {

	private int rvcode; // 리뷰코드
	private String memberid; // 사용자 닉네임
	private String rvtitle; // 리뷰제목
	private String rvcontent; // 리뷰내용
	private String movienm; // 영화제목
	private int rvpoints; // 리뷰평점
	private Date rvdate; // 리뷰작성날짜
	private int rvreplycnt; // 리뷰댓글수
	private int rvrecommcnt; // 리뷰추천수
	private String moviecd; // 영화코드

	public Review() {
	}

	public Review(int rvcode, String memberid, String rvtitle, String rvcontent, String movienm, int rvpoints,
			Date rvdate, int rvreplycnt, int rvrecommcnt, String moviecd) {
		super();
		this.rvcode = rvcode;
		this.memberid = memberid;
		this.rvtitle = rvtitle;
		this.rvcontent = rvcontent;
		this.movienm = movienm;
		this.rvpoints = rvpoints;
		this.rvdate = rvdate;
		this.rvreplycnt = rvreplycnt;
		this.rvrecommcnt = rvrecommcnt;
		this.moviecd = moviecd;
	}

	public int getRvcode() {
		return rvcode;
	}

	public void setRvcode(int rvcode) {
		this.rvcode = rvcode;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getRvtitle() {
		return rvtitle;
	}

	public void setRvtitle(String rvtitle) {
		this.rvtitle = rvtitle;
	}

	public String getRvcontent() {
		return rvcontent;
	}

	public void setRvcontent(String rvcontent) {
		this.rvcontent = rvcontent;
	}

	public String getMovienm() {
		return movienm;
	}

	public void setMovienm(String movienm) {
		this.movienm = movienm;
	}

	public int getRvpoints() {
		return rvpoints;
	}

	public void setRvpoints(int rvpoints) {
		this.rvpoints = rvpoints;
	}

	public Date getRvdate() {
		return rvdate;
	}

	public void setRvdate(Date rvdate) {
		this.rvdate = rvdate;
	}

	public int getRvreplycnt() {
		return rvreplycnt;
	}

	public void setRvreplycnt(int rvreplycnt) {
		this.rvreplycnt = rvreplycnt;
	}

	public int getRvrecommcnt() {
		return rvrecommcnt;
	}

	public void setRvrecommcnt(int rvrecommcnt) {
		this.rvrecommcnt = rvrecommcnt;
	}

	public String getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(String moviecd) {
		this.moviecd = moviecd;
	}

	@Override
	public String toString() {
		return "Review [rvcode=" + rvcode + ", memberid=" + memberid + ", rvtitle=" + rvtitle + ", rvcontent="
				+ rvcontent + ", movienm=" + movienm + ", rvpoints=" + rvpoints + ", rvdate=" + rvdate + ", rvreplycnt="
				+ rvreplycnt + ", rvrecommcnt=" + rvrecommcnt + ", moviecd=" + moviecd + "]";
	}

} // end class Review
