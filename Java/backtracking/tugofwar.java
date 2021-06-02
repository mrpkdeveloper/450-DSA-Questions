package backtracking;

import java.util.ArrayList;

public class tugofwar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 6, 1, 3 };
		ArrayList<Integer> set1 = new ArrayList<>();
		ArrayList<Integer> set2 = new ArrayList<>();
		solve(arr, arr.length, set1, set2, 0, 0, 0);
		System.out.println(ans);

	}

	public static String ans = "";
	public static int mindiff = Integer.MAX_VALUE;

	public static void solve(int[] arr, int n, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumset1,
			int sumset2, int i) {

		if (i == arr.length) {
			if (mindiff > Math.abs(sumset1 - sumset2)) {
				mindiff = Math.abs(sumset1 - sumset2);
				ans = set1 + " " + set2;
//				System.out.println(ans);
			}
			return;
		}

		// add to first set
		if (set1.size() < (n + 1) / 2) {
			set1.add(arr[i]);
			solve(arr, n, set1, set2, sumset1 + arr[i], sumset2, i + 1);
			set1.remove(set1.size() - 1);

		}

		// add to second set
		if (set2.size() < (n + 1) / 2) {
			set2.add(arr[i]);
			solve(arr, n, set1, set2, sumset1, sumset2 + arr[i], i + 1);
			set2.remove(set2.size() - 1);

		}
	}

}
