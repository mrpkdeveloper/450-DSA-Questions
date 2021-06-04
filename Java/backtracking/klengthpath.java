package backtracking;

import java.util.HashSet;

public class klengthpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adjmat = { { 0, 10, 5, 0 }, { 0, 0, 0, 0 }, { 0, 5, 0, 20 }, { 0, 10, 0, 0 } };
		int k = 36;
		HashSet<Integer> map = new HashSet<Integer>();
		System.out.println(solve(adjmat, k, 0, map));
	}

	// O(n!) -> time complexity
	public static boolean solve(int[][] adjmat, int k, int src, HashSet<Integer> map) {

		if (k <= 0) {
			return true;
		}
		map.add(src);

		int[] nbrs = adjmat[src];
		for (int i = 0; i < nbrs.length; i++) {
			if (nbrs[i] != 0 && !map.contains(nbrs[i])) {
				if (nbrs[i] > k) {
					return true;
				}
				if (solve(adjmat, k - nbrs[i], i, map)) {
					return true;
				}
			}
		}
		map.remove(src);
		return false;
	}

}
