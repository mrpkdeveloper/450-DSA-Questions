package misclaneous;

public class nooflengthn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 2, 5 };
		int B = 2;
		int C = 21;
		System.out.println(solve(arr, B, C));

	}

	public static int solve(int[] arr, int B, int C) {
		int ans = 0;
		int nod = 0;
		int n = C;
		if (arr.length == 0) {
			return 0;
		}
		while (n > 0) {
			n = n / 10;
			nod++;
		}

		if (B > nod) {
			return 0;
		} else if (B < nod) {
			if (arr[0] == 0) {
				ans = (arr.length - 1) * (int) Math.pow(arr.length, B - 1);
			} else {
				ans = (int) Math.pow(arr.length, B);
			}
			if (B == 1 && arr[0] == 0) {
				ans++;
			}
			return ans;
		} else {
			if (B == 1) {
				int count = 0;
				for (int k = 0; k < arr.length; k++) {
					if (arr[k] > C)
						break;
					count++;
				}
				return count;
			} else {
				int[] temp = new int[nod];
				n = C;
				int i = nod - 1;
				while (n > 0 && i >= 0) {
					temp[i] = n % 10;
					n = n / 10;
					i--;
				}
				for (int j = 0; j < temp.length; j++) {
					System.out.println(temp[j]);
				}
				// count no elements smaller than or equal to first digit of C
				int count = 0, flag = 0;
				for (int k = 0; k < arr.length; k++) {
					if (arr[k] == 0) {
						continue;
					}
					if (arr[k] == temp[0])
						flag = 1;
					if (arr[k] > temp[0])
						break;
					count++;
				}
				ans = count * (int) (Math.pow(arr.length, B - 1));
				// but this and may contains some extra values
				if (flag == 0) {
					// means no extra values present
					return ans;
				} else {
					int j = 1;
					while (flag == 1 && j <= B - 1) {
						flag = 0;
						int countx = 0;
						for (int k = 0; k < arr.length; k++) {
							if (arr[k] > temp[j])
								countx++;
							if (arr[k] == temp[j])
								flag = 1;
						}
						ans -= countx * (int) (Math.pow(arr.length, B - j - 1));
						j++;
					}

					if (j == B && flag == 1) {
						ans--;
					}
				}

			}
		}
		return ans;
	}

}
