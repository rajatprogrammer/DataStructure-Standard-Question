package DP;
//https://www.geeksforgeeks.org/find-length-longest-subsequence-one-string-substring-another-string/?ref=rp
public class subsequenceSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "LLBLLACLLDBLLDLLCDLL";
		String y = "BACDBDCD";
		System.out.print(subsequenceRecursive(y,x,0,0));
	}
	
	static int subsequenceRecursive(String S,String N,int s,int n) {
		if(n>=N.length()-1) {
			return 1;
		}
		if(s>=S.length()-1) {
			return 1;
		}
		 if(S.charAt(s)==N.charAt(n)) {
			return 1 + subsequenceRecursive(S,N,s+1,n+1)+subsequenceRecursive(S,N,s+1,n); 
		}else {
			return subsequenceRecursive(S,N,s+1,n);
		}
	}

}
