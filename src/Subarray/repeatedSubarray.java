package Subarray;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class repeatedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {0,0,0,0,0};
		int arr2[] = {0,0,0,0,0};
		System.out.print(repeated(arr1,arr2));
	}
	public static int repeated(int arr1[],int arr2[]) {
		int dp[][] = new int[arr1.length+1][arr2.length+1];
		int max=0;
		for(int i=1;i<=arr1.length;i++) {
			for(int j=1;j<=arr2.length;j++) {
				if(arr1[i-1]==arr2[j-1]) {
					dp[i][j] =dp[i-1][j-1] + 1;
				}
				max=Math.max(dp[i][j], max);
			}
		}
		return max;
	}

}
