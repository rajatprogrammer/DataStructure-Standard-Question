package ARRAY;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class rotated_sored_duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = { 2, 5, 6, 0, 0, 1, 2 };
		int target = 3;
		System.out.print(search(num,6));
	}

	public static boolean search(int[] nums, int target) {
		int n = nums.length - 1;
		int low = 0, high = n;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid]<nums[high]) { // right
				if (target > nums[mid] && target <=nums[high]) {
					low = mid + 1;
				} else {
					high = mid;
				}
			} else if(nums[mid]> nums[high]) { //left
				if (target >= nums[low] && nums[mid] > target) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}else { //mid==high
				high--;
			}
		}
		return false;

	}

}
