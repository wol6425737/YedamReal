package com.yedam.java.ch0502;

import java.util.Scanner;

public class baekjun2752 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] sort = new int[3];
		int temp = 0;
		for(int i = 0; i<sort.length;i++) {
			sort[i] = scanner.nextInt();
		}
		//버블정렬
		for(int i =sort.length; i>1;i--) {
			for(int j = 1; j<i;j++) {
				if(sort[j-1] > sort[j]) {
					temp = sort[j-1];
					sort[j-1] = sort[j];
					sort[j] = temp;
				}
			}
			

		}
		for(int i =0; i<sort.length;i++) {
			System.out.print(sort[i] + " ");
			}
		
		scanner.close();
	}
}
