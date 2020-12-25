package Subarray;

import java.util.HashMap;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/
/*Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
 * */
public class K_pair_max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		System.out.print(maxOperations(arr,5));
	}
	public static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for(int num : nums) {
            int secondNum = k-num;
            if(map.containsKey(secondNum) && map.get(num) > 0 && map.get(secondNum) > 0) {
                if(num == secondNum && map.get(num) < 2) {
                    continue;
                }
                map.put(num, map.get(num) - 1);
                map.put(secondNum, map.get(secondNum) - 1);
                res++;
            }
        }
        return res;
    }

}
