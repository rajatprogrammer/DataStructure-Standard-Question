package Heap;
// this question is also done with stack in o(n) time and o(n) space
import java.util.Comparator;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class maximumSubarray {
//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
//https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int k=4;
		printKMax(arr,arr.length,k);
	}
	 static void printKMax(int arr[], int n, int k) {
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			 public int compare(Integer o1,Integer o2) {
				 return o2-o1;
			 }
		});
		 //0(n) time //o(k) space complexity
		 for(int i=0;i<k;i++) {
			 pq.add(arr[i]);
		 }
		 System.out.print(pq.peek());
		 for(int i=k;i<n;i++) {
			pq.remove(arr[i-k]);
			pq.add(arr[i]);
			System.out.print(pq.peek());
		 }
		 
	 }

}
