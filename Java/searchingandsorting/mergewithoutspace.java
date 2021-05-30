package searchingandsorting;

public class mergewithoutspace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = { 2, 4, 6, 8 };
//		int[] arr2 = { 1, 3, 5, 7 };

		int[] arr1 = { 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 7, 8, 8, 9, 9, 10, 11, 12, 12, 13, 13, 15, 16, 16, 16, 18, 20 };
		int[] arr2 = { 1, 2, 2, 2, 3, 3, 4, 6, 7, 8, 8, 9, 9, 11, 11, 12, 13, 14, 14, 15, 16, 18, 19, 20 };

		merge(arr1, arr2, arr1.length, arr2.length);

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

	}

	public static void merge(int arr1[], int arr2[], int n, int m) {
		int ts = n + m;
		int rem = ts % 2;
		int gap = ts / 2 + rem;
		int i = 0, j = gap;
		while (true) {
			while (i < n && j < n) {
				if (arr1[i] > arr1[j]) {
					int temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
				i++;
				j++;
			}
			if (j >= n)
				j = j - n;
			while (i < n && j < m) {
				if (arr1[i] > arr2[j]) {
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}
				i++;
				j++;
			}
			if (i >= n)
				i = i - n;
			while (j < m) {
				if (arr2[i] > arr2[j]) {
					int temp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp;
				}
				i++;
				j++;
			}
			if (gap == 1) {
				break;
			}
			rem = gap % 2;
			gap = gap / 2 + rem;
			i = 0;
			j = gap;
		}

	}

}
