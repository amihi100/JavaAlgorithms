package Parking;

public class ParkingProblem {
	public static int paringProblem(List list){
		int count = 0, len = 0, v = 1, x = 2;
		boolean ans=false;
		list.head.data=v;
		Node temp=list.head.next;
		while(!ans){
			count=1;
			while(temp.data!=v){
				count++;	
				temp=temp.next;
			}
			temp.data=x;
			len=count;
			while(count>0){
				temp=temp.prev;
				count--;
			}
			if (temp.data==x) ans = true;
			else temp = temp.next;
		}
		return len;
	}
	public static void main(String[] args) {
		int listLength = 102, to = 10, count = 0;
		int number = 1000;
		for (int j = 1; j <= number; j++) {
			List list=new List();
			for (int i = 0; i < listLength; i++) {
				list.add((int)(Math.random()*to));
			}
			int len = paringProblem(list);
			if (len != listLength) count++;
		}
		System.out.println("number of errors = "+count);
		List list1=new List();
		for (int i = 0; i < listLength; i++) {
			list1.add(1);
		}
		System.out.println("number of cars: "+paringProblem(list1));
	}
}
