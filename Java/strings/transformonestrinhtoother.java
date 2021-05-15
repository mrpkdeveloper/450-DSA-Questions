package strings;

public class transformonestrinhtoother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "EACBD";
		String s2 = "ABCDE";
		transform(s1, s2);

	}

	public static void transform(String s1, String s2) {

		int i = s1.length() - 1, j = s2.length() - 1;
		int res = 0;
		while (i >= 0 && j >= 0) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i--;
				j--;
			} else {
				res++;
				i--;
			}
		}
		System.out.println(res);
	}

}
