package edu.spring.posco.domain;

public class Member {
	
	private String memberid;
	private String pwd;
	private String pwdcheck;
	private String nickname;
	private String email;
	
	public Member() {}

	public Member(String memberid, String pwd, String pwdcheck, String nickname, String email) {
		super();
		this.memberid = memberid;
		this.pwd = pwd;
		this.pwdcheck = pwdcheck;
		this.nickname = nickname;
		this.email = email;
	}
	
	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdcheck() {
		return pwdcheck;
	}

	public void setPwdcheck(String pwdcheck) {
		this.pwdcheck = pwdcheck;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", pwd=" + pwd + ", pwdcheck=" + pwdcheck + ", nickname=" + nickname
				+ ", email=" + email + "]";
	}
	
	
}
