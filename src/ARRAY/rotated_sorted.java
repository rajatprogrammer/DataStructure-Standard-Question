package ARRAY;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class rotated_sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,5,6,7,0,1,2};
		System.out.print(search(nums,0));
	}
	public static int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
	    while (start <= end) {
	      int mid = (start + end)/ 2;
	      if (nums[mid] == target) return mid;
	      else if (nums[mid] >= nums[start]) {
	        if (target >= nums[start] && target < nums[mid]) end = mid - 1;
	        else start = mid + 1;
	      }
	      else {
	        if (target <= nums[end] && target > nums[mid]) start = mid + 1;
	        else end = mid - 1;
	      }
	    }
	    return -1;
	}

}
