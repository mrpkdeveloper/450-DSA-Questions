package misclaneous;

public class stringpallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ",.., ";
		System.out.println(isPalindrome(s));

	}

	public static int isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char a = Character.toLowerCase(s.charAt(i));
			char b = Character.toLowerCase(s.charAt(j));
			while (i < s.length() && !Character.isLetterOrDigit(a)) {
				i++;
				if (i < s.length())
					a = Character.toLowerCase(s.charAt(i));
			}
			while (j >= 0 && !Character.isLetterOrDigit(b)) {
				j--;
				if (j >= 0)
					b = Character.toLowerCase(s.charAt(j));
			}
			if (i > j) {
				break;
			}
			if (a != b) {
				return 0;
			} else {
				i++;
				j--;
			}
		}
		return 1;
	}

}
