package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sumtriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		sumtriplet(arr, 13);

	}

	// time - O(n^2) space-O(n)
	public static void sumtriplet(int[] arr, int sum) {

		int not = 0;
		for (int i = 0; i < arr.length; i++) {

			int nowsum = sum - arr[i], nop = 0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int j = i + 1; j < arr.length; j++) {
				if (map.containsKey(arr[j])) {
					map.put(arr[j], map.get(arr[j]) + 1);
				} else {
					map.put(arr[j], 1);
				}
			}

			for (int j = i + 1; j < arr.length; j++) {
				if (map.containsKey(nowsum - arr[j])) {
					nop += map.get(arr[j]);
				}
				if (nowsum - arr[j] == arr[j]) {
					nop--;
				}
			}
			nop = nop / 2;
			if (nop > 0) {
				not += nop;
			}

		}
		System.out.println(not);
	}

	// time - O(n^2) space-O(1)
	public static boolean sumtripletoptrimised(int[] arr, int sum) {

		int not = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1, k = arr.length - 1;
			int nowsum = sum - arr[i];
			while (j < k) {
				if (nowsum < arr[j] + arr[k]) {
					k--;
				} else if (nowsum > arr[j] + arr[k]) {
					j++;
				} else {
					return true;
				}
			}

		}
		return false;
	}
}
