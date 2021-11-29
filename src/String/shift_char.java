package String;
//https://leetcode.com/problems/shifting-letters/
public class shift_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(shiftingLetters("abc",new int[] {4,6,7}));
	}
	
	 public static String shiftingLetters(String s, int[] shifts) {
	        
	        char ch[] = s.toCharArray();
	        int total = 0;
	        
	        for(int i = shifts.length-1;i>=0;i--){
	            
	            total = (total + shifts[i]) % 26;
	            ch[i] = (char)((ch[i] - 'a' + total) % 26 + 'a');
	        }
	        return String.valueOf(ch);
	    }

}
