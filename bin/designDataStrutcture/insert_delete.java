package designDataStrutcture;
// https://leetcode.com/problems/insert-delete-getrandom-o1/
//https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class insert_delete {
	 List<Integer> arr = new ArrayList<>(); 
	    Map<Integer,Integer> hash = new HashMap<>(); 
	    Random rand = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input type opertaion ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
		//value of operation 	[[],[1],[2],[2],[],[1],[2],[]]
	}
	public boolean insert(int val) {
        
        // false if element is already in the set        
        if (hash.containsKey(val))
            return false;
        
        // true if the element is added to the set
        hash.put(val,arr.size());
        arr.add(val);
        return true;
    }
	public boolean remove(int val) {
        
        // return false if the element is not in the set
        if (!hash.containsKey(val))
            return false;
        
        // remove element is it is in the set; use temp to retain order
        int temp = arr.get(arr.size()-1);
        arr.set(hash.get(val),temp);
        hash.put(temp,hash.get(val));

		// swap elements to keep O(1) time
        arr.remove(arr.size()-1);
        hash.remove(val);
        return true;
    }
	public int getRandom() {
        
        // find a random element between idx 0 and size-1
          int idx = rand.nextInt(arr.size());
          return arr.get(idx);
    }
	

    


}
