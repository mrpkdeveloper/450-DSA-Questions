package backtracking;

public class printallpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3, }, { 4, 5, 6 } };
		solve(mat, 0, 0, "");

	}

	public static void solve(int[][] mat, int i, int j, String ans) {

		if (i >= mat.length || j >= mat[0].length) {
			return;
		}

		if (i == mat.length - 1 && j == mat[0].length - 1) {
			System.out.println(ans + mat[i][j]);
			return;
		}

		int[] rx = { 1, 0 };
		int[] ry = { 0, 1 };

		for (int k = 0; k < ry.length; k++) {
			solve(mat, i + rx[k], j + ry[k], ans + mat[i][j] + " ");
		}

	}

}
