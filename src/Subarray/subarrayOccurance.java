package Subarray;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/count-subarrays-equal-number-occurrences-two-given-elements/?ref=rp
public class subarrayOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    int arr[] = { 1, 2, 2, 3, 4, 1 }; 
	    int n = arr.length; 
	    int x = 2, y = 3; 
	    System.out.println(sameOccurrence(arr, n, x, y)); 
	}
	static int sameOccurrence(int arr[], int n, int x, int y) 
	{ 
	    int []countX = new int[n]; 
	    int []countY = new int[n]; 
	  
	    Map<Integer,Integer> m = new HashMap<>();  
	      
	    // To store counts of same diff 
	    // Count occurrences of x and y 
	    for (int i = 0; i < n; i++) 
	    { 
	        if (arr[i] == x)  
	        { 
	            if (i != 0) 
	                countX[i] = countX[i - 1] + 1; 
	            else
	                countX[i] = 1; 
	        }  
	        else
	        { 
	            if (i != 0) 
	                countX[i] = countX[i - 1]; 
	            else
	                countX[i] = 0; 
	        } 
	        if (arr[i] == y) 
	        { 
	            if (i != 0) 
	                countY[i] = countY[i - 1] + 1; 
	            else
	                countY[i] = 1; 
	        }  
	        else 
	        { 
	            if (i != 0) 
	                countY[i] = countY[i - 1]; 
	            else
	                countY[i] = 0; 
	        } 
	      
	        // Increment count of current 
	        if(m.containsKey(countX[i] - countY[i])) 
	        { 
	            m.put(countX[i] - countY[i], m.get(countX[i] - countY[i])+1); 
	        } 
	        else
	        { 
	            m.put(countX[i] - countY[i], 1); 
	        } 
	    } 
	  
	    // Traverse map and commute result.  
	    int result = m.get(0); 
	    for (Map.Entry<Integer,Integer> it : m.entrySet())  
	        result = result + ((it.getValue()) * ((it.getValue()) - 1)) / 2; 
	      
	    return (result); 
	} 

}
