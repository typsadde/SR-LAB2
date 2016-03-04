import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.io.FileInputStream;

public class testFrameWork {

	public static void main(String[] args) {

		String[] combArray = new String[194];
		Path filePath = Paths.get("C:/Users/sayye/Downloads","jenny_output.txt");
		int k = 0;
		int n;
		byte bufferByte;
		FileInputStream fis = null;

		try{
			fis = new FileInputStream("jenny_output.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
			String line;
			while(((line=br.readLine())!=null) || k<194) {
			//	System.out.println(line);
				combArray[k] = line;
				k++;
			} 
		} catch(Exception e){
			e.printStackTrace();
		}
		for (int i=0;i<combArray.length;i++) {
			System.out.println(combArray[i]);
		}
		//System.out.println(Arrays.toString(combArray));

		sort sortStuff = new sort();
		Random rand = new Random();
		int[] array = new int[20];
		double[] arrayLong = new double[20];
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

