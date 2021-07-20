package misclaneous;

public class prettyprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		prettyPrint(4);
		System.out.println(-1 % 20);

	}

	public static void prettyPrint(int A) {
		int sz = 2 * A - 1;
		int[][] ans = new int[sz][sz];
		int temp = 0, limit = sz;
		while (A > 0) {
			for (int i = temp; i < limit; i++) {
				for (int j = temp; j < limit; j++) {
					ans[i][j] = A;
				}
			}
			A--;
			temp++;
			limit--;
		}

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

}
