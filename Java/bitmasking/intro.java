package bitmasking;

public class intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(extractbit(4, 1));
		System.out.println(setbit(4, 2));
		System.out.println(resetbit(4, 3));

		System.out.println(rightmostsetbit(4));

		System.out.println(addone(102));

		System.out.println(magicnumber5(5));

		System.out.println(poweroftwo(8));

	}

	public static int extractbit(int n, int i) {
		int mask = 1 << (i - 1);
		return ((n & mask) == 0 ? 0 : 1);
	}

	public static int setbit(int n, int i) {
		int mask = 1 << (i - 1);
		return (n | mask);
	}

	public static int resetbit(int n, int i) {
		int mask = ~(1 << (i - 1));
		return (n & mask);
	}

	public static int rightmostsetbit(int n) {

		int i = 0;
		int mask = (1 << i);
		while ((n & mask) == 0) {
			i++;
			mask = (1 << i);
		}
		return i + 1;

	}

	public static int addone(int n) {
		int mask = 1;
		while ((n & mask) != 0) {
			n = n ^ mask;
			mask = mask << 1;
		}
		n = n ^ mask;
		return n;
	}

	public static int magicnumber5(int i) {
		int pow = 1, sum = 0;
		while (i != 0) {
			pow *= 5;
			if ((i & 1) == 1) {
				sum += pow;
			}
			i = i >> 1;
		}
		return sum;
	}

	public static boolean poweroftwo(int n) {
		if (n == 0) {
			return false;
		}
		return ((n & (n - 1)) == 0 ? true : false);
	}

}
