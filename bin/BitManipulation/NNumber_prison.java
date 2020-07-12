package BitManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/prison-cells-after-n-days/
public class NNumber_prison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cells[] = {0,1,0,1,1,0,0,1};
		System.out.print(Arrays.toString(prisonAfterNDays(cells,7)));
	}
	public static int[] prisonAfterNDays(int[] cells, int N) {
        int num = 0;
        for (int i=0;i<cells.length;i++) {
            if (cells[i] == 1 ){
                num += (int)Math.pow(2, cells.length-i-1);
            }
        }
        
        Set<Integer> hash = new HashSet<>();
        int i=0;
        for(;i<N;i++){
			// XNOR because both bits need to be on/off
			// and 126 (01111110) to turnoff endbits
            int temp = ~(num<<1 ^ num>>1) & 126;
            if(hash.contains(temp)) break;
            hash.add(temp);
            num = temp;
        }

        if (i!=N) {
            N %= i;
            i=0;
            for(;i<N;i++){
                num = ~(num<<1 ^ num>>1) & 126;
            }
        }

        int[] ans = new int[8];
        for (int j=7;j>=0;j--) {
            if (num%2==1) ans[j] = 1;
            else ans[j] = 0;
            num /= 2;
        }
        return ans;
    }

}
