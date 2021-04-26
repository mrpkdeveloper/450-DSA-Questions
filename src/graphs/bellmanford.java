package graphs;

import java.util.ArrayList;
import java.util.HashMap;

import graphs.makegraph.Graph;

public class bellmanford {

	public static class edgepair {
		String v1;
		String v2;
		int cost;

		edgepair(String v1, String v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
	}

	public static ArrayList<edgepair> alledges(HashMap<String, HashMap<String, Integer>> vtces) {

		ArrayList<edgepair> ans = new ArrayList<>();
		for (String v : vtces.keySet()) {
			HashMap<String, Integer> nbr = vtces.get(v);
			for (String nbrv : nbr.keySet()) {
				ans.add(new edgepair(v, nbrv, nbr.get(nbrv)));
			}
		}
		return ans;
	}

	public static void bellmanford(HashMap<String, HashMap<String, Integer>> vtces, String src) {
		ArrayList<edgepair> edges = alledges(vtces);
		HashMap<String, Integer> map = new HashMap<>();

		// fill map with every vname and max value
		for (String vname : vtces.keySet()) {
			// not putting max value as we will add and that can go beyound range
			map.put(vname, 1000000);
			if (vname == src) {
				map.put(vname, 0);
			}
		}

		// now relax every vertex
		int V = vtces.size();
		for (int i = 1; i <= V; i++) {
			for (edgepair e : edges) {
				int oc = map.get(e.v2);
				int nc = map.get(e.v1) + e.cost;
				if (oc > nc) {
					if (i <= V - 1)
						map.put(e.v2, nc);
					else
						System.out.println("-ve weight cycle present");
				}
			}
		}

		System.out.println(map);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("a");
		graph.addvertex("b");
		graph.addvertex("c");
		graph.addvertex("d");
		graph.addvertex("e");

		graph.addedge("a", "b", 8);
		graph.addedge("a", "c", 4);
		graph.addedge("a", "d", 5);
		graph.addedge("c", "d", -3);
		graph.addedge("d", "e", 4);
		graph.addedge("b", "e", 2);
		graph.addedge("e", "b", 1);

		graph.diplay();

		bellmanford(graph.vtces, "a");
	}

}
