package misclaneous;

public class powerfunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 71045970;
		int n = 41535484;
		int d = 64735492;
//		int x = -1;
//		int n = 1;
//		int d = 20;
		System.out.println(pow(x, n, d));

	}

	public static int pow(int x, int n, int d) {
		if (x == 0 && n == 0) {
			return 0;
		}
		long ans = 1, base = x;
		while (n > 0) {
			if (n % 2 == 0) {
				base = (base * base) % d;
				n = n / 2;
			} else {
				ans = (ans * base) % d;
				n--;
			}
		}
		if (ans < 0) {
			long fans = ans * -1;
			long mod = fans % d;
			ans = d - mod;
			return (int) ans;
		}
		return (int) ans % d;
	}

}
