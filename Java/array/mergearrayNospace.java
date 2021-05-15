package array;

import java.util.Arrays;

public class mergearrayNospace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 5, 18, 20 };
		int[] arr2 = { 10, 12 };
//		merge(arr1, arr2);
		mergearray(arr1, arr2);

	}

	// O(N^2)
	public static void merge(int[] arr1, int[] arr2) {

		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i++;
				sort(arr2);
			} else {
				i++;
			}
		}

		for (int k = 0; k < arr1.length; k++) {
			System.out.println(arr1[k]);
		}
		for (int k = 0; k < arr2.length; k++) {
			System.out.println(arr2[k]);
		}

	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}

	// time- O((n+m)log(n+m))
	public static void mergearray(int[] arr1, int[] arr2) {

		int i = arr1.length - 1, j = 0;
		while (i >= 0 && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i--;
				j++;
			} else {
				break;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int j2 = 0; j2 < arr1.length; j2++) {
			System.out.println(arr1[j2]);
		}
		System.out.println();
		for (int j2 = 0; j2 < arr2.length; j2++) {
			System.out.println(arr2[j2]);
		}

	}

}
