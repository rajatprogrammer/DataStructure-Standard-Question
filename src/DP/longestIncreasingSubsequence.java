package DP;
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
import java.util.Arrays;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,4,2,4,2,3,2,1,4,7,9,3,79,3,90};
		System.out.println(dpLongestIncreasing(nums));
		System.out.println(recursive(nums,0,nums.length,Integer.MIN_VALUE));
	}
	public static int dpLongestIncreasing(int A[]) {
		if(A.length<=0){
            return 0;
        }
      int[] L = new int[A.length];
 
        // longest increasing sub-sequence ending with A[0] has length 1
        L[0] = 1;
 
        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in sub-array A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest increasing sub-sequence that ends with A[j]
                // where A[j] is less than the current element A[i]
                if (A[j] < A[i] && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }
            // include A[i] in LIS
            L[i]++;
        }
 
        // return longest increasing sub-sequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
	}
	
	public static int recursive(int A[],int i,int n,int prev) {
		if (i == n) {
			return 0;
		}

		// case 1: exclude the current element and process the
		// remaining elements
		int excl = recursive(A, i + 1, n, prev);

		// case 2: include the current element if it is greater
		// than previous element in LIS
		int incl = 0;
		if (A[i] > prev) {
			incl = 1 + recursive(A, i + 1, n, A[i]);
		}

		// return maximum of above two choices
		return Integer.max(incl, excl);
	}
	
	static int lis(int arr[], int n)
    {
        int lis[] = new int[n];
        int i, j, max = 0;
 
        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;
 
        /* Compute optimized LIS values in
           bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
 
        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];
 
        return max;
    }

}
