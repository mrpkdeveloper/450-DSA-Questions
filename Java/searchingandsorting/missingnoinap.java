package searchingandsorting;

public class missingnoinap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 6, 11, 16, 21, 31 };
		ap(arr);

	}

	public static void ap(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;
		int cd = (arr[hi] - arr[lo]) / arr.length;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid != arr.length && arr[mid + 1] - arr[mid] != cd) {
				System.out.println(arr[mid] + cd);
				break;
			} else if (mid != 0 && arr[mid] - arr[mid - 1] != cd) {
				System.out.println(arr[mid] - cd);
				break;
			} else if (arr[mid] == arr[0] + mid * cd) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

	}

}
