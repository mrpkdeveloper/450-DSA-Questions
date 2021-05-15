package strings;

public class checkshuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkshuffle("xy", "12", "2xy1"));

	}

	public static boolean checkshuffle(String s1, String s2, String res) {
		int i = 0, j = 0, k = 0;
		while (k < res.length()) {
			if (i < s1.length() && s1.charAt(i) == res.charAt(k)) {
				k++;
				i++;
			} else if (j < s2.length() && s2.charAt(j) == res.charAt(k)) {
				j++;
				k++;
			} else {
				return false;
			}
		}

		return true;
	}

}
