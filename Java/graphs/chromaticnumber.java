package graphs;

import java.util.ArrayList;
import java.util.HashMap;

import graphs.makegraph.Graph;

public class chromaticnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");
		graph.addvertex("4");

		graph.addedge("0", "1", 1);
		graph.addedge("0", "3", 1);
		graph.addedge("2", "1", 1);
		graph.addedge("2", "3", 1);
		graph.addedge("4", "3", 1);
		graph.addedge("4", "1", 1);
		graph.addedge("4", "0", 1);

		graph.diplay();
		cn(graph.vtces);

	}

	// o(n2) this is greedy approach , also not always give min no of colors
	public static void cn(HashMap<String, HashMap<String, Integer>> vtces) {
		int[] vtcescolor = new int[vtces.size()];

		vtcescolor[0] = 0;
		for (int i = 1; i < vtcescolor.length; i++) {
			vtcescolor[i] = -1;
		}
		int cn = 0;

		for (int i = 1; i < vtces.size(); i++) {
			boolean[] colornotavail = new boolean[vtces.size()];
			HashMap<String, Integer> nbr = vtces.get(i + "");
			ArrayList<String> nbrv = new ArrayList<>(nbr.keySet());

			for (String s : nbrv) {
				int n = Integer.parseInt(s);
				if (vtcescolor[n] > -1) {
					colornotavail[n] = true;
				}
			}

			for (int j = 0; j < colornotavail.length; j++) {
				if (colornotavail[j] == false) {
					vtcescolor[i] = j;
					cn = Math.max(cn, j + 1);
					break;
				}
			}

		}

		for (int i = 0; i < vtcescolor.length; i++) {
			System.out.println(vtcescolor[i]);
		}

		System.out.println("cn-----" + cn);

	}

}
