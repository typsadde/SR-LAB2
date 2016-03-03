import java.util.Random;

public class testFrameWork {

	public static void main(String[] args) {
		sort sortStuff = new sort();
		Random rand = new Random();
		int[] array = new int[20];
		//int[] array = new int[20];
		/*Valid int for array*/
		for (int i=0;i<array.length-1;i++) {
			array[i] = rand.nextInt(100);
		}
		sortStuff.sortArray(array);
		System.out.println("Member is on index: "+(sortStuff.membQuery(array, rand.nextInt(100))+1));
				//System.out.println(Arrays.toString(array));
	}

}
