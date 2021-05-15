package array;

public class median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 9, 4, 6, 1, 7, 3, 5 };
//		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] arr = { 5, 7, -2, 4, 1, 3 };
		quicksort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
//		median(arr);

	}

	public static void median(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
		int size = arr.length;
		if (size % 2 == 0) {
			System.out.println((arr[(size - 1) / 2] + arr[(size + 1) / 2]) / 2);
		} else {
			System.out.println(arr[(size - 1) / 2]);
		}

	}

	public static void quicksort(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		}

		int p = partition(arr, start, end, arr[end]);
		quicksort(arr, start, p - 1);
		quicksort(arr, p + 1, end);

	}

	public static int partition(int[] arr, int start, int end, int pivot) {
		// 0 --- i-1 -> <=part
		// i --- j-1 -> >part
		// j --- end -> unknown
		int i = start, j = start;
		while (j <= end) {
			if (arr[j] > pivot) {
				j++;
			} else {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j++;
			}
		}

		return i - 1;
	}
}
