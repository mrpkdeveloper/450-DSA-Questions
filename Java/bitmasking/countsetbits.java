package bitmasking;

public class countsetbits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(setBits2(7));
		System.out.println(7 & 6);

	}

	static int setBits(int n) {
		int c = 0;
		while (n != 0) {
			c += n & 1;
			n = n >> 1;
		}
		return c;
	}

	static int setBits2(int n) {
		int c = 0;
		while (n != 0) {
			c++;
			n = n & (n - 1);
		}
		return c;
	}

}
