package strings;

public class mininsertionfrontpalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(palindrome("abc"));
//		System.out.println(palindrome("AACECAAAA"));
//		System.out.println(palindrome("namand"));
		palinromeoptimised("abc");

	}

	// O(n2)->time
	public static int palindrome(String s) {
		int j = s.length() - 1;
		while (j > 0) {
			if (checkpalindrome(s, j)) {
				return s.length() - j - 1;
			} else {
				j--;
			}

		}

		return s.length() - 1;

	}

	public static boolean checkpalindrome(String s, int j) {
		int i = 0;
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				j--;
				i++;
			}
		}
		return true;
	}

	public static void palinromeoptimised(String s) {
		String temp = s + "@";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i);
		}
		System.out.println(temp);

		int[] pitable = new int[temp.length() + 1];
		int i = 0, j = -1;
		pitable[0] = -1;
		while (i < temp.length()) {
			while (j >= 0 && temp.charAt(i) != temp.charAt(j)) {
				j = pitable[j];
			}
			i++;
			j++;
			pitable[i] = j;

		}

		for (int k = 0; k < pitable.length; k++) {
			System.out.println(pitable[k]);
		}
		System.out.println(s);
		System.out.println("ans " + (s.length() - pitable[temp.length()]));

	}

}
