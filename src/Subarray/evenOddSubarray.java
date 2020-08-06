package Subarray;
//https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
public class evenOddSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,5};
		System.out.print(numOfSubarrays(arr));
	}
	public static int numOfSubarrays(int[] arr) {
	    int odd = 0, even = 0, sum = 0;
	    for (int n : arr) {
	        if (n % 2 == 1) {
	            int temp = odd;
	            odd = even + 1;
	            even = temp;
	        }
	        else
	            ++even;
	        sum = (sum + odd) % 1000000007;
	    }
	    return sum;
	}

}
