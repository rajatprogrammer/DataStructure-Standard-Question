package MISC;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class map_priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> py = new PriorityQueue<Integer>(3,(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				// System.out.println(o2.compareTo(o1));
				 return o2.compareTo(o1);
//				if(o2>o1) {
//					return 1;
//				}
//				else {
//					return -1;
//				}
			}
		}));
//		Queue<Integer> py = new PriorityQueue<Integer>(5);
		py.add(3);
		py.add(19);
		py.add(112121);
		py.add(1);
		py.add(12);
	
		System.out.println(py.poll());
		System.out.println(py.poll());
		System.out.println(py.poll());
		System.out.println(py.poll());
		System.out.println(py.poll());
	}

}
