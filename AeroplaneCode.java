//package AeroplaneCode;

import java.util.ArrayList;

class Node{
	int x, y, price, numOfPaths;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.price = 0;
		this.numOfPaths = 0;
	}
	public String toString(){
		return "x="+x+", y="+y+", price="+price+", np="+numOfPaths+"; ";
	}
}// class Node

public class AeroplaneCode {
	int numOfPaths, cheapestPrice, len;
	private Node [][]mat;
	//ArrayList<String> paths;
	public AeroplaneCode(int example){
		numOfPaths = 0;
		cheapestPrice = 0;
		if (example==1) mat = InitMatrixOfPrices.initMatOfNodes1();
		else if (example==2) mat = InitMatrixOfPrices.initMatOfNodes2();

	}
	public void getBestPrice(){
		// n rows, m columns
		int n = mat.length, m = mat[0].length;
		mat[0][0].price = 0;
		for (int i=1; i<n; i++){// first column
			mat[i][0].price = mat[i-1][0].y+  mat[i-1][0].price;
			mat[i][0].numOfPaths = 1;
		}
		for (int j=1; j<m; j++){// first row
			mat[0][j].price = mat[0][j-1].price +  mat[0][j-1].x;
			mat[0][j].numOfPaths = 1;
		}
		for (int i=1; i<n; i++){
			for (int j=1; j<m; j++){
				int a = mat[i-1][j].price+mat[i-1][j].y;
				int b = mat[i][j-1].price+mat[i][j-1].x;
				if (a<b){
					mat[i][j].price = a;
					mat[i][j].numOfPaths = mat[i-1][j].numOfPaths;				
				}
				else if (a>b) {
					mat[i][j].price = b;
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths;
				}
				else{//x==y
					mat[i][j].price = a;
					mat[i][j].numOfPaths = mat[i][j-1].numOfPaths+mat[i-1][j].numOfPaths;
				}
			}
		}
		numOfPaths = mat[n-1][m-1].numOfPaths;
		cheapestPrice = mat[n-1][m-1].price;
	}
	String getOneCheapestPath(){
		String ans = "";
		int i = mat.length-1, j = mat[0].length-1;
		while(i>0 && j>0){
			int a = mat[i-1][j].price+mat[i-1][j].y;
			int b = mat[i][j-1].price+mat[i][j-1].x;
			if (a < b){
				ans = "1" + ans;
				i--;
			}
			else{//a>b
				ans = "0" + ans;
				j--;
			}
		}
		if (i==0){
			while (j>0){
				ans = "0" + ans;
				j--;
			}
		}
		else {//j==0
			while (i>0){
				ans = "1" + ans;
				i--;
			}
		}
		return ans;
	}
	//////
	//calculate all the cheapest pats
	public  void AllPathsRecurs(int teta){
		if (numOfPaths<=teta){
			ArrayList<String> paths = new  ArrayList<String>(numOfPaths);
			buildPaths(new String(), mat.length-1, mat[0].length-1, paths);
			System.out.println(paths);
		}
	}
	public void buildPaths(String path, int i, int j, ArrayList<String> paths){
		if (i>0 && j>0){
			int a = mat[i-1][j].price+mat[i-1][j].y;
			int b = mat[i][j-1].price+mat[i][j-1].x;
			if (a < b){
				buildPaths("1"+path, i-1, j, paths);
			}
			else if(a > b){
				buildPaths("0"+path, i, j-1, paths);
			}
			else{//a==b
				buildPaths("1"+path, i-1, j, paths);
				buildPaths("0" + new String(path), i, j-1, paths);
			}
		}
		else if (i==0 && j==0){
			paths.add(path);
		}
		else if (i==0){
			String t = new String();
			for(int k=0; k<j; k++) t = t +  "0";
			paths.add(t + path);
		}
		else if (j==0){
			String t = new String();
			for(int k=0; k<i; k++) t = t +  "1";
			paths.add(t + path);
		}
	}


	//////
	// Print matrix of prices
	public void printPrices(){
		System.out.println("\nmatrix of prices in right direction\n");
		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j].price+" ");
			}
			System.out.println();
		}
	}
	// Print matrix of paths number
	public void printNumberOfPaths(){
		System.out.println("\nthe matrix of numbers of the cheapest paths \n");
		for (int i=0; i<mat.length; i++){
			for (int j=0; j<mat[0].length; j++){
				System.out.print(mat[i][j].numOfPaths+" ");
			}
			System.out.println();
		}
	}
	public int getNumOfPaths(){return numOfPaths;}
	public int getCheapestPrice(){return cheapestPrice;}

	public static void main(String[] args) {
		int example = 2;
		AeroplaneCode bp = new AeroplaneCode(example);
		bp.getBestPrice();
		System.out.println("the price of the cheapest path: "+bp.getCheapestPrice());
		System.out.println("number of the cheapest paths: "+bp.getNumOfPaths());
		bp.printPrices();
		bp.printNumberOfPaths();
		System.out.println("one path: " + bp.getOneCheapestPath());
		System.out.println("all paths: ");
		int teta = 10;
		bp.AllPathsRecurs(teta);
	}
}
