package edu.spring.posco.domain;

import java.util.Date;

public class FreeBoard {
	
		private int bno;
		private String title;
		private String content;
		private String memberid;
		private Date reg_date;
		private int reply_cnt;
		
		public FreeBoard() {}

		public FreeBoard(int bno, String title, String content, String memberid, Date reg_date, int reply_cnt) {
			this.bno = bno;
			this.title = title;
			this.content = content;
			this.memberid = memberid;
			this.reg_date = reg_date;
			this.reply_cnt = reply_cnt;
		}

		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getmemberid() {
			return memberid;
		}

		public void setmemberid(String userid) {
			this.memberid = userid;
		}

		public Date getReg_date() {
			return reg_date;
		}

		public void setReg_date(Date reg_date) {
			this.reg_date = reg_date;
		}

		public int getReply_cnt() {
			return reply_cnt;
		}

		public void setReply_cnt(int reply_cnt) {
			this.reply_cnt = reply_cnt;
		}

		@Override
		public String toString() {
			return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", memberid=" + memberid + ", reg_date="
					+ reg_date + ", reply_cnt=" + reply_cnt + "]";
		}

}
