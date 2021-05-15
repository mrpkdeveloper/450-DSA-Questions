package graphs;

public class floydwarshall {

	// floyad warshall -> shortest path from each vertex to other vertex
	// O(V^3) uses dp
	public static void floydwarshall() {
		int[][] graph = { { 0, 3, 10000, 7 }, { 8, 0, 2, 10000 }, { 10000, 10000, 0, 1 }, { 2, 10000, 10000, 0 } };
		int V = 4; // 4 vertex
		int[][] dist = new int[V][V];
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[0].length; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					int oc = dist[i][j];
					int nc = dist[i][k] + dist[k][j];
					if (nc < oc) {
						dist[i][j] = nc;
					}
				}
			}
		}

		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		floydwarshall();
	}

}
