package Tree;
//https://leetcode.com/problems/subtree-of-another-tree/
public class subtree {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(5);
		TreeNode root2 = new TreeNode(6);
			System.out.print(isSubtree(root1,root2));

	}
	 public static boolean isSubtree(TreeNode s, TreeNode t) {
	        TreeNode temp = search(s,t);
	        if(temp!=null){
	            return(final1(temp,t));
	        }
	        else{
	            return false;
	        }
	    }
	    public static TreeNode search(TreeNode s, TreeNode t) {
	        if(s==null){
	            return null;
	        }
	        if(s.val==t.val){
	            return s;
	        }
	        TreeNode l = search(s.left,t);
	        TreeNode f = search(s.right,t);
	        if(l!=null){
	            return l;
	        }else if(f!=null){
	            return f;
	        }
	        else{
	            return null;
	        }
	    }
	    public static boolean final1(TreeNode s, TreeNode t){
	        if(s==null && t==null){
	            return true;
	        }
	        else if(s==null|| t==null){
	            return false;
	        }
	            boolean lf = final1(s.left,t.left);
	            boolean rf = final1(s.right,t.right);
	            if(s.val==t.val && lf && rf){
	                return true;
	            }else{
	                return false;
	            }
	    }
	

}
