package array;

public class minswapsKtogether {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 2, 1, 5, 6, 3 };
//		int[] arr = { 2, 7, 9, 5, 8, 7, 4 };
		int[] arr = { 10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1 };

		ktogether(arr, 1);

	}

	public static void ktogether(int[] arr, int k) {
		int klessequal = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				klessequal++;
			}
		}

		int i = 0, j = klessequal - 1;
		while (j < arr.length) {
			int kgreater = 0;
			for (int j2 = i; j2 <= j; j2++) {
				if (arr[j2] > k) {
					kgreater++;
				}
			}
			if (min > kgreater) {
				min = kgreater;
			}
			i++;
			j++;

		}
		System.out.println(min);
	}

}
