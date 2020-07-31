package math;
//https://leetcode.com/problems/powx-n/
public class power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(myPow(10.832,3));
	}
	public  static double myPow(double x, int n) {
        double ans = 1;
        long l = Math.abs((long)n);
        while (l > 0) {
            if ((l & 1) == 1) ans *= x;
			x *= x;
            l >>= 1;
        }
        return n < 0 ? 1 / ans : ans;
    }
	

}
