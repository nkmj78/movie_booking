package edu.spring.posco.domain;

// 리뷰 댓글
public class Rvreply {
	
	private int rvcode;			// 리뷰코드 
	private String memberid;	// 작성자 닉네임
	private int rvreplycd;		// 리뷰댓글코드
	private String rvtext;		// 리뷰댓글내용
	private int rvlike;			// 리뷰댓글좋아요
	private int moviecd;		// 영화코드
	
	public Rvreply() {}

	

	public Rvreply(int rvcode, String memberid, int rvreplycd, String rvtext, int rvlike, int moviecd) {
		this.rvcode = rvcode;
		this.memberid = memberid;
		this.rvreplycd = rvreplycd;
		this.rvtext = rvtext;
		this.rvlike = rvlike;
		this.moviecd = moviecd;
	}



	public int getMoviecd() {
		return moviecd;
	}



	public void setMoviecd(int moviecd) {
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

	public int getRvreplycd() {
		return rvreplycd;
	}

	public void setRvreplycd(int rvreplycd) {
		this.rvreplycd = rvreplycd;
	}

	public String getRvtext() {
		return rvtext;
	}

	public void setRvtext(String rvtext) {
		this.rvtext = rvtext;
	}

	public int getRvlike() {
		return rvlike;
	}

	public void setRvlike(int rvlike) {
		this.rvlike = rvlike;
	}



	@Override
	public String toString() {
		return "Rvreply [rvcode=" + rvcode + ", memberid=" + memberid + ", rvreplycd=" + rvreplycd + ", rvtext="
				+ rvtext + ", rvlike=" + rvlike + ", moviecd=" + moviecd + "]";
	}

	

} // end class Rvreply
