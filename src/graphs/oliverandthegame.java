package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class oliverandthegame {

//	9
//	1 2
//	1 3
//	2 6
//	2 7
//	6 9
//	7 8
//	3 4
//	3 5

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		Long n = scn.nextLong();
		HashMap<Long, ArrayList<Long>> vtces = new HashMap<>();
		for (long i = (long) 1; i <= n; i++) {
			ArrayList<Long> nbr = new ArrayList<>();
			vtces.put(i, nbr);
		}
		long noe = n - 1;
		while (noe > 0) {
			long u = scn.nextLong();
			long v = scn.nextLong();

			ArrayList<Long> nbru = vtces.get(u);
			ArrayList<Long> nbrv = vtces.get(v);

			nbru.add(v);
			nbrv.add(u);

			noe--;
		}
		long nq = scn.nextLong();
		while (nq > 0) {
			long t = scn.nextLong();
			long x = scn.nextLong();
			long y = scn.nextLong();
			boolean ans = game(vtces, n, t, x, y);
			if (ans) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			nq--;
		}

	}

	public static boolean game(HashMap<Long, ArrayList<Long>> vtces, long n, long t, long x, long y) {

		long[] intime = new long[(int) (n + 1)];
		long[] outtime = new long[(int) (n + 1)];
		dfs(vtces, 0, intime, outtime, 1);
		if (!check(x, y, intime, outtime) && !check(y, x, intime, outtime)) {
			return false;

		}
		if (t == 0) {
			return check(x, y, intime, outtime);

		} else {
			return check(y, x, intime, outtime);
		}

	}

	private static boolean check(long x, long y, long[] intime, long[] outtime) {
		if (intime[(int) x] < intime[(int) y] && outtime[(int) x] > outtime[(int) y]) {
			return true;
		} else {
			return false;
		}

	}

	// euler tour
	public static int t = 1;

	public static void dfs(HashMap<Long, ArrayList<Long>> vtces, long par, long[] intime, long[] outtime, long src) {
		intime[(int) src] = t++;
		ArrayList<Long> nbr = vtces.get(src);
		for (Long i : nbr) {
			if (i != par)
				dfs(vtces, src, intime, outtime, i);
		}
		outtime[(int) src] = t++;

	}

}
