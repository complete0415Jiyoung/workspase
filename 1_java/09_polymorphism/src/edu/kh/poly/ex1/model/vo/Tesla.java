package edu.kh.poly.ex1.model.vo;

public class Tesla extends Car{ //전기차 
	
	private int betterCapacity; //배터리 용량

	
	public Tesla() {
	 super(); //부모생성자 (Car)
	}
	
	//매개변수 생성자 (상속 버전)
	//alt + shift -> o -> 아래방향키->enter
	public Tesla(String engine, String fuel, int wheel, int betterCapacity) {
		super(engine, fuel, wheel);
		this.betterCapacity = betterCapacity;
	}

	//getter/ setter
	public int getBetterCapacity() {
		return betterCapacity;
	}

	public void setBetterCapacity(int betterCapacity) {
		this.betterCapacity = betterCapacity;
	}
	
	
	//Car.toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + " / " + betterCapacity;
	}
	
}
