package stackandqueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class gamewithstring {

	static int minValue(String s, int k) {
		// code here
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (Integer freq : map.values()) {
			q.add(freq);
		}

		for (int i = 0; i < k; i++) {
			int val = q.remove();
			q.add(val - 1);
		}

		int sum = 0;
		while (!q.isEmpty()) {
			int val = q.remove();
			sum += val * val;
		}

		// System.out.println(map);
		return sum;
	}

}
