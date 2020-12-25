package Tree;
//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
import java.util.LinkedList;
import java.util.Queue;

public class deepest_tree {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			val=data;
			left=right=null;
		}
	}
	TreeNode lca;
    int max;
    //wrong solution need to handle edge cases
//	 public TreeNode subtreeWithAllDeepest(TreeNode root) {
//	        if(root==null){
//	            return null;
//	        }
//	      Queue<TreeNode> q = new LinkedList<TreeNode>();
//	        TreeNode prev=null;
//	        TreeNode curr=null;
//	      q.add(root);
//	      while(!q.isEmpty()){
//	          TreeNode root1 = q.peek();
//	          for(int i=0;i<q.size();i++){
//	              TreeNode temp = q.poll();
//	              if(temp.left!=null){
//	                  q.add(temp.left);
//	              }
//	              if(temp.right!=null){
//	                  q.add(temp.right);
//	              }
//	          }
//	          if(curr!=null){
//	              prev=curr;
//	          }
//	          curr=root1;
//	      }
//	       return  prev;
//	    }
	 //finest solutioons
	 public TreeNode subtreeWithAllDeepest1(TreeNode root) {
	        if (root == null) return null;
	        dfs(root, 0);
	        return lca;
	    }
	    
	    int dfs(TreeNode node, int level) {
	        if (node == null) return level - 1;
	        int left = dfs(node.left, level + 1);
	        int right = dfs(node.right, level + 1);
	        if (max < Math.max(left, right)) {
	            max = Math.max(left, right);
	        }
	        if (left == right && left == max) lca = node;
	        return Math.max(left, right);
	    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left=new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left=new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right=new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		deepest_tree ob1 = new deepest_tree();
		System.out.print(ob1.subtreeWithAllDeepest1(root).val);
	}

}
