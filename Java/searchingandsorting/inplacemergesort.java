package searchingandsorting;

public class inplacemergesort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void sort(int[] arr, int s, int e) {
		if (s == e) {
			return;
		}
		int mid = (s + e) / 2;
		sort(arr, s, mid);
		sort(arr, mid + 1, s);

		merge(arr, s, mid, e);

	}

	private static void merge(int[] arr, int s, int mid, int e) {

	}

}
