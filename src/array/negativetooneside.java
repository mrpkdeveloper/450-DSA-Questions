package array;

public class negativetooneside {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6, 4 };
//		partitioning(arr);
		order(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	// 0 - i-1 -> -ve
	// i - j-1 -> +ve
	// j - end -> unknown

	public static void partitioning(int[] arr) {
		int i = 0, j = 0;
		while (j <= arr.length - 1) {
			if (arr[j] > 0) {
				j++;
			} else {
				// swap i and j values
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
		}

	}

	// if order matters
	public static void order(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] < 0) {
				i++;
			} else {
				int tempind = i;
				while (i < arr.length && arr[i] > 0) {
					i++;
				}
				if (i != arr.length) {
					rotate(arr, tempind, i);
					i = tempind;
				}
			}
		}
	}

	private static void rotate(int[] arr, int tempind, int i) {
		int last = arr[i];
		for (int j = i; j > tempind; j--) {
			arr[j] = arr[j - 1];
		}
		arr[tempind] = last;

	}

}
