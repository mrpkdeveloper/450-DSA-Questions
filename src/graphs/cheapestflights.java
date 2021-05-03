package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class cheapestflights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		3
//		[[0,1,2],[1,2,1],[2,0,10]]
//		1
//		2
//		1

//		output = 1;

//		5
//		[[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
//		0
//		2
//		2

//		output= 7

//5
//[[1,2,10],[2,0,7],[1,3,8],[4,0,10],[3,4,2],[4,2,10],[0,3,3],[3,1,6],[2,4,5]]
//0
//4
//1		

//3
//[[0,1,100],[1,2,100],[0,2,500]]
//0
//2
//0

		int n = 5, src = 0, dst = 2, k = 1;
		int[][] edges = { { 0, 3, 2 }, { 0, 1, 5 }, { 3, 1, 2 }, { 1, 2, 5 }, { 1, 4, 1 }, { 4, 2, 1 } };
//		int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		cf(n, edges, src, dst, k);

	}

	public static void cf(int n, int[][] flights, int src, int dst, int k) {

		HashMap<Integer, HashMap<Integer, Integer>> adj = new HashMap<>();
		for (int i = 0; i < n; i++) {
			HashMap<Integer, Integer> nbr = new HashMap<>();
			adj.put(i, nbr);
		}
		for (int i = 0; i < flights.length; i++) {
			int u = flights[i][0];
			int v = flights[i][1];
			int c = flights[i][2];
			HashMap<Integer, Integer> nbr = adj.get(u);
			nbr.put(v, c);
		}
		int min = Integer.MAX_VALUE;
		System.out.println(bfs(adj, src, dst, k, min));
		HashSet<Integer> map = new HashSet<>();
//		int ans = allpath(adj, src, dst, map, "" + src, 0, k, 0);
//		if (ans == Integer.MAX_VALUE)
//			System.out.println(-1);
//		else {
//			System.out.println(ans);
//		}

	}

	public static class pair implements Comparable<pair> {
		int vname;
		int cost;
		String path;
		int stop;

		pair(int v, int c, String s, int st) {
			this.vname = v;
			this.cost = c;
			this.path = s;
			this.stop = st;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	// optimised dijkstra - this is best and optimised solution
	public static int bfs(HashMap<Integer, HashMap<Integer, Integer>> adj, int src, int dest, int k, int min) {
		int[] costs = new int[adj.size()];
		int[] stops = new int[adj.size()];
		Arrays.fill(costs, Integer.MAX_VALUE);
		Arrays.fill(stops, Integer.MAX_VALUE);
		costs[src] = 0;
		stops[src] = 0;
		PriorityQueue<pair> queue = new PriorityQueue<>();
		queue.add(new pair(src, 0, src + "", 0));
		while (!queue.isEmpty()) {
			pair rv = queue.remove();
			if (rv.vname == dest) {
				System.out.println(rv.path + "   @ " + rv.cost);
				return rv.cost;
			}
			if (rv.stop > k) {
				continue;
			}
			HashMap<Integer, Integer> nbr = adj.get(rv.vname);
			ArrayList<Integer> nbrlist = new ArrayList<Integer>(nbr.keySet());
			for (Integer i : nbrlist) {
				// better cost or better steps
				if (rv.cost + nbr.get(i) < costs[i]) {
					queue.add(new pair(i, rv.cost + nbr.get(i), rv.path + i, rv.stop + 1));
					costs[i] = rv.cost + nbr.get(i);
					stops[i] = rv.stop;
				} else if (rv.stop < stops[i]) {
					queue.add(new pair(i, rv.cost + nbr.get(i), rv.path + i, rv.stop + 1));
				}

			}
		}
		return -1;

	}

	// brute force
	public static int allpath(HashMap<Integer, HashMap<Integer, Integer>> adj, int src, int dest, HashSet<Integer> map,
			String path, int cost, int k, int stop) {

		if (src == dest) {
			if (stop <= k + 1) {
//				System.out.println(path + " @ " + cost);
				return cost;
			}
			return Integer.MAX_VALUE;
		}

		map.add(src);
		int myans = Integer.MAX_VALUE;
		HashMap<Integer, Integer> nbr = adj.get(src);
		ArrayList<Integer> nbrlist = new ArrayList<Integer>(nbr.keySet());
		for (Integer i : nbrlist) {
			if (!map.contains(i)) {
				int a = allpath(adj, i, dest, map, path + i, cost + nbr.get(i), k, stop + 1);
				if (myans > a) {
					myans = a;
				}
			}
		}

		map.remove(src);
		return myans;
	}

}
