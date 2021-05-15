package graphs;

import java.util.*;

public class mcoluringproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//failed
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {

		int[] vtcescolor = new int[G.length];

		vtcescolor[0] = 0;
		for (int i1 = 0; i1 < vtcescolor.length; i1++) {
			vtcescolor[i1] = -1;
		}
		int cn = 0;

		for (int i1 = 0; i1 < G.length; i1++) {
			boolean[] colornotavail = new boolean[G.length];
			List<Integer> nbrv = G[i1];

			for (Integer s : nbrv) {
//				int n = Integer.parseInt(s);
				if (vtcescolor[s] > -1) {
					colornotavail[s] = true;
				}
			}

			for (int j = 0; j < colornotavail.length; j++) {
				if (colornotavail[j] == false) {
					vtcescolor[i1] = j;
					cn = Math.max(cn, j + 1);
					break;
				}
			}

		}

//		for (int i1 = 0; i1 < vtcescolor.length; i1++) {
//			System.out.println(vtcescolor[i1]);
//		}

//		System.out.println("cn-----" + cn);
		if (cn <= C) {
			return true;
		} else {
			return false;
		}
	}
}
