package graphs;

import java.util.HashMap;
import java.util.LinkedList;

public class twocliche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int adj[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 0 } };
		System.out.println(tc(adj));

	}

	public static class pair {
		int vname;
		int color;

		pair(int v, int col) {
			this.vname = v;
			this.color = col;
		}
	}

	public static boolean tc(int[][] adj) {

		int[][] adjnew = new int[adj.length][adj[0].length];
		// taking complement
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[0].length; j++) {
				if (adj[i][j] == 0 && i != j) {
					adjnew[i][j] = 1;
				}
			}
		}

		// now check for bipertite
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < adj.length; i++) {
			if (!map.containsKey(i)) {
				queue.addLast(new pair(i, 1));
				while (!queue.isEmpty()) {
					pair rv = queue.removeFirst();
					// cycle
					if (map.containsKey(rv.vname)) {

						int nc = rv.color;
						int oc = map.get(rv.vname);
						if (oc != nc) {
							return false;
						}
						continue;
					}

					map.put(rv.vname, rv.color);

					for (int j = 0; j < adjnew[0].length; j++) {
						if (adjnew[rv.vname][j] == 1) {
							int nc = 1;
							if (rv.color == 1) {
								nc = 2;
							}
							if (!map.containsKey(j)) {
								queue.add(new pair(j, nc));
							}
						}
					}
				}

			}
		}
		return true;
	}

}
