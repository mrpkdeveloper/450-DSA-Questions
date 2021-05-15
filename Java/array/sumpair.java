package array;

import java.util.HashMap;
import java.util.Map;

public class sumpair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 1, 4, 3 };
		sumpair(arr, 6);

	}

	public static void sumpair(int[] arr, int k) {
		Map<Integer, Integer> temp = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (temp.containsKey(arr[i])) {
				temp.put(arr[i], temp.get(arr[i]) + 1);
			} else {
				temp.put(arr[i], 1);
			}
		}
		int sumpair = 0;
		for (int i = 0; i < arr.length; i++) {
			if (temp.containsKey(k - arr[i])) {
				sumpair += temp.get(k - arr[i]);
			}
			if (k - arr[i] == arr[i]) {
				sumpair--;
			}
		}

		System.out.println(sumpair / 2);
	}

}
