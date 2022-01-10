package com.yedam.java.test02;

public class Main {
	public static void main(String[] args) {
		Card card = new TossCard("5432-4567-9534-3657",20251203,253,"신빛용");
		card.showCardInfo();
		Card card1 = new DGBCard("5432-4567-9534-3657",20251203,253,"신빛용");
		card1.showCardInfo();
		
	}
	

}
