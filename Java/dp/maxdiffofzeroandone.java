package dp;

public class maxdiffofzeroandone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "11000010001";
		String s = "11111111";
		solve(s);
		solvedp(s);

	}

	// brute force
	public static void solve(String s) {

		int diff = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			int count0 = 0, count1 = 0;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j) == '0') {
					count0++;
				} else {
					count1++;
				}
				if (diff < count0 - count1) {
					diff = count0 - count1;
				}

				if (count1 == s.length()) {
					diff = -1;
					break;
				}
			}
		}
		System.out.println(diff);
	}

	// using kadanes algo
	// O(n) - > time
	public static void solvedp(String s) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = 0;
			if (s.charAt(i) == '0') {
				val = 1;
			} else {
				val = -1;
			}

			if (sum + val > val) {
				sum = sum + val;
			} else {
				sum = val;
			}

			if (max < sum) {
				max = sum;
			}

		}

		System.out.println(max);

	}

}
