package edu.spring.posco.domain;

public class Payment {

	private int paycode; 	 // 결제코드
	private String payment;  // 결제수단
	private String price;    // 결제가격
	private String memberid; // 아이디
	private int reservcd;	 // 예매번호 
	
	public Payment() {}
	
	public Payment(int paycode, String payment, String price, String memberid, int reservcd) {
		super();
		this.paycode = paycode;
		this.payment = payment;
		this.price = price;
		this.memberid = memberid;
		this.reservcd = reservcd;
	}
	public int getPaycode() {
		return paycode;
	}
	public void setPaycode(int paycode) {
		this.paycode = paycode;
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
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public int getReservcd() {
		return reservcd;
	}
	public void setReservcd(int reservcd) {
		this.reservcd = reservcd;
	}
	@Override
	public String toString() {
		return "Payment [paycode=" + paycode + ", payment=" + payment + ", price=" + price + ", memberid=" + memberid
				+ ", reservcd=" + reservcd + "]";
	}
	
	
}
