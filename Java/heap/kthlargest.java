package heap;

public class kthlargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 1, 4, 6, 2 };
		int k = 5;
//		largest(arr, k);
		kthlargest(arr, k);

	}

	// O(nlogk) - > time
	public static void largest(int[] arr, int k) {
		// create min heap
		minheap heap = new minheap();
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				heap.add(arr[i]);
			} else if (heap.heap.get(0) < arr[i]) {
				heap.remove();
				heap.add(arr[i]);
			}
		}
		System.out.println(heap.remove());
	}

	// more effecient approach
	// o(n) - > avg time
	// o(n2) -> worst
	public static void kthlargest(int[] arr, int k) {

		int pi = partitioning(arr, 0, arr.length - 1);
		int ogi = arr.length - k;

		while (pi != ogi) {
			if (pi < ogi) {
				pi = partitioning(arr, pi + 1, arr.length - 1);
			} else {
				pi = partitioning(arr, 0, pi - 1);
			}
		}
		System.out.println(arr[pi]);

	}

	// 0 - i-1 -> <=pivot
	// i - j-1 -> >pivot
	// j - end -> unknown
	public static int partitioning(int[] arr, int st, int en) {
		int i = 0, j = 0, p = arr[en];
		while (j <= en) {
			if (arr[j] > p) {
				j++;
			} else {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j++;
			}
		}
		return i - 1;
	}

}
