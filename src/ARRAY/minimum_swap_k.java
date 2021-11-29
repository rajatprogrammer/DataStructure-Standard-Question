package ARRAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
//https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987607/O(n)-explanation-with-picture
public class minimum_swap_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {1,0,0,0,0,0,1,1};
		int k=3;
		System.out.println(minMoves(nums,k));
	}
	 public static int minMoves(int[] nums, int k) {
	        if(k <= 1) return 0;
	        List<Integer> ones = new ArrayList<>();
	        ones.add(0);
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] == 1) ones.add(i);
	        }
	        int[] prefix = new int[ones.size()];
	        for(int i = 1; i < prefix.length; i++) {
	            prefix[i] = prefix[i-1] + ones.get(i);
	        }
	        int ans = Integer.MAX_VALUE;
	        int radius = (k-1)/2;
	        for(int i = 1; i <= ones.size() - k; i++) {
	            /*
	            * Left Boundary -> i
	            * Right Boundary -> i + k - 1
	            * Mid Index = i + radius
	            */
	            int midIndex = i + radius;
	            int leftCost = prefix[midIndex-1] - prefix[i-1];
	            int rightCost = prefix[i + k - 1] - prefix[midIndex];
	            int totalCost = rightCost - leftCost - ((k % 2 == 0) ? ones.get(midIndex) : 0);
	            ans = Math.min(ans, totalCost);
	        }
	        ans -= radius*(radius+1);
	        if(k % 2 == 0) ans -= k/2;
	        return ans;
	  
	    }
	

}
