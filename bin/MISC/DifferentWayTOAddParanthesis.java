package MISC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class DifferentWayTOAddParanthesis {
	Map<String,List<Integer>> hs = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentWayTOAddParanthesis ob1 =new DifferentWayTOAddParanthesis();
		List<Integer> result=ob1.diffWaysToCompute("2*3-4*5");
		Integer array[] = new Integer[result.size()];
		array=result.toArray(array);
		System.out.print(Arrays.toString(array));
	}
	//recursive Solution
	public List<Integer>diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		int i=0;
		while(i<input.length()) {
			 char c=input.charAt(i);
			if(input.charAt(i)!='*'&&input.charAt(i)!='+'&& input.charAt(i)!='-') {
				i++;
				continue;
			}
			List<Integer> left = diffWaysToCompute(input.substring(0,i));
			List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
			for(Integer rf:right) {
				for(Integer lf:left) {
					if(c=='*') {
						result.add(lf*rf);
					}else if(c=='-') {
						result.add(lf-rf);
					}else {
						result.add(lf+rf);
					}
				}
			}
			i++;
		}
		 if(result.size()==0){
			 result.add(Integer.parseInt(input));
	     }
		 return result;
	}
	//DP SOLUTIOn
	public List<Integer>diffWaysToComputeDP(String input) {
		List<Integer> result = new ArrayList<Integer>();
		if(hs.containsKey(input)) {
			return hs.get(input);
		}
		int i=0;
		while(i<input.length()) {
			 char c=input.charAt(i);
			if(input.charAt(i)!='*'&&input.charAt(i)!='+'&& input.charAt(i)!='-') {
				i++;
				continue;
			}
			List<Integer> left = diffWaysToCompute(input.substring(0,i));
			List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
			for(Integer rf:right) {
				for(Integer lf:left) {
					if(c=='*') {
						result.add(lf*rf);
					}else if(c=='-') {
						result.add(lf-rf);
					}else {
						result.add(lf+rf);
					}
				}
			}
			i++;
		}
		 if(result.size()==0){
			 result.add(Integer.parseInt(input));
	     }
		 hs.put(input,result);
		 return result;
	}
	

}
