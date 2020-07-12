package designDataStrutcture;
//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class insert_duplicate_allowed {
	 Random r = new Random();
	    List<Integer>list=new ArrayList<>();
	    Map<Integer,Set<Integer>>map=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean insert(int val) {
        if(map.containsKey(val)){
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }else{ 
            Set<Integer>set=new HashSet<>();
            set.add(list.size());
            list.add(val);
            map.put(val,set);
            return true;
        }
    }
	
	 public int getRandom() {
	        return list.get(r.nextInt(list.size()));
	 }
	 
	 public boolean remove(int val) {
		 if(!map.containsKey(val))return false;
	        Set<Integer>l=map.get(val);
	        int removeIndex=0;
	        for(Integer key:l){
	            removeIndex=key;break;
	        }
	        l.remove(removeIndex);
	        if(l.size()==0)map.remove(val);
	        if(removeIndex==list.size()-1){
	            list.remove(list.size()-1);
	            return true;
	        }
	        int lastval=list.get(list.size()-1);
	        Set<Integer>l1=map.get(lastval);
	        l1.remove(list.size()-1);
	        l1.add(removeIndex);
	        list.remove(list.size()-1);
	        list.set(removeIndex,lastval);
	        return true;

	    }
	
	

}
