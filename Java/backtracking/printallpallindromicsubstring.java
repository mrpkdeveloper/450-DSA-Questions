package backtracking;

public class printallpallindromicsubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "nittin";
		print(s, "");

	}

	public static void print(String s, String ans) {

		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i + 1);
			if (check(prefix)) {
				String res = s.substring(i + 1);
				print(res, ans + prefix + " ");
			}
		}

	}

	private static boolean check(String prefix) {
		// TODO Auto-generated method stub
		if (prefix.length() == 1) {
			return true;
		}
		int i = 0, j = prefix.length() - 1;
		while (i < j) {
			if (prefix.charAt(i) != prefix.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

}
