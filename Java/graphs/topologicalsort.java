package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import graphs.makegraph.Graph;

public class topologicalsort {

	public static void topsort(HashMap<String, HashMap<String, Integer>> vtces) {

		HashMap<String, Boolean> map = new HashMap<>();
		LinkedList<String> st = new LinkedList<>();
		ArrayList<String> nbrlist = new ArrayList<String>(vtces.keySet());
		for (String string : nbrlist) {
			if (!map.containsKey(string)) {
				dfs(map, string, vtces, st);
			}
		}

		int[] ans = new int[st.size()];
		int j = 0;
		while (st.size() > 0) {
			ans[j++] = Integer.parseInt(st.removeFirst());
		}
//		return ans;
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	public static void dfs(HashMap<String, Boolean> map, String src, HashMap<String, HashMap<String, Integer>> vtces,
			LinkedList<String> st) {

		if (map.containsKey(src)) {
			return;
		}
		map.put(src, true);
		HashMap<String, Integer> nbr = vtces.get(src);
		ArrayList<String> nbrlist = new ArrayList<String>(nbr.keySet());
		for (String string : nbrlist) {
			if (!map.containsKey(string)) {
				dfs(map, string, vtces, st);
			}
		}

		st.addFirst(src);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
//		graph.addvertex("0");
//		graph.addvertex("1");
//		graph.addvertex("2");
//		graph.addvertex("3");
		graph.addvertex("4");
		graph.addvertex("5");
		graph.addvertex("6");

//		graph.addedge("0", "3", 1);
//		graph.addedge("0", "1", 1);
//		graph.addedge("3", "2", 1);
//		graph.addedge("2", "1", 1);

		graph.addedge("4", "5", 1);
		graph.addedge("5", "6", 1);
		graph.addedge("6", "4", 1);
//		graph.addedge("4", "6", 10);

		graph.diplay();

		topsort(graph.vtces);
	}

}
