package DP;
//https://www.geeksforgeeks.org/maximum-subsequence-sum-from-a-given-array-which-is-a-perfect-square/
public class square_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		square_subsequence ob1= new square_subsequence();
		System.out.print(ob1.findSum(arr,arr.length));
	}
	int findSum(int arr[], int n) 
	{ 
	    int sum = 0; 
	    // Find sum of all values 
	    for (int i = 0; i < n; i++) { 
	        sum += arr[i]; 
	    } 
	  
	    int val = (int) Math.sqrt(sum); 
	  
	    for (int i = val; i >= 0; i--) { 
	        if (isSubsetSum(arr, n, i * i)) { 
	            // return the value; 
	            return i * i; 
	        } 
	    } 
	  
	    return 0; 
	}
	public boolean isSubsetSum(int[] arr, int n, int sum) {
		 boolean subset[][]=new boolean[n + 1][sum + 1]; 
		  
		    // If sum is 0, then answer is true 
		    for (int i = 0; i <= n; i++) 
		        subset[i][0] = true; 
		  
		    // If sum is not 0 and arr[] is empty, 
		    // then answer is false 
		    for (int i = 1; i <= sum; i++) 
		        subset[0][i] = false; 
		  
		    // Fill the subset table in bottom up manner 
		    for (int i = 1; i <= n; i++) { 
		        for (int j = 1; j <= sum; j++) { 
		  
		            if (j < arr[i - 1]) 
		                subset[i][j] = subset[i - 1][j]; 
		  
		            if (j >= arr[i - 1]) 
		                subset[i][j] 
		                    = subset[i - 1][j] 
		                      || subset[i - 1][j - arr[i - 1]]; 
		        } 
		    } 
		  
		    return subset[n][sum]; 
	} 

}
