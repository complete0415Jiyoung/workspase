package edu.kh.oop.cls.run;

import edu.kh.oop.cls.model.service.ClsService;

public class ClsRun {

	public static void main(String[] args) {

		ClsService service = new ClsService();
		
		//service.ex1(); //
		//service.ex2(); // static 확인 예제 호출 
		//service.ex3(); // 생성자 예제 
		service.ex4();	//매게변수 생성자 예제
		

	}

}
