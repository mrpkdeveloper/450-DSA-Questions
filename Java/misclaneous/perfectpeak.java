package misclaneous;

public class perfectpeak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 16143, 24430, 25073, 22550, 18585, 8076, 31197, 14607, 17965, 9516, 20427, 26174, 21949, 9497,
				17914, 23343 };

		System.out.println(perfectPeak(arr));
	}

	public static int perfectPeak(int[] arr) {

		for (int i = 1; i < arr.length - 1; i++) {
			boolean flag1 = true, flag2 = true;
			for (int j = 0; j < i; j++) {
				if (arr[j] >= arr[i]) {
					flag1 = false;
					break;
				}
			}

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] <= arr[i]) {
					flag2 = false;
					break;
				}
			}

			if (flag1 && flag2) {
				System.out.println(arr[i]);
				return 1;
			}
		}
		return 0;
	}

}
