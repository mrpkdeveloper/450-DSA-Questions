package strings;

public class knuthmorispratt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		pitable("aaaa");
//		pitable("aaaabaacd");
//		pitable("abcabca");
		String s = "ababcaababcaabc";
		String pat = "ababcaabc";
//		kmp(s, pat);

		String a1 = "00012";
		String a2 = "12";

		System.out.println(a1.compareTo(a2));

//		System.out.println("---------");
//		long a = Long.parseLong("");
//		System.out.println(a);

	}

	public static void kmp(String s, String pat) {
		int[] pitable = pitable(pat);
		int i = 0, j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = pitable[j - 1];
				} else {
					i++;
				}
			}
			if (j == pat.length()) {
				System.out.println("Patern is found at " + (i - j));
				break;
			}
		}
	}

	public static int[] pitable(String pat) {
		int[] pitable = new int[pat.length()];
		pitable[0] = 0;
		int i = 1;
		while (i < pitable.length) {
			// peche vala dekho ki match hota ke nahin
			// nahin hota to or peche jao
			int j = pitable[i - 1];
			while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
				j = pitable[j - 1];
			}

			// fir dekho ab apna ith char match hota ya nahin
			if (pat.charAt(i) == pat.charAt(j))
				j++;
			pitable[i] = j;
			i++;
		}

//		for (int k = 0; k < pitable.length; k++) {
//			System.out.println(pitable[k]);
//		}

		return pitable;

	}

}
