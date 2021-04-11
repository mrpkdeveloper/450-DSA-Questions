package mattrix;

public class rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] m = { { 1, 2, 3, }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(m);

	}

	public static void rotate(int[][] m) {

		// transpose and then reverse each row 
		for (int i = 0; i < m.length; i++) {
			for (int j = i; j < m[0].length; j++) {
				int temp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = temp;
			}

			int k = 0, l = m[0].length - 1;
			while (k <= l) {
				int temp = m[i][k];
				m[i][k] = m[i][l];
				m[i][l] = temp;
				k++;
				l--;
			}
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

	}

}
