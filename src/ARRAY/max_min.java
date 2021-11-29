package ARRAY;

import java.util.Arrays;

//https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/
//worked only for sorted array
public class max_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 9, 10, 78,90};
		System.out.print(Arrays.toString(max_minFunc(arr)));
	}
	public static int[] max_minFunc(int arr[]) {
		int n = arr.length;
		int max_index=n-1,min_idx=0,maxNumberElem=arr[n-1]+1;
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				arr[i] =arr[i] + ((arr[max_index]%maxNumberElem)*maxNumberElem);
				max_index--;
			}else {
				arr[i] =arr[i] + ((arr[min_idx]%maxNumberElem)*maxNumberElem);
				min_idx++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = arr[i]/maxNumberElem;
		}
		return arr;
	}

}
