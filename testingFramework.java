
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testingFramework extends TestCase {

	private int[] numberarray;
	private int key = -1;
	
	private static int[][] numbers;
	private static int[] query;
	
	private static int MAX = 100;
	private static final int ARRAYSIZE = 20;
	private static int SAMPLES = 20;
	
	private final static int ARRAYINDEX = 0;
	private final static int KEYINDEX = 1;

	public testingFramework(int[] li1, int k) {
		this.numberarray = li1;
		this.key = k;
	}

	@Parameters
	public static Collection<Object[]> generateData() {
		
		FileInputStream fis = null;
		
		List<int[]> inputFile = new ArrayList<int[]>();

		try{
			fis = new FileInputStream("out.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
			String line;
			while(((line = br.readLine()) != null)) {
				String[] items = line.split(" ");
				
				int[] results = new int[items.length];

				for (int i = 0; i < items.length; i++) {
				    try {
				        results[i] = Integer.parseInt(items[i]);
				    } catch (NumberFormatException nfe) {};
				}
				
				inputFile.add(results);
			} 
			
			SAMPLES = inputFile.size();
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		query = new int[SAMPLES];
		numbers = new int[SAMPLES][ARRAYSIZE];
		Random generator = new Random();
		
		for (int i = 0; i < SAMPLES; i++) {
			numbers[i] = inputFile.get(i);
			query[i] = generator.nextInt(MAX);
		}
	    
	    Object[][] data = new Object[SAMPLES][2];
	    
	    for(int i = 0; i < SAMPLES; i++) {
	    	data[i][ARRAYINDEX] = numbers[i];
	    	data[i][KEYINDEX] = query[i];
	    }
	    
	    return Arrays.asList(data);
	}

	@Test
	public void SortingTest() {
		long startTime = System.currentTimeMillis();

		sort sorter = new sort();
		sorter.sortArray(numberarray);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Our sorting time " + elapsedTime);

		if (!validateSorting(numberarray)) {
			fail("Array not sorted correctly");
		}
		assertTrue(true);
	}
	
	
	@Test
	public void MemberTest() {
		
		sort sorter = new sort();
		int memberat = sorter.membQuery(numberarray, key);
		
		System.out.println("Looking for key: " + key);
		System.out.println("Memberat gives: " + memberat);
		System.out.println("Validatemember gives: " + validateMember(numberarray, key));

		if (validateMember(numberarray, key) && memberat == -1) {
			fail("Key is a member but is not found");
		}
		assertTrue(true);
	}


	private boolean validateSorting(int[] numbers) {
		for (int i = 0; i < ARRAYSIZE - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean validateMember(int[] numbers, int key) {
		for(int i = 0; i < ARRAYSIZE - 1; i++) {
			if(numbers[i] == key) {
				return true;
			}
		}
		return false;
	}
}
