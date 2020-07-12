package Graph;
import java.util.HashMap;
import java.util.Map;
//https://www.geeksforgeeks.org/disjoint-set-data-structures/

/**
 * @author Rajat
 * Date 06/20/2015
 *  
 * Video link - https://youtu.be/ID00PMy0-vE
 *  
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 * 
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is 
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 * total time will be O(m). Proof in Coreman book.
 */
public class disjoint_Set {
	private Map<Long, node> hs = new HashMap<Long, node>();
			class node{
			Long data;
			node parent;
			int rank;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		disjoint_Set ob1= new disjoint_Set();
		ob1.makeSet(0);
		ob1.makeSet(1);
		ob1.makeSet(2);
		ob1.makeSet(3);
		System.out.println(ob1.union(0,1));
		System.out.println(ob1.union(1,2));
		System.out.println(ob1.union(2,0));
		System.out.println(ob1.union(2,3));
		System.out.println(ob1.union(3,3));

        System.out.println(ob1.findSet(1));
        System.out.println(ob1.findSet(2));
        System.out.println(ob1.findSet(3));
        System.out.println(ob1.findSet(0));
		
	}
	
	void makeSet(long data) {
		node root = new node();
		root.data = data;
		root.parent = root;
		root.rank=0;
		hs.put(data,root);
	}
	
	 /**
     * Finds the representative of this set
     */
    public long findSet(long data) {
        return findSet(hs.get(data)).data;
    }
    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    public node findSet(node data) {
    	if(data.parent==data) {
    		return data.parent;
    	}
    	data.parent = findSet(data.parent);
    	return data.parent;
    }
    
    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(long data1, long data2) {
    	node node1 = hs.get(data1);
    	node node2=hs.get(data2);
    	node parent1 = findSet(node1);
    	node parent2 = findSet(node2);
    	if(parent1==parent2) {
    		return false;
    	}else {
    			if(parent1.rank>=parent2.rank) {
    				parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
    	            parent2.parent = parent1;
    			}else {
    				parent1.parent = parent2;
    			}
    			return true;
    	}
   
    }
}
