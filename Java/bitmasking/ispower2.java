package bitmasking;

public class ispower2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPowerofTwo(long n) {
		if (n == 0) {
			return false;
		}

		return ((n & (n - 1)) == 0 ? true : false);

	}

}
