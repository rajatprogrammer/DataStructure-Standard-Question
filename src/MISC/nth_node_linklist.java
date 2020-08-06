package MISC;

class node{
	node next;
	int data;
	node(int data){
		this.data = data;
		this.next=null;
	}
}
public class nth_node_linklist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root = new node(5);
		root.next = new node(7);
		root.next.next = new node(8);
		root.next.next.next = new node(0);
		//root.next.next.next.next = new node(10);
		nthNode(root,4);
		
	}
	
	static void nthNode(node root,int n) {
		node ptr = root;
		node ref = root;
		int count =1;
		boolean flag=true;
		if(root!=null) {
			while(count<=n) {
				if(ref==null) {
					flag=false;
					System.out.println("no node is in string");
					break;
				}
				else {
					count++;
					ref=ref.next;
				}
			}
			if(flag) {
				while(ref!=null) {
					ptr=ptr.next;
					ref=ref.next;
				}
				System.out.println("data is" +ptr.data);
			}
			
		}
		else {
			System.out.println("no node is in string");
		}
	}

}
