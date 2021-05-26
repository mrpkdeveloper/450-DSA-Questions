package searchingandsorting;

import java.util.Arrays;

public class findpairwithgivendiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(nlogn) -> time
	public boolean findPair(int arr[], int size, int n) {
		// code here.
		Arrays.sort(arr);
		int i = 0, j = 1;
		while (i < arr.length && j < arr.length) {
			if (arr[j] - arr[i] == n) {
				return true;
			} else if (arr[j] - arr[i] < n) {
				j++;
			} else {
				i++;
			}
		}

		return false;
	}

}
