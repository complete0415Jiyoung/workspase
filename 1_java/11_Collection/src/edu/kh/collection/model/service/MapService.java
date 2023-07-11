 package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {
	
	//Map : key 와 value 한쌍이 데이터가 되어 이를 모아둔 데이터의 객체

	
	// - Key를 모아두면 Set의 특징 (중복X)
	// - value를 모아두면 List의 특징(중복O)
	
	public void ex1() {
		
		//HashMap<k,v> Map의 자식 클래스 중 대표되는 Map
		
		Map<Integer , String > map = new HashMap<Integer, String>();
		
		//Map.put(Integer key , String value) : 추가 (put :놓다)
		map.put(1, "홍길동");
		map.put(2, "홍길1");
		map.put(3, "홍길2");
		map.put(4, "홍길3");
		map.put(5, "홍길4");
		map.put(6, "홍길5");
		
		
		//key 중복
		map.put(1, "홍홍홍");//중복 허용 안함 대신value덮어 쓰기 

		//value 중복 
		map.put(7,  "홍길5");
		
		System.out.println(map); //map.toString( )오버라이딩 되어있음 
		
		
	}
	
	public void ex2() {
		//Map의 사용 예제
		
		//VO (값 저장용 객체) 는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용 
		//-> 재사용이 적은 VO 는 오히려 코드 낭비이다. 
		//-> 이때, Map을 이용해서 VO와 비슷한 코드 작성할 수있다. 
		
		//1)VO버전
		Member mem = new Member();
		
		//값세팅 
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		
		//값 출력
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
	
		System.out.println("------------------");
	
		//2)Map버전
		Map <String, Object> map = new HashMap<String, Object>();
		//value가 Object타입 == 어떤 객체든 value에 들어올 수 있다. 
		//다향성의 업캐스팅

		//값세팅
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25);
					//int -> Integer(AutoBoxing) - 대입 -> Object
		
		//값출력
		System.out.println(map.get("id").toString());
		//@가 사라져 있네? 왜 사라졌을꽈?
		//String java.lang.Object.toString() -> 정적바인딩 
		//실행중 확인해보니까 String 자식객체 -> 자식 toString()호출 -> 동적바인딩 
		//다향성(업케스팅) + 동적바인딩
		
		System.out.println(map.get("pw"));
		System.out.println(map.get("age")); 
		
		//***Map에 저장된 데이터 순차적으로 접근하기***
			
		//Map에서 Key만 모아두면 Set의 특징을 가진다. 
		//->이를 활용할 수 있도록 Map에서 
		//	keySet()메소드 제공
		//		--> key 만 모아서 Set으로 반환
		
		Set<String>set = map.keySet(); //id, pw, age가 저장된 Set반환 
		
		System.out.println(set);
		
		//향상된 for 문
		for(String key:set) {
			System.out.println(map.get(key));
						//key가 반복 될때 마다 변경 
						//-> 변경된 Key에 맞는 value가 출력 된다.
		}
		//Map에 저장된 데이터가 많거나
		//어떤 key가 있는지 불분명 할 때
		//Map에 저장된 모든 데이터에 접근해야 할때 
		//keySet() + 향상된 for문 코드 사용한다.
	}
	
	public void ex3() {
		
		List< Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		for(int i=0; i<10; i++ ) {
			//Map 생성 
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			//Map데이터 추가 
			map.put("id", "user0"+i);
			map.put("pw", "pass0"+i);
			
			//Map을 List에 추가 
			list.add(map);
			
		}
		//for문 종료시  List에는 10개의 Map객체가 추가 되어 있다
				
		//List에 저장된 Map에서 key가 "id"인 경우 value를 모두 출력
		
		//향상된 for 문
		for(Map <String,Object> temp :list) {
			System.out.println(temp.get("id"));
		}
	}
}
