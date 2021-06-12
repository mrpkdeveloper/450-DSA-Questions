package greedy;

public class smallestnowithgivensum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s = 36, d = 4;
		solve(s, d, "");
		System.out.println(solve2(s, d));

	}

	// brute force
	public static boolean solve(int s, int d, String ans) {
		if (d == 0) {
			if (s == 0 && ans.charAt(0) != '0') {
				System.out.println(ans);
				return true;
			}
			return false;
		}

		for (int i = 9; i >= 0; i--) {
			if (s >= i) {
				if (solve(s - i, d - 1, i + ans)) {
					return true;
				}
			}
		}

		return false;
	}

	// optimised O(d) -> time complexity
	public static String solve2(int s, int d) {
		String ans = "";
		if (9 * d < s) {
			return "-1";
		}

		for (int i = d; i > 0; i--) {
			if (s > 9) {
				ans = "9" + ans;
				s = s - 9;
			} else {
				if (i == 1) {
					ans = s + ans;
					return ans;
				} else {
					ans = (s - 1) + ans;
					i--;
					while (i > 1) {
						ans = "0" + ans;
						i--;
					}
					ans = "1" + ans;
					return ans;
				}
			}
		}

		return ans;

	}

}
