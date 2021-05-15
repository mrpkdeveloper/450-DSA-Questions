package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import graphs.makegraph.Graph;

public class prims {

	public static class pair implements Comparable<pair> {
		String vname;
		String pathvtc;
		int wt;

		pair(String v, String p, int w) {
			this.pathvtc = p;
			this.vname = v;
			this.wt = w;
		}

		@Override
		public int compareTo(pair o) {
			return this.wt - o.wt;
		}
	}

	public static void prims(HashMap<String, HashMap<String, Integer>> vtces) {

		PriorityQueue<pair> queue = new PriorityQueue<>();
		HashMap<String, Boolean> map = new HashMap<>();

		ArrayList<String> vtceslist = new ArrayList<>(vtces.keySet());
		for (String string : vtceslist) {
			if (!map.containsKey(string)) {
				bft(vtces, string, map, queue);
			}
		}

	}

	private static void bft(HashMap<String, HashMap<String, Integer>> vtces, String src, HashMap<String, Boolean> map,
			PriorityQueue<pair> queue) {
		queue.add(new pair(src, "-1", 0));
		while (!queue.isEmpty()) {
			pair rv = queue.remove();
			if (map.containsKey(rv.vname)) {
				continue;
			}
			map.put(rv.vname, true);

			System.out.println(rv.vname + " via " + rv.pathvtc + " @ " + rv.wt);

			HashMap<String, Integer> nbr = vtces.get(rv.vname);
			for (String nbvtc : nbr.keySet()) {
				if (!map.containsKey(nbvtc)) {
					queue.add(new pair(nbvtc, rv.vname, nbr.get(nbvtc)));
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// this is undirected graph (changes done in make graph)
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

		prims(graph.vtces);

	}

}
