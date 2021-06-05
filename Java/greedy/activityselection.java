package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class activityselection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] = { 5, 3, 0, 5, 8, 1 };
		int e[] = { 9, 4, 6, 7, 9, 2 };
		solve(s, e);

	}

	public static class pair implements Comparable<pair> {

		int start, end;

		pair(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.end - o.end;
		}

	}

	public static void solve(int[] s, int[] e) {

		ArrayList<pair> arr = new ArrayList<>();

		for (int i = 0; i < s.length; i++) {
			arr.add(new pair(s[i], e[i]));
		}
		Collections.sort(arr);
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).start + " - " + arr.get(i).end);
//		}

		int count = 1, end = arr.get(0).end;
		for (int i = 1; i < arr.size(); i++) {
			if (end < arr.get(i).start) {
				count++;
				end = arr.get(i).end;
			}
		}

		System.out.println(count);
	}

}
