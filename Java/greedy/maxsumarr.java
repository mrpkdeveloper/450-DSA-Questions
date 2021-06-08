package greedy;

import java.util.Arrays;

public class maxsumarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int Maximize(int arr[], int n) {
		int mod = (int) (Math.pow(10, 9) + 7);
		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + (long) arr[i] * i) % mod;
		}
		return (int) sum;

	}

}
