package Parking;
// double cycle linked list
public class List {
	Node head,tail;
	public List(){
		head=tail=null;
	}
	void add(int a){
		Node n=new Node(a);
		if(head==null){
			head=n;
			head.next=head.prev=head;
			tail=head;
		}
		else{
			n.next=head;
			n.prev=tail;
			tail.next=n;
			head.prev=n;
			tail=n;
		}
	}
	public String toString(){
		String s="";
		Node t=head;
		while (t.next!=head){
			s=s+" "+t.data;
			t=t.next;
		}
		return s+" "+tail.toString();	

	}
	public static void main(String[] args){
		List list = new List();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
	}

}
