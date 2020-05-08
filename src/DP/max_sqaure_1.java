//https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
package DP;

public class max_sqaure_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{0,0,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
		System.out.print(getMaxSquareof1(mat));
						
		}
	
	public static int  getMaxSquareof1(int mat[][]) {
		int dp[][] = new int[mat.length+1][mat[0].length+1];
		int max = 0;
		for(int i=1;i<dp.length;i++) {
				for(int j=1;j<dp[0].length;j++) {
					if(mat[i-1][j-1]==0) {
						dp[i][j]=0;
					}else {
						dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) +1;
						if(dp[i][j]>max) {
							max=dp[i][j];
						}
					}
				}
		}
		return max;
	}

}
