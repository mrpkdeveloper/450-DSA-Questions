package graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class journeytomoon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		0 1
//		2 3
//		0 4

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		b.add(2);
		b.add(3);
		c.add(0);
		c.add(4);
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		System.out.println(journeyToMoon(5, list));

	}

	public static int journeyToMoon(int n, ArrayList<ArrayList<Integer>> list) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> nbr = new ArrayList<>();
			adj.add(nbr);
		}

		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> edge = list.get(i);
//			System.out.println(edge);
			int u = edge.get(0);
			int v = edge.get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		System.out.println();

//		for (int i = 0; i < adj.size(); i++) {
//			System.out.println(adj.get(i));
//		}

		HashSet<Integer> map = new HashSet<>();
		ArrayList<Integer> componentsize = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!map.contains(i)) {
				int c = 0;
				int a = dfs(adj, map, i, c);
				componentsize.add(a);
			}
		}

		System.out.println(componentsize);
		int totalpairs = (n * (n - 1)) / 2;
		for (int i = 0; i < componentsize.size(); i++) {
			int x = componentsize.get(i);
			totalpairs = totalpairs - (x * (x - 1)) / 2;
		}
		return totalpairs;
	}

	public static int dfs(ArrayList<ArrayList<Integer>> list, HashSet<Integer> map, int src, int c) {
//		if (map.contains(src)) {
//			return 0;
//		}
		map.add(src);
		ArrayList<Integer> nbr = list.get(src);
		System.out.println(nbr);
		int c = 1;
		for (int i = 0; i < list.size(); i++) {
			if (!map.contains(i)) {
				c += dfs(list, map, i);
			}
		}
		return c;
	}
}
