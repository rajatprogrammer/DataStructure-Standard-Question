package BitManipulation;
//https://leetcode.com/problems/single-number-ii/
//first we do biwise xor with nums[i] and then do and with completement of  two variable for onces
public class singleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {2,2,2,4};
		 int once=0;
	        int two=0 ;   
			for(int i=0;i<nums.length;i++){
	           once = (once^nums[i])&(~two);
	            two= (two^nums[i])&(~once);
	        }
			System.out.print(once);
	}

}
