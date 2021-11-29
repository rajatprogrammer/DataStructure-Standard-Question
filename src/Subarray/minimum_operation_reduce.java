package Subarray;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class minimum_operation_reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,20,1,1,3};
		System.out.println(minOperations(arr,10));
		System.out.println(minOperations1(arr,10));
	}

	public static int minOperations(int[] nums, int x) {
		 int current = 0;
	        for (int num : nums) {
	            current += num;
	        }
	        int n = nums.length;
	        int mini = Integer.MAX_VALUE;
	        int left = 0;

	        for (int right = 0; right < n; right++) {
	            // sum([0,..,left) + (right,...,n-1]) = x
	            current -= nums[right];
	            // if smaller, move `left` to left
	            while (current < x && left <= right) {
	                current += nums[left];
	                left += 1;
	            }
	            // check if equal
	            if (current == x) {
	                mini = Math.min(mini, (n-1-right)+left);
	            }
	        }
	        return mini != Integer.MAX_VALUE ? mini : -1;
	}
	 public static int minOperations1(int[] nums, int x) {
	        int left=0,right=nums.length-1,sum=0,answer=-1;
			while (left <= right && sum < x) {
	            sum += nums[left++];
	        }
			 while (left >= 0) {
		            if (sum == x) {
		                int operations = left + nums.length - right - 1;
		                
		                if (answer == -1 || answer > operations) {
		                    answer = operations;
		                }
		            }
		            
		            if (sum >= x) {
		                if (left == 0) break;
		                sum -= nums[--left];
		            } else {
		                if (left >= right) break;
		                sum += nums[right--];
		            }
		        }
			 return answer;
		}

}
