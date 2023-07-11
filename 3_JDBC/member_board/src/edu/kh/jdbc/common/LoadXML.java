package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadXML {

	public static void main(String[] args) {
		//외부 XML 파일 읽어 오기 ( Properties 사용)
		Properties prop = new Properties();
		
		try {
			
			prop.loadFromXML(new FileInputStream("driver.xml"));
		
			//Property : 속성 (데이터)
			//prop.getProperty(driver) : XML에서 얻어온 값 중에서
			//							 Key가 driver인 엔트리의 value를 얻어옴
			System.out.println("driver : "+ prop.getProperty("driver"));
			
			//외부파일 미사용
			String str = "oracle.jdbc.driver.OracleDriver";
			System.out.println(str);
			
			//JAVA는 코드가 한 글자라도 변환되면 
			//다시 처음부터 전체내용을 컴파일(이진 코드로 번역)한다 --> 비효율적
			
			//그런데 java에 외부 파일를 읽어오는 변하지 않는 코드를 작성하면 
			//컴파일을 다시 하지 않음 -> 효율적
			
			//컴파일 다시 하지 않아고 외부 파일 내용이 변하면 자동으로 반영 
			
			//DB연결 정보 ,SQL 내용은 빈번히 변화될 예정 
			//1) Java 코드에 직접 작성-> 다시 컴파일 -> 실행 (비효율적) 
			//2) XML에 작성 -> 바로 실행 (다시 컴파일 X , 효율적) 
			// + (추가효과) DB정보, SQL 한곳에 모아서 관리 (보기 좋고, 관리가 쉬움)
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(JDBCTemplate.getConnection());
	}

}
