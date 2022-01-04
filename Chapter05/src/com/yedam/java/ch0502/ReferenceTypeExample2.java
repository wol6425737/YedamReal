package com.yedam.java.ch0502;

public class ReferenceTypeExample2 {
	public static void main(String[] args) {
		for(int i= 0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		//다차원 배열 -> 배열의 배열
		int[][] mathScores = new int[2][3];
		for(int i=0; i<mathScores.length; i++) {
			for(int j=0; j<mathScores[i].length; j++) {
				System.out.printf("mathScores[%d][%d] : "+ mathScores[i][j] + "\n" ,i,j);
				
			}
		}
		
		int[][] englishScores = new int[2][];
		englishScores[0] = new int[2];
		englishScores[1] = new int[3];
		for(int i = 0; i<englishScores.length;i++) {
			for(int j =0; j<englishScores[i].length; j++) {
				System.out.println("englishScores["+i+"]["+j+"]:" + englishScores[i][j]);
			}
		}
		
		int[][] javaScores = {{95, 80}, {92, 96, 80}};
		for(int i=0; i<javaScores.length; i++) {
			for(int j=0; j<javaScores[i].length;j++) {
				System.out.println("javaScores["+i+"]["+j+"]: " + javaScores[i][j]);
			}
		}
		
		
	}

}
