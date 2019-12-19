import java.util.Arrays;


public class GlassBalls {

	public static int eqExperiment(int q, int[]arr){
		// if arr[i-1] < q < arr[i] the ball is broken in floor i..
		int n = arr.length, count = 0;
		int step = (int)(Math.sqrt(n));
		if (step*step<n) step++;
		int floor = step;
		boolean isBroken = false;
		// the first ball
		while(!isBroken && floor < n){
			count++;
			if (arr[floor] > q) isBroken = true;
			else{
				floor = floor + step;
			}
		}
		if (floor >= n){ // try last floor
			if (arr[n-1] > q) isBroken = true;
			count++;
		}
		// the second ball
		floor = floor - step;
		if (isBroken){
			isBroken = false;
			while (!isBroken && floor < n){
				count++;
				if (arr[floor] > q) isBroken = true;
				else floor++;
			}
		}
		return count;
	}
	public static int triangleExperiment(int q, int[]arr){
		// ifarr[i-1] < q < arr[i] the ball is broken in floor i..
		int n = arr.length, count = 0;
		// non-equal parts: 1,2,3,4,5,...number 
		// while (1+2+...< numFloors)
		// 1+2+...+number = number*(number+1)/2
		int k = 1;
		while (n > k*(k+1)/2){
			k++;
		}
		int step = k;
		int floor = step;
		boolean isBroken = false;
		// the first ball
		while(!isBroken && floor < n){
			count++;
			if (arr[floor] > q) isBroken = true;
			else floor = floor + (--step);
		}
		if (floor >= n){ // try last floor
			if (arr[n-1] > q) isBroken = true;
			count++;
		}
		// the second ball
		floor = floor - step;
		if (isBroken){
			isBroken = false;
			while (!isBroken && floor < n){
				count++;
				if (arr[floor] > q) isBroken = true;
				else floor++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int size = 120, num = 100000;//n^2=121, n==11; k(k+1)/2 = 120, k=15
		int to = size*5, countEq = 0, countTrian = 0;
		System.out.println("size = "+ size + ", 2*sqrt(size) = " + 2*Math.sqrt(size) + ", sqrt(2*size) = " + Math.sqrt(2*size));

		for (int i = 1; i <= num; i++) {
			int []arr = MyLibrary.randomIntegerDiffArray(size, to);
			Arrays.sort(arr);
			//System.out.println(Arrays.toString(arr));
			int q = (int)(Math.random()*arr[size-1]+1);
			//System.out.println("q = "+q);
			
//			int[]arr = {3, 9, 14, 20, 24, 27, 30, 31, 35, 40, 46, 56};
//			int q = 38;
			countEq = countEq + eqExperiment(q, arr);
			countTrian = countTrian + triangleExperiment(q, arr);
		}
		System.out.println("Eq Experiment count = "+countEq+", average = "+(double)countEq/num);
		System.out.println("Triangle Experiment count = "+countTrian+", average = "+(double)countTrian/num);
		
	}
}
