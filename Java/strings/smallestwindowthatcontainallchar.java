package strings;

import java.util.HashMap;
import java.util.HashSet;

public class smallestwindowthatcontainallchar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(smallestwindow("GEEKSGEEKSFOR"));
//		System.out.println(smallestwindow("abcd"));
//		System.out.println(smallestwindow("aabbcdab"));

	}

	public static int smallestwindow(String s) {

		// add al unique characters to hashset
		HashSet<Character> map = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			map.add(s.charAt(i));
		}

		int count = map.size();

		if (s.length() == count) {
			return count;
		}

		HashMap<Character, Integer> map2 = new HashMap<>();
		int i = 0, j = 0, distinct = 0, minlength = Integer.MAX_VALUE;
		int mini = 0, minj = 0;
		while (i <= j && j < s.length()) {

			// acquire
			while (map2.size() < count) {
				char ch = s.charAt(j);
				map2.put(ch, map2.getOrDefault(ch, 0) + 1);
				j++;
			}

			// collect ans and release
			while (map2.size() == count) {
				if (minlength > (j - i)) {
					minlength = j - i;
					minj = j;
					mini = i;
				}
				char ch = s.charAt(i);
				if (map2.get(ch) == 1) {
					map2.remove(ch);
				} else
					map2.replace(ch, map2.get(ch) - 1);
				i++;
			}
		}

		System.out.println(s.substring(mini, minj));
		return minlength;
	}

}
