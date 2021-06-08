package greedy;

import java.util.TreeSet;

public class chooseandswap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "abba";
		System.out.println(chooseandswap(A));

	}

	public static String chooseandswap(String A) {
		TreeSet<Character> set = new TreeSet<>();

		for (int i = 0; i < A.length(); i++) {
			set.add(A.charAt(i));
		}
		// System.out.println(set);
		StringBuilder s = new StringBuilder();
		int flag = 0;

		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			set.remove(ch);
			char f = ' ';
			if (set.isEmpty()) {
				break;
			}
			for (char val : set) {
				f = val;
				break;
			}
			if (f < ch) {
				flag = 1;
				for (int j = 0; j < A.length(); j++) {
					if (A.charAt(j) == f) {
						s.append(ch);
					} else if (A.charAt(j) == ch) {
						s.append(f);
					} else {
						s.append(A.charAt(j));
					}
				}
				break;
			}
		}
		if (flag == 0) {
			return A;
		}
		return s.toString();
	}

}
