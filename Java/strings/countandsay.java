package strings;

public class countandsay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countandsay(4));

	}

	public static String countandsay(int n) {
		if (n == 1) {
			return "1";
		}

		String myans = countandsay(n - 1);
		int i = 0;
		StringBuilder finalans = new StringBuilder();
		while (i < myans.length()) {
			int count = 0;
			char c = myans.charAt(i);
			while (i < myans.length() && myans.charAt(i) == c) {
				i++;
				count++;
			}
			finalans.append(count);
			finalans.append(c);
		}
		return finalans.toString();

	}

}
