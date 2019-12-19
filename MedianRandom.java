import java.util.Arrays;
public class MedianRandom {
	// get random array 
	public static int[] randArray(int size){
		int [] a = new int[size];
		for(int i=0; i<a.length; i++){
			a[i] = (int)(Math.random()*a.length);
		}
		return a;
	}
	// Median  of the array
	public static int medianSort(int arr[]){
		Arrays.sort(arr);
		return arr[arr.length/2];
	}
	// number calculation (number > Median) 
	public static int median64(int arr[], int first){
		int max = arr[0];
		for (int i=0; i<first; i++){
			if (max < arr[i]) max=arr[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int a[], med64, med; 
		int count = 0, size = 100001, first = 64;
		for (int i=0; i<100; i++){
			a = randArray(size);
			med64 = median64(a, first);
			med = medianSort(a);
			if (med64>=med) count++;
		}	
		System.out.println("count = "+count+"%");
	}
}
