package com.yedam.java.ch01;

public interface RemoteControl {
	//상수
	public final static int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0; //interface에선 모든 필드가 상수 (final static 생략해도,...)
	
	//추상메서드
	public abstract void turnOn();
	public void turnOff(); //interface에서 abstract 생락해도 전부 추상 메소드
	public void setVolume(int volume);
	
	
}
