package edu.spring.posco.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import edu.spring.posco.domain.MovieInfo;

@Service
public class MovieInfoService {
	private static String clientID="WWJKK8nYSknY1spU7Rnj";
	private static String clientSecret="lBAgYKP7GS";
	
	public List<MovieInfo> searchMovie(String keyword,int display, int start) {
		List<MovieInfo> list=null;
		
		
		try {
			URL url;
			url=new URL("https://openapi.naver.com/v1/search/"+"movie.xml?query="
					+URLEncoder.encode(keyword,"UTF-8")
					+(display !=0 ? "&display=" +display:"")
					+(start !=0 ? "&start=" +start : ""));
			//URL 연결
			URLConnection urlConn= url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
			//파싱- 팩토리 만들고 팩토리로 파서 생성( 풀 파서 사용)
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream()));
            
            int eventType=parser.getEventType();
            MovieInfo m= null;
            
            while(eventType !=XmlPullParser.END_DOCUMENT) {
            	switch(eventType) {
            	case XmlPullParser.END_DOCUMENT:
            		break;
            	case XmlPullParser.START_DOCUMENT:
            		 list=new ArrayList<MovieInfo>();
            		 break;
            	case XmlPullParser.START_TAG:{
            		String tag=parser.getName();
            		switch(tag) {
            		case "item":
            			m=new MovieInfo();
            			break;
            		case "title":
            			if(m !=null)
            				m.setMovienm(parser.nextText());
            			break;
            		case "image":
            			if(m !=null)
            				m.setMovieposter(parser.nextText());
            			break;
            		case "subtitle":
            			if(m != null)
            				m.setMovienmen(parser.nextText());
            			break;
            		case "pubDate":
            			if(m != null)
            				m.setOpendt(parser.nextText());
            			break;
            		case "director":
            			if(m != null)
            				m.setDirector(parser.nextText());
            			break;
            		case "actor":
            			if(m!=null)
            				m.setActor1(parser.nextText());
            			break;
            		case "userRating":
            			if( m!=null)
            				m.setAvgpoints(parser.next());
            			break;
            		}
            		break;
            		}
            	case XmlPullParser.END_TAG:{
            		String tag=parser.getName();
            		if(tag.equals("item")) {
            			list.add(m);
            			m=null;	
            		}
        			
            		
            	}
            
            	}
            	eventType = parser.next();
            	}
           
            
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		return list;
	}

	
	
	}


