
public class Exponenta {
	public static double powerLoop(double x , int n ){
		double result = 1;
		while (n!=0) {
			if (n%2 == 1) result = result*x;
			x = x*x;
			n=n/2;
		}
		return result;

	}

	public static double powerRecursion(double x, int n){
		double result = 1;
		if (n == 0){// exit of recursion
			result = 1;
		}
		else if (n%2 == 0){// n is even
			result = powerRecursion(x*x, n/2);
		}
		else{// n is odd
			result = x*powerRecursion(x*x, (n - 1)/2);
		}
		return result;
	}
	public static void main(String[] args) {		
		System.out.println("loop:\n");
		for(int i=0; i<=10; i++){
			System.out.print(powerLoop(2, i)+", ");			
		}
		System.out.println();
		for(int i=0; i<=10; i++){
			System.out.print(powerLoop(3, i)+", ");			
		}
		System.out.println();
		for(int i=0; i<=10; i++){
			System.out.print(powerLoop(5, i)+", ");			
		}	
		// recursion
		System.out.println("\n\nrecursion\n");
		for(int i=0; i<=10; i++){
			System.out.print(powerRecursion(2, i)+", ");			
		}
		System.out.println();
		for(int i=0; i<=10; i++){
			System.out.print(powerRecursion(3, i)+", ");			
		}
		System.out.println();
		for(int i=0; i<=10; i++){
			System.out.print(powerRecursion(5, i)+", ");			
		}
		System.out.println();
	}

}
