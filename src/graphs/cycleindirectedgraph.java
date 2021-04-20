package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import graphs.makegraph.Graph;

public class cycleindirectedgraph {

	public static class pair {
		String vname;
		String path;

		pair(String name, String path) {
			this.vname = name;
			this.path = path;
		}
	}

	public static void DFT(HashMap<String, HashMap<String, Integer>> vtces) {
		HashMap<String, Boolean> map = new HashMap<>();
		LinkedList<pair> stack = new LinkedList<>();
		int[] order = new int[vtces.size()];
		ArrayList<String> nbrs = new ArrayList<>(vtces.keySet());
		for (String string : nbrs) {
			if (map.containsKey(string)) {
				continue;
			}
			String path = "";
			stack.addFirst(new pair(string, path + string));
			order[Integer.parseInt(string)] = 1;
			while (!stack.isEmpty()) {
				pair rv = stack.removeFirst();
				order[Integer.parseInt(rv.vname)] = 0;
				if (map.containsKey(rv.vname)) {
					System.out.println("cycle present2");
					continue;
				}

				if (order[Integer.parseInt(rv.vname)] == 1) {
					System.out.println("cycle");
				}

				map.put(rv.vname, true);

//				System.out.println(map);

				System.out.println(rv.vname + " via " + rv.path);

				HashMap<String, Integer> nbrv = vtces.get(rv.vname);
				ArrayList<String> nbrsvlist = new ArrayList<>(nbrv.keySet());
				for (String string1 : nbrsvlist) {
//					if (!map.containsKey(string1)) {
					stack.addFirst(new pair(string1, rv.path + string1));
					order[Integer.parseInt(rv.vname)] = 1;
//					}
				}

				order[Integer.parseInt(rv.vname)] = 0;

			}

		}

		for (int i = 0; i < order.length; i++) {
			System.out.println(order[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");
//		graph.addvertex("4");
//		graph.addvertex("5");
//		graph.addvertex("6");
//		graph.addvertex("7");
//		graph.addvertex("8");

		graph.addedge("0", "3", 1);
		graph.addedge("1", "0", 1);
		graph.addedge("3", "2", 1);
		graph.addedge("2", "1", 1);
//		graph.addedge("2", "4", 1);
//		graph.addedge("4", "0", 1);
//		graph.addedge("3", "4", 1);
//		graph.addedge("3", "5", 1);
//		graph.addedge("4", "7", 1);
//		graph.addedge("5", "7", 1);

		graph.diplay();
//		graph.bfs("A", "E");
		System.out.println();
		DFT(graph.vtces);
	}

}
