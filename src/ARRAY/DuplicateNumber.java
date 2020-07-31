package ARRAY;
//https://leetcode.com/problems/find-the-duplicate-number/solution/
public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,4,2,2};
		System.out.print(findDuplicate(nums));
	}
	 public static int findDuplicate(int[] nums) {
	        int n = nums.length;
	        for(int i = 0; i < n; i++){
	            int index = nums[i]%n;
	            nums[index]+=n;
	        }
	        
	        for(int i=0;i<n;i++){
	            if(nums[i]/n > 1){
	                return i;
	            }
	        }
	        return -1;
	    }

}
