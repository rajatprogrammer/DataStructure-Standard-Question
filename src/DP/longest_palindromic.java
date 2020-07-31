package DP;
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
public class longest_palindromic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(longestPalSubstr("forgeeksskeegfor"));
	}
	static String longestPalSubstr(String str) {
		int n = str.length();
		//length 1
		boolean dp[][] = new boolean[n][n];
		for(int i=0;i<n;i++) {
			dp[i][i]=true;
		}
		int maxLength = 1;
		int start=0;
		//length 2
		for(int i=0;i<n-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				start = i; 
				dp[i][i+1]=true;
			}
		}
		//length 3
		for(int k=2;k<n;k++) {
			for(int i=0;i<n-k+1;i++) {
				int j = i + k - 1;
				if (dp[i + 1][j - 1] 
						&& str.charAt(i) == str.charAt(j)) { 
					dp[i][j] = true; 
						if (k > maxLength) { 
							start = i; 
							maxLength = k; 
						} 
					} 
			}
		}
		return str.substring(start,start+maxLength);
		
	}
	

}
