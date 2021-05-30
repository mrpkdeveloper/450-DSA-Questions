package searchingandsorting;

import java.util.ArrayList;
import java.util.HashMap;

public class countsubarraywithzerosum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		findSubarrayprint(arr, arr.length);
		System.out.println(findSubarray(arr, arr.length));

	}

	public static long findSubarray(int[] arr, int n) {
		int i = -1, sum = 0, count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(sum, 1);
		while (i < n - 1) {
			i++;
			sum += arr[i];
			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.replace(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return count;
	}

	public static void findSubarrayprint(int[] arr, int n) {
		int i = -1, sum = 0, count = 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(i);
		map.put(sum, list);
		while (i < n - 1) {
			i++;
			sum += arr[i];
			if (map.containsKey(sum)) {
				ArrayList<Integer> l = map.get(sum);
				for (Integer idx : l) {
					System.out.println(idx + 1 + " - " + i);
				}
				l.add(i);
				map.replace(sum, l);
			} else {
				ArrayList<Integer> list1 = new ArrayList<>();
				list1.add(i);
				map.put(sum, list1);
			}
		}

//		return count;
	}

}
