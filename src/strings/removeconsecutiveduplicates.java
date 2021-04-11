package strings;

public class removeconsecutiveduplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeduplicates("aacbbc"));

	}

	public static String removeduplicates(String s) {

		if (s.length() == 0) {
			return "";
		}

		int i = 0;
		while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
			i++;
		}
		String ros = s.substring(i + 1);
		String ans = s.charAt(i) + removeduplicates(ros);
		return ans;
	}

}
