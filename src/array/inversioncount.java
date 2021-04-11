package array;

public class inversioncount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 2, 4, 1, 3, 5 };
//		int arr[] = { 2, 3, 4, 5, 6 };
//		int arr[] = { 1, 7, 2, 5, 3 };
		int arr[] = { 5, 4, 3,   2, 1 };
		int[] temp = new int[arr.length];
		int ans = mergesort(arr, temp, 0, arr.length - 1);
//		inversioncount(arr);
//		for (int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}

		System.out.println(ans);

	}

	// brute force
//	public static void inversioncount(int[] arr) {
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[i] > arr[j]) {
//					count++;
////					swap(arr, i, j);
//				}
//			}
//		}
//
//		System.out.println(count);
//
//	}
//
//	public static void swap(int[] arr, int i, int j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}

	public static int mergesort(int[] arr, int[] temp, int lo, int hi) {
		if (lo >= hi) {
			return 0;
		}

		int count = 0;
		int mid = (lo + hi) / 2;
		count += mergesort(arr, temp, lo, mid);
		count += mergesort(arr, temp, mid + 1, hi);

		count += merge(arr, lo, mid, hi, temp);
		return count;

	}

	public static int merge(int[] arr, int lo, int mid, int hi, int[] temp) {
		int count = 0;
		int i = lo, j = mid + 1, k = lo;
		while (i <= mid && j <= hi) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			} else {
				count += (mid + 1) - i;
//				count++;
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		if (i == mid + 1) {
			while (j <= hi) {
				temp[k] = arr[j];
				k++;
				j++;
			}
		} else {
			while (i <= mid) {
				temp[k] = arr[i];
				k++;
				i++;
			}
		}

//		for (int k2 = lo; k2 <= hi; k2++) {
//			arr[k2] = temp[k2];
//			System.out.println(arr[k2]);
//		}
//		System.out.println("**********");
		return count;
	}

}
