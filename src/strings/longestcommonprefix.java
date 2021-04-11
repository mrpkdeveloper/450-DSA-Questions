package strings;

public class longestcommonprefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "flower", "flow", "flight" };
		System.out.println(prefix(arr));
	}

	public static String prefix(String[] arr) {
		if (arr.length == 0 || arr == null) {
			return "";
		}
		if (arr.length == 1) {
			return arr[0];
		}
		String temp = arr[0];
		String longest = temp;
		for (int i = 1; i < arr.length; i++) {
			String prefix = checkprefixoptimised(temp, arr[i]);
			if (longest.length() > prefix.length()) {
				longest = prefix;
			}
		}

		return longest;

	}

	public static String checkprefix(String s1, String s2) {

		int i = 0, j = 0;
		String prefix = "";
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				break;
			} else {
				prefix += s1.charAt(j);
			}
			i++;
			j++;
		}
		return prefix;

	}

	// since addingh character to a string copies whole string again
	// it inc time complexities
	// so try to avoid adding characters to string
	public static String checkprefixoptimised(String s1, String s2) {

		int i = 0, j = 0;
		String prefix = "";
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				break;
			}
			i++;
			j++;
		}
		prefix = s1.substring(0, j);
		return prefix;

	}

}
