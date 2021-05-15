package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import graphs.makegraph.Graph;

public class mintimebyjob {

	public static void topsort(HashMap<String, HashMap<String, Integer>> vtces) {

		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> nbrlist = new ArrayList<String>(vtces.keySet());
		for (String string : nbrlist) {
			if (!map.containsKey(string)) {
				dfs(map, string, vtces, 1);
			}
		}
// ans store in map
		System.out.println(map);

	}

	public static void dfs(HashMap<String, Integer> map, String src, HashMap<String, HashMap<String, Integer>> vtces,
			int t) {

		if (map.containsKey(src)) {
			if (t < map.get(src)) {
				return;
			}
		}
		map.put(src, t);
		HashMap<String, Integer> nbr = vtces.get(src);
		ArrayList<String> nbrlist = new ArrayList<String>(nbr.keySet());
		for (String string : nbrlist) {
			if (!map.containsKey(string) || t + 1 > map.get(string)) {
				dfs(map, string, vtces, t + 1);
			}
		}

//		st.addFirst(src);
//		st.addFirst(t + "");

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

		graph.addedge("0", "1", 1);
		graph.addedge("0", "2", 1);
		graph.addedge("0", "3", 1);
//		graph.addedge("2", "1", 1);

		graph.addedge("2", "4", 1);
		graph.addedge("4", "5", 1);

		graph.addedge("6", "7", 1);
		graph.addedge("7", "2", 10);

		graph.diplay();

		topsort(graph.vtces);
	}

}
