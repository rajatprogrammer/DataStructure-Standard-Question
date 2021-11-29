package Subarray;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
/*company:amazon,goldmansach
 * */
public class shortestSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 84, -37, 32, 40, 95 };
		int K = 167;
		shortestSubarray ob1 = new shortestSubarray();
		System.out.print(ob1.shortestSubarray(arr, K));
	}

	public int shortestSubarray(int[] A, int K) {
		int n = A.length;
		long[] sums = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			sums[i] = sums[i - 1] + A[i - 1];
		}
		int ans = Integer.MAX_VALUE;
		Deque<Integer> dq = new LinkedList<Integer>();
		for (int i = 0; i < sums.length; i++) {
			long sum = sums[i];

			while (!dq.isEmpty() && sums[dq.getLast()] > sum) {
				dq.removeLast();
			}
			while (!dq.isEmpty() && sums[dq.getFirst()] + K <= sum) {
				ans = Math.min(ans, i - dq.removeFirst());
			}
			dq.add(i);
		}
		return (int) ans==Integer.MAX_VALUE?-1:(int) ans;

	}
}
