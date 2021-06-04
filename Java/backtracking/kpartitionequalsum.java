package backtracking;

public class kpartitionequalsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 1, 5, 5, 6 };
		int k = 3;
		System.out.println(isKPartitionPossible(arr, arr.length, k));

	}

	public static boolean isKPartitionPossible(int arr[], int n, int k) {
		int presum = 0;
		if (k > n) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			presum += arr[i];
		}

		if (presum % k != 0) {
			return false;
		}

		return partition(arr, k, 0, new int[k], 0);

	}

	public static boolean partition(int[] arr, int k, int psf, int[] sumarr, int i) {
		if (i == arr.length) {
			if (psf == k) {
				for (int j = 0; j < sumarr.length - 1; j++) {
					if (sumarr[j] != sumarr[j + 1]) {
						return false;
					}
				}
				return true;
			}
			return false;
		}

		for (int j = 0; j < k; j++) {
			if (sumarr[j] != 0) {
				sumarr[j] += arr[i];
				if (partition(arr, k, psf, sumarr, i + 1)) {
					return true;
				}
				sumarr[j] -= arr[i];
			} else {
				sumarr[j] += arr[i];
				if (partition(arr, k, psf + 1, sumarr, i + 1)) {
					return true;
				}
				sumarr[j] -= arr[i];
				break;
			}
		}

		return false;
	}

}
