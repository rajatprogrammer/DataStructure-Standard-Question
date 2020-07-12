package ARRAY;

import java.util.HashSet;

//https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
public class FindUnsorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 4, 45, 6, 10, 8 }; 
        int n = 16; 
        printpairs(A, n); 
	}
	static void printpairs(int arr[], int sum) 
    { 
        HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i = 0; i < arr.length; ++i) { 
            int temp = sum - arr[i]; 
  
            // checking for condition 
            if (s.contains(temp)) { 
                System.out.println( 
                    "Pair with given sum "
                    + sum + " is (" + arr[i] 
                    + ", " + temp + ")"); 
            } 
            s.add(arr[i]); 
        } 
    } 
  

}
