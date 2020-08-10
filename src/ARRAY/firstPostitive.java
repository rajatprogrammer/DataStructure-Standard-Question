package ARRAY;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/first-missing-positive/
//Given an unsorted integer array, find the smallest missing positive integer.
//in:[1,2,0] ,out:2
//in:[3,4,-1,1],out 2
//neesd To SOlve
//https://leetcode.com/problems/minimum-cost-to-merge-stones/
//https://leetcode.com/problems/find-the-closest-palindrome/
//https://leetcode.com/problems/unique-paths-iii/
//https://leetcode.com/problems/minimum-cost-for-tickets/
//https://leetcode.com/discuss/interview-question/778035/dynamic-programming-patterns
//https://leetcode.com/tag/segment-tree/
public class firstPostitive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,4,-1,1};
		System.out.println(firstMissingPositiveExtraSpace(arr));
		System.out.println(firstMissingPositive(arr));
	}
	//extra space creation for hashSet
	public static int firstMissingPositiveExtraSpace(int[] nums) {
		  int min = Integer.MAX_VALUE;
	        Set<Integer> set = new HashSet<>();
	        for (int i : nums) {
	            min = Math.min(min, i);
	            set.add(i);
	        }
	        
	        
	        if (min <= 1) {
	            for (int i = min; ;i++) {
	                if (i > 0 && !set.contains(i))
	                    return i;
	            }    
	        } else 
	            return 1;
	}
	//o(n) solution
	public static int firstMissingPositive(int[] nums) {
		int l=0;
		int n=nums.length;
		while(l<n) {
			if(nums[l]>0 && nums[l]<n && nums[nums[l]-1]!=nums[l]) {
				swap(nums,l,nums[l]-1);
			}else {
				l++;
			}
		}
		for(int i=0;i<n;i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
		return n+1;
	}
	public static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

}
