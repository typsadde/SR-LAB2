import java.util.Random;
import java.util.Arrays;

public class sort {
	public static void sortArray(int[] arrayToSort) {
		int switches = 0;
		int buffer = 0;
		System.out.println(Arrays.toString(arrayToSort));
		for(int j=0;j<arrayToSort.length-1;j++) {
			for(int i=0;i<arrayToSort.length-1;i++) {
				if(arrayToSort[i]>arrayToSort[i+1]) {
				//System.out.println("Bookmark");
					buffer = arrayToSort[i+1];
					arrayToSort[i+1] = arrayToSort[i];
					arrayToSort[i] = buffer;
				}
			}
		}
		System.out.println(Arrays.toString(arrayToSort));
	}

	public static int membQuery(int[] array,int member) {
		int x=0,l,r;
		l=1;
		r = array.length;
		while(l<r) {
			x = (l+r)/2;
			if(member==array[x]) {
				return x;
			}
		/*	System.out.println("x is: "+x);
			System.out.println("l is: "+l);
			System.out.println("r is: "+r);*/
			if(member<array[x]) {	
				r = x-1;
			}
			else {
				l = x+1;
			}
		}
		System.out.println("Index is: "+x);
		System.out.println("Value is: "+array[x]);
		
		
		return -1;
		
	}
}


