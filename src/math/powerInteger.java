package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*https://leetcode.com/problems/powerful-integers/
 * Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 20 + 30
3 = 21 + 30
4 = 20 + 31
5 = 21 + 31
7 = 22 + 31
9 = 23 + 30
10 = 20 + 32
 * */
public class powerInteger {

	public static void main(String[] args) {
		System.out.print(powerfulIntegers(2,3,10));
	}
		 public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		        HashSet<Integer> set = new HashSet();
		        List<Integer> l1 = new ArrayList();
		        List<Integer> l2 = new ArrayList();
		        
		        int px = (int) Math.pow(x, 0);
		        int p = 0; 
		        while(px <= bound) {
		            l1.add(px);
		            p++;
		            px = (int) Math.pow(x, p);
		            if(px == 1) {
		                break;
		            }
		        }
		        
		        int py = (int) Math.pow(y, 0);
		        p = 0;
		        while(py <= bound) {
		            l2.add(py);
		            p++;
		            py = (int) Math.pow(y, p);
		            if(py == 1) {
		                break;
		            }
		        }
		        
		        for(int i=0; i<l1.size(); i++) {
		            if(l1.get(i) > bound) {
		                break;
		            }
		            for(int j=0; j<l2.size(); j++) {
		                if(l2.get(j) > bound) {
		                    break;
		                }
		                int sum = l1.get(i) + l2.get(j);
		                if(sum <= bound) {
		                    set.add(sum);
		                }
		            }
		        }
		        
		        return new ArrayList<Integer>(set);
		    }
	 }
	
