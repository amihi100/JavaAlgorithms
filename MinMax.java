package MinMax;

public class MinMax {
	// Search of maximum && minimum elements by pairs
	public static int minMaxPairs(int []arr){
		int min, max, comparisons=0;
		min = arr[0];
		max = arr[1];
		comparisons++;
		if (arr[0]>arr[1]){
			min = arr[1];
			max = arr[0];			
		}
		for (int i=2; i<arr.length-1; i=i+2){
			comparisons++;
			if(arr[i]<arr[i+1]){
				comparisons = comparisons + 2;
				if(arr[i]<min)  min = arr[i];
				if(arr[i+1]>max)  max = arr[i+1];
			}
			else{
				comparisons = comparisons + 2;
				if(arr[i+1]<min)  min = arr[i+1];
				if(arr[i]>max)  max = arr[i];				
			}
		}
		// if number of elements is odd, we check the last element
		if (arr.length!=0){
			comparisons++;
			if (arr[arr.length-1]>max){
				max = arr[arr.length-1];
			}
			else{
				comparisons++;
				if (arr[arr.length-1]<min){
					min = arr[arr.length-1];					
				}
			}
		}
		//		System.out.println("min = "+min+", max = "+max);
		return comparisons;
	}
	// standard algorithm for search of maximum && minimum elements
	public static int minMaxStandard(int []arr){
		int max = arr[0], min = arr[0], comparisons = 0;
		for (int i=1; i<arr.length; i++){
			comparisons++;
			if(arr[i] < min){
				min = arr[i];
			}
			else{
				comparisons++;
				if(arr[i] > max){
					max = arr[i];
				}
			}
		}
		//		System.out.println("min = "+min+", max = "+max);
		return comparisons;
	}
	// average number of comparisons in standard algorithm
	public static double meanNumOfComparisonsStandard(int size,int num){
		int comparisons = 0;
		for (int i=0; i<num; i++){
			int [] arr = MyLibrary.randomIntegerArray(size);
			comparisons = comparisons + minMaxStandard(arr);
		}
		return ((double)comparisons)/num;
	}
	// average number of comparisons in standard algorithm
	public static double meanNumOfComparisonsPairs(int size,int num){
		int comparisons = 0;
		for (int i=0; i<num; i++){
			int [] arr = MyLibrary.randomIntegerArray(size);
			// MyLibrary.printIntegerArray(arr);
			comparisons = comparisons + minMaxPairs(arr);
		}
		return ((double)comparisons)/num;
	}
	public static void main(String[] args) {
		/// number of comparisons
		int size = 100000, num = 1;
		double c1 = meanNumOfComparisonsStandard(size, num);
		System.out.println("num of comparisons standard: "+c1+", rate = "+c1/size);
		double c2 = meanNumOfComparisonsPairs(size, num);
		System.out.println("num of comparisons pairs: "+c2+", rate = "+c2/size);
	}
}
// OUTPUT
//num of comparisons standard: 199987.0, rate = 1.99987
//num of comparisons pairs: 150000.0, rate = 1.5
