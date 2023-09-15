package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.vo.Air;

@Controller
public class OpenAPIController {

	//발급 받은 인증키 변수처리
	public static final String SERVICEKEY = "tgsexJsoT70XL7QhJyVbu3oIAFAOij%2FhkBsA%2BB4lPQgf567fDoQxwep%2FeclXgua3OJhj%2FUVxmfy%2BwS9l3UMlqQ%3D%3D";


	//Json형식으로 대기오염 OpenAPI 활용하기
	// @RequestMapping(value = "air", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String airMethod( String location ) throws IOException{ 

		//OpenAPI 서버로 요청하고자 하는 url 작성
		String url ="http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

		url += "?serviceKey=" + SERVICEKEY;  //서비스키 추가
		url += "&numOfRows="+10; // 옵션 선택이고 행의 개수
		url += "&sidoName="+ URLEncoder.encode(location,"UTF-8"); //지역명 추가(한글이 들어가면 인코팅 추가)
		url += "&returnType=json";	// 리턴 타입	


		// 1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);

		// 2. 생성된 URL 객체로 URLCpnnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();

		//3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");

		//4. 해당 OpenAPI 서버로 요청 후 입력스트립을 통해서 응답객체 얻어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));


		String responseText ="";
		String line;
		while((line = br.readLine()) != null){
			responseText += line;
		}

		//5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();


		return responseText;

	}


	//**************************************************************
	// xml 형식으로 대기오염 OpenAPI 활용하기

	@RequestMapping(value = "air", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String airPollution(String location) throws IOException {

		String url ="http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

		url += "?serviceKey=" + SERVICEKEY;  //서비스키 추가
		url += "&sidoName="+ URLEncoder.encode(location,"UTF-8"); //지역명 추가(한글이 들어가면 인코팅 추가)
		url += "&returnType=xml";
		url += "&numOfRows="+20; // 옵션 선택이고 행의 개수


		//1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);

		//2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();

		//3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");

		//4. 해당 OpenAPI 서버로 요청 후 입력스트림을 통해서 응답객체 얻어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

		String responseText ="";
		String line;
		while((line = br.readLine()) != null){
			responseText += line;
		}

		//5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();

		System.out.println(responseText);

		return responseText;

	}

	// xml 형식으로 지진해일 대피소 OpenAPI 활용하기
	@RequestMapping(value = "shelter", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String shelterList() throws IOException {

		String url ="http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";

		url += "?serviceKey=" + SERVICEKEY;  //서비스키 추가
		url += "&pageNo=1"; //지역명 추가(한글이 들어가면 인코팅 추가)
		url += "&numOfRows=10"; // 옵션 선택이고 행의 개수
		url += "&type=xml";


		//1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);

		//2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection();
		
		
		//3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");

		//4. 해당 OpenAPI 서버로 요청 후 입력스트림을 통해서 응답객체 얻어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

		String responseText ="";
		String line;
		while((line = br.readLine()) != null){
			responseText += line;
		}

		//5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();


		System.out.println(responseText);
		return responseText;


	}







}
