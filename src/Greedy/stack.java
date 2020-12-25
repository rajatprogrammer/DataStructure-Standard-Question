package Greedy;

import java.util.Stack;

public class stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="()(()))))()";
		Stack<Character> s = new Stack<Character>();
	      int count=0;
	      int max=0;
	      for(int i=0;i<name.length();i++){
	       //  System.out.println("hello" +count );
	         if(name.charAt(i)=='('){
	            s.push('(');
	         }
	         else if(name.charAt(i)==')'){
	        	 if(!s.isEmpty()) {
	        		 s.pop();
	        		  count++;
	        		  max= Math.max(count,max);
	        	 }else {
	        		 count=0;
	        	 }
	         }
	      }
	       System.out.println(max*2);
	}
	

}
