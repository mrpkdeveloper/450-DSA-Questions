package array;

public class findduplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
		int[] arr = { 1, 3, 3, 4, 2, 2 };
//		findduplicate(arr);
//		duplicate(arr);
		duplicatetwopointer(arr);

	}

	// solved in O(n) but used O(n) space
	public static void findduplicate(int[] arr) {
		int[] temp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			temp[arr[i]] += 1;
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > 1) {
				System.out.println(i);
			}
		}

	}

	// more optimised O(n) we change values of array
	// but then again restore it
	public static void duplicate(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % n] += n;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] / n > 1) {
				System.out.println(i + " duplicate");
			}
			arr[i] = arr[i] % n;
			System.out.println(arr[i]);
		}

	}

	// most optimised two pointer approach
	public static void duplicatetwopointer(int[] arr) {
		int slow = arr[0];
		int fast = arr[0];

		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		} while (slow != fast);

		fast = arr[0];

		while (slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}

		System.out.println(slow);

	}

}
