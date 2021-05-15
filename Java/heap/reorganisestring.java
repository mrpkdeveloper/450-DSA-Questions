package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class reorganisestring {

	public static void main(String[] args) {

		System.out.println(reorganise("aaabbbccc"));

	}

	public static class pair implements Comparable<pair> {
		char ch;
		int frq;

		pair(char c, int f) {
			this.ch = c;
			this.frq = f;
		}

		@Override
		public int compareTo(pair o) {
			return o.frq - this.frq;
		}
	}

	public static String reorganise(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		PriorityQueue<pair> heap = new PriorityQueue<>();
		for (char c : map.keySet()) {
			heap.add(new pair(c, map.get(c)));
		}

		int maxfrq = heap.peek().frq;
		if (maxfrq > s.length() - maxfrq + 1) {
			System.out.println("not possible");
			return "";
		}

		StringBuilder ans = new StringBuilder();
		while (heap.size() > 1) {
			pair ch1 = heap.remove();
			pair ch2 = heap.remove();

			ans.append(ch1.ch);
			ans.append(ch2.ch);

			ch1.frq--;
			ch2.frq--;
			if (ch1.frq > 0) {
				heap.add(ch1);
			}
			if (ch2.frq > 0) {
				heap.add(ch2);
			}
		}

		if (heap.size() != 0) {
			pair ch = heap.remove();
			ans.append(ch.ch);
		}
		return ans.toString();

	}

}
