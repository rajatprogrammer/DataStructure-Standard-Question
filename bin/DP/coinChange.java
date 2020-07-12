package DP;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-2/
//https://www.geeksforgeeks.org/coin-change-dp-7/
public class coinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {1,2,5};
		int amount=5;
		Integer dp[][] = new Integer[coins.length][amount+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.print(coinChange(coins,0,amount,dp));
	}
	
	static int  coinChange(int[]coins,int i,int amount,Integer dp[][]) {
		if(amount==0) {
			return 1;
		}else if(amount<0 || coins.length<=i) {
			return 0;
		}else if(dp[i][amount]!=-1){
			return dp[i][amount];
		}
		else {
			dp[i][amount] = coinChange(coins,i,amount-coins[i],dp) + coinChange(coins,i+1,amount,dp);
		}
		return amount;
		
	}

}
