package searchingandsorting;

import java.util.ArrayList;
import java.util.Arrays;

public class foursum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n3) - > time O(1)-> space
	public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int K) {
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> fans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = K - arr[i] - arr[j];
				int k = j + 1, l = arr.length - 1;
				while (k < l) {
					if (sum == arr[k] + arr[l]) {
						ArrayList<Integer> ans = new ArrayList<>();
						ans.add(arr[i]);
						ans.add(arr[j]);
						ans.add(arr[k]);
						ans.add(arr[l]);
						fans.add(ans);

						// after that eliminate for duplicate
						while (k < l && arr[k] == ans.get(2))
							k++;
						while (k < l && arr[l] == ans.get(3))
							l--;
					} else if (sum > arr[k] + arr[l]) {
						k++;
					} else {
						l--;
					}
				}
				// after that eliminate for duplicate
				while (j + 1 < arr.length && arr[j] == arr[j + 1])
					j++;
			}
			// after that eliminate for duplicate
			while (i + 1 < arr.length && arr[i] == arr[i + 1])
				i++;
		}
		return fans;
	}

}
