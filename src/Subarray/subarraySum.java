package Subarray;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class subarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2,4};
		System.out.print(sumSubarrayMins(arr));
	}
    public static int sumSubarrayMins(int[] A) {
    	 Stack<Integer> st = new Stack<>();
         int res = 0, mod = (int)Math.pow(10, 9) + 7;
         for (int i = 0; i < A.length; i++) {
             while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                 int curr = st.pop();
                 res = (res + A[curr] * (curr - (st.isEmpty() ? -1 : st.peek())) * (i - curr)) % mod;
             }
             st.push(i);
         }
         while (!st.isEmpty()) {
             int curr = st.pop();
             res = (res + A[curr] * (curr - (st.isEmpty() ? -1 : st.peek())) * (A.length - curr)) % mod;
         }
         return res;
    }

}
