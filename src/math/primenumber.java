package math;

public class primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(10));
	}
	
	 public static int countPrimes(int n) {
	        if (n <= 2) {
	            return 0;
	        }
	        
	        boolean[] numbers = new boolean[n];
	        for (int p = 2; p <= (int)Math.sqrt(n); ++p) {
	            if (numbers[p] == false) {
	                for (int j = p*p; j < n; j += p) {
	                    numbers[j] = true;
	                }
	            }
	        }
	        
	        int numberOfPrimes = 0;
	        for (int i = 2; i < n; i++) {
	            if (numbers[i] == false) {
	                ++numberOfPrimes;
	            }
	        }
	        
	        return numberOfPrimes;
	    }

}
