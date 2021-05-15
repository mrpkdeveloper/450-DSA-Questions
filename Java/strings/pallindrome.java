package strings;

public class pallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int pallindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return 0;
			} else {
				i++;
				j--;
			}
		}
		return 1;

	}

}
