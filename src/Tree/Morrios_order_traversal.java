package Tree;

public class Morrios_order_traversal {
	static class node{
		int data;
		node left,right;
		public node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public void morrios_inorder(node root) {
			while(root!=null) {
				if(root.left==null) {
					System.out.println("data-->" + root.data);
					root=root.right;
				}else {
					node predecessor = root.left;
					while(predecessor.right!=null && predecessor.right!=root) {
						predecessor = predecessor.right;
					}
					if(predecessor.right==null) {
						predecessor.right = root;
						root = root.left;
					}else {
						predecessor.right = null;
						System.out.println("data-->" + root.data);
						root = root.right;
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node ob1 = new node(10);
		ob1.left = new node(8);
		ob1.right = new node(15);
		ob1.left.left = new node(5);
		ob1.left.right = new node(9);
		ob1.right.left = new node(11);
		ob1.right.right = new node(20);
		ob1.right.left.left = new node(10);
		ob1.morrios_inorder(ob1);
	}

}
