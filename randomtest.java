import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class randomtest extends TestCase {

	private int[] numberarray;
	private static int[][] numbers;
	private static int MAX = 100;
	private static int SIZE = 20;

//	@Before
//	public void setUp() throws Exception {
//		numbers = new int[SIZE][SIZE];
//		Random generator = new Random();
//		for (int i = 0; i < numbers.length; i++) {
//			for(int j = 0; j < numbers.length; j++) {
//				numbers[i][j] = generator.nextInt(MAX);
//			}
//		}
//	}

	public randomtest(int[] li1) {
		this.numberarray = li1;
	}

	@Parameters
	public static Collection<int[]> generateData()
	{
		// In this example, the parameter generator returns a List of
		// arrays.  Each array has two elements: { datum, expected }.
		// These data are hard-coded into the class, but they could be
		// generated or loaded in any way you like.
		
		numbers = new int[SIZE][SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length; j++) {
				numbers[i][j] = generator.nextInt(MAX);
			}
		}
		
		List<int[]> list = new ArrayList<int[]>();
	    for (int[] array : numbers) {
	        list.addAll(Arrays.asList(array));
	    }
		
		return list;
	}

	@Test
	public void SortingTest() {
		long startTime = System.currentTimeMillis();

		sort sorter = new sort();
		sorter.sortArray(numberarray);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Our sorting time " + elapsedTime);

		if (!validate(numberarray)) {
			fail("Should not happen");
		}
		assertTrue(true);
	}
	
	
//	@Test
//	public void MemberTest() {
//		long startTime = System.currentTimeMillis();
//
//		sort sorter = new sort();
//		sorter.sortArray(numberarray);
//
//		long stopTime = System.currentTimeMillis();
//		long elapsedTime = stopTime - startTime;
//		System.out.println("Our sorting time " + elapsedTime);
//
//		if (!validate(numberarray)) {
//			fail("Should not happen");
//		}
//		assertTrue(true);
//	}


	private boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
