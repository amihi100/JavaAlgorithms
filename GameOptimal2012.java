
public class GameOptimal2012 {
	int gameArr[];
	public GameOptimal2012(int []arr){
		gameArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			gameArr[i] = arr[i];
		}
	}
	private int[][]buildMatrix(){
		int [][]mat = new int[gameArr.length][gameArr.length];
		for(int i=0; i<gameArr.length; i++){
			mat[i][i] = gameArr[i];
		}
		// j - number of diagonal or column number
		// i - row number 
		// i+j - column number of element
		// which is situated on diagonal j, row i
		for (int j = 1; j < mat[0].length; j++) {
			for (int i = 0; i < mat.length - j; i++) {
				int x = gameArr[i]-mat[i+1][i+j];
				int y = gameArr[i+j] - mat[i][i+j-1];
				mat[i][i+j] = Math.max(x, y);
			}
		}
		return mat;
	}
	public int gameStrategy(){
		int mat[][] = buildMatrix();
		MyLibrary.printIntMatrix(mat);
		System.out.println();
		int i = 0; 
		int j = gameArr.length - 1;
		int first=0, second=0;
		int firstSum = 0, secondSum = 0;
		for (int k = 0; k < gameArr.length/2; k++) {
			// the first takes a number
			if (gameArr[i]-mat[i+1][j] > gameArr[j] - mat[i][j-1]){
				firstSum = firstSum + gameArr[i];
				first = i++;
			}
			else{
				firstSum = firstSum + gameArr[j];
				first = j--;
			}
			// the second takes a number
			if (j>0){
				if (gameArr[i]- mat[i+1][j] > gameArr[j] - mat[i][j-1]){
					secondSum = secondSum + gameArr[i];
					second = i++;
				}
				else{
					secondSum = secondSum + gameArr[j];
					second = j--;
				}
			}
			else{//j=0 the second takes the last element
				second = j;
				secondSum = secondSum + gameArr[j];
			}
			System.out.print((first+1)+"->"+(second+1)+"->");
			System.out.println("first: gameArr["+first+"] = "+gameArr[first]+
					", second: gameArr["+second+"] = "+gameArr[second]);
		}
		System.out.println();
		System.out.println("firstSum = "+firstSum+", secondSum = "+secondSum+", diff = "+(firstSum-secondSum));
		return firstSum;
	}
	public static void main(String[] args) {
		int arr[] = {5,10,20,1};
		//int arr[] = {5,20,10,1};
		//int arr[] = {1,3,6,1,3,6};
		//int arr[] = {6,3,1,6,3,1};
		//int arr[] = {1, 5, 3, 3, 5, 3}; 
		//int arr[] = {3, 5, 3, 3, 5, 1}; 
		// int []arr = {7, 1, 3, 9, 6, 0, 3, 2, 2, 7};
		//int arr[] = {3, 5, 3, 3, 5, 1}; 
		//int arr[] = {48, 30, 1, 8, 5, 35};
		//int arr[] = {54, 16, 78, 0, 40, 76, 80, 87}; 
		//int arr[] = {4, 3, 0, 4, 5, 3};
		int size = 6;
		//int arr[] = MyLibrary.randomIntegerArray(size);
		MyLibrary.printIntegerArray(arr);
		System.out.println();
		GameOptimal2012 game = new GameOptimal2012(arr);
		game.gameStrategy();
	}
}
/** the first example
1, 3, 6, 1, 3, 6, 

1, 2, 4, 3, 0, 6, 
0, 3, 3, -2, 5, 1, 
0, 0, 6, 5, 4, 2, 
0, 0, 0, 1, 2, 4, 
0, 0, 0, 0, 3, 3, 
0, 0, 0, 0, 0, 6, 
first: gameArr[5] = 6, second: gameArr[4] = 3
first: gameArr[0] = 1, second: gameArr[3] = 1
first: gameArr[2] = 6, second: gameArr[1] = 3
firstSum = 13, secondSum = 7, diff = 6
=============================================
the second example

1, 5, 3, 3, 5, 3, 

1, 4, -1, 4, 1, 2, 
0, 5, 2, 5, 0, 3, 
0, 0, 3, 0, 5, 2, 
0, 0, 0, 3, 2, 1, 
0, 0, 0, 0, 5, 2, 
0, 0, 0, 0, 0, 3, 
first: gameArr[5] = 3, second: gameArr[4] = 5
first: gameArr[3] = 3, second: gameArr[2] = 3
first: gameArr[1] = 5, second: gameArr[0] = 1
firstSum = 11, secondSum = 9, diff = 2

*/