package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Parent {
	
	public void method() throws FileNotFoundException{
		// 호출한 곳으로  IOException을 던딤 
		// == 해당 매소드는 
		//	IOException을 발생 시킬 가능성이 있음으로 
		// 	호출한 곳에서 예외를 처리해야한다
		
		
		System.out.println("부모 메소드");
		
		// 오버라이딩 시 
		// 예외는 같거나 더 좁은 범위
		// * 좁은 범위 == 구체적인 예외 
		
		//FileNotFoundException
		//IOException의 자식 예외이으로 오버라이딩이 가능!
		
		
		//Exception(모든 예외의 부모)은 
		//IOException의 부모 예외임으로 오버라이딩 불가 ..
		
		
		
		
		
		
		
		
	}

}
