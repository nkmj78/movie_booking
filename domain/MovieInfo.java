package edu.spring.posco.domain;

public class MovieInfo {
	private int moviecd; // 영화 코드 
	private int showtm; // 영화 상영 시간
	private int avgpoints; // 평점 
	private int agelimit; // 연령 등급 
	
	private String movienm; // 영화 한글 제목
	private String movienmen; // 영화 영어 제목
	private String opendt; // 영화 개봉일
	private String nationnm; // 영화 제작국가
	private String genre1; // 영화 장르 1
	private String genre2; // 영화 장르 2
	private String genre3; // 영화 장르 3
	private String director; // 영화감독
	private String scenario; // 줄거리
	private String actor1; // 주연배우 1
	private String actor2; // 주연배우 2
	private String movieposter; // 영화 포스터
	
	
 
	public MovieInfo () {}

	public int getMoviecd() {
		return moviecd;
	}

	public void setMoviecd(int moviecd) {
		this.moviecd = moviecd;
	}

	public String getMovienm() {
		return movienm;
	}

	public void setMovienm(String movienm) {
		this.movienm = movienm;
	}

	public String getMovienmen() {
		return movienmen;
	}

	public void setMovienmen(String movienmen) {
		this.movienmen = movienmen;
	}

	public int getShowtm() {
		return showtm;
	}

	public void setShowtm(int showtm) {
		this.showtm = showtm;
	}

	public String getOpendt() {
		return opendt;
	}

	public void setOpendt(String opendt) {
		this.opendt = opendt;
	}

	public String getNationnm() {
		return nationnm;
	}

	public void setNationnm(String nationnm) {
		this.nationnm = nationnm;
	}

	public String getGenre1() {
		return genre1;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}

	public String getGenre2() {
		return genre2;
	}

	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}

	public String getGenre3() {
		return genre3;
	}

	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getActor1() {
		return actor1;
	}

	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public String getActor2() {
		return actor2;
	}

	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public int getAvgpoints() {
		return avgpoints;
	}

	public void setAvgpoints(int avgpoints) {
		this.avgpoints = avgpoints;
	}

	public String getMovieposter() {
		return movieposter;
	}

	public void setMovieposter(String movieposter) {
		this.movieposter = movieposter;
	}

	public int getAgelimit() {
		return agelimit;
	}

	public void setAgelimit(int agelimit) {
		this.agelimit = agelimit;
	}

	@Override
	public String toString() {
		return "MovieInfo [moviecd=" + moviecd + ", showtm=" + showtm + ", avgpoints=" + avgpoints + ", agelimit="
				+ agelimit + ", movienm=" + movienm + ", movienmen=" + movienmen + ", opendt=" + opendt + ", nationnm="
				+ nationnm + ", genre1=" + genre1 + ", genre2=" + genre2 + ", genre3=" + genre3 + ", director="
				+ director + ", scenario=" + scenario + ", actor1=" + actor1 + ", actor2=" + actor2 + ", movieposter="
				+ movieposter + "]";
	}
	
	
}

