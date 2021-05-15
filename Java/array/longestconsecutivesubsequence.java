package array;

import java.util.HashMap;
import java.util.HashSet;

public class longestconsecutivesubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
//		int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
		LCS(arr);

	}

	public static void LCS(int[] arr) {

		HashSet<Integer> map = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.add(arr[i]);
		}

		int longest = 0;
		int start = 0, end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!map.contains(arr[i] - 1)) {
				int j = 1, l = 1;
				while (map.contains(arr[i] + j)) {
					l++;
					j++;
				}
				if (l >= longest) {
					longest = l;
					start = arr[i];
					end = arr[i] + l - 1;
				}
			}

		}

		System.out.println(longest);

		for (int i = start; i <= end; i++) {
			System.out.println(i);
		}

	}

}
