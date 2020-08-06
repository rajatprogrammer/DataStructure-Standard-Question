package MISC;

public class implemt_non_repeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// xor will the xor of two non repeating elements
        //we know that in a XOR b, any particular bit is set if that bit is set in either a or b
        //we can use this to divide the array elements into two groups where each group will be responsible
        // to get a and b
		int a[]= {4,2,2,3,3,29};
		int xor = a[0];
		for(int i = 1; i < a.length; i++) 
			   xor ^= a[i]; 
		 // System.out.println(xor);
		//get the right most set bit
		int set_bit_no = xor & ~(xor-1);
		System.out.println(set_bit_no);
		//divide the array elements into 2 groups
		int x=0,y=0;
		for(int i = 0; i < a.length; i++) 
		  {
		    if((a[i] & set_bit_no)!=0) 
		    {
			     x = x ^ a[i]; /*XOR of first set */
		    }
		    else
		     y = y ^ a[i]; /*XOR of second set*/
		  } 
		System.out.println("first is " +x +"second is" + y);
	}

}
