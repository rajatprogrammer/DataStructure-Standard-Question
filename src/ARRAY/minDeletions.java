package ARRAY;

import java.util.Arrays;
//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class minDeletions {

	public static void main(String[] args) {
		minDeletions ob1 = new minDeletions();
		String s="aaabbbcc";
		System.out.print(ob1.minDeletions(s));

	}
	public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
		Arrays.sort(freq);
        int exp = freq[25];
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) continue;
            if (freq[i] > exp) {
                res += freq[i] - exp;
            } else {
                exp = freq[i];
            }
            if (exp > 0) exp--; // Lowest exp is zero, cannot be negative
        }
        return res;
    }

}
