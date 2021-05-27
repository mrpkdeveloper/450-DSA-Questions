package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class rotalloranges {

	public class pair {
		int time;
		int i, j;

		pair(int t, int i, int j) {
			this.time = t;
			this.i = i;
			this.j = j;
		}
	}

	// Function to find minimum time required to rot all oranges.
	public int orangesRotting(int[][] grid) {
		Queue<pair> q = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new pair(0, i, j));
				}
			}
		}

		int maxt = 0;
		int[] rx = { -1, 1, 0, 0 };
		int[] ry = { 0, 0, -1, 1 };
		while (!q.isEmpty()) {

			pair rv = q.remove();
			if (maxt < rv.time) {
				maxt = rv.time;
			}

			int i = rv.i;
			int j = rv.j;
			// check for nbrs
			for (int k = 0; k < 4; k++) {
				int fi = i + rx[k];
				int fj = j + ry[k];
				int nr = grid.length;
				int nc = grid[0].length;
				if (fi >= 0 && fi < nr && fj >= 0 && fj < nc && grid[fi][fj] == 1) {
					q.add(new pair(rv.time + 1, fi, fj));
					grid[fi][fj] = 2;
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return maxt;
	}
}
