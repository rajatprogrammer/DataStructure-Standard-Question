package STACK;
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
import java.util.Stack;

public class valid_strinf {
	static class store{
        int index;
        char ch;
        public store(int index,char ch){
            this.index = index;
            this.ch = ch;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
	}
	public static String minRemoveToMakeValid(String s) {
        Stack<store> s1 = new Stack<store>();
        int count=0; 
        while(s.length()>count){
            if(s.charAt(count)=='('){
                s1.push(new store(count,s.charAt(count)));    
            }else if (s.charAt(count)==')' && !s1.isEmpty() && s1.peek().ch=='('){
                s1.pop(); 
            }else if(s.charAt(count)==')'){
                s1.push(new store(count,s.charAt(count))); 
            }
            count++;
        }
        while(!s1.isEmpty()){
            store temp = s1.pop();
            s=s.substring(0, temp.index)+ s.substring(temp.index + 1);
        }
        return (s);

    }

}
