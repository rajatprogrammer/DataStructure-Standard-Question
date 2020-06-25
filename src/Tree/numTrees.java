package Tree;
//https://leetcode.com/problems/unique-binary-search-trees/ (Amazon)
//https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
//https://www.geeksforgeeks.org/program-nth-catalan-number/
public class numTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(5));
		System.out.println(recursiveNumTree(5));
	}
	public static int numTrees(int n) {
	      int dp[]=new int[n+1];
	        dp[0]=1;
	        dp[1]=1;
	        for(int i=2;i<=n;i++){
	            for(int j=0;j<i;j++){
	                dp[i]+=dp[j]*dp[i-j-1];
	            }
	        }
	        return dp[n];
	 }
	
	public static int recursiveNumTree(int n) {
		if(n<=1) return 1;
		else
		{
		int count=0;
		for(int i=1;i<=n;i++)
		{
		int left =recursiveNumTree(i-1);
		int right = recursiveNumTree(n - i);
		count+= left*right;
		}
		return count;
		}
	 }
	
	 int catalan(int n) { 
	        int res = 0; 
	          
	        // Base case 
	        if (n <= 1) { 
	            return 1; 
	        } 
	        for (int i = 0; i < n; i++) { 
	            res += catalan(i) * catalan(n - i - 1); 
	        } 
	        return res; 
	    } 


}
