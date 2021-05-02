package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import graphs.makegraph.Graph;

public class eulariancircuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addvertex("0");
		graph.addvertex("1");
		graph.addvertex("2");
		graph.addvertex("3");
		graph.addvertex("4");

//		graph.addvertex("5");
//		graph.addvertex("6");

		graph.addedge("0", "1", 1);
		graph.addedge("0", "2", 1);
		graph.addedge("1", "2", 1);
		graph.addedge("2", "3", 1);
		graph.addedge("2", "4", 1);
		graph.addedge("3", "4", 1);

//		graph.addedge("5", "6", 1);

		int a = euler(graph.vtces);
		if (a == 0) {
			System.out.println("NO ");
		} else if (a == 1) {
			System.out.println("Euler ckt");
		} else {
			System.out.println("Semi euler");
		}
	}

	public static int euler(HashMap<String, HashMap<String, Integer>> vtces) {
		// check for connected components
		if (!checkcomponents(vtces)) {
			return 0;
		}

		// now check for no of odd degree vtc
//		if(0)-> euler ckt 
//		if(2) - > semi euler
		// else-> no
		int odd = 0;
		ArrayList<String> vlist = new ArrayList<>(vtces.keySet());
		for (String string : vlist) {
			HashMap<String, Integer> nbr = vtces.get(string);
			if (nbr.size() % 2 != 0) {
				odd++;
			}
		}

		if (odd > 2) {
			return 0;
		} else if (odd == 0) {
			return 1;
		} else {
			return 2;
		}
	}

	private static boolean checkcomponents(HashMap<String, HashMap<String, Integer>> vtces) {

		ArrayList<String> vlist = new ArrayList<>(vtces.keySet());
		// find vtc with degree greter than 0
		String start = "";
		for (String string : vlist) {
			HashMap<String, Integer> nbr = vtces.get(string);
			if (nbr.size() > 0) {
				start = string;
				break;
			}
		}
		// all components disconnected
		if (start == "") {
			return true;
		}

		HashSet<String> map = new HashSet<>();
		dfs(vtces, map, start);
		// Checking after dfs if any other edge left or not
		for (String string : vlist) {
			if (!map.contains(string)) {
				HashMap<String, Integer> nbr = vtces.get(string);
				if (nbr.size() > 0) {
					return false;
				}
			}
		}

		return true;
	}

	private static void dfs(HashMap<String, HashMap<String, Integer>> vtces, HashSet<String> map, String start) {
		map.add(start);
		HashMap<String, Integer> nbr = vtces.get(start);
		for (String string : nbr.keySet()) {
			if (!map.contains(string))
				dfs(vtces, map, string);
		}
	}

}
