package MISC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/distant-barcodes/
 * */
public class adjacent_block {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int barcodes[] = {1,1,1,1,2,2,3,3};
		adjacent_block.rearrangeBarcodes(barcodes);
	}
	 public static void rearrangeBarcodes(int[] barcodes) {
		 int res[] = new int[barcodes.length];
		 	Arrays.fill(res,Integer.MAX_VALUE);
	       Map<Integer,Integer> hs = new TreeMap<Integer,Integer>();
	        for(int i=0;i<barcodes.length;i++){
	            if(!hs.containsKey(barcodes[i])){
	                hs.put(barcodes[i],1);
	            }else{
	                hs.put(barcodes[i],hs.get(barcodes[i])+1);
	            }
	        }
	        Map sortedMapValue = valueSort(hs); 
	        
	       for(Map.Entry<Integer, Integer> mp :hs.entrySet()) {
	    	   System.out.println("value"+ mp.getKey());
	       }

	    }
	 public static <K, V extends Comparable<V> > Map<K, V> 
	    valueSort(final Map<K, V> map) 
	    { 
	        // Static Method with return type Map and 
	        // extending comparator class which compares values 
	        // associated with two keys 
	        Comparator<K> valueComparator = new Comparator<K>() { 
	            
	                  // return comparison results of values of 
	                  // two keys 
	                  public int compare(K k1, K k2) 
	                  { 
	                      int comp = map.get(k1).compareTo( 
	                          map.get(k2)); 
	                      if (comp == 0) 
	                          return 1; 
	                      else
	                          return comp; 
	                  } 
	            
	              }; 
	        
	        // SortedMap created using the comparator 
	        Map<K, V> sorted = new TreeMap<K, V>(valueComparator); 
	        
	        sorted.putAll(map); 
	        
	        return sorted; 
	    } 
}
