package edu.spring.posco.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.posco.domain.Member;

import edu.spring.posco.domain.MovieInfo;

import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.Rvlike;
import edu.spring.posco.service.MemberService;
import edu.spring.posco.service.ReviewService;
import edu.spring.posco.service.RvlikeService;
import edu.spring.posco.service.RvreplyService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	private Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired RvlikeService rvlikeService;
	@Autowired ReviewService reviewService;
	@Autowired MemberService memberService;
	@Autowired RvreplyService rvrerplyService;
	
	@RequestMapping(value = "/review", method = RequestMethod.GET) 
	public void poscoReview(Model model) throws Exception {
		List<Review> reviewList = reviewService.reviewAll();
		model.addAttribute("reviewList", reviewList);
				
	} // end poscoReview()
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void reviewWrite() {
		
	} // end revieWrite()
	

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Review review) {
		log.info("write({})", review);
		// BoardService의 메소드를 사용해서 사용자가 작성한 내용을 DB에 insert
		reviewService.insertReview(review);
		// 서비스 처리가 끝난 후에 게시판 메인 페이지로 이동
		return "redirect:/board/review";
	}
	
	@RequestMapping(value = "/reviewdetail", method = RequestMethod.GET)
	public void reviewDetail(int rvcode, Model model, HttpSession session) {
		log.info("reviewDetail({})", rvcode);
		
		String memberid = (String) session.getAttribute("signinId");
		Rvlike rvlike = null;
		
		if(memberid != null) {
			rvlike = rvlikeService.selectByMemberidRvcode(memberid, rvcode);
			if(rvlike == null) {
				rvlikeService.insertRvlike(memberid, rvcode);
			}
		}
		
		// rvcode로 검색
		Review review = reviewService.searchReviewByRvcode(rvcode);
		model.addAttribute("review", review);
		model.addAttribute("rvlike", rvlike);
		
	} // end reviewDetail()
	
	@RequestMapping(value = "/reviewupdate", method = RequestMethod.GET)
	public void reviewUpdate(int rvcode, Model model) {
		log.info("reviewUpdate({})", rvcode);
		Review review = reviewService.searchReviewByRvcode(rvcode);
		model.addAttribute("review", review);
	} // end reviewUpdate()
	 
	@RequestMapping(value = "/reviewupdate", method = RequestMethod.POST)
	
	public String reviewUpdate(Review review) {
		log.info("reviewUpdate({})", review);
		
		reviewService.updateReview(review);
		
		return "redirect:/board/reviewdetail?rvcode=" + review.getRvcode();
	} // end reviewUpdate()
	
	@RequestMapping(value = "/reviewdelete", method=RequestMethod.GET)
	public String reviewDelete(int rvcode) {
		log.info("reviewUpdate({})", rvcode);

		// rvcode로
		reviewService.deleteReview(rvcode);
		
		// 댓글도 삭제
		rvrerplyService.deleteRvreplyByRvcode(rvcode);

		return "redirect:/board/review";
	} // end reviewDelete()

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/reviewlike", method=RequestMethod.GET)
	public String reviewLike(int rvcode, HttpSession session) {
		String memberid = (String) session.getAttribute("signinId");
		JSONObject obj = new JSONObject();
		
		ArrayList<String> msgs = new ArrayList<>();
		HashMap<String, Object> hash = new HashMap<>();
		
		Rvlike rvlike =  rvlikeService.selectByMemberidRvcode(memberid, rvcode);
		
		Review review = reviewService.searchReviewByRvcode(rvcode);
		int like_cnt = review.getRvrecommcnt();
		int like_check =  rvlike.getLikecheck();
		
		log.info("like_cnt: " + like_cnt);
		log.info("memberid: " + memberid);
		
		// TODO
				
		if(like_check == 0 ) {
			log.info("좋아요!");
			rvlikeService.updateLikecheck(memberid, rvcode);
			like_check++;
		    like_cnt++;
			reviewService.updateRvrecomm(rvcode, 1);
		} else {
			log.info("좋아요 취소");
			rvlikeService.updateLikecheckCancel(memberid, rvcode);
			like_check--;
		    like_cnt--;
			reviewService.updateRvrecomm(rvcode, -1);
		}
		
	
		obj.put("msg", msgs);
		obj.put("like_check", like_check);
	    obj.put("like_cnt", like_cnt);		
		
		
		return obj.toJSONString();
	} // end reviewLike()
	
	// start
	@RequestMapping(value="/moviecd", method = RequestMethod.POST)
	@ResponseBody
	public int ReviewMovieCd(@RequestBody MovieInfo minfo, Model model) throws UnsupportedEncodingException, MalformedURLException {
		int movieCd = 0;
		String movienm = minfo.getMovienm().replace("\"", "");
		String director2 = minfo.getDirector().replace("|", "");
		String director = director2.replace("감독 : ", "");
		// 네이버 openApi의 정보를 통해서 공공데이터포털 영화 정보를 불러옴
				String Url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json"
						+ URLEncoder.encode("?key=26f6b10efd1a1182bfbcc0b33e141537&movieNm="+ movienm + "&directorNm=" + director, "UTF-8");
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
//			           들어가서
			          JSONObject movieListResult = (JSONObject) jsonObject.get("movieListResult");
//			          // 들어가기
			          JSONArray movieList = (JSONArray) movieListResult.get("movieList");
			          // 배열을 오브젝트로 추출해야함
			          JSONObject movieObject = (JSONObject) movieList.get(0);
			          int movieCd2 = Integer.parseInt((String)movieObject.get("movieCd"));
			          System.out.println(movieCd2);
			          movieCd = movieCd2 ;
			       } catch (Exception e) {
			          e.printStackTrace();
			       }
		return movieCd;
	} // end
	
	
	
} // end class BoardController
