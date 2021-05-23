package bitmasking;

public class countnoofflipbits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countBitsFlip(int a, int b) {

		int z = a ^ b;
		int c = 0;
		while (z != 0) {
			c++;
			z = z & (z - 1);
		}

		return c;
	}
}
