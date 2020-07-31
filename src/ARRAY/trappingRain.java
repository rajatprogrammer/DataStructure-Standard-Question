package ARRAY;
//https://www.geeksforgeeks.org/trapping-rain-water/
public class trappingRain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,0,2};
		System.out.println(maxWater(arr,arr.length));
		System.out.println(OptimizedmaxWater(arr,arr.length));
		System.out.println(trap(arr));
	}
	public static int maxWater(int[] arr, int n)  {
		if(arr.length==0) {
			return 0;
		}else {
			int res=0;
			for(int i=1;i<n-1;i++) {
				int left = arr[i];
				for(int j=0;j<i;j++) {
					left = Math.max(left, arr[j]);
				}
				int right =arr[i];
				for(int j=n-1;j>i;j--) {
					right = Math.max(right, arr[j]);
				}
				res = res  + Math.min(left, right)-arr[i];
			}
			return res;
		}
	}
	public static int OptimizedmaxWater(int[] arr, int n)  {
		int left[] = new int[n]; 
        int right[] = new int[n]; 
        int water = 0; 
        left[0] = arr[0]; 
        for (int i = 1; i < n; i++) 
            left[i] = Math.max(left[i - 1], arr[i]); 
  
        // Fill right array 
        right[n - 1] = arr[n - 1]; 
        for (int i = n - 2; i >= 0; i--) 
            right[i] = Math.max(right[i + 1], arr[i]);
        for (int i = 0; i < n; i++) 
            water += Math.min(left[i], right[i]) - arr[i]; 
        return water; 
        
	}
	//most optimized solution 2 pointers
	public static int trap(int[] arr) {
        int result = 0; 
    int n = arr.length;
        // maximum element on left and right 
        int left_max = 0, right_max = 0; 
  
        // indices to traverse the array 
        int lo = 0, hi = n - 1; 
  
        while (lo <= hi) { 
            if (arr[lo] < arr[hi]) { 
                if (arr[lo] > left_max) 
  
                    // update max in left 
                    left_max = arr[lo]; 
                else
  
                    // water on curr element = 
                    // max - curr 
                    result += left_max - arr[lo]; 
                lo++; 
            } 
            else { 
                if (arr[hi] > right_max) 
  
                    // update right maximum 
                    right_max = arr[hi]; 
  
                else
                    result += right_max - arr[hi]; 
                hi--; 
            } 
        }
        return result;
    }
}
