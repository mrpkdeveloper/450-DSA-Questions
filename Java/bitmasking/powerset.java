package bitmasking;

public class powerset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subset("abc", "");

	}

	public static void subset(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = s.charAt(0);
		String ros = s.substring(1);
		subset(ros, ans);
		subset(ros, ans + ch);
	}

}
