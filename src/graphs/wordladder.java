package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class wordladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String end = "cog";
		ArrayList<String> arr = new ArrayList<>();
		arr.add("hot");
		arr.add("dot");
		arr.add("tog");
		arr.add("cog");
		System.out.println(length(begin, end, arr));
//		"hit"
//		"cog"
//		["hot","dot","tog","cog"]

	}

	public static int length(String begin, String end, ArrayList<String> arr) {

		if (!arr.contains(end)) {
			return 0;
		}

		HashSet<String> list = new HashSet<>();
		for (String string : arr) {
			list.add(string);
		}
		LinkedList<String> queue = new LinkedList<>();
		queue.addLast(begin);
		int depth = 0;
		while (!queue.isEmpty()) {
			depth++;
			int sz = queue.size();
			while (sz > 0) {
				String rv = queue.removeFirst();
				sz--;
				for (int i = 0; i < rv.length(); i++) {
					for (int j = 97; j <= 122; j++) {
						char ch = (char) j;
						if (ch == rv.charAt(i)) {
							continue;
						}
						String ns = rv.substring(0, i) + ch + rv.substring(i + 1);
						if (ns.compareTo(end) == 0) {
							return (depth + 1);
						}
						if (list.contains(ns)) {
							queue.addLast(ns);
							list.remove(ns);
						}
					}
				}
			}
		}
		return 0;
	}

}
