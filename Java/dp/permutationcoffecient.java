package dp;

public class permutationcoffecient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(npr(5, 2));

	}

	// npr -> n!/(n-r)!
	// also npr -> n*(n-1)*(n-2)*(n-3) ....... (n-k+1)

	// time-> O(n)
	static int npr(int n, int r) {

		int ans = 1;

		for (int i = 0; i < r; i++) {
			ans *= (n - i);
		}

		return ans;
	}

}
