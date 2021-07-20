package misclaneous;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largestnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	class Sort implements Comparator<Integer> {
		// Used for sorting in ascending order of
		// roll number

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			String a = "" + o1 + o2;
			String b = "" + o2 + o1;
			return a.compareTo(b);
		}
	}

	public String largestNumber(List<Integer> A) {
		Integer[] arr = new Integer[A.size()];
		for (int i = 0; i < A.size(); i++) {
			arr[i] = A.get(i);
		}


		Arrays.parallelSort(arr, new Sort());

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < A.size(); i++) {
			ans.append(arr[i]);
		}

		if (ans.charAt(0) == '0')
			return "0";
		return ans.toString();

	}

}
