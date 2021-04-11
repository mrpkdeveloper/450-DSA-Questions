package array;

public class smallestsubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 45, 6, 0, 19 };
//		int[] arr = { 1, 10, 5, 2, 7 };
//		int[] arr = { 6, 3, 4, 5, 4, 3, 7, 9 }; //16
		subarray(arr, 51);

	}

	public static void subarray(int[] arr, int sum) {
		int i = 0, j = 0, x = 0, min = Integer.MAX_VALUE;
		while (i < arr.length && j < arr.length) {

			while (x <= sum && j < arr.length) {
				x += arr[j];
				j++;
			}
			while (x > sum && i < arr.length) {
				int ml = j - i;
				if (ml < min) {
					min = ml;
				}
				x -= arr[i];
				i++;

			}

		}
		System.out.println(min);
	}

}
