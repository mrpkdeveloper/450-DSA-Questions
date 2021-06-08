package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Chocola {

	// same as of min cost to cut square board
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			Integer[] x = new Integer[m - 1];
			Integer[] y = new Integer[n - 1];
			for (int i = 0; i < x.length; i++) {
				x[i] = scn.nextInt();
			}
			for (int i = 0; i < y.length; i++) {
				y[i] = scn.nextInt();
			}
			solve(x, y);

			t--;
		}
	}

	public static void solve(Integer[] x, Integer[] y) {

		int mincost = 0, h = 1, v = 1, i = 0, j = 0;
		Arrays.sort(x, Collections.reverseOrder());
		Arrays.sort(y, Collections.reverseOrder());

		while (i < x.length && j < y.length) {
			if (x[i] >= y[j]) {
				mincost += x[i] * v;
				h++;
				i++;
			} else {
				mincost += y[j] * h;
				v++;
				j++;
			}
		}

		while (i != x.length) {
			mincost += x[i] * v;
			h++;
			i++;
		}

		while (j != y.length) {
			mincost += y[j] * h;
			v++;
			j++;
		}

		System.out.println(mincost);

	}

}
