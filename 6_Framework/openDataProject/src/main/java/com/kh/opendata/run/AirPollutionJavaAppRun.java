package com.kh.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.vo.Air;

public class AirPollutionJavaAppRun {

	//발급 받은 인증키 변수처리
	public static final String SERVICEKEY = "tgsexJsoT70XL7QhJyVbu3oIAFAOij%2FhkBsA%2BB4lPQgf567fDoQxwep%2FeclXgua3OJhj%2FUVxmfy%2BwS9l3UMlqQ%3D%3D";



	public static void main(String[] args) throws IOException { // UnsupportedEncodingException의
															// 부모로 예외 처리
		//OpenAPI 서버로 요청하고자 하는 url 작성
		String url ="http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

		//필수
		url += "?serviceKey=" + SERVICEKEY; 
		//서비스키가 제대로 부여 되지 않았을 경우 SERVICE_KEY_IS_NOT_REGISTERED_ERROR 발생
		url +="&sidoName="+ URLEncoder.encode("서울","UTF-8");

		url += "&returnType=json";

		//System.out.println(url);

		//****HttpURLConnection 객체를 활용해서 OpenAPI 요청절차**** 
		// 1. 요청할 주소를 전달해서 java.net.URL 객체 생성하기
		URL requestURL = new URL(url);

		// 2. 생성된 URL 객체를가지고 HttpUrlConnection 객체 얻어내기
		HttpURLConnection urlConn = (HttpURLConnection)requestURL.openConnection();
									//다운캐스팅

		// 3. 요청 시 필요한 Header 설정하기
		urlConn.setRequestMethod("GET");

		// 4. 해당 OpenAPI 서버로 요청 보낸 후 입력 스트림을 통해 응답데이터 받기
		BufferedReader br = new BufferedReader( new InputStreamReader(urlConn.getInputStream()));
		// 보조 스트림 						문자(2바이트) 			보조스트림		기반스트림 Input(1바이트)
		// BufferedReader : 한줄 단위로 읽어 오자!

		String responseText="";
		String line;
		// 한 줄 씩 읽어와 line 에 담고 line null일 때 반복문 종료
		while( (line = br.readLine()) != null) { // 한줄 씩 읽어올 때 데이터가 있는 동안 반복

			//System.out.println(line);
			responseText += line;
		}
		//System.out.println(responseText);
		

		// JSONObject, JSONArray을 이용해서 파싱할 수 있다.(gson라이브러리 필요)
		
		//json데이터를 원하는 데이터만 추출하여 VO에 담기
		//응답데이터 text를 jsonObject화  시키는 작업 필요(파싱)
		JsonObject totalObj = JsonParser.parseString(responseText).getAsJsonObject();
		//System.out.println("total : " + totalObj);
		
		//response 속성 접근
		JsonObject responseObj = totalObj.getAsJsonObject("response");
		//System.out.println("response : "+ responseObj);

		//body 속성 접근
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		//System.out.println("body : "+ bodyObj);
		
		//totalCount 속성 접근
		int totalCount = bodyObj.get("totalCount").getAsInt();
		//System.out.println("totalCount: "+totalCount);
		
		//items (JsonArray형태)속성 접근 
		JsonArray itemArr = bodyObj.getAsJsonArray("items");
		System.out.println("itemArr : "+itemArr);
		

		ArrayList<Air> list = new ArrayList<>();
		
		
		//ites에 담겨 있는 item객체 하나씩 추출
		for(int i=0; i<itemArr.size(); i++) {
			//JsonArr배열에서 하나씩 꺼내올 때 .size사용!
			
			JsonObject item = itemArr.get(i).getAsJsonObject();
			
			//System.out.println(item);
		
			Air air = new Air();
			air.setStationName(item.get("stationName").getAsString()); //측정소명
			air.setDataTime(item.get("dataTime").getAsString()); // 측정일시
			air.setKhaiValue(item.get("khaiValue").getAsString()); //통합대기화
			
			air.setPm10Value(item.get("pm10Value").getAsString()); //미세먼지농도
			air.setSo2Value(item.get("so2Value").getAsString()); //이황가스농도
			air.setCoValue(item.get("coValue").getAsString()); //일산화탄소농도
			air.setNo2Value(item.get("no2Value").getAsString()); //이산화탄소농도
			air.setO3Value(item.get("o3Value").getAsString()); //오존농도
			
			
			list.add(air);
		}
		
		System.out.println("list :" +list);
		
		// list에 담긴 VO 객체확인
		for( Air air : list) {
			System.out.println("air: "+air);
		}
		
		
		
		
		// 5. 다 사용한 스트림 객체 반납하기
		br.close();
		urlConn.disconnect();


	}

}
