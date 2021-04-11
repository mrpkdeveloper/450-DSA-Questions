package array;

public class threewaypartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 3, 4, 1 };
//		int[] arr = { 76, 8, 75, 22, 59, 96, 30, 38, 36 };
//		partitioning(arr, 2, 4);
//		partitioning(arr, 44, 62);
//		threeWayPartition(arr, 44, 62);
		threeWayPartition(arr, 2, 4);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void partitioning(int[] arr, int a, int b) {
		// 0 --- i-1 -> <=a
		// i --- j-1 -> >a && <=b
		// j --- k -> unknown
		// k+1 --- end -> >b
		int i = 0, j = 0, k = arr.length - 1;
		while (j <= k && j < arr.length) {
			if (arr[j] > b) {
				int temp = arr[j];
				arr[j] = arr[k];
				arr[k] = temp;
				k--;
			} else if (arr[j] <= b && arr[j] > a) {
				j++;
			} else if (arr[j] <= a) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j++;
			}
		}
	}

	public static void threeWayPartition(int[] arr, int lowVal, int highVal) {
		int n = arr.length;
		int start = 0, end = n - 1;

		// Traverse elements from left
		for (int i = 0; i <= end;) {
			if (arr[i] < lowVal) {

				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
				i++;

			} else if (arr[i] > highVal) {

				int temp = arr[end];
				arr[end] = arr[i];
				arr[i] = temp;
				end--;

			}

			else
				i++;
		}

	}

}
