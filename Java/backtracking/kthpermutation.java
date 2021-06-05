package backtracking;

import java.util.ArrayList;

public class kthpermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int k = 2;
		String s = "";
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			s += i;
			arr.add(i);
		}

		solve(s, "", k);
		solveopti(arr, k);

	}

	public static int c = 0;

	// O(n!) -> time not efficient
	public static void solve(String s, String ans, int k) {
		if (s.length() == 0) {
			c++;
			if (c == k)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String res = s.substring(0, i) + s.substring(i + 1);
			solve(res, ans + ch, k);
		}

	}

	public static void solveopti(ArrayList<Integer> arr, int k) {

		int[] fact = new int[10];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i - 1] * i;
//			System.out.println(fact[i]);
		}

		// 0 based indexing
		k = k - 1;
		String ans = "";
		while (true) {
			int bs = fact[arr.size() - 1]; // block size
			int fni = k / bs; // first no index
			int fn = arr.get(fni); // first no
			ans += fn;
			arr.remove(fni);
			if (arr.size() == 0) {
				break;
			}
			k = k % bs; // update k and find kth permutation in block
		}

		System.out.println(ans);
	}

}
