package strings;

import java.util.HashMap;

public class computercafeproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		computercafe(2, "ABBAJJKZKZ");
//		computercafe(3, "GACCBDDBAGEE");
//		computercafe(3, "GACCBGDDBAEE");
//		computercafe(1, "ABCBCA");
		computercafe(1, "ABCBCADEED");
	}

	public static void computercafe(int n, String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int count = 0;
		int i = 0, wait = 0;
		while (i < s.length()) {
			while (count <= n && i < s.length()) {
				if (!map.containsKey(s.charAt(i))) {
					count++;
					map.put(s.charAt(i), 1);
				} else {
					map.remove(s.charAt(i));
					count--;
				}
				i++;
			}

			while (count > n) {
				if (map.containsKey(s.charAt(i))) {
					map.remove(s.charAt(i));
					count--;
					wait++;
				} else {
					count++;
					map.put(s.charAt(i), 1);
				}
				i++;
			}
		}

		System.out.println(wait);
	}

}
