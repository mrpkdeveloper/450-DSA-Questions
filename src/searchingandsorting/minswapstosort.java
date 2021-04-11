package searchingandsorting;

import java.util.Map;
import java.util.TreeMap;

public class minswapstosort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 4, 3, 2 };
		minswaps(arr);

	}

	static Map<Integer, Integer> map = new TreeMap<>();

	public static void minswaps(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		System.out.println(map);
		int i = 0,minswap=0;
		

	}

}
