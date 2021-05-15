package strings;

import java.util.HashMap;

public class isomorphicstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "abcace";
		String s1 = "pepcoding";
		String s2 = "sosherlok";
//		String s2 = "xyzxzw";
		System.out.println(isomorphic(s1, s2));

	}

	public static boolean isomorphic(String s1, String s2) {

		HashMap<Character, Character> map1 = new HashMap<>();
		HashMap<Character, Boolean> map2 = new HashMap<>();

		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {

			char ch1 = s1.charAt(i);
			char ch2 = s2.charAt(j);
			if (map1.containsKey(ch1)) {
				if (map1.get(ch1) != ch2) {
					return false;
				}
			} else {
				if (map2.containsKey(ch2)) {
					return false;
				} else {
					map1.put(ch1, ch2);
					map2.put(ch2, true);
				}
			}
			i++;
			j++;
		}

		System.out.println(map1);
		System.out.println(map2);
		return true;

	}

}
