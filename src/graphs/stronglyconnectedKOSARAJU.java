package graphs;

import java.util.LinkedList;

public class stronglyconnectedKOSARAJU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void kosaraju(int[][] adj) {

	}

	public static void dfs(int[] visited, int[][] adj, int src, LinkedList<Integer> st) {

		visited[src] = 1;
		int[] nbr = adj[src];
		for (int i = 0; i < nbr.length; i++) {
			if (nbr[i] == 1 && visited[i] == 0) {
				dfs(visited, adj, i);
			}
		}

	}

}
