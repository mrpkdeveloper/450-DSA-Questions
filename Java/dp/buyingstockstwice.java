package dp;

public class buyingstockstwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 30, 15, 10, 8, 25, 80 };
		solve(arr);

	}

	public static void solve(int[] arr) {

		int[] buytoday = new int[arr.length];
		int[] selltoday = new int[arr.length];

		int min = arr[0];
		selltoday[0] = 0;
		for (int i = 1; i < selltoday.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
			int profit = arr[i] - min;
			selltoday[i] = Math.max(selltoday[i - 1], profit);

		}

		buytoday[arr.length - 1] = 0;
		int max = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (max < arr[i]) {
				max = arr[i];
			}
			int profit = max - arr[i];
			buytoday[i] = Math.max(buytoday[i + 1], profit);
		}

		for (int i = 0; i < selltoday.length; i++) {
			System.out.println(selltoday[i] + " " + buytoday[i]);
		}

		int ans = buytoday[0] + selltoday[0];
		for (int i = 1; i < selltoday.length; i++) {
			ans = Math.max(ans, selltoday[i] + buytoday[i]);
		}
		System.out.println(ans);

	}

}
