package mattrix;

public class rowwithmax1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println(maxone(m));

	}

	public static int maxone(int[][] m) {

		int r = 0, c = 0;
		while (c < m[0].length) {
			if (m[r][c] == 1) {
				return r;
			} else {
				r++;
			}

			if (r == m.length) {
				r = 0;
				c++;
			}
		}
		return -1;
	}

}
