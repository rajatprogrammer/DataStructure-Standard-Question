package MISC;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Word Ladder (Length of shortest chain to reach a target word)
Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a valid word i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.

Example:

Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
             start = TOON
             target = PLEA
Output: 7
Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA
 * */


class store{
	String word;
	int count;	
	public store(String word,int count) {
		this.word=word;
		this.count=count;
	}
}

public class word_ladder {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> D = new HashSet<String>(); 
		D.add("poon"); 
		D.add("plee"); 
		D.add("same"); 
		D.add("poie"); 
		D.add("plie"); 
		D.add("poin"); 
		D.add("plea"); 
		String start = "toon"; 
		String target = "plea"; 
		System.out.println("total lenght is" + shortestChainLen(start,target,D));
	}
	static int shortestChainLen(String orig, String dest,HashSet<String> str) {
		Queue<store> queue = new LinkedList<store>();
		queue.add(new store(orig,1));
		int total = -1;
		while(!queue.isEmpty()) {
			store item =queue.peek();
			queue.remove(item);
			Iterator<String> temp = str.iterator(); 
			while (temp.hasNext()) { 
				String text=temp.next();
				boolean data=isadjacent(item.word,text); 
				if(data) {
					item.count = item.count+1;
					queue.add(new store(text,item.count));
					temp.remove();
					total = item.count;
					if (text == dest) 
						return total; 
				}
	        } 
			
		}
		return total;
		
	}
	
	static boolean isadjacent(String  a, String  b) 
	{ 
		int count = 0; // to store count of differences 
		int n = a.length(); 

		// Iterate through all characters and return false 
		// if there are more than one mismatching characters 
		for (int i = 0; i < n; i++) 
		{ 
			if (a.charAt(i) != b.charAt(i)) count++; 
			if (count > 1) return false; 
		} 
		return count == 1 ? true : false; 
	} 

}
