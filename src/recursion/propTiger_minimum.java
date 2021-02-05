package recursion;

public class propTiger_minimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,4};
		System.out.println(move(10,0));
	}
	
	public static int move(int target,int move) {
		if(target==0) {
			return move;
		}
		if(target<0) {
			return Integer.MAX_VALUE;
		}
		int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE,z=Integer.MAX_VALUE;
		if(target>=4) {
			x=(move(target-4,move+1));
		}
		else if(target>=2) {
			y=(move(target-2,move+1));
		}
		else if(target>=1) {
			z=(move(target-1,move+1));
		}
		
		int k = Math.min(x,y);
		return Math.min(k, z);
	}

}
