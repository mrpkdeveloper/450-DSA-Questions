package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import graphs.makegraph.Graph;

public class dfsdft {

	public static class pair {
		String vname;
		String path;

		pair(String name, String path) {
			this.vname = name;
			this.path = path;
		}
	}

	public static void DFT(HashMap<String, HashMap<String, Integer>> vtces) {
		LinkedList<pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<String>(vtces.keySet());
		HashMap<String, Boolean> map = new HashMap<>();
		for (String string : keys) {
			if (map.containsKey(string)) {
				continue;
			}

			String path = "";
			stack.addFirst(new pair(string, path + string));
			while (!stack.isEmpty()) {
				// 1 remove pair and to map
				pair rv = stack.removeFirst();
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
						stack.addFirst(new pair(string1, rv.path + string1));
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
		DFT(graph.vtces);
	}

}
