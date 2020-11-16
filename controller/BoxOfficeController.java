package edu.spring.posco.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xmlpull.v1.XmlPullParserException;

import edu.spring.posco.domain.BoxOffice;
import edu.spring.posco.service.BoxService;

@RestController
public class BoxOfficeController {
   private static final Logger log = LoggerFactory.getLogger(BoxOfficeController.class);
   @Autowired BoxService boxservice;
   @RequestMapping(value = "/boxOffice", method = RequestMethod.GET)
   public ResponseEntity<String> readAllReplies(HttpServletResponse response)
         throws XmlPullParserException, IOException {

	   Calendar c1 = new GregorianCalendar();
	   c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷 
	   String date = sdf.format(c1.getTime()); // String으로 저장


	   
	   
      // url 주소
      String Url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"
      		+ "?key=26f6b10efd1a1182bfbcc0b33e141537&targetDt="+ date + "&itemPerPage=10";

      URL url = new URL(Url);

      HttpURLConnection urlconnection = null;
      BufferedReader br = null;
      String result = "";
      
      try {
         urlconnection = (HttpURLConnection) url.openConnection();
         urlconnection.setRequestMethod("GET");
         urlconnection.connect();

		 br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream() , "UTF-8"));
         
		 //네이버 api는 이거 넣어 주기
//         String line;
//         while ((line = br.readLine()) != null) {
//            result = result + line ;
//         }
//         System.out.println(result);
         
         
         JSONParser jsonParse = new JSONParser(); //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
         JSONObject jsonObject = (JSONObject) jsonParse.parse(br.readLine()); //JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다. 
         System.out.println(jsonObject);
         // 들어가서
         JSONObject boxOfficeResult = (JSONObject) jsonObject.get("boxOfficeResult");
         System.out.println(boxOfficeResult);
         // 들어가기
         JSONArray dailyBoxOfficeList = (JSONArray) boxOfficeResult.get("dailyBoxOfficeList");
         System.out.println(dailyBoxOfficeList);
         
         
//         JSONArray boxOffice = (JSONArray) jsonObject.get("dailyBoxOfficeList"); 
//         System.out.println("* dailyBoxOfficeList *");
         
         
         // 기존에 boxOffice 데이터 제거
         boxservice.boxShift();
         
         // openapi 추출 및 DB 저장
         for(int i=0; i<dailyBoxOfficeList.size(); i++) {
        	 System.out.println("=dailyBoxOfficeList_"+ i +" ===========");
        	 
        	// boxservice.boxlist에 넣을라고
             BoxOffice boxOffice = new BoxOffice();
             
        	 // 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object로 추출
        	  
        	 JSONObject boxObject = (JSONObject) dailyBoxOfficeList.get(i);
        	  //JSON name으로 추출
        	  result = result + " 영화코드: " + boxObject.get("movieCd") ;
        	  result = result + " 순위: " + boxObject.get("rank") ;
        	  result = result + " 영화제목: " +boxObject.get("movieNm") ;
        	  result = result + " 개봉년도: " +boxObject.get("openDt") ;
        	  result = result + " 누적관객수: " + boxObject.get("audiAcc") + "\r\n";
        	  boxOffice.setMoviecd(Integer.parseInt((String) boxObject.get("movieCd")));
        	  boxOffice.setRank(Integer.parseInt((String)boxObject.get("rank")));
        	  boxOffice.setMovienm((String)boxObject.get("movieNm"));
        	  boxOffice.setOpendt((String)boxObject.get("openDt"));
        	  boxOffice.setAudiacc(Integer.parseInt((String)boxObject.get("audiAcc")));
        	  System.out.println(boxOffice);
        	  
        	  boxservice.boxList(boxOffice);
         }

//         log.info("DATA: " + boxOffice);
//         System.out.println(boxOffice);
         
      } catch (Exception e) {
         e.printStackTrace();
      }

      // 인터넷에 한글 안 깨지게 해주는 것
      HttpHeaders responseHeaders = new HttpHeaders();
      responseHeaders.add("Content-Type", "application/json; charset=UTF-8");
      
      ResponseEntity<String> entity = new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);

      return entity;
   }

}