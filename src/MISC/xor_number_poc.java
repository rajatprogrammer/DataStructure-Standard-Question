package MISC;

public class xor_number_poc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9,12,2,11,2,2,10,9,12,10,9,11,2};
		int n = 1024;
		int data = a[0];
		for(int i=1;i<a.length;i++) {
			data = data ^ a[i];
			 System.out.println("xor is " + data + "order is" + i);
		}
		for(int i=1;i<=4;i++) {
			n = n<<i;
		System.out.println("left shift " + n + "order is" + i);
	}
		n = 1024;
		for(int i=1;i<=4;i++) {
			n = n>>i;
		System.out.println("right shift is " + n + "order is" + i);
	}

	}
}
