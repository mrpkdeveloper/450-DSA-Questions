package dp;

public class paintingfence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWays(3, 2));

	}

	public static long countWays(int n, int k) {
		if (n == 1) {
			return k;
		}
		int mod = 1000000007;
		long same = k;
		long diff = k * (k - 1);
		long total = same + diff;

		for (int i = 3; i <= n; i++) {
			same = diff % mod;
			diff = (total * (k - 1)) % mod;
			total = (same + diff) % mod;
		}

		return total;
	}

}
