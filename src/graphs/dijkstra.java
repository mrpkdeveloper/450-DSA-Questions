package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import graphs.makegraph.Graph;

public class dijkstra {

	public static class pair implements Comparable<pair> {
		String vname;
		String path;
		int wt;

		pair(String vname, String path, int w) {
			this.vname = vname;
			this.path = path;
			this.wt = w;
		}

		@Override
		public int compareTo(pair o) {
			return this.wt - o.wt;
		}
	}

	public static void dijkstra(HashMap<String, HashMap<String, Integer>> vtces) {
		PriorityQueue<pair> queue = new PriorityQueue<>();
		HashMap<String, Boolean> map = new HashMap<>();
		ArrayList<String> vlist = new ArrayList<>(vtces.keySet());
		for (String string : vlist) {
			if (map.containsKey(string)) {
				continue;
			}
			queue.add(new pair(string, string, 0));
			while (!queue.isEmpty()) {
				pair rv = queue.remove();
				if (map.containsKey(rv.vname)) {
					continue;
				}
				map.put(rv.vname, true);

				System.out.println(rv.vname + " via " + rv.path + " @ " + rv.wt);
				HashMap<String, Integer> nbr = vtces.get(rv.vname);
				ArrayList<String> nbrlist = new ArrayList<String>(nbr.keySet());
				for (String string2 : nbrlist) {
					if (!map.containsKey(string2)) {
						queue.add(new pair(string2, rv.path + string2, rv.wt + nbr.get(string2)));
					}
				}
			}
		}

	}

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
		dijkstra(graph.vtces);

	}

}
