package Subarray;
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/submissions/
public class delet_1_subarrauy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,1,1,0,1,1,0,1};
	}
	public static int longestSubarray(int[] nums) {
		int left=-1, max=0,once=0;
		for(int i=0;i<nums.length;i++) {
			if(once== 0&& nums[i]==0) {
				left=i;
				continue;
			}
			if(nums[i]==1) {
				once++;
			}else {
				once = i-left-1;
				left=i;
			}
			max = Math.max(once, max);
		}
		if(left == -1)
            return max -1;
        
        return max;
	}

}
