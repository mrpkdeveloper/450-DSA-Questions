package array;

import java.util.HashMap;
import java.util.Map;

public class elementsappearktimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 1, 2, 2, 1, 2, 3, 3 };
		ktimes(arr, 4);

	}

	public static void ktimes(int[] arr, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Map.Entry m : map.entrySet()) {
			int value = (int) m.getValue();
			if (value > (arr.length / k)) {
				System.out.println(m.getKey());
			}

		}

	}

}
