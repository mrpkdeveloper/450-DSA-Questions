package array;

import java.util.PriorityQueue;

public class kthmaxmin {

//use sorting or mean max heap O(nlogn)
//partition method best O(n)	
// also known as quick select

//fail for duplicates

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 8, 3, 7, 2, 6, 9, 5, 4, 21 };
		int k = 4;
		k--;// 0 based indexing
		// pass last element as pivot
		int p = partition(arr, 0, arr.length - 1, arr[arr.length - 1]);
		while (p != k) {
			if (p > k) {
				p = partition(arr, 0, p - 1, arr[p - 1]);
			} else if (p < k) {
				p = partition(arr, p + 1, arr.length - 1, arr[arr.length - 1]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("kth smallest - > " + arr[p]);

		quicksort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	// 0 - i-1 < p
	// i - j-1 >=p
	// j - end --> unknown

	public static int partition(int[] arr, int start, int end, int pivot) {
		int i = start, j = start;
		// we have to check for unknown area
		while (j <= end) {
			if (arr[j] > pivot) {
				j++;
			} else {
				// swap i and j values
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
		}

		return i - 1;
	}

	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int p = partition(arr, start, end, arr[end]);
		quicksort(arr, start, p - 1);
		quicksort(arr, p + 1, end);
	}

	// this is the other efficient method using priority queue
	// adding elements in pq. After adding Kth element, start removing 1 element
	// from pq before adding (k+1)th element
	// by this we will get pq containing k largest elements of array.. Then return
	// the peek value of pq
	// By Shubham Aggarwal @shubham242k
	public static int KthMaximum(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < a.length; i++) {
			if (i < k) {
				pq.add(a[i]);
			} else {
				if (a[i] > pq.peek()) {
					pq.remove();
					pq.add(a[i]);
				}
			}

		}

		return pq.peek();

	}

}
