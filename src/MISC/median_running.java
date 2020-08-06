package MISC;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class median_running {
		Queue<Integer> smaller =  new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Queue<Integer> greater = new PriorityQueue<Integer>();
		int first_mid = 0;
		double mid = 0;
	    public void addNum(int num) {
	        if(first_mid==0) {
	        	smaller.add(num);	
	        	mid = smaller.peek();
	        	first_mid=1;
	        }else {
	        	if(smaller.size()==greater.size()) {
	        		if(mid<num) {
	        			greater.add(num);
	        			mid = greater.peek();
	        		}else {
	        			smaller.add(num);
	        			mid = smaller.peek();
	        		}
	        	}else if(smaller.size()>greater.size()) {
	        		if(mid<num) {
	        			greater.add(num);
	        			mid = ((greater.peek() + smaller.peek())/2);
	        		}else {
	        			smaller.add(num);
	        			greater.add(smaller.remove());
	        			mid = ((greater.peek() + smaller.peek())/2);
	        		}
	        	}else {
	        		if(mid<num) {
	        			greater.add(num);
	        			smaller.add(greater.remove());
	        			mid = ((greater.peek() + smaller.peek())/2);
	        		}else {
	        			smaller.add(num);
	        			mid = ((greater.peek() + smaller.peek())/2);
	        		}
	        	}
	        }
	    }
	    
	    public double findMedian() {
			return mid;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
