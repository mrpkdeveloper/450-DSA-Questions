package strings;

public class wordwrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// quest-> aaa bb cc ddddd
		// aaa
		// bb cc
		// ddddd
		int[] arr = { 3, 2, 2, 5 };
		wordwrap(arr, 4, 6);

	}

	static int printSolution(int p[], int n) {
		int k;
		if (p[n] == 1)
			k = 1;
		else
			k = printSolution(p, p[n] - 1) + 1;
		System.out.println("Line number" + " " + k + ": " + "From word no." + " " + p[n] + " " + "to" + " " + n);
		return k;
	}

	// tc-> total characters allowed
	public static void wordwrap(int[] arr, int n, int tc) {

		int[][] extraspace = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			extraspace[i][i] = tc - arr[i - 1];
			for (int j = i + 1; j <= n; j++) {
				extraspace[i][j] = extraspace[i][j - 1] - arr[j - 1] - 1;
			}
		}

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(extraspace[i][j] + "    ");
//			}
//			System.out.println();
//		}
		System.out.println();
		System.out.println();

		// lc -> least cost
		// lc[i][j] will have cost of a line which has words from
		// i to j
		int lc[][] = new int[n + 1][n + 1];
		for (int i = 1; i < lc.length; i++) {
			for (int j = 1; j < lc.length; j++) {
				if (extraspace[i][j] < 0) {
					lc[i][j] = Integer.MAX_VALUE;
				} else if (j == n && extraspace[i][j] >= 0) {
					lc[i][j] = 0; // for last word
				} else {
					lc[i][j] = extraspace[i][j] * extraspace[i][j];
				}
			}
		}

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(lc[i][j] + "    ");
//			}
//			System.out.println();
//		}

		// c[i] will have total cost of optimal arrangement of words
		// from 1 to i
		int c[] = new int[n + 1];

		// p[] is used to print the path.
		int p[] = new int[n + 1];

		// Calculate minimum cost and find minimum cost arrangement.
		// The value c[j] indicates optimized cost to arrange words
		// from word number 1 to j.
		c[0] = 0;
		for (int i = 1; i <= n; i++) {
			c[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (c[j - 1] != Integer.MAX_VALUE && lc[j][i] != Integer.MAX_VALUE && (c[j - 1] + lc[j][i] < c[i])) {
					c[i] = c[j - 1] + lc[j][i];
					p[i] = j;
				}
			}
		}

		System.out.println();
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}
		System.out.println();
		System.out.println();

		System.out.println(printSolution(p, n));

	}

}
