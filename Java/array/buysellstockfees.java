package array;

public class buysellstockfees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
		buysell(arr, 3);

	}

	// bs-> bought state profit
	// ss-> sell state profit
	public static void buysell(int[] arr, int fees) {
		int bs = -arr[0], ss = 0;
		System.out.println("  " + bs + " ---- " + ss);
		for (int i = 1; i < arr.length; i++) {
			int temp = bs;
			if (bs < (ss - arr[i])) {
				bs = ss - arr[i];
			}
			if (ss < arr[i] + temp - fees) {
				ss = arr[i] + temp - fees;
			}
			System.out.println("  " + bs + " ---- " + ss);
		}

		System.out.println(ss);
	}

}
