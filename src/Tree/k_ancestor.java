package Tree;
//https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
//https://iq.opengenus.org/binary-lifting-k-th-ancestor-lowest-common-ancestor/
public class k_ancestor {
	int maxPow=0;
	int[][] jump;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k_ancestor ob1 =new k_ancestor();
		int parent[] = {-1,0,0,1,1,2,2}; 
		ob1.TreeAncestor(7, parent);
		System.out.println(ob1.getKthAncestor(6,2));
	}
	
	public void TreeAncestor(int n, int[] parent) {
        int maxPow = (int) (Math.log(n)/Math.log(2) +1);
        System.out.println("maxPower" + maxPow);
        jump = new int[maxPow][n];
        jump[0] = parent;
        for(int p=1;p<maxPow;p++) {
        	for(int j=0;j<n;j++) {
        		int pre = jump[p-1][j];
        		jump[p][j]=pre==-1?-1:jump[p-1][pre];
        	}
        }
        	for(int i=0;i<maxPow;i++) {
        		for(int k=0;k<n;k++) {
        			System.out.print(" " + jump[i][k]);
        		}
        		System.out.println();
        	}
    }
	
	public int getKthAncestor(int node, int k) {
		int maxPow = this.maxPow;
        while (k > 0 && node > -1) {
            if (k >= 1 << maxPow) {
            	System.out.print(maxPow);
                node = jump[maxPow][node];
                k -= 1 << maxPow;
            } else
                maxPow -= 1;
        }
        return node;
    }

}
