package searchingandsorting;

public class searchinrotatedarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 6, 8, 9, 2, 3, 4, 5 };
//		int[] arr = { 23, 25, 26, 77, 87, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
//		int[] arr = { 4, 2 };
		int[] arr = { 1, 3 };
//		System.out.println(pivot(arr));
		find(arr, 3);

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

}
