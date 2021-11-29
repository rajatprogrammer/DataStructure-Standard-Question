package DP;

import java.util.Arrays;

//https://leetcode.com/problems/combination-sum-iv/
public class combinatorial_sum {
	 public int dp [];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combinatorial_sum ob1 = new combinatorial_sum();
		int arr[] = {1,2,3};
		int target=4;
		System.out.println(ob1.combinationSum4(arr,target));
		System.out.println(ob1.combinationSumRecursive(arr,target));
	}
	
	 public int combinationSum4(int[] nums, int target) {
		 dp = new int [target + 1];
	        Arrays.fill (dp, -1);
	        return Solve (nums, target);
	 }
	 
	 public int Solve (int nums [], int sum) {
	        if (sum == 0)
	            return 1;
	        if (sum < 0)
	            return 0;
	        if (dp [sum] != -1)
	            return dp [sum];
	        int count = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums [i] <= sum)
	                count += Solve (nums, sum - nums [i]);
	        }
	        return dp [sum] = count;
	    }
	 
	 public int combinationSumRecursive(int[] nums, int target) {
		    if (target == 0) {
		        return 1;
		    }
		    int count = 0;
		    for (int i = 0; i < nums.length; i++) {
		        if (nums [i] <= target)
		            count += combinationSum4 (nums, target - nums [i]);
		    }
		    return count;
		}
	

}
