import java.util.Arrays;

public class sort {
	public void sortArray(int[] arrayToSort) {
		int buffer = 0;
		System.out.println(Arrays.toString(arrayToSort));
		
		for(int j=0;j<arrayToSort.length-1;j++) {
			for(int i=0;i<arrayToSort.length-1;i++) {
				if(arrayToSort[i]>arrayToSort[i+1]) {
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
		
		int left = 0;
		int mid;
        int right = array.length - 1;
        while (left <= right) {
        	mid = left + (right - left) / 2;
            if(member < array[mid]) {
            	right = mid - 1;
            } else if (member > array[mid]) {
            	left = mid + 1;
            } else {
            	return mid;
            }
        }
        return -1;
	}
}


