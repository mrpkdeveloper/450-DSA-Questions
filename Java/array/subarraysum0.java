package array;

import java.util.*;

public class subarraysum0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 4, 2, -3, 1, 6 };
		int[] arr = { 10, -10 };
//		int[] arr = { 4, 2, 0, 1, 6 };
//		int[] arr = { 4, 5, -4, -2, 1 };
//		int[] arr = { 36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17,
//				-21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19 };

		System.out.println(subarraysum(arr));

	}

	public static boolean subarraysum(int[] arr) {
		Set<Integer> temp = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			temp.add(sum);
			sum += arr[i];
			System.out.println(temp);
			if (temp.contains(sum)) {
				return true;
			}
		}
		return false;

	}

}
