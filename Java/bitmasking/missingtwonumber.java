package bitmasking;

public class missingtwonumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 4, 3 };
		missingno(5, arr);

	}

	public static void missingno(int n, int[] arr) {

		int z = 1;
		for (int i = 2; i <= n; i++) {
			z = z ^ i;
		}

		for (int i = 0; i < arr.length; i++) {
			z = z ^ arr[i];
		}

		// now z contains xor of two missing no
//		System.out.println(z);

		int rightmostsetbit = z & ~(z - 1);

		int set = 0, reset = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & rightmostsetbit) != 0) {
				set = set ^ i;
			} else {
				reset = reset ^ i;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightmostsetbit) != 0) {
				set = set ^ arr[i];
			} else {
				reset = reset ^ arr[i];
			}
		}

		System.out.println("missing no are -> " + set + " , " + reset);

	}

}
