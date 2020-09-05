package ARRAY;
//https://leetcode.com/problems/subarrays-with-k-different-integers/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class subarray_with_k {
	List<Integer> ls  = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1,2,3};
		int K=2;
		int total = subarraysWithKDistinct(arr,K) - subarraysWithKDistinct(arr,K-1);
		System.out.print(total);
	}
	
	public static int subarraysWithKDistinct(int[] A, int K) {
		int left=0;
		int right=0;
		int res= 0;
		HashMap<Integer,Integer> hs = new HashMap<Integer, Integer>();
		while(right<A.length) {
			hs.put(A[right],hs.getOrDefault(A[right],0)+1);
			while(hs.size()>K) {
				hs.put(A[left], hs.get(A[left])-1);
				if(hs.get(A[left])==0) {
					hs.remove(A[left]);
				}
				left++;
			}
			 res= res+right-left+1;
			 right++;
		}
		return res;
    }

}
