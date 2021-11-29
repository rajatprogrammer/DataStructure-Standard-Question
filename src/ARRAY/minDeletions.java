package ARRAY;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
//microsoft ,apple
public class minDeletions {

	public static void main(String[] args) {
		minDeletions ob1 = new minDeletions();
		String s="aaabbbcc";
		System.out.print(ob1.minDeletions(s));

	}
	public int minDeletions(String s) {
        if(s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int x: map.values()){
            while(x> 0 && set.contains(x)){
                x--;
                result++;
            }
            set.add(x);
        }
        return result;
    }

}
