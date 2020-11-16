package edu.spring.posco.domain;

public class BoxOffice {

	private int moviecd; // 영화코드
	private int rank; // 랭킹
	private String movienm; // 영화제목
	private String movieposter; // 영화 포스터 
	private String opendt; // 영화개봉일
	private int audiacc; // 누적관객수
	
	public BoxOffice () {}

	public BoxOffice(int moviecd, int rank, String movienm, String movieposter) {
		
		this.moviecd = moviecd;
		this.rank = rank;
		this.movienm = movienm;
		this.movieposter = movieposter;
	}

	
	
	public BoxOffice(int moviecd, int rank, String movienm, String movieposter, String opendt, int audiacc) {
		this.moviecd = moviecd;
		this.rank = rank;
		this.movienm = movienm;
		this.movieposter = movieposter;
		this.opendt = opendt;
		this.audiacc = audiacc;
	}

	public int getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(int moviecd) {
		this.moviecd = moviecd;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getMovienm() {
		return movienm;
	}

	public void setMovienm(String movienm) {
		this.movienm = movienm;
	}

	public String getMovieposter() {
		return movieposter;
	}

	public void setMovieposter(String movieposter) {
		this.movieposter = movieposter;
	}

	public String getOpendt() {
		return opendt;
	}

	public void setOpendt(String opendt) {
		this.opendt = opendt;
	}

	public int getAudiacc() {
		return audiacc;
	}

	public void setAudiacc(int audiacc) {
		this.audiacc = audiacc;
	}

	@Override
	public String toString() {
		return "BoxOffice [moviecd=" + moviecd + ", rank=" + rank + ", movienm=" + movienm + ", movieposter="
				+ movieposter + ", opendt=" + opendt + ", audiacc=" + audiacc + "]";
	}

	
	
	
	
}
