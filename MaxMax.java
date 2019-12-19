package MaxMax;

import java.util.Arrays;
/**
   Three algorithms search for 2 largest elements of an array. 
   Each function returns the number of comparisons
   A={arr[0], arr[1], . . . ,arr[arr.length]}
   max1 = maximum{A}
   max2 = maximum{A\max1}
   Remark: the start values of max1, max2 must be different.
   Assumptions: 
   				1)elements of the array are different
   				2) array length > 2
 **/
public class MaxMax {
	/**
	 * The function twoMaxGreatThanMax1 
	 * searches two largest elements of the an array
	 * the first check is: a[i]>max1 
	 * @param arr - the array
	 * @return variable count the number of comparisons
	 */
	public static int twoMaxGreatThanMax1(int arr[]){//2n comparisons
		int max1, max2, count = 1;
		int start = 1;
		// initialization
		max1 = arr[0];
		while (max1 == arr[start]) start++;
		max2 = arr[start];
		if (arr[0]<arr[start]){
			max1 = arr[start];
			max2 = arr[0];
		}
		// the main loop
		for (int i=2; i<arr.length; i++){
			// the first comparison
			count++;
			if(arr[i] > max1){
				max2=max1;
				max1=arr[i];
			}
			else{
				count++;
				if(arr[i]>max2) max2=arr[i];
			}
		}
		// the result:
		System.out.println("max1 = "+max1+", max2 = "+max2);
		return count;
	}
	/**
	 * The function twoMaxLessThanMax2 
	 * searches two largest elements of the an array
	 * the first check is: a[i]>max2 
	 * @param arr - the array
	 * @return variable count the number of comparisons
	 */
	public static int twoMaxLessThanMax2(int arr[]){//n comparisons
		int max1, max2, comparisons = 0;
		int start = 1;
		// assumption: array length > 2
		max1 = arr[0];
		while (max1 == arr[start]) start++;
		max2 = arr[start];
		comparisons++;
		if (arr[0]<arr[start]){
			max1 = arr[start];
			max2 = arr[0];
		}
		// the main loop
		for (int i=start; i<arr.length; i++){
			comparisons++;
			// the first comparison
			if(arr[i] > max2){ 
				comparisons++;
				if (arr[i] < max1) max2 = arr[i];
				else{
					max2 = max1;
					max1 = arr[i];
				}
			}
		}
		// print the result:
		System.out.println("max1 = "+max1+", max2 = "+max2);
		return comparisons;
	}
	public static int[] randArr(int size){
		int arr[] = new int[size];
		int i=0;
		while(i<size) arr[i++] = i;
		for (int j = 0; j < size; j++) {
			 int index = (int)(Math.random()*size); 
			 swap(arr, j, index);
		}
		return arr;		
	}
	private static void swap(int[]arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	// 
	public static void main(String[] args) {
		// two largest elements
		int size = 10000000, count;
		System.out.println("size = "+size);
		long start, end;
		double diff;
		int arr[] = randArr(size);

		/// twoMaxGreatThanMax1 
		start = System.currentTimeMillis();
		count = twoMaxGreatThanMax1(arr);
		end = System.currentTimeMillis();
		diff = ((double)(end - start))/1000.0;
		System.out.println("time twoMaxGreatThanMax1: "+diff);
		System.out.println("number of comparisons: "+count);
		System.out.println();

		/// twoMaxLessThanMax2 
		start = System.currentTimeMillis();
		count = twoMaxLessThanMax2(arr);
		end = System.currentTimeMillis();
		diff = ((double)(end - start))/1000.0;
		System.out.println("time twoMaxLessThanMax2: "+diff);
		System.out.println("number of comparisons: "+count);
		System.out.println();
		// check 
		Arrays.sort(arr);
		//System.out.println("check: max1="+arr[arr.length-1]+", max2="+arr[arr.length-2]);				
	}
}
/** the results:
	size = 10000000
	max1 = 10000000, max2 = 9999999
	time twoMaxGreatThanMax1: 0.031
	number of comparisons: 19999978
	
	max1 = 10000000, max2 = 9999999
	time twoMaxLessThanMax2: 0.032
	number of comparisons: 10000043
 **/
