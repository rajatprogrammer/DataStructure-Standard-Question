package Subarray;

import java.util.HashMap;
//https://www.geeksforgeeks.org/longest-sub-array-sum-k/
//Longest sub-array having sum k
public class longestSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={-5, 8, -14, 2, 4, 12};
		System.out.print(longestSUbarraySUm(arr,-5));
	}
	public static int longestSUbarraySUm(int arr[],int k) {
		  HashMap<Integer, Integer> map = new HashMap<>(); 
          int sum = 0, maxLen = 0; 
          int n=arr.length;
          for(int i=0;i<n;i++) {
        	  sum =sum +arr[i];
        	  if (sum == k) 
                  maxLen = i + 1; 
        	  if (!map.containsKey(sum)) { 
                  map.put(sum, i); 
              } 
        	  else {
        		  if (map.containsKey(sum - k)) { 
                      
                      // update maxLength 
                      if (maxLen < (i - map.get(sum - k))) 
                          maxLen = i - map.get(sum - k); 
                  } 
        	  }
          }
		return maxLen;
	}

}
