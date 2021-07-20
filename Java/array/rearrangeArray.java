package array;

public class rearrangeArray {
	public static void rightRotate(int a[], int wrongIndex, int idx) {
		int temp = a[idx];

		for (int i = idx; i > wrongIndex; i--)
			a[i] = a[i - 1];
		a[wrongIndex] = temp;
	}

	public static void rearrange(int a[], int n) {
		int wrongIndex = -1;

		for (int idx = 0; idx < n; idx++) {
			if (wrongIndex >= 0) {
				if ((a[wrongIndex] < 0 && a[idx] >= 0) || (a[wrongIndex] >= 0 && a[idx] < 0)) {
					rightRotate(a, wrongIndex, idx);
					if (idx - wrongIndex >= 2)
						wrongIndex += 2;
					else
						wrongIndex = -1;
				}
			}

			if (wrongIndex == -1)
				if ((a[idx] >= 0 && idx % 2 == 0) || (a[idx] < 0 && idx % 2 == 1))
					wrongIndex = idx;
		}
	}

	public static void main(String[] args) {
		int a[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		int n = a.length;
		rearrange(a, n);
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}
}
