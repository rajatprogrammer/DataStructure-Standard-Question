package ARRAY;

import java.util.Arrays;

//https://leetcode.com/problems/prison-cells-after-n-days/
public class PrisonNday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cells[] = {0,1,0,1,1,0,0,1};
		System.out.print(Arrays.toString(prisonAfterNDays(cells,7)));
	}
	 public static int[] prisonAfterNDays(int[] cells, int N) {
		 int a = N%14==0?14:N%14;
		 int arr[] = new int[cells.length];
		 for(int k=0;k<a;k++){
	            for(int i=1;i<cells.length-1;i++){
	                if(cells[i+1]==cells[i-1])
	                    arr[i]=1;
	                else
	                    arr[i]=0;
	            }
	           for(int i=0;i<cells.length;i++) {
	        	   cells[i] = arr[i];
	           }
	        }
	        return cells;
	    }
	 }
