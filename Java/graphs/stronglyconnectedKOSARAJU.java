package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class stronglyconnectedKOSARAJU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adj = { { 0, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 }, };
		kosaraju(adj);

	}

	public static void kosaraju(int[][] adj) {
		// dfs and store all values in stack
		int[] vis = new int[adj.length];
		LinkedList<Integer> st = new LinkedList<>();
		for (int i = 0; i < adj.length; i++) {
			if (vis[i] == 0) {
				dfs(vis, adj, i, st);
			}
		}

		// now reverse every edge of adj list
		for (int i = 0; i < adj.length; i++) {
			for (int j = i + 1; j < adj[0].length; j++) {
				int temp = adj[i][j];
				adj[i][j] = adj[j][i];
				adj[j][i] = temp;
			}
		}

		Arrays.fill(vis, 0);
		// now again dfs with stack elements
		int c = 0;
		while (!st.isEmpty()) {
			int src = st.removeFirst();
			if (vis[src] == 0) {
				c++;
				dfs2(vis, adj, src);
			}
		}
		System.out.println(c);
	}

	public static void dfs(int[] visited, int[][] adj, int src, LinkedList<Integer> st) {
		visited[src] = 1;
		int[] nbr = adj[src];
		for (int i = 0; i < nbr.length; i++) {
			if (nbr[i] == 1 && visited[i] == 0) {
				dfs(visited, adj, i, st);
			}
		}
		st.addFirst(src);
	}

	public static void dfs2(int[] visited, int[][] adj, int src) {
		visited[src] = 1;
		int[] nbr = adj[src];
		for (int i = 0; i < nbr.length; i++) {
			if (nbr[i] == 1 && visited[i] == 0) {
				dfs2(visited, adj, i);
			}
		}
	}

}
