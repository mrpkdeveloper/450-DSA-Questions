package array;

public class maxproductsubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 6, -3, -10, 0, 2 };
//		int[] arr = { 2, 3, 4, 5, -1, 0 };
//		int[] arr = { 8, -2, -2, 0, 8, 0, -6, -8, -6, -1 };
		int[] arr = { 90, 91, -91, 91, -91, -90, 90, 90, -90, -90 };
		maxproduct(arr);
//		long a = 90 * 91 * -91 * 91 * -91 * -90 * 90 * 90 * -90;
		long a = 90 * 91 * (-91) * 91 * (-91);
		System.out.println(a);

	}

	public static void maxproduct(int[] arr) {
		long max = 1, min = 1, finalmax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				max = 1;
				min = 1;
				continue;
			}
			long temp = max;
			max = Math.max(Math.max((long) arr[i], max * arr[i]), min * arr[i]);
			min = Math.min(Math.min((long) arr[i], temp * arr[i]), min * arr[i]);

			if (finalmax < max) {
				finalmax = max;
			}
		}

		System.out.println(finalmax);

	}

}
