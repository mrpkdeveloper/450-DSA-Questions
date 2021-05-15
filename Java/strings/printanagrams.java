package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class printanagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "god", "act", "dog", "tac", "cat" };
		anagrams(arr);

	}

	public static void anagrams(String[] arr) {

		HashMap<HashMap<Character, Integer>, ArrayList<String>> list = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			String s = arr[i];
			for (int j = 0; j < s.length(); j++) {
				if (!map.containsKey(s.charAt(j))) {
					map.put(s.charAt(j), 1);
				} else {
					map.replace(s.charAt(j), map.get(s.charAt(j)) + 1);
				}
			}

			if (!list.containsKey(map)) {
				ArrayList<String> arrlist = new ArrayList<String>();
				arrlist.add(s);
				list.put(map, arrlist);
			} else {
				list.get(map).add(s);
				list.replace(map, list.get(map));
			}

		}

		List<List<String>> finalans = new ArrayList<>();
		for (ArrayList<String> anslist : list.values()) {
			finalans.add(anslist);
		}

		System.out.println(finalans);

	}

}
