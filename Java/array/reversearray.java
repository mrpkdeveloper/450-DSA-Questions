package array;

public class reversearray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		reverse(arr);

	}

	public static void reverse(int[] arr) {
		int last = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = last;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
