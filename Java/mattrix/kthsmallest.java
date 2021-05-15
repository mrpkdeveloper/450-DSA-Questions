package mattrix;

import java.util.Arrays;

public class kthsmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { { 16, 28, 60, 64 }, { 22, 41, 63, 91 }, { 26, 50, 87, 93 }, { 36, 78, 87, 94 } };
		System.out.println(smallest(m, 3));

	}

	// nlogn->time complexity
	public static int smallest(int[][] m, int k) {
		int lo = m[0][0], hi = m[m.length - 1][m[0].length - 1];
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int j = m.length - 1;
			int count = 0;
			// count is no of elements smaller than mid in matrix
			for (int i = 0; i < m.length; ++i) {
				while (j >= 0 && m[i][j] > mid)
					--j;
				count += (j + 1);
			}

			if (count < k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}

		return lo;
	}

}
