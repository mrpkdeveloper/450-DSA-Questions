package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class combinationsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 6, 5, 5, 7, 1, 8, 2, 9, 9, 7, 7, 9 };
		int sum = 6;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			arr.add(a[i]);
		}
		HashSet<Integer> hs = new HashSet<Integer>(arr);
		arr = new ArrayList<Integer>(hs);
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> fans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		solve(arr, sum, fans, ans, 0);
		System.out.println(fans);

	}

	public static void solve(ArrayList<Integer> arr, int sum, ArrayList<ArrayList<Integer>> fans,
			ArrayList<Integer> ans, int lastcoinused) {

		if (sum < 0) {
			return;
		}
		if (sum == 0) {
			fans.add(new ArrayList<Integer>(ans));
//			fans.add(ans);
			return;
		}

		for (int i = lastcoinused; i < arr.size(); i++) {
			ans.add(arr.get(i));
			solve(arr, sum - arr.get(i), fans, ans, i);
			ans.remove(ans.size() - 1);
		}

	}

	// another approach
	public static void solve2(ArrayList<Integer> arr, int sum, ArrayList<ArrayList<Integer>> fans,
			ArrayList<Integer> ans, int i) {

		if (sum < 0 || i >= arr.size()) {
			return;
		}
		if (sum == 0) {
			fans.add(new ArrayList<Integer>(ans));
			return;
		}

		// coin used
		ans.add(arr.get(i));
		solve2(arr, sum - arr.get(i), fans, ans, i);
		ans.remove(ans.size() - 1);
		// coin not used
		solve2(arr, sum, fans, ans, i + 1);

	}

}
