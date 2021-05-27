package bitmasking;

public class posofonlysetbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int findPosition(int n) {
		// code here
		if (!isPowerofTwo(n)) {
			return -1;
		}
		int pos = 0;
		while (n != 1) {
			pos++;
			n = n >> 1;
		}

		return pos + 1;

	}

	public static boolean isPowerofTwo(int n) {
		if (n == 0) {
			return false;
		}

		return ((n & (n - 1)) == 0 ? true : false);

	}

}
