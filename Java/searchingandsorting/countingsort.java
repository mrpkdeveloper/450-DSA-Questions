package searchingandsorting;

public class countingsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 5, 3, 2, 4, 5 };
		countsort(arr, 2, 5);

	}

	public static void countsort(int[] arr, int min, int max) {
		int range = max - min + 1;
		int[] farr = new int[range];

		for (int i = 0; i < arr.length; i++) {
			int idx = arr[i] - min;
			farr[idx]++;
		}

		for (int i = 1; i < farr.length; i++) {
			farr[i] = farr[i - 1] + farr[i];
		}

		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = arr[i];
			int idx = farr[val - min] - 1;
			ans[idx] = val;
			farr[val - min]--;
		}

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
