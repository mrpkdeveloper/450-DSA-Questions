package greedy;

import java.util.Arrays;

public class smallestsubsetwithgrtrsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 1, 1, 1, 1 };
		sum(arr);

	}

	public static void sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		Arrays.parallelSort(arr);
		int l = 0, subsetsum = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (subsetsum <= sum / 2) {
				subsetsum += arr[i];
				l++;
			} else {
				break;
			}
		}

		System.out.println(subsetsum + " " + l);

	}

}
