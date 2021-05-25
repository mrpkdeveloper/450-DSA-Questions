package searchingandsorting;

public class repeatingandmissing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n) -> space and time
	int[] findTwoElement(int arr[], int n) {
		int duplicate = 0, missing = 0;
		int[] vis = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (vis[arr[i]] == 1) {
				duplicate = arr[i];
			}
			vis[arr[i]] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if (vis[i] == 0) {
				missing = i;
				break;
			}
		}

		int[] ans = new int[2];
		ans[0] = duplicate;
		ans[1] = missing;
		return ans;
	}

	// O(n) -> time O(1) -> space
	// used bitmasking
	int[] findTwoElementopti(int arr[], int n) {
		int z = 0;
		for (int i = 0; i < n; i++) {
			z = z ^ arr[i];
		}

		for (int i = 1; i <= n; i++) {
			z = z ^ i;
		}

		// by this time z has xor of misiing and duplicate no;
		int rightsetbit = (z & ~(z - 1));
		int set = 0;
		int reset = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & rightsetbit) != 0) {
				set = set ^ arr[i];
			} else {
				reset = reset ^ arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((i & rightsetbit) != 0) {
				set = set ^ i;
			} else {
				reset = reset ^ i;
			}
		}

		int missing = 0, duplicate = 0;

		for (int i = 0; i < n; i++) {
			if (set == arr[i]) {
				duplicate = set;
				missing = reset;
				break;
			} else if (reset == arr[i]) {
				duplicate = reset;
				missing = set;
				break;
			}
		}

		int[] ans = new int[2];
		ans[0] = duplicate;
		ans[1] = missing;
		return ans;
	}

}
