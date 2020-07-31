package Sorting;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
public class sort_012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort_012 ob1 = new sort_012();
		int nums[] = {0,2,0,2,1,2,1,1,1,0};
		ob1.sortColors(nums);
		System.out.print(Arrays.toString(nums));
	}
	public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
