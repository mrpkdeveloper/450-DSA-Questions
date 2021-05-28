package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class distanceofnearest1 {

	public class pair {
		int mindist, i, j;

		pair(int d, int i, int j) {
			this.mindist = d;
			this.i = i;
			this.j = j;
		}
	}

	// Function to find distance of nearest 1 in the grid for each cell.
	public int[][] nearest(int[][] grid) {

		Queue<pair> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					q.add(new pair(0, i, j));
				}
			}
		}

		int[][] ans = new int[grid.length][grid[0].length];
		int[][] vis = new int[grid.length][grid[0].length];
		int[] rx = { -1, 1, 0, 0 };
		int[] ry = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {

			pair rv = q.remove();
			int i = rv.i;
			int j = rv.j;
			ans[i][j] = rv.mindist;

			// check for nbrs
			for (int k = 0; k < 4; k++) {
				int fi = i + rx[k];
				int fj = j + ry[k];
				int nr = grid.length;
				int nc = grid[0].length;
				if (fi >= 0 && fi < nr && fj >= 0 && fj < nc && grid[fi][fj] == 0 && vis[fi][fj] != 1) {
					q.add(new pair(rv.mindist + 1, fi, fj));
					vis[fi][fj] = 1;
				}
			}

		}
		return ans;
	}

}
