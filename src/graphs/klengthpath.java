package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import graphs.makegraph.Graph;

public class klengthpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");
		graph.addvertex("4");
		graph.addvertex("5");
		graph.addvertex("6");

		graph.addedge("0", "1", 10);
		graph.addedge("1", "2", 10);
		graph.addedge("3", "0", 25);
		graph.addedge("2", "3", 10);

		graph.addedge("4", "3", 2);
		graph.addedge("5", "4", 3);
		graph.addedge("6", "4", 8);
		graph.addedge("5", "6", 3);

		graph.diplay();
		HashSet<String> map = new HashSet<>();
		System.out.println(dfs(graph.vtces, "0", map, 100));

	}

	public static boolean dfs(HashMap<String, HashMap<String, Integer>> adj, String src, HashSet<String> map, int k) {

		if (k <= 0) {
			return true;
		}
		map.add(src);
		HashMap<String, Integer> nbr = adj.get(src);
		ArrayList<String> nbrlist = new ArrayList<>(nbr.keySet());
		for (String i : nbrlist) {
			int wtnbr = nbr.get(i);
			if (wtnbr > k) {
				return true;
			}

			if (!map.contains(i))
				if (dfs(adj, i, map, k - wtnbr)) {
					return true;
				}
		}
		map.remove(src);

		return false;

	}

}
