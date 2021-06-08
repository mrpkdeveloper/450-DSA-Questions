package bitmasking;

public class printsubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4 };
		subsets(arr);

	}

	public static void subsets(int[] arr) {
		int limit = (int) (1 << arr.length);
		for (int i = 0; i < limit; i++) {
			String set = "";
			int temp = i;
			for (int j = arr.length - 1; j >= 0; j--) {
				if ((temp & 1) == 1) {
					set = arr[j] + set;
				} else {
					set = " _ " + set;
				}
				temp = temp >> 1;
			}
			System.out.println(set);
		}

	}

}
