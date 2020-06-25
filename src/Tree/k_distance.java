package Tree;
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//https://www.geeksforgeeks.org/print-all-nodes-at-distance-k-from-given-node-iterative-approach/
//imp question microsoft,amazon
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class treeNode{
	int val;
	treeNode left;
	treeNode right;
	public treeNode(int data) {
		val=data;
		left=right=null;
	}
}

public class k_distance {
	HashMap<treeNode,treeNode> hs = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k_distance ob1 = new k_distance();
		treeNode root = new treeNode(20);
		root.left =  new treeNode(8);
		root.right =  new treeNode(22);
		root.left.left =  new treeNode(4);
		root.left.right =  new treeNode(12);
		root.left.right.left =  new treeNode(18);
		root.left.right.right =  new treeNode(14);
		ob1.storeParent(root);
		ob1.printKLevel(root.left.right,2);
	}
	
	public void storeParent(treeNode root) {
		Queue<treeNode> q = new LinkedList<treeNode>();
		q.add(root);
		hs.put(root, null);
		while(q.size()>0) {
			treeNode temp = q.poll();
			if(temp.left!=null) {
				hs.put(temp.left,temp);
				q.add(temp.left);
			}
			if(temp.right!=null) {
				hs.put(temp.right,temp);
				q.add(temp.right);
			}
			
		}
	}
	public void printKLevel(treeNode target,int k) {
		Set<treeNode> visited = new HashSet<treeNode>();
		Queue<treeNode> q = new LinkedList<treeNode>();
		q.add(target);
		visited.add(target);
		int dist=0;
		while(!q.isEmpty()) {
			if (dist == k) { 
	            while (!q.isEmpty()) { 
	              System.out.print(q.peek().val + "->");
	                q.poll(); 
	            } 
	        } 
			int size = q.size();
			for(int i=0;i<size;i++) {
				treeNode node = q.remove();
				if(node.left!=null && !visited.contains(node.left)) {
					q.add(node.left);
				}
				if(node.right!=null && !visited.contains(node.right)) {
					q.add(node.right);
				}
				if(hs.containsKey(node) && hs.get(node)!=null && !visited.contains(hs.get(node))) {
					q.add(hs.get(node));
					
				}
				visited.add(node);
			}
			
			dist++;
		}
	}

}
