import java.util.Arrays;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class testFrameWork {

	public static void main(String[] args) throws IOException {

		String[] combArray = new String[194];
		int k = 0;
		FileInputStream fis = null;

		// genRandom();
		
		try{
			fis = new FileInputStream("jenny_output.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
			String line;
			while(((line=br.readLine())!=null) || k<194) {
			//	System.out.println(line);
				combArray[k] = line;
				k++;
			} 
			br.close();
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

	
	public static void genRandom() throws IOException {
		int numberOftests = 300;
		Random rand = new Random();
		
		File fout = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		
		for(int i = 0; i < numberOftests; i++) {
			int[] array = new int[20];

			for (int j = 0; j < array.length; j++) {
				array[j] = rand.nextInt(100);
			}
			
			String str = Arrays.toString(array);
			str = str.replace(",", "");
			str = str.replace("[", "");
			str = str.replace("]", "");
			
			bw.write(str);
			bw.newLine();
		}
		
		bw.close();
	}
}

