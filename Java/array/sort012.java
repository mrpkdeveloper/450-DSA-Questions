package array;

public class sort012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 0, 2, 1, 2, 0 };
//		int[] arr = { 0, 1, 1, 1, 1, 0 };
		threewaypartition(arr, 0, arr.length - 1);
//		countmethod(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	// solving using partition method
	// 0 - lo-1 = 0
	// lo - mid-1 =1
	// mid - hi =unknown
	// hi+1 - end -> 2
	public static void threewaypartition(int[] arr, int start, int end) {
		int lo = 0, mid = 0, hi = end;
		while (mid <= hi) {
			if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] < 1) {
				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
			} else {
				int temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;
				hi--;
			}
		}

	}

	// method of counting (easy to understand less comparisons)
	public static void countmethod(int[] arr) {
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				c0++;
			} else if (arr[i] == 1) {
				c1++;
			} else {
				c2++;
			}
		}

		int i = 0;
		while (c0 != 0) {
			arr[i] = 0;
			i++;
			c0--;
		}
		while (c1 != 0) {
			arr[i] = 1;
			i++;
			c1--;
		}
		while (c2 != 0) {
			arr[i] = 2;
			i++;
			c2--;
		}
	}

}
