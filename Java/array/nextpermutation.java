package array;

public class nextpermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 5, 4 };
		nextperm(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void nextperm(int[] arr) {

		int i = arr.length - 2;

		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = arr.length - 1;
			while (arr[j] <= arr[i]) {
				j--;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		reverse(arr, i + 1);

	}

	public static void reverse(int[] arr, int i) {
		// 5 3 2 6 -> 6 2 3 5
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

}
