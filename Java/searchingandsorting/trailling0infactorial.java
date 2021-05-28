package searchingandsorting;

public class trailling0infactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(85));
		fact2(22);

	}

	// q-1 -> find no of trailling 0 in n!
	public static int fact(int n) {

		int a = 5;
		int c = 0;
		// logic
		// n/5+n/25+n/125 ..... till 0
		while (n / a != 0) {
			c += n / a;
			a *= 5;
		}

		return c;

	}

	// q-2 find the no which has atleast n no of trailling 0
	public static void fact2(int n) {

		int lo = 0;
		int hi = 5 * n;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (fact(mid) >= n) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(lo);

	}

}
