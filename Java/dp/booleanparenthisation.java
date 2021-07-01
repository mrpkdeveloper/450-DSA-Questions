package dp;

public class booleanparenthisation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "TFFTFFFTTTTFTFFTTF";
//		String s2 = "|^&|^^^|&^|^^&^|^";

		String S = "T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T";
		String s1 = "";
		String s2 = "";
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'T' || S.charAt(i) == 'F') {
				s1 += S.charAt(i);
			} else {
				s2 += S.charAt(i);
			}
		}
//		System.out.println(s1);
//		System.out.println(s2);

		solvedp(s1, s2);

	}

	public static void solvedp(String s1, String s2) {

		int[][] dpt = new int[s1.length()][s1.length()];
		int[][] dpf = new int[s1.length()][s1.length()];
		int mod = 1003;

		for (int g = 0; g < dpf.length; g++) {
			for (int i = 0, j = g; j < dpf[0].length; j++, i++) {
				if (g == 0) {
					if (s1.charAt(i) == 'T') {
						dpt[i][j] = 1;
					} else {
						dpf[i][j] = 1;
					}
				} else {
					for (int k = i; k < j; k++) {
						char oprt = s2.charAt(k);
						int ltc = dpt[i][k];
						int rtc = dpt[k + 1][j];
						int lfc = dpf[i][k];
						int rfc = dpf[k + 1][j];

						if (oprt == '|') {
							dpt[i][j] += (ltc * rtc + ltc * rfc + lfc * rtc) % mod;
							dpf[i][j] += (lfc * rfc) % mod;
						} else if (oprt == '&') {
							dpt[i][j] += (ltc * rtc) % mod;
							dpf[i][j] += (lfc * rfc + ltc * rfc + lfc * rtc) % mod;
						} else {
							dpt[i][j] += (ltc * rfc + lfc * rtc) % mod;
							dpf[i][j] += (ltc * rtc + lfc * rfc) % mod;
						}
					}
				}
			}
		}

//		for (int i = 0; i < dpf.length; i++) {
//			for (int j = 0; j < dpf.length; j++) {
//				System.out.print(dpt[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(dpt[0][s1.length() - 1] % mod);
	}

}
