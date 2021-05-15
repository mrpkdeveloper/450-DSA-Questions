package searchingandsorting;

public class findfirstandlastindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int arr[] = { 1 };
//		int arr[] = { 2, 2 };
//		int arr[] = { 1, 4 };
		find(arr, 4);

	}

	public static void find(int[] arr, int n) {
		if (arr.length == 1 && arr[0] == n) {
			int[] list = new int[2];
			System.out.println(0 + " " + 0);
		}
		int l = 0, r = arr.length - 1, first = -1, last = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] < n) {
				l = mid + 1;
			} else if (arr[mid] > n) {
				r = mid - 1;
			} else {
				first = mid;
				last = mid;
				while (first >= 0 && arr[first] == n) {
					first--;
				}
				first = first + 1;
				while (last < arr.length && arr[last] == n) {
					last++;
				}
				last = last - 1;
				break;
			}
		}

		System.out.println(first + " " + last);

	}

}
