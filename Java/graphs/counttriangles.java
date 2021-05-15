package graphs;

public class counttriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create adjacency matrix
		// of an undirected graph
		int graph[][] = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 0 } };

		// Create adjacency matrix
		// of a directed graph
		int digraph[][] = { { 0, 0, 1, 0 }, { 1, 0, 0, 1 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

		count(graph, false);
		count(digraph, true);

	}

	public static void count(int[][] adj, boolean directed) {
		int c = 0;
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				for (int k = 0; k < adj.length; k++) {
					if (adj[i][j] == 1 && adj[j][k] == 1 && adj[k][i] == 1) {
						c++;
					}
				}
			}
		}

		if (directed) {
			c = c / 3;
		} else {
			c = c / 6;
		}

		System.out.println(c);

	}

}
