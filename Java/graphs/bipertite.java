package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import graphs.makegraph.Graph;

public class bipertite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
//		graph.addvertex("3");
//		graph.addvertex("4");

		graph.addedge("0", "1", 1);
		graph.addedge("0", "2", 1);
//		graph.addedge("2", "1", 1);
//		graph.addedge("2", "3", 1);
//		graph.addedge("4", "3", 1);
//		graph.addedge("4", "1", 1);
//		graph.addedge("4", "0", 1);
		System.out.println(bipertite(graph.vtces));

	}

	public static class pair {
		String vname;
		int color;

		pair(String v, int col) {
			this.vname = v;
			this.color = col;
		}
	}

	public static boolean bipertite(HashMap<String, HashMap<String, Integer>> vtces) {

		LinkedList<pair> queue = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();

		ArrayList<String> vnamelist = new ArrayList<String>(vtces.keySet());
		for (String string : vnamelist) {
			if (!map.containsKey(string)) {

				queue.addFirst(new pair(string, 1));
				while (!queue.isEmpty()) {
					pair rv = queue.removeFirst();

					// cycle
					if (map.containsKey(rv.vname)) {
						int oc = map.get(rv.vname);
						int nc = rv.color;
						if (oc != nc) {
							return false;
						}
						continue;
					}

					map.put(rv.vname, rv.color);

					HashMap<String, Integer> nbr = vtces.get(rv.vname);
					ArrayList<String> nbrvnamelist = new ArrayList<String>(nbr.keySet());
					for (String string2 : nbrvnamelist) {
						int nc = 1;
						if (rv.color == 1) {
							nc = 2;
						}
						if (!map.containsKey(string2)) {
							queue.addLast(new pair(string2, nc));
						}
					}

				}

			}
		}

		return true;
	}

}
