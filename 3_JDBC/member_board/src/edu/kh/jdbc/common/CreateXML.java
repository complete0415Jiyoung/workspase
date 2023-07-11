package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateXML { // 주의 사항! 혼자서 실행하면 파일 사라짐 주의!
	
	// XML (eXtansible Markup Language) : 단순화된 데이터 기술 형식 

	
	// XML 사용하려는 이유 
	// DB 연결, SQL 같이 수정이 빈번한 내용을 
	// 코드에 직접 작성하면 좋지 않음
	
	// 왜? JAVA == 컴파일 언어 -> 코드가 조금만 수정되도 전체 컴파일 다시함 
	//							-> 시간이 오래 걸림
	
	// 그런데, XML 외부파일을 이용해서 XML 내용을 바꿔도 
	// 		JAVA에서 XML 파일 읽어오는 코드는 변하지 않음 -> 컴파일 X -> 시간효율 상승
	
	
	
	public static void main(String [] args) {
		
		// XML은 K : V 형식의 map, XML은 문자열만 저장
		
		// MAP <String, String> == properties
		
		// * properties 컬렉션 객체 
		// 1. <String, String> 으로 key, value 가 타입 제한된 Map
		// 2. XML 파일을 생성하고 읽어 오는데 특화 
		
		Properties prop = new Properties();
		
		try {
			FileOutputStream fos = new FileOutputStream("board-sql.xml");
			//											파일 이름
			
			prop.storeToXML(fos, "board Service SQL"); //XML 파일 생성 
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
