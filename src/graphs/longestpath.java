package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import graphs.makegraph.Graph;

public class longestpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");
		graph.addvertex("4");
		graph.addvertex("5");
//		graph.addvertex("6");

//		graph.addedge("0", "3", 1);
//		graph.addedge("0", "1", 1);
//		graph.addedge("3", "2", 1);
//		graph.addedge("2", "1", 1);

//		graph.addedge("0", "1", 1);
//		graph.addedge("1", "2", 10);
//		graph.addedge("2", "0", 20);
//		graph.addedge("4", "6", 10);

		graph.addedge("0", "1", 5);
		graph.addedge("0", "2", 3);
		graph.addedge("1", "3", 6);
		graph.addedge("1", "2", 2);
		graph.addedge("2", "4", 4);
		graph.addedge("2", "5", 2);
		graph.addedge("2", "3", 7);
		graph.addedge("3", "5", 1);
		graph.addedge("3", "4", -1);
		graph.addedge("4", "5", -2);

		graph.diplay();

//		topsort(graph.vtces);
		longetspath(graph.vtces, "1");

	}

	public static void longetspath(HashMap<String, HashMap<String, Integer>> vtces, String src) {

		LinkedList<String> st = new LinkedList<String>();
		topsort(vtces, st);

		int[] dist = new int[vtces.size()];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MIN_VALUE;
		}
		dist[Integer.parseInt(src)] = 0;

		while (!st.isEmpty()) {
			String vname = st.removeFirst();
			if (dist[Integer.parseInt(vname)] != Integer.MIN_VALUE) {
				HashMap<String, Integer> nbrs = vtces.get(vname);
				ArrayList<String> nbrname = new ArrayList<String>(nbrs.keySet());
				for (String string : nbrname) {
					if (dist[Integer.parseInt(string)] < dist[Integer.parseInt(vname)] + nbrs.get(string)) {
						dist[Integer.parseInt(string)] = dist[Integer.parseInt(vname)] + nbrs.get(string);
					}
				}

			}
		}

		for (int i = 0; i < dist.length; i++) {
			System.out.println(dist[i]);
		}

	}

	public static void topsort(HashMap<String, HashMap<String, Integer>> vtces, LinkedList<String> st) {

		HashSet<String> map = new HashSet<String>();
		ArrayList<String> vname = new ArrayList<>(vtces.keySet());

		for (String string : vname) {
			if (!map.contains(string)) {
				dfs(map, st, string, vtces);
			}
		}

	}

	private static void dfs(HashSet<String> map, LinkedList<String> st, String src,
			HashMap<String, HashMap<String, Integer>> vtces) {

		map.add(src);

		ArrayList<String> nbrs = new ArrayList<>(vtces.get(src).keySet());
		for (String string : nbrs) {
			if (!map.contains(string)) {
				dfs(map, st, string, vtces);
			}
		}

		st.addFirst(src);

	}

}
