import java.util.Random;
import java.util.Arrays;

public class sort {
	public void sortArray(int[] arrayToSort) {
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

	// @ requires i >= 0;
	public int membQuery(int[] array,int member) {
		int x=0,l,r;
		l=1;
		r = array.length;
		while(l<r) {
			x = (l+r)/2;
			if(member==array[x]) {
				return x;
			}
			
			if(member<array[x]) {	
				r = x-1;
			}
			else {
				l = x+1;
			}
		}

		return -1;	
	}
}


