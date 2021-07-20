package searchingandsorting;

public class searchinrotatedarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 6, 8, 9, 2, 3, 4, 5 };
//		int[] arr = { 23, 25, 26, 77, 87, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
//		int[] arr = { 4, 2 };
//		int[] arr = { 1, 3 };
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
//		System.out.println(pivot(arr));
//		find(arr, 12);
		System.out.println(solve(arr, 12));

	}

	public static int pivot(int[] arr) {

		int l = 0, r = arr.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] < arr[r]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		// pivot index
		return r;
	}

	public static void find(int[] arr, int n) {

		int pivot = pivot(arr);
		System.out.println(pivot);
		int l = 0, r = arr.length - 1;
		if (arr[r] >= n) {
			l = pivot;
		} else {
			r = pivot - 1;
		}
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == n) {
				System.out.println(mid);
				break;
			} else if (arr[mid] > n) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

	}

	public static int solve(int[] arr, int B) {
		int hi = arr.length - 1, lo = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			System.out.println(arr[mid]);
			if (arr[mid] == B) {
				return mid;
			} else if (arr[lo] <= arr[mid]) {
				// key can be present in left half
				if (arr[lo] <= B && arr[mid] > B) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				// key can be present in right half
				if (arr[mid] < B && arr[hi] >= B) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

}
