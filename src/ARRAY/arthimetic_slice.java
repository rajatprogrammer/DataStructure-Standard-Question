package ARRAY;
//https://leetcode.com/problems/arithmetic-slices/
/*
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7
 
A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

 
Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * */
public class arthimetic_slice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3,4,5};
		System.out.print(numberOfArithmeticSlices(arr));
	}
	 public static int numberOfArithmeticSlices(int[] A) {
		 if(A.length<3){
	            return 0;
	        }
		 int dpDiff[] = new int[A.length-1];
		 int count=0;
		 for(int i=1;i<A.length;i++) {
			 dpDiff[i-1] = Math.abs(A[i]-A[i-1]);
		 }
		 for(int i=1;i<dpDiff.length;i++) {
			 if(dpDiff[i-1]==dpDiff[i]) {
				 count++;
				 int itr = i;
				 boolean run=true;
				 while(itr>1 && run) {
					 if(dpDiff[i]==dpDiff[itr-1] && dpDiff[i]==dpDiff[itr-2]) {
						 count++;
						 itr--;
					 }
					 else {
						 run=false; 
					 }
				 }
			 }
		 }
	        return count;
	 }

}
