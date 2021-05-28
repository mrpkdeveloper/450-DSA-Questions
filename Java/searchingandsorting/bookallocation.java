package searchingandsorting;

public class bookallocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 250, 74, 159, 181, 23, 45, 129, 174 };
//		int arr[] = { 12, 34, 67, 90 };
		int m = 6;
//		int m = 2;
		allocation(arr, m);

	}

	public static void allocation(int[] arr, int m) {

//		Arrays.parallelSort(arr);
		// min no of pages
		int lo = 0;
		for (int i = 0; i < arr.length; i++) {
			if (lo < arr[i]) {
				lo = arr[i];
			}
		}
		// max no of pages
		int hi = 0;
		for (int i = 0; i < arr.length; i++) {
			hi += arr[i];
		}

		int max = Integer.MAX_VALUE;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
//			System.out.println(mid);
			int nostudents = 1;
			int nopages = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					break;
				}
				if (arr[i] + nopages <= mid) {
					nopages += arr[i];
				} else {
					nostudents++;
					nopages = arr[i];
				}
			}

			if (nostudents <= m) {
				if (max > mid) {
					max = mid;
				}
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(max);

	}

}
