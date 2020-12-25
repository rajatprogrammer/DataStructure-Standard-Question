package Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/smallest-range-ii/
public class smallest_range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,6};
		int k=3;
		smallest_range ob1 =new smallest_range();
		System.out.print(ob1.smallestRangeII(arr,k));
	}
	public int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
		int n=A.length;
		int res=A[n-1]-A[0];

		for(int i=0;i<n-1;i++){
			int max=Math.max(A[n-1]-K,A[i]+K);
			int min=Math.min(A[0]+K,A[i+1]-K);
			res=Math.min(res,max-min);
		}

		return res;
	}
	

}
