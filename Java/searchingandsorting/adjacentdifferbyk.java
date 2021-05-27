package searchingandsorting;

public class adjacentdifferbyk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 20, 40, 50, 70, 70, 60 };
		int k = 20;
		int x = 70;
		search(arr, k, x);

	}

	// can do simple linear search
	// this also works in O(n) -> time but optimised

	public static void search(int[] arr, int k, int x) {

		int i = 0;
		while (i < arr.length) {

			if (arr[i] == x) {
				System.out.println(i);
				break;
			}

			i += Math.max(1, Math.abs((arr[i] - x) / k));

		}

	}
}
