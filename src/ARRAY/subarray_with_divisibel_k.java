package ARRAY;

import java.util.HashMap;
/*
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
Accepted
74,152
Submissions
141,987
Seen this question in a real interview before?
 * */
public class subarray_with_divisibel_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int subarraysDivByK(int[] nums, int K) {
	        if(nums==null || nums.length==0) return 0;
	        
	        int ans=0;
	        int remSum=0;
	        HashMap<Integer,Integer> map=new HashMap<>();
	        map.put(0,1);           //Freq of 0 as remainder is 1
	        
	        for(int i=0;i<nums.length;i++){
	            remSum+=nums[i];
	            int temp=remSum%K;
	            if(temp<0) temp+=K;
	            if(map.containsKey(temp)){
	                ans+=map.get(temp);
	            }
	            map.put(temp,map.getOrDefault(temp,0)+1);
	        }
	        return ans;
	    }

}
