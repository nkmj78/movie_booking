package edu.spring.posco.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.ShortComment;
import edu.spring.posco.service.BoxService;
import edu.spring.posco.service.InfoService;
import edu.spring.posco.service.InfoServiceImple;
import edu.spring.posco.service.ShortCommentService;

@Controller
public class InfoController {
	private Logger log = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired InfoService infoservice;
	@Autowired BoxService boxservice;
	@Autowired ShortCommentService shortservice;
	
	@RequestMapping(value="/comments/{commcd}", method=RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteShortComment(@PathVariable(name="commcd") Integer commcd){
		int result = shortservice.stctdelete(commcd);
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		return entity;
	} // end deleteShortComment()
	
	@RequestMapping(value="/comments", method=RequestMethod.POST)
	public ResponseEntity<Integer> createShortComment(@RequestBody ShortComment shortComment) {
		log.info("create 호출", shortComment);
		
		int result = shortservice.stctinsert(shortComment);
		
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
		
		return entity;
	} // end createShortComment()
	
	@RequestMapping(value="/comments/all/{moviecd}", method=RequestMethod.GET)
	public ResponseEntity<List<ShortComment>> readShortComment(@PathVariable(name="moviecd") int moviecd){
		log.info("readShortComment(moviecd={})", moviecd);
		
		List<ShortComment> commentlist = shortservice.stctAll(moviecd);
		
		ResponseEntity<List<ShortComment>> entity = new ResponseEntity<List<ShortComment>>(commentlist, HttpStatus.OK);
		
		return entity;
	} // end readShortComment()
	  

	
	// info에서 naver open api의 영화 제목 포스터 감독명 등을 위해서
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String goInfoMovie (String title, String poster, String director,String opendt, String actor, Model model)
			throws MalformedURLException, UnsupportedEncodingException {
	
		// moviCd값을 넣을 변수 선언
		String movieCd = null;
		
		String removeB = title.replace("<b>", "");
		String removeBTitle = removeB.replace("</b>", "");
		int deletel= director.indexOf('|');
		String removel = director.substring(0, deletel);
		
		
		model.addAttribute("title", title);
		model.addAttribute("poster", poster);
		model.addAttribute("director", removel);
		model.addAttribute("opendt", opendt);
		

		// 네이버 openApi의 정보를 통해서 공공데이터포털 영화 정보를 불러옴
		String Url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json"
				+ URLEncoder.encode("?key=26f6b10efd1a1182bfbcc0b33e141537&movieNm="+ removeBTitle + "&directorNm=" + removel, "UTF-8");
				
		
		
		URL url = new URL(Url);
		
		HttpURLConnection urlconnection = null;
	      BufferedReader br = null;
	      String result = "";
	      
	      try {
	          urlconnection = (HttpURLConnection) url.openConnection();
	          urlconnection.setRequestMethod("GET");
	          urlconnection.connect();

	 		 br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream() , "UTF-8"));
	          

	          String line;
	          while ((line = br.readLine()) != null) {
	             result = result + line ;
	          }
	          
	          
	          
	          JSONParser jsonParse = new JSONParser(); //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
	          JSONObject jsonObject = (JSONObject) jsonParse.parse(result); //JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다. 
	          
//	           들어가서
	          JSONObject movieListResult = (JSONObject) jsonObject.get("movieListResult");
	          
//	          // 들어가기
	          JSONArray movieList = (JSONArray) movieListResult.get("movieList");
	          
	          
	          // 배열을 오브젝트로 추출해야함
	          JSONObject movieObject = (JSONObject) movieList.get(0);
	          movieCd = (String)movieObject.get("movieCd");
	      } catch (Exception e) {
	          e.printStackTrace();
	       }
	      
	      // 다시 영화정보를 이용해서 상세영화정보를 불러옴
	   // url 주소
	      String Url2 = " http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json"
	      		+ "?key=26f6b10efd1a1182bfbcc0b33e141537&movieCd=" + movieCd;
	      
	      URL url2 = new URL(Url2);

	      HttpURLConnection urlconnection2 = null;
	      BufferedReader br2 = null;
	      String result2 = "";
	      
	      try {
	         urlconnection2 = (HttpURLConnection) url2.openConnection();
	         urlconnection2.setRequestMethod("GET");
	         urlconnection2.connect();

			 br2 = new BufferedReader(new InputStreamReader(urlconnection2.getInputStream() , "UTF-8"));
	         
			 
	         String line2;
	         while ((line2 = br2.readLine()) != null) {
	            result2 = result2 + line2 ;
	         }
	         JSONParser jsonParse2 = new JSONParser(); //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
	         JSONObject jsonObject2 = (JSONObject) jsonParse2.parse(result2); //JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다. 
	         
	         // 들어가서
	         JSONObject movieInfoResult = (JSONObject) jsonObject2.get("movieInfoResult");
	         
	         // 들어가기
	         JSONObject movieInfo = (JSONObject) movieInfoResult.get("movieInfo");
	         
	         
	         movieInfo.get("movieNmEn");
	         movieInfo.get("showTm");
	         movieInfo.get("typeNm");
	         // nations배열에서 꺼내기
	         JSONArray nationArray = (JSONArray)movieInfo.get("nations");
	         JSONObject nation = (JSONObject)nationArray.get(0);
	         // 장르 배열에서 꺼내기
	         JSONArray genresArray = (JSONArray)movieInfo.get("genres");
	         String genreList = new String();
	         for(int i =0;i <genresArray.size();i++) {
	        	 JSONObject genre = (JSONObject)genresArray.get(i);
	        	 String genres = (String)genre.get("genreNm");
	        	 
	        	 if(i == genresArray.size()-1) {
	        		 genreList= genreList + genres;
	        	 }else {
	        	 genreList= genreList + genres + ", " ;
	        	 }
	         }
	      
	         
	         JSONArray actorsArray = (JSONArray)movieInfo.get("actors");
	         String actorAndCast = new String();
	         for(int i =0;i <actorsArray.size();i++) {
	         JSONObject actors = (JSONObject)actorsArray.get(i);
	         	String actor1 = (String)actors.get("peopleNm");
	         	
	         	String cast = (String)actors.get("cast");
	         	
//	         	String actor3 = (String)actors.get("peopleNm");
	         	actorAndCast = actorAndCast + actor1;
	         	actorAndCast = actorAndCast +" "+ cast;
	         	if(i == actorsArray.size()-1) {
	         		continue;
	         	}else {
	         		actorAndCast = actorAndCast +", ";
	         		
	         	}
	         	
	         }
	         
	         JSONArray audits = (JSONArray)movieInfo.get("audits");
	         JSONObject watchGradeNm = (JSONObject)audits.get(0);
	         System.out.println(watchGradeNm.get("watchGradeNm"));

	         
	      
	        model.addAttribute("movieNmEn", movieInfo.get("movieNmEn"));
	 		model.addAttribute("showTm", movieInfo.get("showTm"));
	 		model.addAttribute("typeNm", movieInfo.get("typeNm"));
	 		model.addAttribute("nations", nation.get("nationNm"));
	 		model.addAttribute("genres", genreList);
	 		model.addAttribute("actors", actorAndCast);
	 		model.addAttribute("watchGradeNm", watchGradeNm.get("watchGradeNm"));
	 		
	 		
//	 		List<Review> dbList = new ArrayList<Review>();
//	 		String db = new String();
//	 		dbList.add(infoservice.movieSeelctAll(movieCd));
//	 		for(int i=0; i<dbList.size();i++) {
//	 			db = db+ dbList.get(i);
//	 			
//	 		}
//	 		System.out.println(db);
	 		
	        model.addAttribute("review", infoservice.movieReviewsSelctAll(movieCd)); 
	        model.addAttribute("box",boxservice.boxSelectAll());
	 		
	        
	      } catch (Exception e) {
	          e.printStackTrace();
	       }

	        List<ShortComment> shortComment = shortservice.stctAll(Integer.parseInt(movieCd));
	        log.info("??" + shortComment);
			model.addAttribute("shortcomment", shortComment);
			        
			model.addAttribute("moviecd", movieCd);
			
	      log.info("movieCd: " + movieCd);
		
		return "infopage"; 
		
	} // end goInfoMovie()
	
} // end class InfoController
