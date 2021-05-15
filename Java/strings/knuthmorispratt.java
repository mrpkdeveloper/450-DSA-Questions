package strings;

public class knuthmorispratt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		pitable("aaaa");
		pitable("aaaabaacd");
		String s = "ababcaababcaabc";
		String pat = "ababcaabc";
//		kmp(s, pat);

	}

	public static void kmp(String s, String pat) {
		int[] pitable = pitable(pat);
		int i = 0, j = 0;
		while (i < s.length()) {
			while (j >= 0 && s.charAt(i) != pat.charAt(j)) {
				j = pitable[j];
			}
			i++;
			j++;
			if (j == pat.length()) {
				System.out.println("Patern is found at " + (i - j));
				j = pitable[j];
			}
		}
	}

	public static int[] pitable(String pat) {
		int[] pitable = new int[pat.length() + 1];
		int i = 0, j = -1;
		pitable[0] = -1;
		while (i < pat.length()) {
			while (j >= 0 && pat.charAt(i) != pat.charAt(j)) {
				j = pitable[j];
			}
			i++;
			j++;
			pitable[i] = j;

		}

		for (int k = 0; k < pitable.length; k++) {
			System.out.println(pitable[k]);
		}

		return pitable;

	}

}
