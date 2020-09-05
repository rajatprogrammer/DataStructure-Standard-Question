package ARRAY;

//https://leetcode.com/problems/longest-mountain-in-array/
public class longest_mountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 1, 4, 7, 3, 2, 5 };
		System.out.print(longestMountain(arr));
	}
	//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	//https://leetcode.com/problems/replace-the-substring-for-balanced-string/
	// o(n) solution
	public static int longestMountain(int[] A) {
		if (A.length <= 2) {
			return 0;
		}
		int max_len = 0;
		boolean flip = false;
		int temp = 1;
		for (int i = 1; i < A.length; i++) {
			while (i < A.length && A[i - 1] < A[i]) {
				temp++;
				i++;
				flip = true;
			}
			while (flip && i < A.length && A[i - 1] > A[i]) {
				temp++;
				i++;
				max_len = Math.max(max_len, temp);
			}
			flip = false;
			temp = 1;
		}
		if (max_len < 3) {
			return 0;
		}
		return max_len;
	}

}
