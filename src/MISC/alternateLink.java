package MISC;

class node12 {
	node12 next;
	int data;
	node12(int data){
		this.data=data;
		this.next = null;
	}
}
public class alternateLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node12 root = new node12(1);
		root.next = new node12(2);
		root.next.next = new node12(3);
		root.next.next.next = new node12(4);
		root.next.next.next.next = new node12(5);
		root.next.next.next.next.next = new node12(6);
		root.next.next.next.next.next.next = new node12(7);
		root.next.next.next.next.next.next.next = new node12(8);
		node12 alt  =null;

		while(root!=null) {
			node12 mid=root,prev=null,fats=root.next.next;
		}

	}

}
