package graphs;

import java.util.ArrayList;
import java.util.HashMap;

import graphs.makegraph.Graph;

public class travellingsalesman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] adj = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };
		HashMap<String, Boolean> map = new HashMap<>();
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");

		graph.addedge("0", "1", 20);
		graph.addedge("0", "2", 42);
		graph.addedge("0", "3", 25);

		graph.addedge("1", "0", 20);
		graph.addedge("1", "2", 30);
		graph.addedge("1", "3", 34);

		graph.addedge("2", "0", 42);
		graph.addedge("2", "1", 30);
		graph.addedge("2", "3", 10);

		graph.addedge("3", "0", 25);
		graph.addedge("3", "1", 34);
		graph.addedge("3", "2", 10);

		graph.diplay();
		hc(graph.vtces, map, "0", "0", "0", 0);

	}

	public static void hc(HashMap<String, HashMap<String, Integer>> vtces, HashMap<String, Boolean> map, String src,
			String psf, String osrc, int wt) {
//		System.out.println("hello");
		if (map.size() == vtces.size() - 1) {
			HashMap<String, Integer> nbr = vtces.get(src);
			ArrayList<String> nbrlist = new ArrayList<String>(nbr.keySet());
			boolean flag = false;
			for (String string : nbrlist) {
				if (string == osrc) {
					flag = true;
					break;
				}
			}
			System.out.print(psf);
			if (flag) {
				System.out.println(" * @" + (wt + nbr.get(osrc)));
			} else {
				System.out.println(".");
			}

			return;
		}

		map.put(src, true);
		HashMap<String, Integer> nbr = vtces.get(src);
		ArrayList<String> nbrlist = new ArrayList<String>(nbr.keySet());
		for (String string : nbrlist) {
			if (!map.containsKey(string)) {
				hc(vtces, map, string, psf + string, osrc, wt + nbr.get(string));
			}
		}
		map.remove(src);

	}

	// for tsp - > we have to find min hamiltonian cycle

}
