package Tree;
//https://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/
public class closest_leaf {
	static class Node  
	{ 
	    int key; 
	    Node left, right; 
	   
	    public Node(int key)  
	    { 
	        this.key = key; 
	        left = right = null; 
	    } 
	}
	static int minDis = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		closest_leaf ob1= new closest_leaf();
        // Let us create Binary Tree shown in above example 
		Node root = new Node(1); 
        root.left = new Node(12); 
       root.right = new Node(13); 
   
        root.right.left = new Node(14); 
        root.right.right = new Node(15); 
   
        root.right.left.left = new Node(21); 
        root.right.left.right = new Node(22); 
        root.right.right.left = new Node(23); 
        root.right.right.right = new Node(24); 
   
        root.right.left.left.left = new Node(1); 
        root.right.left.left.right = new Node(2); 
        root.right.left.right.left = new Node(3); 
        root.right.left.right.right = new Node(4); 
        root.right.right.left.left = new Node(5); 
        root.right.right.left.right = new Node(6); 
        root.right.right.right.left = new Node(7); 
        root.right.right.right.right = new Node(8); 
        ob1.findLeafDown(root.right,0);
        ob1.throughParent(root, root.right.key);
        System.out.print(minDis);
	}
	
	public void findLeafDown(Node root, int lev) {
		if(root==null) {
			return;
		}else {
			 if (root.left == null && root.right == null)  
		        { 
				 if(minDis>lev) {
						minDis=lev;
					}		               
		            return; 
		        } 
			findLeafDown(root.left,lev+1);
			findLeafDown(root.right,lev+1);
		}
	}
	public int  throughParent(Node root,int data) {
		if(root==null) {
			return -1;
		}
		if(root.key==data) {
			return 0;
		}
		int l = throughParent(root.left,data);
		if(l!=-1) {
			findLeafDown(root.right, l + 2);
			return l+1;
		}
		int r = throughParent(root.right,data);
		if(r!=-1) {
			findLeafDown(root.left, r + 2);
			return r+1;
		}
		return -1;
	}

}
