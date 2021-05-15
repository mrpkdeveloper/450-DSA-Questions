package array;

public class buysellstock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 1, 5, 3, 6, 4 };
//		int[] arr = { 7, 6, 4, 3, 1 };
		maximiseprofit(arr);

	}

	public static void maximiseprofit(int[] arr) {
		int minprice = 0;
		int maxprice = 0;
		minprice = arr[0];
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= minprice) {
				minprice = arr[i];
			} else if (arr[i] - minprice >= profit) {
				profit = arr[i] - minprice;
			}

		}

		System.out.println(profit);
	}

}
