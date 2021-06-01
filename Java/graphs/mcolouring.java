package graphs;

public class mcolouring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adj = { { 0, 1, 1, 0 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };

		System.out.println(graphcolouring(adj, 3, 0, new int[adj.length]));

	}

	public static boolean graphcolouring(int[][] adj, int m, int src, int[] color) {
		// all vtces visited
		if (src == adj.length) {
			return true;
		}

		// now check which colur i can give the src
		for (int i = 1; i <= m; i++) {
			if (check(adj, src, i, color)) {
				color[src] = i;
				if (graphcolouring(adj, m, src + 1, color)) {
					return true;
				}
				color[src] = 0;
			}
		}
		return false;
	}

	private static boolean check(int[][] adj, int src, int col, int[] color) {
		// if adj have same color return false
		for (int j = 0; j < color.length; j++) {
			if (adj[src][j] == 1 && color[j] == col) {
				return false;
			}
		}
		return true;
	}

}
