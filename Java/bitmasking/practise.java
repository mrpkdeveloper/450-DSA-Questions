package bitmasking;

public class practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 13, j = 60;
		i ^= j;
		j ^= i;
		i ^= j;
//		System.out.println(i + " " + j);

		int val = 1;
		do {
			val++;
			++val;
		} while (val++ > 25);

		System.out.println(val);
	}

}
