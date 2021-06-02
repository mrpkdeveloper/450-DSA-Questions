package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class combinationsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 6, 5, 5, 7, 1, 8, 2, 9, 9, 7, 7, 9 };
//		int sum = 6;
		int arr[] = { 6, 3, 7 };
		int sum = 18;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Arrays.parallelSort(arr);
		ArrayList<ArrayList<Integer>> fans = new ArrayList<ArrayList<Integer>>();
		solve(arr, sum, fans, ans, 0);
		System.out.println(fans);

	}

	public static HashSet<ArrayList<Integer>> map = new HashSet();

	public static void solve(int[] arr, int sum, ArrayList<ArrayList<Integer>> fans, ArrayList<Integer> ans,
			int lastcoinused) {

		if (sum < 0) {
			return;
		}
		if (sum == 0) {
			if (!map.contains(ans)) {
				fans.add(new ArrayList<Integer>(ans));
				map.add(new ArrayList<Integer>(ans));
			}
			return;
		}

		for (int i = lastcoinused; i < arr.length; i++) {
			ans.add(arr[i]);
			solve(arr, sum - arr[i], fans, ans, i);
			ans.remove(ans.size() - 1);
		}
	}

}
