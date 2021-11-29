//https://leetcode.com/problems/ones-and-zeroes/
/*You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * */
package ARRAY;

import java.util.Arrays;

public class onesAndZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String arg[] = { "10", "0001", "111001", "1", "0" };
		int m = 5;
		int n = 3;
		System.out.print(findMaxForm(arg, m, n));
	}

	public static int findMaxForm(String[] strs, int m, int n) {
        if(strs==null || m<0 || n<0) return 0;
       int[][] dp=new int[m+1][n+1];
       for(String str:strs){
           int ones=(int)str.chars().filter(num -> num=='1').count();
           int zeroes=str.length()-ones;
           for(int i=m;i>=zeroes;i--){
               for(int j=n;j>=ones;j--){
					dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones]+1);
               }
           }
       }
       return dp[m][n];
   }
}
