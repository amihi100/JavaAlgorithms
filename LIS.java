package Lcs_Lis;
import java.util.Arrays;

public class LIS {
// binary search between in array
	public static int binarySearchBetween(int []arr, int end, int value){
/**
	if value<arr[0] the function returns zero
	if value>arr[end] the function returns  end+1
	if arr[index-1] < value < arr[index]
	the function returns index,
*/
		int low = 0, high = end;
		if (value<arr[0]) return 0;
		if (value>arr[end])  return end+1;
		while (low <=high){
			int middle = (low + high)/2;
			if (low == high) {// stop search
				return low;
			}
			else {
				if (arr[middle] == value){//value was found
					return middle;
				}
				if (value < arr[middle]){// value suppose to be left
					high = middle;
				}
				else{// value suppose to be right
					low = middle+1;
				}
			}
		}
		return -1;
	}
// binary search between in diagonal of matrix
	public static int binarySearchBetween(int [][]arr, int end, int value){
/**
	if value<arr[0] the function returns zero
	if value>arr[end] the function returns  end+1
	if arr[index-1] < value < arr[index]
	the function returns index,
*/
		int low = 0, high = end;
		if (value<arr[0][0]) return 0;
		if (value>arr[end][end])  return end+1;
		while (low <=high){
			int middle = (low + high)/2;
			if (low == high) {// stop search
				return low;
			}
			else {
				if (arr[middle][middle] == value){//value was found
					return middle;
				}
				if (value < arr[middle][middle]){// value suppose to be left
					high = middle;
				}
				else{// value suppose to be right
					low = middle+1;
				}
			}
		}
		return -1;
	}
	// array contains different integer numbers,assumption: arr.length>2
	// calculation of the length of largest increment subsequence
	public static int LISLength(int [] arr){
		int size = arr.length;
		int d[] = new int[size];
		d[0] = arr[0];
		int end = 0;
		for (int i=1; i<size; i++){
			int index = binarySearchBetween(d, end, arr[i]);
			d[index] = arr[i];
			if (index>end) end++;
		}
		return end+1;
	}
	public static int[] LIS2(int [] arr){
		int size = arr.length;
		int mat [][] = new int[size][size];
		mat [0][0] = arr[0];
		int end = 0;
		for (int i=1; i<size; i++){
			int index = binarySearchBetween(mat, end, arr[i]);
			mat[index][index] = arr[i];
			for(int j=0; j<index; j++){
				mat[index][j]=mat[index-1][j];
			}
			mat[index][index] = arr[i];
			if (index>end) end++;
			//MyLibrary.printIntMatrix(mat);
			//System.out.println();
		}
		int ans[] = new int[end+1];
		for(int j=0; j<=end; j++) ans[j]=mat[end][j];
		return ans;
	}
	// the longest decreasing sequence
	public static int[] LDS2(int [] arr){
		int t[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			t[i] = -arr[i];
		}
		int []ans = LIS2(t);
		for (int i = 0; i < ans.length; i++) {
			ans[i] = -ans[i];
		}
		return ans;
	}
	public static void checkLIS2(){
		int size = 10;
		//int [] arr ={8,1,100,101,2}; 
		int []arr = {0, 1, 101, 9, 10, 11, 1, 2, 3, 100, 4, -1, 5, 6};
		//int [] arr ={8,1,100,101,2,3,4,102,100,101,50}; 
		//int[]arr = {1,6,100,5,200};
		//int [] arr ={6,5,4,3,2,1}; 
		//int [] arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		//int [] arr = {8, 2, 9, 3, 1, 10, 4, 6, 5, 7}; 
		System.out.println(Arrays.toString(arr));
		int m = LISLength(arr);
		System.out.println("m = "+m);
		int [] d = LIS2(arr);
		System.out.println(Arrays.toString(d));
	}
	public static void checkLDS2(){
		int size = 10;
		//int [] arr ={8,1,100,101,2}; 
		//int [] arr ={8,1,100,101,2,3,4,102,100,101,50}; 
		//int[]arr = {1,6,100,5,200};
		//int [] arr ={6,5,4,3,2,1}; 
		//int [] arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		int [] arr = {8, 2, 9, 3, 1, 10, 4, 6, 5, 7}; 
		System.out.println(Arrays.toString(arr));
		int [] d = LDS2(arr);
		System.out.println(Arrays.toString(d));
	}
	public static void main(String[] args) {
		checkLIS2();
		//checkLDS2();
	}
}
