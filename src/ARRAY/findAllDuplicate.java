package ARRAY;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
import java.util.ArrayList;
import java.util.List;

public class findAllDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,4,3};
		System.out.println(findDuplicates(arr));
	}
	 public static List<Integer> findDuplicates(int[] nums) {
	        List<Integer>ls = new ArrayList<Integer>();
	        int n = nums.length;
	        for (int i = 0; i < nums.length; i++) {
	            int index = (nums[i] - 1) % n;
	            nums[index] += n;
	        }
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] > 2 * n) {
	            	ls.add(i + 1);
	            }
	        }
	        return ls;
	    }

}
