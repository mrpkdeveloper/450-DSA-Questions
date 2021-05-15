package heap;

public class mergetwoheaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 4, m = 3;
		long a[] = { 10, 5, 6, 2 };
		long b[] = { 12, 7, 9 };
		long merged[] = new long[a.length + b.length];
		merge(merged, a, b, n, m);
	}

	public static void merge(long merged[], long a[], long b[], long n, long m) {

		int k = 0;
		for (int i = 0; i < a.length; i++) {
			merged[k] = a[i];
			k++;
		}

		for (int i = 0; i < b.length; i++) {
			merged[k] = b[i];
			k++;
		}
		n = n + m;
		for (long i = n / 2 - 1; i >= 0; i--) {
			downheapify(merged, (int) i);
		}

		for (int i = 0; i < merged.length; i++) {
			System.out.println(merged[i]);
		}

	}

	public static void add(long[] arr, long val, int i) {

		arr[i] = val;
		upheapify(arr, i);

	}

	private static void upheapify(long[] arr, int ci) {
		int pi = (ci - 1) / 2;

		if (arr[pi] < arr[ci]) {
			long temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			upheapify(arr, pi);
		}
	}

	public static void downheapify(long[] arr, int pi) {

		int lc = 2 * pi + 1;
		int rc = 2 * pi + 2;

		int maxi = pi;
		if (lc < arr.length && arr[maxi] < arr[lc]) {
			maxi = lc;
		}
		if (rc < arr.length && arr[maxi] < arr[rc]) {
			maxi = rc;
		}

		if (maxi != pi) {
			long temp = arr[maxi];
			arr[maxi] = arr[pi];
			arr[pi] = temp;
			downheapify(arr, maxi);
		}
	}

}
