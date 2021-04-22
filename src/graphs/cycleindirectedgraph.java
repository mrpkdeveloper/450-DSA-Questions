package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import graphs.makegraph.Graph;

public class cycleindirectedgraph {

	private static boolean isCyclicUtil(HashMap<String, HashMap<String, Integer>> vtces, String vname,
			boolean[] visited, boolean[] recStack) {

		// Mark the current node as visited and
		// part of recursion stack
		int i = Integer.parseInt(vname);
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;
		recStack[i] = true;
		
		HashMap<String, Integer> nbrv = vtces.get(vname);
		ArrayList<String> nbrsvlist = new ArrayList<>(nbrv.keySet());

		for (String c : nbrsvlist)
			if (isCyclicUtil(vtces, c, visited, recStack))
				return true;

		recStack[i] = false;

		return false;
	}

	public static boolean DFT(HashMap<String, HashMap<String, Integer>> vtces) {
		boolean[] visited = new boolean[vtces.size()];
		boolean[] recStack = new boolean[vtces.size()];
		ArrayList<String> nbrs = new ArrayList<>(vtces.keySet());
		for (String string : nbrs) {
			if (isCyclicUtil(vtces, string, visited, recStack)) {
				return true;
			}
		}
		return false;
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
//		graph.addvertex("7");
//		graph.addvertex("8");

		graph.addedge("0", "3", 1);
		graph.addedge("0", "1", 1);
		graph.addedge("3", "2", 1);
		graph.addedge("2", "1", 1);

		graph.addedge("4", "5", 1);
		graph.addedge("5", "6", 1);
		graph.addedge("6", "4", 1);
//		graph.addedge("3", "5", 1);
//		graph.addedge("4", "7", 1);
//		graph.addedge("5", "7", 1);

		graph.diplay();
//		graph.bfs("A", "E");
		System.out.println(DFT(graph.vtces));

	}

}
