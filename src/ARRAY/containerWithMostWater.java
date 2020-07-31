package ARRAY;
//https://www.geeksforgeeks.org/container-with-most-water/
//https://leetcode.com/problems/container-with-most-water/
public class containerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,8,6,2,5,4,8,3,7};
		System.out.print(mostWater(arr));
	}
	public static int mostWater(int arr[]) {
		if(arr.length==0) {
			return 0;
		}else {
			int hi=arr.length-1;
			int low=0;
			int area =0;
			while(hi>low) {
				area= Math.max(area,(Math.min(arr[hi], arr[low])*(hi-low)));
				if(arr[hi]>arr[low]) {
					low++;
				}else {
					hi--;
				}
			}
			return area;
		}
	}
	

}
