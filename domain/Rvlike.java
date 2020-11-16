package edu.spring.posco.domain;

// 리뷰 게시판 좋아요 모델 클래스
public class Rvlike {
	
	private int likecd;			// 좋아요 코드
	private String memberid;	// 사용자 아이디
	private int rvcode;			// 리뷰 코드
	private int likecheck;		// 좋아요 체크
	
	public Rvlike() {}

	public Rvlike(int likecd, String memberid, int rvcode, int likecheck) {
		super();
		this.likecd = likecd;
		this.memberid = memberid;
		this.rvcode = rvcode;
		this.likecheck = likecheck;
	}

	public int getLikecd() {
		return likecd;
	}

	public void setLikecd(int likecd) {
		this.likecd = likecd;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getRvcode() {
		return rvcode;
	}

	public void setRvcode(int rvcode) {
		this.rvcode = rvcode;
	}

	public int getLikecheck() {
		return likecheck;
	}

	public void setLikecheck(int likecheck) {
		this.likecheck = likecheck;
	}

	@Override
	public String toString() {
		return "Rvlike [likecd=" + likecd + ", memberid=" + memberid + ", rvcode=" + rvcode + ", likecheck=" + likecheck
				+ "]";
	}

} // end class Rvlike
