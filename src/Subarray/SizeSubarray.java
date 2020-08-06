package Subarray;
//https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
//https://leetcode.com/problems/minimum-size-subarray-sum/
public class SizeSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5 };
		System.out.print(minSubArrayLen(11, arr));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int minlen = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				minlen = Math.min(minlen, i - left + 1);
				sum -= nums[left];
				left++;
			}
		}
		return minlen == Integer.MAX_VALUE ? 0 : minlen;
	}
}
