package stackandqueue;

import java.util.HashMap;
import java.util.LinkedList;

public class firstnonrepeatingcharacterstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabc";
		System.out.println(FirstNonRepeatingopti(s));

	}

	// brute force O(n2)
	public static String FirstNonRepeating(String s) {
		StringBuilder temp = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			temp.append(s.charAt(i));
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			int j = 0;
			int flag = 1;
			while (j < temp.length()) {
				if (map.get(temp.charAt(j)) == 1) {
					ans.append(temp.charAt(j));
					flag = 0;
					break;
				}
				j++;
			}
			if (flag == 1) {
				ans.append('#');
			}

		}

		return ans.toString();
	}

	// optimised O(n) - > time
	public static String FirstNonRepeatingopti(String s) {
		LinkedList<Character> temp = new LinkedList<>();
		StringBuilder ans = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			temp.addLast(s.charAt(i));
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			while (!temp.isEmpty() && map.get(temp.getFirst()) != 1) {
				temp.removeFirst();
			}
			if (temp.size() == 0) {
				ans.append('#');
			} else {
				ans.append(temp.getFirst());
			}
		}
		return ans.toString();
	}

}
