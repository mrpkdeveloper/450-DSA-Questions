package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class journeytomoon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		10 7
//		0 2
//		1 8
//		1 4
//		2 8
//		2 6
//		3 5
//		6 9

// test case 2		
//		100000 2
//		1 2
//		3 4		

//		output
//		4999949998

		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		int p = scn.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		while (p > 0) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			int u = scn.nextInt();
			int v = scn.nextInt();
			a.add(u);
			a.add(v);
			list.add(a);
			p--;
		}

		System.out.println(journeyToMoon(n, list));

	}

//	public static int c = 0;

	public static long journeyToMoon(long n, ArrayList<ArrayList<Integer>> list) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> nbr = new ArrayList<>();
			adj.add(nbr);
		}

		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> edge = list.get(i);
			int u = edge.get(0);
			int v = edge.get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		HashSet<Integer> map = new HashSet<>();
		ArrayList<Integer> componentsize = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!map.contains(i)) {
				int c = 0;
				c = dfs(adj, map, i);
				componentsize.add(c);
			}
		}

//		System.out.println(componentsize);

		long totalpairs = ((n * (n - 1)) / 2);
		System.out.println(totalpairs);
		for (int i = 0; i < componentsize.size(); i++) {
			long x = componentsize.get(i);
			totalpairs = totalpairs - (x * (x - 1)) / 2;
		}
		return totalpairs;
	}

//	public static void dfs(ArrayList<ArrayList<Integer>> list, HashSet<Integer> map, int src) {
//		if (map.contains(src)) {
//			return;
//		}
//		map.add(src);
//		c = c + 1;
//		ArrayList<Integer> nbr = list.get(src);
//		for (int i = 0; i < nbr.size(); i++) {
//			int a = nbr.get(i);
//			if (!map.contains(a)) {
////				System.out.println(i);
//				dfs(list, map, a);
//			}
//		}
//	}

	public static int dfs(ArrayList<ArrayList<Integer>> list, HashSet<Integer> map, int src) {
		if (map.contains(src)) {
			return 0;
		}
		map.add(src);
		ArrayList<Integer> nbr = list.get(src);
		int c = 1;
		for (int i = 0; i < nbr.size(); i++) {
			int a = nbr.get(i);
			if (!map.contains(a)) {
				c += dfs(list, map, a);
			}
		}
		return c;
	}
}
