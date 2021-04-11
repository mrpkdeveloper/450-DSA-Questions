package array;

public class uglynumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ugly(150);

	}

	public static void ugly(int n) {

		int c = 1;
		int i = 2;
		for (i = 2; c <= n - 1; i++) {
			int maxno = checkugly(i, 2);
			maxno = checkugly(maxno, 3);
			maxno = checkugly(maxno, 5);
			if (maxno == 1) {
				c++;
			}
		}
		System.out.println(i - 1);
	}

	public static int checkugly(int a, int b) {
		while (a % b == 0) {
			a = a / b;
		}
		return a;
	}

}
