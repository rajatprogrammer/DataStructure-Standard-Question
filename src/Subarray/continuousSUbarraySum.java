package Subarray;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/continuous-subarray-sum/
public class continuousSUbarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {23, 2, 4, 6, 7};
		int k=6;
		//System.out.println(checkSubarraySumRajat(arr,k));
		System.out.println(checkSubarraySumPrefix(arr,k));
	}
	// designed by me not able to pass some corner cases
	public static  boolean checkSubarraySumRajat(int[] nums, int k) {
        if(nums.length<=1){
            return false;
        }
        int prefix[] = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            prefix[i] = prefix[i-1]+ nums[i-1];
        }
        for(int i=2;i<prefix.length;i++){
            if(k==0 && prefix[i]==0){
                return true;
            }
            if(k!=0&& prefix[i]%k==0){
                return true;
            }else if(k!=0 &&(prefix[i]-prefix[i-2])%k==0){
                return true;
            }
            
        }
        return false;
    }
	
	public  static boolean checkSubarraySumPrefix(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int curSum = 0;
        map.put(0, 0);
        for(int i = 0; i < nums.length; i++)
        {
            curSum += nums[i];
            
            if (map.getOrDefault(curSum%k, i) <= i-1)
            {
                return true;
            }
            else
            {
                map.putIfAbsent(curSum%k, i+1);
            }                
        }
        return false;
    }
	

}
