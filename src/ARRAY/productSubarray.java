package ARRAY;
//https://leetcode.com/problems/maximum-product-subarray/
//amazon,google,microsoft
public class productSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,-2,4};
		System.out.print(maxProduct(nums));
	}
	 public static int maxProduct(int[] nums) {
	        int ma = nums[0];
	        int mi = nums[0];
	        int gma = ma;
	        for(int i=1;i<nums.length;i++){
	                int temp = Math.max(nums[i],Math.max(ma*nums[i],mi*nums[i]));
	                mi = Math.min(Math.min(mi*nums[i],ma*nums[i]),nums[i]);
	                ma = temp;
	                gma = Math.max(gma,ma);
	        }
	        return gma;
	        }

}
