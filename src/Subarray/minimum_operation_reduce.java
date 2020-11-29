package Subarray;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class minimum_operation_reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,20,1,1,3};
		System.out.print(minOperations(arr,10));
	}

	public static int minOperations(int[] nums, int x) {
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
