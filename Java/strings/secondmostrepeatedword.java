package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class secondmostrepeatedword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };
		repeat(arr);

	}

	public static void repeat(String[] arr) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.replace(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		int max = 0, secondmax = 0;
		String maxstring = "", secondmaxstring = "";
		for (Map.Entry<String, Integer> item : map.entrySet()) {
			if (item.getValue() > max) {
				secondmax = max;
				secondmaxstring = maxstring;
				max = item.getValue();
				maxstring = item.getKey();
			} else if (item.getValue() > secondmax && item.getValue() != max) {
				secondmax = item.getValue();
				secondmaxstring = item.getKey();
			}
		}
		System.out.println(secondmaxstring);

	}

}
