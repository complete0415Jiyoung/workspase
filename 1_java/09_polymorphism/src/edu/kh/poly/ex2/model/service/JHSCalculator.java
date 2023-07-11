package edu.kh.poly.ex2.model.service;

public class JHSCalculator implements Calculator{
	@Override
	public int plus(int num1, int num2) {
		return num1 + num2 + MAX_NUM;
	}

	@Override
	public int minus(int num1, int num2) {
	    return num1 - num2 + MAX_NUM;
	}

	@Override
	public int multiple(int num1, int num2) {
	    return num1 * num2 + MAX_NUM;
	}

	@Override
	public double divide(int num1, int num2) {
	    return (double) num1 / num2 + MAX_NUM;
	}

}
