package hashFunction;
//https://leetcode.com/problems/longest-duplicate-substring/submissions/
import java.util.HashMap;
import java.util.Map;

public class longestDuplicate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String longestDupSubstringRajat(String S) {
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		int low=0;
		int high = S.length();
		int mid=0;
		int max_len=0;
		String max_string = "";
		while(low<=high) {
			 mid = low + (high-low)/2;
			 String substr = S.substring(low,mid);
			 if(hs.containsKey(substr)) {
				 hs.put(substr,hs.get(substr)+1);
				 if(max_len<hs.get(substr)) {
					 max_len=hs.get(substr);
					 max_string = substr;
				 }
			 }else {
				 hs.put(substr,1);
			 }
			 low=low+1;	
		}
		return max_string;
		
	}
	public String longestDupSubstring(String S) {
		int low =0;
		int high = S.length()-1;
		int mid =0;
		while(low<high) {
			mid = low + (high-low)/2;
			if(isDuplicatePresent(S,mid)) {
				low=mid;
			}else {
				high = mid-1;
			}
		}
		return findDuplicate(S,low);
	}
	
	private boolean isDuplicatePresent(String S, int length) {
		return findDuplicate(S,length)!=null?true:false;
	}
	
	 private String findDuplicate(String S, int length) { 
		 long prime = 29;
		 long hash=0;
		 long firstEntryPower = 1;
		 for(int i=0;i<length;i++) {
			firstEntryPower = firstEntryPower * prime;
			hash = hash * prime + S.charAt(i)-'a';
		 }
		 Map<Long, Integer> map = new HashMap<>();
	     map.put(hash, 0);
	     
	     for(int i=length;i<S.length();i++) {
	    	 hash = hash * prime + (S.charAt(i) - 'a');
	    	 hash = hash- firstEntryPower * (S.charAt(i - length) - 'a');
	    	 if (map.containsKey(hash)) {
	             int index = map.get(hash);
	             return S.substring(index, index + length);
	         }
		     map.put(hash, i - length + 1);
	     }
	     return null;
	 }
}
