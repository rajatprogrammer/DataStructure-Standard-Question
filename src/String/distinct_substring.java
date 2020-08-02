package String;
import java.util.HashMap;
import java.util.Map;
//amazon
//https://www.geeksforgeeks.org/count-of-substrings-of-length-k-with-exactly-k-distinct-characters/
public class distinct_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "aabcdabbcdc";
		int k=3;
		System.out.print(countSubstrings(x,k));
	}

	public static int countSubstrings(String str, int K) {
		int N = str.length();

// Store the count  
		int answer = 0;

// Store the count of  
// distinct characters  
// in every window  
		Map<Character, Integer> map = new HashMap<Character, Integer>();

// Store the frequency of  
// the first K length substring  
		for (int i = 0; i < K; i++) {

// Increase frequency of  
// i-th character  
			if (map.get(str.charAt(i)) == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}

// If K distinct characters  
// exist  
		if (map.size() == K)
			answer++;

// Traverse the rest of the  
// substring  
		for (int i = K; i < N; i++) {

// Increase the frequency  
// of the last character  
// of the current substring  
			if (map.get(str.charAt(i)) == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}

// Decrease the frequency  
// of the first character  
// of the previous substring  
			map.put(str.charAt(i - K), map.get(str.charAt(i - K)) - 1);

// If the character is not present  
// in the current substring  
			if (map.get(str.charAt(i - K)) == 0) {
				map.remove(str.charAt(i - K));
			}

// If the count of distinct  
// characters is 0  
			if (map.size() == K) {
				answer++;
			}
		}

// Return the count  
		return answer;
	}

}
