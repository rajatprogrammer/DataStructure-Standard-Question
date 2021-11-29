package prefixSum;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/prefix-and-suffix-search/
 * */
public class PrefixandSuffixSearch {

	public static HashMap<String, Integer> hs = new HashMap<>();

	public static void main(String[] args) {
		String words[] = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};
		WordFilter(words);
		System.out.print(f("bccbacbcba","a"));

	}

	public static void WordFilter(String[] words) {
		for(int w=0;w<words.length;w++) 
		{
	        for(int i=0;i<=words[w].length();i++) 
	        {
	        	for(int j=0;j<=words[w].length();j++) {
	        		String pat = words[w].substring(0,i)+'#'+words[w].substring(words[w].length()-j);
	        		hs.put(pat,w);
	        	}
	        }
		}
    }

	public static int f(String prefix, String suffix) {
		int ft=(hs.containsKey(prefix+'#'+suffix))?hs.get(prefix+'#'+suffix): -1;
		return ft;
	}

}
