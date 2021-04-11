package strings;

public class rotationstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcd";
		String s2 = "cdab";
		rotations(s1, s2);

	}

	public static void rotations(String s1, String s2) {

		String temp = s1.concat(s1);
		if (temp.contains(s2)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

}
