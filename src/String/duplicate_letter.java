package String;

import java.util.HashMap;
import java.util.Stack;

//https://leetcode.com/problems/remove-duplicate-letters/
public class duplicate_letter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbacdcbc";
		System.out.print(removeDuplicateLetters(s));
	}
	public static String removeDuplicateLetters(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++){
          char c = s.charAt(i);
          map.put(c , map.getOrDefault(c , 0)+1);
        }
        Stack<Character> st = new Stack<>();
        boolean visited[] = new boolean[26];
        for(int i=0 ; i<s.length() ; i++){
          char c = s.charAt(i);
          if(visited[c - 'a']){
            map.put(c , map.get(c) - 1);
            continue;
          }
          while(st.size()!=0 && (st.peek() - 'a') >= (c - 'a') && map.get(st.peek()) != 0 ){
            visited[st.peek() - 'a'] = false;
            st.pop();
          }
          st.push(c);
          visited[c - 'a'] = true;
          map.put(c , map.get(c) - 1);
          
        }
       StringBuilder sb = new StringBuilder();
      while(st.size()!=0){
        sb.append(st.pop());
      }
      sb = sb.reverse();
      return sb.toString();
    }

}
