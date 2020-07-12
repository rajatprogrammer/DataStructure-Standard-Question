package STACK;
//https://leetcode.com/problems/valid-parentheses/
import java.util.Stack;

public class validParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isValid("()[]{}"));
	}
	public static boolean isValid(String s) {
	      Stack<Character> stk = new  Stack<>();
	        for(int i=0;i<s.length();i++){
	           if(s.charAt(i)=='(' ||s.charAt(i)=='{' || s.charAt(i)=='[' ){
	              stk.push(s.charAt(i)); 
	           }else{
	               if(!stk.isEmpty()){
	                    char x = stk.peek();
	                   if(x=='(' && s.charAt(i)==')'){
	                       stk.pop();
	                   }
	                   else if(x=='{' && s.charAt(i)=='}'){
	                       stk.pop();
	                   }
	                   else if(x=='[' && s.charAt(i)==']'){
	                       stk.pop();
	                   }else{
	                       return false;
	                   }
	               }else{
	                   return false;
	               }
	               
	           } 
	        }
	        if(stk.isEmpty()){
	            return true;
	        }else{
	            return false;
	        }
	    }

}
