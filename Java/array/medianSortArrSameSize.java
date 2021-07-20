package array;

public class medianSortArrSameSize {

	public static double find_median(int[] a, int[] b) {
		return find_median(a, b, 0, 0, a.length - 1, b.length - 1);
	}

	public static double find_median(int[] a, int[] b, int Sa, int Sb, int Ea, int Eb) {
		if (Ea - Sa <= 1)
			return (Math.max(a[Sa], b[Sb]) + Math.min(a[Ea], b[Eb])) / 2.0;
		double m1 = median(a, Sa, Ea);
		double m2 = median(b, Sb, Eb);
		if (m1 == m2)
			return m1;
		if (m1 > m2)
			return find_median(a, b, Sa, (Sb + Eb + 1) / 2, (Sa + Ea + 1) / 2, Eb);
		return find_median(a, b, (Sa + Ea + 1) / 2, Sb, Ea, (Sb + Eb + 1) / 2);
	}

	private static double median(int[] arr, int s, int e) {
		return (arr[(s + e) / 2] + arr[(s + e + 1) / 2]) / 2.0;
	}

	public static void main(String[] args) {

		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };

		double ans = find_median(ar1, ar2);

		System.out.println(ans);
	}
}
