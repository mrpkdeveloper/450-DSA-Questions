package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class makegraph {

	public static class Graph {

		HashMap<String, HashMap<String, Integer>> vtces;
//		HashMap<String, Integer> nbr = new HashMap<>();

		Graph() {
			vtces = new HashMap<>();
		}

		public void addvertex(String vname) {
			HashMap<String, Integer> nbr = new HashMap<>();
			vtces.put(vname, nbr);
		}

		public void removevertex(String vname) {
			// remove all edges
			vtces.remove(vname);
		}

		// directed graph
		public void addedge(String vname1, String vname2, int cost) {
			HashMap<String, Integer> nbr1 = vtces.get(vname1);
			HashMap<String, Integer> nbr2 = vtces.get(vname2);
			if (nbr1 == null || nbr2 == null || nbr1.containsKey(vname2)) {
				System.out.println("vertex not present or edge alrady present");
				return;
			}
			nbr1.put(vname2, cost);
			// now become undirected
//			nbr2.put(vname1, cost);
		}

		public boolean containsedge(String v1, String v2) {
			if (vtces.containsKey(v1) && vtces.containsKey(v2)) {
				HashMap<String, Integer> nbr = vtces.get(v1);
				if (nbr == null) {
					return false;
				} else
					return nbr.containsKey(v2);
			}
			return false;
		}

		public void diplay() {
			ArrayList<String> vertex = new ArrayList<>(vtces.keySet());
			System.out.println("--------------------------------");
			for (String string : vertex) {
				HashMap<String, Integer> nbr = vtces.get(string);
				System.out.println(string + " : " + nbr);
			}
			System.out.println("--------------------------------");
		}

		// sssp
		public class pair {
			String vname;
			String path;

			pair(String name, String path) {
				this.vname = name;
				this.path = path;
			}
		}

		public void bfs(String src, String dest) {

			LinkedList<pair> queue = new LinkedList<>();
			String path = "";
			HashMap<String, Boolean> map = new HashMap<>();
			queue.addLast(new pair(src, path + src));
			while (!queue.isEmpty()) {
				// remove vertex and to add to map
				pair rv = queue.removeFirst();
				if (map.containsKey(rv.vname)) {
					continue;
				}
				map.put(rv.vname, true);

				// work
				// 2 if direct edge present then return true
				if (containsedge(rv.vname, dest)) {
					System.out.println(rv.path + dest);
					break;
				}

				// add nbrs
				ArrayList<String> nbr = new ArrayList<String>(vtces.get(rv.vname).keySet());
				for (String string : nbr) {
					queue.addLast(new pair(string, rv.path + string));
				}

			}

		}

		public void BFT() {

			LinkedList<pair> queue = new LinkedList<>();
			ArrayList<String> keys = new ArrayList<String>(vtces.keySet());
			HashMap<String, Boolean> map = new HashMap<>();
			for (String string : keys) {
				if (map.containsKey(string)) {
					continue;
				}

				String path = "";
				queue.addLast(new pair(string, path + string));
				while (!queue.isEmpty()) {
					// 1 remove pair and to map
					pair rv = queue.removeFirst();
					String vname = rv.vname;

					if (map.containsKey(vname)) {
						continue;
					}

					map.put(vname, true);

					// 2 if direct edge present then return true
					System.out.println(vname + " via " + rv.path);

					// 3 add nbrs to queue
					HashMap<String, Integer> nbr = vtces.get(vname);
					ArrayList<String> keys1 = new ArrayList<>(nbr.keySet());
					for (String string1 : keys1) {
						if (!map.containsKey(string1)) {
							queue.addLast(new pair(string1, rv.path + string1));
						}
					}
				}

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		9 9
//		0 2
//		0 5
//		1 5
//		1 6
//		1 8
//		3 4
//		3 5
//		4 7
//		5 7

		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");
		graph.addvertex("4");
		graph.addvertex("5");
		graph.addvertex("6");
		graph.addvertex("7");
		graph.addvertex("8");

		graph.addedge("0", "2", 1);
		graph.addedge("0", "5", 1);
		graph.addedge("1", "5", 1);
		graph.addedge("1", "6", 1);
		graph.addedge("1", "8", 1);
		graph.addedge("3", "4", 1);
		graph.addedge("3", "5", 1);
		graph.addedge("4", "7", 1);
		graph.addedge("5", "7", 1);

		graph.diplay();
//		graph.bfs("A", "E");
		System.out.println();
		graph.BFT();

	}

}
