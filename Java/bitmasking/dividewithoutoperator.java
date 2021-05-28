package bitmasking;

public class dividewithoutoperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		division1(10, 3);

	}

	// method -1 subtraction a/b
	public static void division1(int a, int b) {

		int q = 0;
		while (a >= b) {
			a = a - b;
			q++;
		}

		// quotient
		System.out.println(q);
		// remainder
		System.out.println(a);
	}
	
	

}
