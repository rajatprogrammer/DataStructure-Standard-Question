package math;

public class powe4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPowerOfFour(243));
	}
	public static boolean isPowerOfFour(int num) {
		if(num<=0) {
			return false;
		}else {
			int bit = (int) (Math.log(num)/Math.log(3));
			if(num>0 && num==(int)(Math.pow(3, bit))) {
				return true;
			}
			return false;
		}
    }

}
