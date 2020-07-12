package recursion;
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class longestIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};
		System.out.print(longestIncreasingPath(mat));
	}
	 public static int longestIncreasingPath(int[][] matrix) {
	        int max=0;
	        int R=matrix.length;
	        int C=matrix[0].length;
	        if(R==0 || C==0){
	        	return 0;
	        }
	        int dp[][] =new int[R][C];
	        for(int i=0;i<matrix.length;i++) {
	        	for(int j=0;j<matrix[0].length;j++) {
	        		max= Math.max(max,dfs(matrix,dp,i,j,Integer.MIN_VALUE));
	        	}
	        }
	        return max;
	 }
	 public static int dfs(int[][] matrix,int dp[][],int i,int j,int pre) {
		 if(i<0 || i>=matrix.length ||j<0|| j>= matrix[0].length ||matrix[i][j]<=pre) 
			 return 0;
		 if(dp[i][j] !=0) 
			return dp[i][j];
		 	System.out.println("i is-->" + i + "j is -->j" + j + "pre--" + pre);
		 	int l = dfs(matrix,dp,i,j-1,matrix[i][j]);
	        int r = dfs(matrix,dp,i,j+1,matrix[i][j]);
	        int up = dfs(matrix,dp,i-1,j,matrix[i][j]);
	        int down = dfs(matrix,dp,i+1,j,matrix[i][j]);
	        dp[i][j] = Math.max (l, Math.max(Math.max(r,up),down)) +1;
	        return dp[i][j];
	 }

}
