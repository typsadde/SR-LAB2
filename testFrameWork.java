import java.util.Random;

public class testFrameWork {

	public static void main(String[] args) {
		sort sortStuff = new sort();

		Random rand = new Random();
		int[] array = new int[10];
		for (int i=0;i<array.length-1;i++) {
			array[i] = rand.nextInt(100);
		}
		sortStuff.sortArray(array);
		System.out.println("10 is on index: "+(sortStuff.membQuery(array, 10)+1));
		System.out.println();
		System.out.println("50 is on index: "+(sortStuff.membQuery(array, 50)+1));
		System.out.println();
		System.out.println("90 is on index: "+(sortStuff.membQuery(array, 90)+1));
		//System.out.println(Arrays.toString(array));
	}

}