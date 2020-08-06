package MISC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_closest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1, 8}, {2, 15}, {3, 9}};
		int b[][] = {{1, 8}, {2, 11}, {3, 12}};
		int target = 20;
		Map<Integer, Integer>ob1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer>ob2 = new HashMap<Integer, Integer>();
		List<Integer> l1 = new ArrayList<Integer>(); 
		List<Integer> l2 = new ArrayList<Integer>();
		for(int i=0;i<3;i++) {
			for(int j=1;j<2;j++) {
				//System.out.println("i" + i + "j" + j);
				ob1.put(a[i][j],a[i][j-1]);
				ob2.put(b[i][j],b[i][j-1]);
				l1.add(a[i][j]);
				l2.add(b[i][j]);
			}
		}
		Collections.sort(l1);
		Collections.sort(l2);
		int a2[]=new int[l1.size()];
		int b2[]=new int[l2.size()];
		int count =0;
		for(Integer x : l1) {
			a2[count]=x;
			count++;
		}
		count=0;
		for(Integer x : l2) {
			b2[count]=x;
			count++;
		}
		int curr_diff=Integer.MAX_VALUE, equal=0;
		List<Integer[]>result = new ArrayList<Integer[]>();
		List<Integer[]>result_dif = new ArrayList<Integer[]>();
		int i=0,j=b2.length-1;
		while( i<a2.length && j>=0) {
			if(a2[i] + b2[j]==target) {
				Integer[] temp = new Integer[2];
				temp[0] = ob1.get(a2[i]);
				temp[1] = ob2.get(b2[j]);
				result.add(temp);
				j--;
				
			}else if((a2[i] + b2[j])<target) {
				if(curr_diff>target-(a2[i] + b2[j])) {
					result_dif.clear();
					curr_diff = target-(a2[i] + b2[j]);
					Integer[] temp = new Integer[2];
					temp[0] = ob1.get(a2[i]);
					temp[1] = ob2.get(b2[j]);
					result_dif.add(temp);
				}else if(curr_diff==target-(a2[i] + b2[j])) {
					curr_diff = target-(a2[i] + b2[j]);
					Integer[] temp = new Integer[2];
					temp[0] = ob1.get(a2[i]);
					temp[1] = ob2.get(b2[j]);
					result_dif.add(temp);
				}
				i++;
				
			}else {
				j--;
			}
		}
		result.addAll(result_dif);
		for(Integer[] x : result) {
			System.out.print("[");	
			for(int itr=0;itr<x.length;itr++) {
				System.out.print(x[itr]);	
			}
			System.out.print("]");	
			System.out.println();
		}
	}
}
