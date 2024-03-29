public class SubMatrixOf_1OZ {
	public static void main(String[] args) {
		//int mat[][] = MyLibrary.randomMatrixOf01(6, 6);
		int mat1[][] = {{0,0,0,1,0}, {0,1,1,1,0}, {0,1,1,1,0},
				{0,1,1,1,0},{0,1,1,1,0},{0,1,0,1,1}};
		subMatrixOf1(mat1);
	}
	/**Finds the biggest k*k matrix of '1'.
	 * Complexity O(m*n)
	 * @param mat - matrix filled with 0,1*/
	public static void subMatrixOf1(int [][] mat){	
		// a - help matrix
		int [][]a = new int[mat.length][mat[0].length];
		int maxDim = 0, iMax = 0, jMax = 0;		
		boolean squareOfOneFound = false;	
		// copy first row
		for (int j = 0; j < mat[0].length; j++) {
			if (!squareOfOneFound && mat[0][j] == 1){
				maxDim = 1;
				iMax = 0; 
				jMax = j;
				squareOfOneFound = true;
			}
			a[0][j] = mat[0][j];
		}		
		// copy first column
		for (int i = 0; i < mat.length; i++) {
			if (!squareOfOneFound && mat[i][0] == 1){
				maxDim = 1;
				iMax = 0; 
				jMax = i;
				squareOfOneFound = true;
			}
			a[i][0] = mat[i][0];
		}
		for (int i = 1; i < mat.length ; i++) {
			for (int j = 1; j < mat[0].length ; j++) {
				if (mat[i][j] != 0){
					a[i][j] = min3(a[i-1][j-1],a[i-1][j],a[i][j-1])+1;
					if (a[i][j] > maxDim){
						maxDim = a[i][j];
						iMax = i;
						jMax = j;
					}
				}
			}
		}
		MyLibrary.printIntMatrix(mat);
		System.out.println();
		MyLibrary.printIntMatrix(a);
		System.out.println(" maxDim: "+maxDim+", iMax: "+iMax+", jMax: "+jMax);
	}	
	/**returns min(a, b, c)*/
	public static int min3(int a, int b, int c){
		int min = a;
		if (min > b) min = b;
		if (min > c) min = c;
		return min;
	}

}
