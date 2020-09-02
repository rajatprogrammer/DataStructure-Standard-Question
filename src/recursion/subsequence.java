package recursion;
//
public class subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S ="geeksgeeks";
		String T="ge";
		System.out.print(subsequenceCount(S,T,0,0));
		System.out.print(subsequenceCountDp(S, T));
	}
	static int subsequenceCount(String S, String T,int i,int j)
	    {
	 		if(S.length()==i && T.length()==j || T.length()==j) {
	 			return 1;
	 		}
	 		if(S.length()<=i) {
	 			return 0;
	 		}
	 		if(S.charAt(i)==T.charAt(j)) {
	 			 return subsequenceCount(S, T, i+1, j+1)+subsequenceCount(S, T, i+1, j);
	 		}
	 		return subsequenceCount(S,T,i+1,j);	
	    }
	static int subsequenceCountDp(String S, String T)
    {
		int dp[][] = new int[T.length()+1][S.length()+1];
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=1;
		}
		for(int i=1;i<=T.length();i++) {
			for(int j=1;j<=S.length();j++) {
				if(T.charAt(i-1)==S.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
				}else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		return dp[T.length()][S.length()];
    }
}
