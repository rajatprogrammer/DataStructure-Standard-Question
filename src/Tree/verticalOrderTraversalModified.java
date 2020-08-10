package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class verticalOrderTraversalModified {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =new TreeNode();
		verticalOrderTraversalModified ob1 =new verticalOrderTraversalModified();
		List<List<Integer>> res = ob1.verticalTraversal(root);
	}
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        vtUtil(root, 0, 0, map);

        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            List<Integer> line = new ArrayList();
            for (PriorityQueue<Integer> pq : entry.getValue().values()) {
                while (pq.size() > 0)
                    line.add(pq.poll());
            }
            result.add(line);
        }

        return result;
    }

    private void vtUtil(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) 
			return;

		TreeMap<Integer, PriorityQueue<Integer>> m = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue();
        if (map.containsKey(x)) {
            m = map.get(x);
            if (m.containsKey(y)) {
                pq = m.get(y);
            }
        }
        pq.add(root.val);
        m.put(y, pq);
        map.put(x, m);

        vtUtil(root.left, x - 1, y + 1, map);
        vtUtil(root.right, x + 1, y + 1, map);
    }

}
