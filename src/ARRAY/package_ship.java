package ARRAY;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
//https://www.geeksforgeeks.org/find-two-rectangles-overlap/
public class package_ship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.print(shipWithinDays(arr,5));
	}
	static int shipWithinDays(int[] weights, int D) {
		int start = Integer.MIN_VALUE;
        int end = 0;
        int result = -1;

        //We need to start from the maximum weight as minimum weight a ship can carry
        //should be greater than the maximum weight
        for(int weight : weights){
            end+=weight;
            start = Math.max(start,weight);
        }

        //Do binary search to reduce the search space
        while(start<=end){
            int mid = start+(end-start)/2;

            // check if it is possible to distribute
            // weights by using mid is current minimum
            if(isValid(weights,D,mid)){
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return result;
    }
	
	 static boolean isValid(int[] weights,int minDays,int capacity){
        int daysNeeded =1;
        int weightSum = 0;

        for(int weight : weights){
            //if weights[i] > capacity, it means this good can not be shiped under certain capacity
            if(weight > capacity){
                return false;
            }
            weightSum+=weight;

            // count how many days are required
            // to distribute current mid.
            //If found then increase the no of days
            // and make the sum to that weight to give the next weight to next day
            if(weightSum>capacity){
                daysNeeded++;
                weightSum = weight;
            }

            //If the no. of days increased than min no of days then return false
            if(daysNeeded>minDays)
                return false;
        }
        return true;
    }

}
