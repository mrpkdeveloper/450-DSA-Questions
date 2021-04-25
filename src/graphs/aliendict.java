package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class aliendict {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
//		String[] dict = { "caa", "aaa", "aab" };
		dict(dict, 4);

	}

	public static void dict(String[] dict, int noofalpha) {
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < noofalpha; i++) {
			ArrayList<Integer> nbr = new ArrayList<>();
			g.add(nbr);
		}

		for (int i = 0; i < dict.length - 1; i++) {
			String s1 = dict[i];
			String s2 = dict[i + 1];
			for (int j = 0, k = 0; j < s1.length() && k < s2.length(); j++, k++) {
				if (s1.charAt(j) == s2.charAt(k)) {
					continue;
				} else {
//					System.out.println(s1.charAt(j) + " -> " + s2.charAt(k));
					g.get(s1.charAt(j) - 'a').add(s2.charAt(k) - 'a');

					break;
				}
			}
		}
		topsort(g);

	}

	public static void topsort(ArrayList<ArrayList<Integer>> vtces) {

		HashMap<Integer, Boolean> map = new HashMap<>();
		LinkedList<Integer> st = new LinkedList<>();
		for (int i = 0; i < vtces.size(); i++) {
			if (!map.containsKey(i)) {
				dfs(map, i, vtces, st);
			}
		}

		String ans = "";
		while (st.size() > 0) {
			int n = st.removeFirst();
			char ch = (char) ('a' + n);
			ans += ch;
		}
		System.out.println(ans);

	}

	public static void dfs(HashMap<Integer, Boolean> map, int src, ArrayList<ArrayList<Integer>> vtces,
			LinkedList<Integer> st) {

		if (map.containsKey(src)) {
			return;
		}
		map.put(src, true);
		ArrayList<Integer> nbrlist = vtces.get(src);
		for (int i = 0; i < nbrlist.size(); i++) {
			if (!map.containsKey(nbrlist.get(i))) {
				dfs(map, nbrlist.get(i), vtces, st);
			}
		}

		st.addFirst(src);

	}

}
