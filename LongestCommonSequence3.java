package Lcs_Lis;

import java.util.Arrays;

public class LongestCommonSequence3 {
// build matrix of numbers
	public static int[][] buldMatrix(int[] X, int [] Y) {
		int row = X.length+1,  col = Y.length+1;
		int mat[][] = new int[row][col]; 
		int i=0, j=0;
// first column
		for (i=0; i<row; i++) mat[i][0]=0;
// first row
		for (j=0; j<col; j++) mat[0][j]=0;
// Matrix Interior 
		for (i=1; i<row; i++) {
			for (j=1; j<col; j++) {
				if (X[i-1]==Y[j-1]){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}
// the function returns max common sequence length
	public static int maxSeqLength(int[] X, int [] Y){
		int row = X.length+1,  col = Y.length+1;
		int mat[][] = buldMatrix(X, Y); 
		return mat[row-1][col-1];
	}
// the function returns max common sequence of two integer sequences
	public static int[] maxSequence(int[] X, int [] Y){
		int mat[][] = buldMatrix(X, Y); 
		//MyLibrary.printIntMatrix(mat);
		int row = mat.length;
		int col = mat[0].length;
		int seqLength = mat[row-1][col-1];
		int result[] = new int[seqLength];
		int i=row-1, j=col-1, count=seqLength-1;
		while (count>=0){
			if (X[i-1]==Y[j-1]){
				result[count--]=X[i-1];
				i--;
				j--;
			}
			else if (mat[i][j]==mat[i][j-1]) j--;
			else  i--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		//int X[]={3,1,1,4,1,4};// != greedy
		//int Y[]={1,1,1,1,3,4,2}; //!= greedy
		int Y[] = {1,4,3,1,2,1}; //"bdcaba";
		int X[] = {1,2,3,2,4,1,2}; //"abcbdab";
		System.out.println("max seq len = "+maxSeqLength(X, Y));
		System.out.println(Arrays.toString(maxSequence(X, Y)));
	}

}
