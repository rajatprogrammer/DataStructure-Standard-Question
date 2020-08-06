package MISC;

import java.util.Arrays;

public class non_empty {

	static int func(int[] nums) {
		int n=nums.length;
        int minele=Integer.MAX_VALUE,sum=0;
        for(int i=0;i<n;i++)
        {
            minele=Math.min(minele,nums[i]);
            sum+=nums[i];
        }
        int steps=sum-n*minele;
        return steps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] x = {0};
		System.out.println(non_empty.func(x));
	}

}
