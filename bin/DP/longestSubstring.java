package DP;
//https://www.geeksforgeeks.org/longest-common-substring-dp-29/
public class longestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(recursive("OldSite:GeeksforGeeks.org","NewSite:GeeksQuiz.com",0,0,0));
		System.out.println(DPlongestSubstring("OldSite:GeeksforGeeks.org","NewSite:GeeksQuiz.com"));
	}
	
	public static int DPlongestSubstring(String s1 , String s2) {
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		int result=0;
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j] = 0;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j]  = 1 + dp[i-1][j-1];
					result = Integer.max(result, dp[i][j]); 
				}
			}
		}
		return result;	
	}
	
	public static int recursive(String s1 , String s2 ,int l1,int l2,int count) {
		if(s1.length()==l1 || s2.length()==l2) {
			return count;
		}
		if(s1.charAt(l1)==s2.charAt(l2)) {
			return recursive(s1,s2,l1+1,l2+1,count+1);
		}else {
			return Math.max(count, Math.max(recursive(s1,s2,l1+1,l2,count),recursive(s1,s2,l1,l2+1,count)));
		}
	}
	

}
