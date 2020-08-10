package ARRAY;
//https://leetcode.com/problems/move-zeroes/
public class move_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,3,0,1,33,0,4};
		moveZeroes(arr);
	}
	public static void moveZeroes(int[] nums) {
        int count=0;
       for(int i=0; i<nums.length; i++){
           if(nums[i]==0)
               count++;
           else
               nums[i-count] = nums[i];
       }
       for(int i=nums.length-1; count>0; i--){
           nums[i]=0;
           count--;
       }
   }
}
