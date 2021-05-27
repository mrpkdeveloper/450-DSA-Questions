package searchingandsorting;

public class maxsumnoadjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n) -> time
	public int FindMaxSum(int arr[], int n) {
		int exc = 0, inc = arr[0];
		for (int i = 1; i < n; i++) {
			int temp = inc;
			// if current is included
			inc = exc + arr[i];
			// if curr is excluded
			exc = Math.max(temp, exc);
		}
		return Math.max(inc, exc);

	}

}
