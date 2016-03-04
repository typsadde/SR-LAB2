import java.util.Random;

public class testFrameWork {

	public static void main(String[] args) {
				
		sort sortStuff = new sort();
		Random rand = new Random();
		int[] array = new int[20];
		
		for (int i=0;i<array.length-1;i++) {
			array[i] = rand.nextInt(100);
		}
		sortStuff.sortArray(array);
		int randommember = rand.nextInt(100);
		
		System.out.println("Looking for member: " + randommember);
		
		int memberIndex = sortStuff.membQuery(array, randommember);
		
		if(memberIndex == -1) {
			System.out.println("The member could not be found");
		} else {
			System.out.println("Member is on index: " + memberIndex);
		}
	}

}
