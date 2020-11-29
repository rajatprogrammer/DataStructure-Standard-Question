package ARRAY;
//https://leetcode.com/problems/k-diff-pairs-in-an-array/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class K_diff_pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 1, 4, 1, 5 }, k = 2;
		System.out.print(findPairs(arr, k));
	}

	public static int findPairs(int[] nums, int k) {
		Set<Integer> uniquePair = new HashSet();
		Arrays.sort(nums);
		int n = nums.length;
		for(int i=0;i<nums.length;i++) {
			if(Arrays.binarySearch(nums,i+1,nums.length,nums[i] + k)>0) {
				uniquePair.add(Math.min(nums[i], nums[i]+k));	
			}
		}
		return uniquePair.size();
	}
}
