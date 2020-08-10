package ARRAY;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class rotated_sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,5,6,7,0,1,2};
		System.out.print(search(nums,0));
	}
	public static int search(int[] nums, int target) {
		int n=nums.length-1;
	    int low=0,high=n;
	    while(low<=high) {
	    	int mid = (high+low)/2;
	    	if(nums[mid]==target) {
	    		return 1;
	    	}
	    	if(nums[low]<=nums[mid]) {
	    		if(target>=nums[low] && nums[low]<=nums[mid]) {
	    			high=mid-1;
	    		}else {
	    			low=mid+1;
	    		}
	    	}else {
	    		if(target>=nums[mid] && nums[high]>target) {
	    			low=mid+1;
	    		}else {
	    			high=mid-1;
	    		}
	    	}
	    }
		return -1;
		
	}

}
