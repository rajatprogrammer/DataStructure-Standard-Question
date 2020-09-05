package ARRAY;

import java.util.HashSet;

//https://www.geeksforgeeks.org/longest-consecutive-subsequence/
//https://leetcode.com/problems/longest-consecutive-sequence/
//amazon google
public class lowes_consecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
		System.out.println(longestConsecutive(arr));
	}
	public static int longestConsecutive(int[] arr) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int n = arr.length;
		int ans=0;
		for(int i=0;i<n;i++) {
			hs.add(arr[i]);
		}
		for(int i=0;i<n;i++) {
			if(!hs.contains(arr[i]-1)) {
				int j =arr[i];
				while(hs.contains(j)) {
					j++;
				}
				if(ans<j-arr[i]) {
					ans=j-arr[i];
				}
			}
		}
		return ans;
	}
}
