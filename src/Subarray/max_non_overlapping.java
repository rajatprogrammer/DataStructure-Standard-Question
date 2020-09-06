package Subarray;

import java.util.HashMap;

//https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
public class max_non_overlapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-1,3,5,1,4,2,-9};
		int target=6;
		System.out.print(maxNonOverlapping(arr,target));
	}
	 public static int maxNonOverlapping(int[] nums, int target) {
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		hs.put(0,0);
		int curSum=0;
		int max=0;
		for(int i=0;i<nums.length;i++) {
			curSum = curSum + nums[i];
			if(hs.containsKey(curSum-target)) {
				max=Math.max(max,hs.get(curSum-target)+1);
			}
			hs.put(curSum,max);
		}
		return max;       
	  }
	

}
