package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class wiredconnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		System.out.println(connections(connections, 6));

	}

	public static int connections(int[][] connections, int n) {
		if (connections.length < n - 1) {
			return -1;
		}

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// graph made
		// adding vertex
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		// adding edges
		for (int i = 0; i < connections.length; i++) {
			int vname1 = connections[i][0];
			int vname2 = connections[i][1];

			ArrayList<Integer> nbr1 = graph.get(vname1);
			nbr1.add(connections[i][1]);

			ArrayList<Integer> nbr2 = graph.get(vname2);
			nbr2.add(connections[i][0]);

		}
//		System.out.println(graph);
		int countcomponents = 0;
		int[] map = new int[n];
		for (int i = 0; i < n; i++) {
			if (map[i] == 0) {
				countcomponents++;
				dfs(i, graph, map);
			}
		}

		return (countcomponents - 1);

	}

	public static void dfs(int src, ArrayList<ArrayList<Integer>> graph, int[] map) {
		if (map[src] == 1) {
			return;
		}
		map[src] = 1;
		ArrayList<Integer> nbr = graph.get(src);
		for (Integer integer : nbr) {
			if (map[integer] == 0) {
				dfs(integer, graph, map);
			}
		}
	}

}