package MISC;

public class max_min {
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {6,12,1,3,8,2,4};
		max_min.check(a, 0,0);
		System.out.print(max);
	}
	public static int check(int arr[],int i,int cur_max) {
		if(i>=arr.length) {
			max=Math.max(cur_max, max);
			return max;
		}
		else {
			int lf = check(arr,i+2,cur_max+arr[i]);
			int rf =0;
			if(i+1<arr.length) {
				 rf =  check(arr, i+1, arr[i+1]);
			}
			return Math.max(lf,rf);
			// return Math.max(max,v1);
		}
	}

}
