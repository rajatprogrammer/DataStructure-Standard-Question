package MISC;
/**Remove all nodes which don’t lie in any path with sum>= k
Given a binary tree, a complete path is defined as a path from root to a leaf. The sum of all nodes on that path is defined as the sum of that path. Given a number K, you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.

Note: A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.

Consider the following Binary Tree
          1 
      /      \
     2        3
   /   \     /  \
  4     5   6    7
 / \    /       /
8   9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 20, the tree should be changed to following
(Nodes with values 6 and 8 are deleted)
          1 
      /      \
     2        3
   /   \        \
  4     5        7
   \    /       /
    9  12      10
   / \           \
  13  14         11
      / 
     15 

For input k = 45, the tree should be changed to following.
      1 
    / 
   2   
  / 
 4  
  \   
   9    
    \   
     14 
     /
    15 **/
public class remove_node {
	int data;
	remove_node lf;
	remove_node rf;
	public remove_node(int data) {
		this.data = data;
		this.lf =null;
		this.rf=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		remove_node root = new remove_node(1);
		root.lf = new remove_node(2);
		root.rf = new remove_node(3);
		root.lf.lf = new remove_node(4);
		root.lf.lf.lf = new remove_node(8);
		root.lf.rf = new remove_node(9);
		root.lf.rf.lf = new remove_node(13);
		root.lf.rf.rf = new remove_node(14);
		root.lf.rf.rf.lf = new remove_node(15);
		root.rf.lf = new remove_node(6);
		root.rf.rf = new remove_node(7);
		root.rf.rf.lf = new remove_node(10);
		root.rf.rf.lf.rf = new remove_node(11);
		root.node_delete(root,0,15);
		root.print(root);
	}
	public void print(remove_node root)  
	{  
	    if (root != null)  
	    {  
	        print(root.lf);  
	        System.out.print(root.data + " ");  
	        print(root.rf);  
	    }  
	}  
	 public boolean node_delete(remove_node root,int sum,int k) {
		 if(root!=null) {
			sum = sum +root.data;
			if(root.lf==null && root.rf==null && sum<k) {
				return true;
			}
			if(root.lf==null && root.rf==null && sum>=k) {
					return false;
			}
			boolean left = node_delete(root.lf, sum, k);
			if(left) {
				root.lf=null;
				if(root.lf==null && root.rf==null && sum<k) {
					return true;
				}
			}
			boolean right = node_delete(root.rf, sum, k);
			if(right) {
				root.rf=null;
				if(root.lf==null && root.rf==null && sum<k) {
					return true;
				}
			}
			return false;
		 }else {
			 return true; 
		 }
		 
	 }
}
