package recursion;
//https://leetcode.com/problems/minimum-cost-to-merge-stones/
public class minimun_cost_merge {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,5,1,2,6};
		int x=mergeStones(arr,3);
		System.out.print(x);
	}
	public static int mergeStones(int[] stones, int K) {
		int N = stones.length;
		if ((N - 1) % (K - 1) != 0) return -1;
		int[][] dp = new int[N][N];
		int[] sum = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			sum[i] = sum[i - 1] + stones[i - 1];
		}

		for (int len = K; len <= N; len++) {
			for (int i = 0; i + len <= N; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int t = i; t < j; t += K - 1) {
					dp[i][j] = Math.min(dp[i][j], dp[i][t] + dp[t + 1][j]);
				}
				if ((j - i) % (K - 1) == 0) {
					dp[i][j] += sum[j + 1] - sum[i];
				}
			}
		}
		return dp[0][N - 1];
	}
}

