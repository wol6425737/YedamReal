package com.yedam.java.ch05;

public class Won2Dollar extends Converter {
	
	public Won2Dollar(double ratio){
		super(ratio);
		this.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		
		return src / ratio;
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "원";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "달러";
	}
	
	

}
