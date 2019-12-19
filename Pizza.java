package Pizza;

public class Pizza {

	public static int pizza(double x, int n){
		// x+1 - the optimal number of triangles 
		//px - number of triangles that Eli ate
		//n=(x+1)p+r
		int k = (int)x + 1;
		int p = n/(k+1), r = n%(k+1);
		// ans - number of triangles
		int ans = -1; // r=1 forbidden state
		if( r != 1){
			double t = (x*p + r - 1)/((x+1)*p + r);
			if (t < x/(x+1)){
				ans = 1;// the formula is correct 
			}
			else{
				ans = 0;// the formula is incorrect 
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int loop = 1000000;
		int nminus1 = 0, nplus1 = 0, nzero = 0;
		for (int i = 1; i <= loop; i++) {
			int n = (int)(Math.random()*loop);
			double x = Math.random()*loop;
			int k = pizza(x, n);
			switch(k){
			case -1:
				nminus1++;
				break;
			case 0:
				nzero++;
				break;
			case 1:
				nplus1++;
				break;
			}
		}
		System.out.println("nminus1 = "+nminus1 + ", nzero = " + nzero + ", nplus1 = "+nplus1); 
	}
}
// nminus1 = 15, nzero = 0, nplus1 = 999985