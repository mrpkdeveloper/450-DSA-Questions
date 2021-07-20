package backtracking;

public class nqueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[4][4];
		print(arr, 3, 0, 0, "");

		int n = 4;
		int[] col = new int[n];
		int[] d1 = new int[2 * n];
		int[] d2 = new int[2 * n];
//		printopti(n, 0, "", col, d1, d2);

	}

	public static void print(int[][] arr, int tq, int qp, int i, String ans) {
		if (qp == tq) {
			System.out.println(ans);
			return;
		}

		if (i == arr.length) {
			return;
		}

		for (int k = 0; k < arr.length; k++) {
			if (check(arr, i, k)) {
				arr[i][k] = 1;
				print(arr, tq, qp + 1, i + 1, ans + " { " + i + " - " + k + " }");
				arr[i][k] = 0;
			}
		}
		print(arr, tq, qp, i + 1, ans);

	}

	private static boolean check(int[][] arr, int i, int j) {
		// check for up
		for (int j2 = i - 1; j2 >= 0; j2--) {
			if (arr[j2][j] == 1) {
				return false;
			}
		}

		// check for left diag
		int temp = j - 1;
		for (int j2 = i - 1; j2 >= 0 && temp >= 0; j2--) {
			if (arr[j2][temp] == 1) {
				return false;
			}
			temp--;
		}
		temp = j + 1;
		for (int j2 = i - 1; j2 >= 0 && temp < arr[0].length; j2--) {
			if (arr[j2][temp] == 1) {
				return false;
			}
			temp++;
		}

		return true;

	}

	// branched and bound
	public static void printopti(int n, int i, String ans, int[] col, int[] d1, int[] d2) {
		if (i == n) {
			System.out.println(ans);
			return;
		}

		for (int k = 0; k < n; k++) {
			if (checkopti(n, i, k, col, d1, d2)) {
				col[k] = 1;
				d1[i + k] = 1;
				d2[i - k + n - 1] = 1;
				printopti(n, i + 1, ans + " { " + i + " - " + k + " }", col, d1, d2);
				col[k] = 0;
				d1[i + k] = 0;
				d2[i - k + n - 1] = 0;
			}
		}

	}

	private static boolean checkopti(int n, int i, int j, int[] col, int[] d1, int[] d2) {

		if (col[j] == 1) {
			return false;
		}

		if (d1[i + j] == 1) {
			return false;
		}
		if (d2[i - j + n - 1] == 1) {
			return false;
		}

		return true;

	}

}
