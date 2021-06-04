package backtracking;

public class largestnoinkswap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "4551711527";
		int k = 3;
//		7755511124 -> correct
		char[] arr = s.toCharArray();
		max = s;
		swap(arr, k, 0);
		System.out.println(max);

	}

//wrong
//	public static void swap(String s, int k) {
//		char[] arr = s.toCharArray();
//		int noswap = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (noswap == k) {
//				break;
//			}
//			int max = i;
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[max] <= arr[j]) {
//					max = j;
//				}
//			}
//			char temp = arr[i];
//			arr[i] = arr[max];
//			arr[max] = temp;
//			noswap++;
//		}
//		String ans = String.valueOf(arr);
//		System.out.println(ans);
//
//	}
	public static String max;

	public static void swap(char[] arr, int k, int noswap) {
		String s = String.valueOf(arr);
		if (s.compareTo(max) > 0) {
			max = s;
		}

		if (noswap == k) {
			return;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					swap(arr, k, noswap + 1);
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

}
