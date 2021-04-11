package strings;

import java.util.HashMap;

public class smallestwindow2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String S = "zoomlazapzo";
		String S = "timetopractice";
//		String P = "oza";
		String P = "toc";
		smallestwindow(S, P);

	}

	public static void smallestwindow(String s, String pat) {

		HashMap<Character, Integer> map = new HashMap<>();
		int dist = pat.length();
		for (int i = 0; i < pat.length(); i++) {
			char ch = pat.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int i = 0, j = 0, count = 0, minlength = Integer.MAX_VALUE, mini = 0, minj = 0;
		HashMap<Character, Integer> stringmap = new HashMap<>();
		while (i <= j && j < s.length()) {
			// acquire
			while (j < s.length() && count < dist) {
				char ch = s.charAt(j);
				stringmap.put(ch, stringmap.getOrDefault(ch, 0) + 1);
				if (stringmap.getOrDefault(ch, 0) <= map.getOrDefault(ch, 0)) {
					count++;
				}
				j++;
			}
			// collect ans and release
			while (count == dist) {
				if (minlength > (j - i)) {
					minlength = j - i;
					mini = i;
					minj = j;
				}
				char ch = s.charAt(i);
				if (stringmap.get(ch) == 1) {
					stringmap.remove(ch);
				} else {
					stringmap.replace(ch, stringmap.get(ch) - 1);
				}

				if (stringmap.getOrDefault(s.charAt(i), 0) < map.getOrDefault(s.charAt(i), 0)) {
					count--;
				}
				i++;
			}
		}

		System.out.println(s.substring(mini, minj));
	}

}
