package edu.spring.posco.domain;

public class BoardReply {
	
		private int bno;
		private String memberid;
		private int boardreplycd;
		private String frtext;
		private int frlike;

	public BoardReply() {}

	public BoardReply(int bno, String memberid, int boardreplycd, String frtext, int frlike) {
		super();
		this.bno = bno;
		this.memberid = memberid;
		this.boardreplycd = boardreplycd;
		this.frtext = frtext;
		this.frlike = frlike;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getBoardreplycd() {
		return boardreplycd;
	}

	public void setBoardreplycd(int boardreplycd) {
		this.boardreplycd = boardreplycd;
	}

	public String getFrtext() {
		return frtext;
	}

	public void setFrtext(String frtext) {
		this.frtext = frtext;
	}

	public int getFrlike() {
		return frlike;
	}

	public void setFrlike(int frlike) {
		this.frlike = frlike;
	}

	@Override
	public String toString() {
		return "BoardReply [bno=" + bno + ", memberid=" + memberid + ", boardreplycd=" + boardreplycd + ", frtext="
				+ frtext + ", frlike=" + frlike + "]";
	}


	
}
