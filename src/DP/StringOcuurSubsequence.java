package DP;
//https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
public class StringOcuurSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "rabbbit";
		String b = "rabbit";
		System.out.print(countRecursiveSubsequence(a,b,0,0));
		System.out.print(countDPSubsequence(a, b,a.length(), b.length()));
	}
	
	public static int countRecursiveSubsequence(String a,String b,int m,int n) {
		if(n==b.length() || (m==a.length() && n==b.length())) {
			return 1;
		}
		if(m>=a.length()) {
			return 0;
		}
		if(n>=b.length()) {
			return 0;
		}
		if(a.charAt(m)==b.charAt(n)) {
			return countRecursiveSubsequence(a, b, m+1, n+1) +countRecursiveSubsequence(a, b, m+1, n); 
		}
			return countRecursiveSubsequence(a,b,m+1,n);
	}
	public static int countDPSubsequence(String a,String b,int m,int n) {
		int dp[][] = new int[m+1][n+1];
		for(int i=0;i<=n;i++) {
			dp[i][0]=1;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					//1. exclude the current character
					//2.include current character
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[m][n];
	}

}
