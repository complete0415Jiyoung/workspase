package edu.kh.poly.ex2.model.service;

//계산기 인터페이스 
//-> 모든 계산기에 대한 공통된 필드, 기능명을 제공하는 접점(interface)용도
public interface Calculator {
	//인터페이스: 추상클래스의 변형체(추상클래스 보다 추상도가 높음)
	//	-추상 클래스: 일부만 추상 (0개 이상) 
	//	-인터페이스 : 모두 추상메소드
	
	//필드 (묵시적 암묵적으로 public static final)
	// 어떻게 작성하든 public static final
	public static final double p1 = 3.14;
	static final int MAX_NUM =100000;
	public int MIN_NUM = -1000000;
	int ZERO = 0;
	
	
	//메소드(묵시적 public abstract)
	public abstract int plus (int num1, int num2);
	
	public abstract int minus(int num1, int num2);
	
	public abstract int multiple (int num1, int num2);
	
	public abstract double divide (int num1, int num2);
	

}
