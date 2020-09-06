package STACK;

import java.util.Stack;

//https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
public class repearting_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaac";
		int cost[] = {1,2,3,4,5};
		System.out.print(minCost(s,cost));
	}
	 public static int minCost(String s, int[] cost) {
	        Stack<Integer> stack=new Stack<>();
	        int res=0;
	        for(int i=0;i<s.length();i++){
	            if(!stack.isEmpty()&&s.charAt(stack.peek())==s.charAt(i)){
	                if(cost[stack.peek()]<cost[i]){
	                    res+=cost[stack.peek()];
	                    stack.pop();
	                    stack.push(i);
	                }
	                else {
	                    res+=cost[i];
	                }
	            } else{ stack.push(i);}
	        }
	        return res;
	    }
	

}
