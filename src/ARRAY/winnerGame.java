package ARRAY;

//https://leetcode.com/problems/find-the-winner-of-an-array-game/
public class winnerGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 1, 3, 5, 4, 6, 7 };
		int k = 2;
		System.out.print(getWinner(arr, k));
	}

	public static int getWinner(int[] arr, int k) {
		int winner = arr[0];
		int wins = 0;
		for (int i = 1; i < arr.length; i++) {
			if (winner > arr[i])
				// increment wins count
				wins++;
			else {
				wins = 1;
				// new winner
				winner = arr[i];
			}
			if (wins == k)
				// if wins count is k, then return winner
				break;
		}
		return winner;
	}
}
