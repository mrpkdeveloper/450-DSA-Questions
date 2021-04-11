package strings;

public class rabbinkarp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "AABAACAADAABAABA";
//		String pat = "AABA";
		String s = "ababcaababcaabc";
		String pat = "ababcaabc";
//		detectpattern(s, pat);
		rabinkarp(s, pat);

	}

	// brute force O(n*m)
	public static void detectpattern(String s, String pat) {
		int i = 0, j = 0, k = 0;
		while (i < s.length() && j < s.length()) {
			while (k < pat.length() && j < s.length() && s.charAt(j) == pat.charAt(k)) {
				j++;
				k++;
			}
			if (k == pat.length()) {
				System.out.println("Pattern found at index " + i);
			}
			i++;
			j = i;
			k = 0;
		}
	}

	// Rabbin Karp algo
	// O(n+m) -avg
	// O(n*M) -worst (when string contains pattern only)
	public static void rabinkarp(String s, String pat) {  

		long pathash = hashfunction(pat, pat.length());
		long stringhash = hashfunction(s, pat.length());
		for (int i = 0; i <= s.length() - pat.length(); i++) {
			if (pathash == stringhash) {
				if (checkpat(pat, s, i, i + pat.length() - 1)) {
					System.out.println("Pattern found at index " + i);
				}
			} else if (i < s.length() - pat.length()) {
				stringhash = rollinghashfunction(pat, i + pat.length(), i, s, stringhash);
			}
		}

	}

	public static int prime = 7;

	public static long hashfunction(String pat, int patlength) {
		long result = 0;
		for (int i = 0; i < patlength; i++) {
			result += (long) ((long) pat.charAt(i) * (long) Math.pow(prime, i));
		}
		return result;
	}

	public static long rollinghashfunction(String pat, int newindex, int oldindex, String s, long oldhash) {
		long newhash = oldhash - s.charAt(oldindex);
		newhash /= prime;
		newhash += (long) (s.charAt(newindex) * (long) (Math.pow(prime, pat.length() - 1)));
		return newhash;
	}

	public static boolean checkpat(String pat, String s, int start, int end) {
		int k = 0;
		while (k < pat.length() && start <= end) {
			if (s.charAt(start) != pat.charAt(k)) {
				return false;
			} else {
				k++;
				start++;
			}
		}
		return true;
	}

}
