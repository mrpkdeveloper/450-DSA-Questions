package greedy;

public class maxproductsubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1, 0, 2 };
		solve(arr);

	}

	public static void solve(int[] arr) {

		int maxneg = Integer.MIN_VALUE, count0 = 0, countneg = 0, prod = 1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count0++;
				continue;
			}

			if (arr[i] < 0) {
				countneg++;
				if (maxneg < arr[i]) {
					maxneg = arr[i];
				}
			}

			prod *= arr[i];

		}

		if (count0 == arr.length) {
			System.out.println(0);
		} else if (countneg % 2 != 0) {
			if (countneg == 1 && count0 == arr.length - 1) {
				System.out.println(0);
			} else
				System.out.println(prod / maxneg);
		} else {
			System.out.println(prod);
		}

	}

}
