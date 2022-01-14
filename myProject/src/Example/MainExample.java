package Example;

public class MainExample {
	public static void main(String[] args) {
		
		int[] intArray = normalballArray();
		for(int a : intArray) {
			System.out.print(a + " ");
		}

	}
	
	public static int[] normalballArray() {
		int[] intArray = new int[10];
		for(int i = 0; i<intArray.length;i++) {
			intArray[i] = (int)(Math.random()*10);
			}
		return intArray;
	}

}
