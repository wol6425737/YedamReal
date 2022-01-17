package myproject1.src.Example;

public class MainExample {
	public static void main(String[] args) {

		int[] intArray = normalballArray();
		for (int a : intArray) {
			System.out.print(a + " ");
		}
		
		int pb = powerball();
		System.out.println(pb);

	}

	// 일반볼 1~28까지 숫자 중 5개 추첨
	public static int[] normalballArray() {
		int[] intArray = new int[5];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) ((Math.random() * 28) + 1);
			System.out.println("index " + i + "번째는 " + intArray[i]);
			for (int j = 0; j < i; j++) {
				if (intArray[j] == intArray[i]) {
					i--;
				}
			}
		}
		return intArray;

	}
	
	// 파워볼 0부터 9까지 숫자 중 1개 추첨
	public static int powerball(){
		
		int pb = (int) ((Math.random() * 10));
		
		return pb;
	}

}
