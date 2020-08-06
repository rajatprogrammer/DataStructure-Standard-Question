/**
 *Count number of ways to reach a given score in a game
Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of ways to reach the given score.
Examples:

Input: n = 20
Output: 4
There are following 4 ways to reach 20
(10, 10)
(5, 5, 10)
(5, 5, 5, 5)
(3, 3, 3, 3, 3, 5)

Input: n = 13
Output: 2
There are following 2 ways to reach 13
(3, 5, 5)
(3, 10)
  **/

package MISC;

public class number_of_way {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(number_of_way.numberofway(20,new int[21]));
	}
	static int numberofway(int n,int store[])
	{
//		if(n==0) {
//			return(1);
//		}else if(n<0) {
//			return(0);
//		}else if(store[n]>0)
//			return store[n];
//		else {
//			store[n] = numberofway(n-3, store)+numberofway(n-5, store)+numberofway(n-10, store);
//			return(store[n]);
//		}
		store[0]=1;
		for(int i=3;i<=n;i++) {
			store[i]+=store[i-3];
		}for(int i=5;i<=n;i++) {
			store[i]+=store[i-5];
		}for(int i=10;i<=n;i++) {
			store[i]+=store[i-10];
		}
		return store[n];
	}	
}
