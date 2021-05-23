package bitmasking;

public class counttotalsetbits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countSetBits(int n) {
		if (n == 0) {
			return 0;
		}
		int x = maxpowerof2(n);
		return (x << (x - 1)) + (n + 1 - (1 << x)) + countSetBits(n - (1 << x));

	}

	public static int maxpowerof2(int n) {

		int x = 0;
		while (1 << x <= n) {
			x++;
		}
		return x - 1;
	}

}
