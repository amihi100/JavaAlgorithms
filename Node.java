package Parking;

public class Node {
	int data;
	Node next,prev;
	public Node(int d){
		data=d;
		next=prev=null;
	}
	public String toString(){
		return ""+data;
	}
}
