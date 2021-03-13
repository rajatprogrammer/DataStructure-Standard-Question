package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.

 

Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 * */
public class smallestCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "loveleetcode";
		char c='e';
		//System.out.print(Arrays.toString(shortestToChar(s,c)));
		System.out.print(Arrays.toString(shortestToCharOptimizesWOrked(s,c)));
	}
	public static int[] shortestToCharOptimizesWOrked(String s, char c) {
		int n = s.length();
		int[] result = new int[s.length()];
		int cposition = -n;
		for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==c)
            {
                cposition = i;
            }
            result[i]=Math.abs(i-cposition);
        }
		for(int i=n-1;i>=0;i--)
        {
            if(s.charAt(i)==c)
            {
                cposition = i;
            }
            result[i] =Math.min(result[i], Math.abs(i-cposition));
        }
		 
        return result;
	}
	public static int[] shortestToChar(String s, char c) {
		int res[] = new int[s.length()];
		List<Integer> ls = new ArrayList<Integer>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c) {
				ls.add(i);
			}
		}
		int itr=1;
		for(int i=0;i<s.length();i++) {
			if(ls.size()>itr && ls.get(itr)>i) {
				res[i] = Math.min(Math.abs(i-ls.get(itr-1)),Math.abs(i-ls.get(itr)));
			}
			else if(ls.size()>itr && ls.get(itr)==i) {
				res[i]=0;
			}else if(ls.size()==itr+1 && ls.get(itr)<i) {
				res[i]=i-ls.get(itr);
			}else {
				if(ls.size()>itr) {
					while(ls.size()>itr && ls.get(itr)<i) {
						itr++;
						if(ls.get(itr)>i) {
							res[i] = Math.min(Math.abs(i-ls.get(itr-1)),Math.abs(i-ls.get(itr)));
						}
					}
					
				}
			}
		}
		return res;
			
	}

}
