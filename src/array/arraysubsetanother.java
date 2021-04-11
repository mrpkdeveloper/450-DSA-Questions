package array;

import java.util.HashSet;

public class arraysubsetanother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 8, 4, 5, 3, 1, 7, 9 };
		int[] arr2 = { 5, 1, 3, 7, 9 };
		subset(arr1, arr2);

	}

	public static void subset(int[] arr1, int[] arr2) {

		HashSet<Integer> map = new HashSet<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			map.add(arr1[i]);
		}
		boolean flag = true;
		for (int i = 0; i < arr2.length; i++) {
			if (!map.contains(arr2[i])) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
