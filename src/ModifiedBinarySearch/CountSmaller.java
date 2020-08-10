package ModifiedBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i]
//		
//		Input: nums = [5,2,6,1]
//				Output: [2,1,1,0]
//				Explanation:
//				To the right of 5 there are 2 smaller elements (2 and 1).
//				To the right of 2 there is only 1 smaller element (1).
//				To the right of 6 there is 1 smaller element (1).
//				To the right of 1 there is 0 smaller element.
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountSmaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int nums[] = {5,2,6,1};
			System.out.println(countSmaller(nums));
	}
	public static List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> bs = new ArrayList<>();
        for(int i=nums.length - 1; i>=0; i--){
            int cur = nums[i];
            int l=0, r=bs.size()-1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(bs.get(mid) < cur){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            bs.add(l,cur);
            res[i] = l;
        }
        return Arrays.asList(res);
	}
}
