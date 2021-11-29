package MISC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class anargran_hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> hs = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char seq[] = strs[i].toCharArray();
			Arrays.sort(seq);
			String sortedString = new String(seq);
			if (hs.containsKey(sortedString)) {
				List<String> ls = hs.get(sortedString);
				ls.add(strs[i]);
			} else {
				List<String> ls = new ArrayList<>();
				ls.add(strs[i]);
				hs.put(sortedString, ls);
			}
		}
		for (Entry<String, List<String>> entry : hs.entrySet()) {
			res.add(entry.getValue());
		}
		return res;
	}

}
