package mattrix;

import java.util.Arrays;

public class median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] m = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
//		int[][] m = { { 1 }, { 2 }, { 3 } };
		int[][] m = {{2 ,2 ,6 ,11, 11 ,11 ,14, 19 ,19},
				     {2 ,8 ,12 ,13 ,14 ,15 ,16 ,17 ,19},
				     {1, 2 ,5 ,6 ,12 ,13 ,18 ,20 ,20 },
				     {5,5 ,10, 11, 12, 15, 17 ,17, 20},
				     {4 ,5 ,6, 9 ,9 ,11 ,12 ,17 ,17 },
				     {2 ,4 ,6 ,10 ,12 ,14 ,18 ,18 ,19},
				     {3 ,3 ,8, 8 ,11 ,13 ,14 ,15 ,18},
				     {4,7 ,10 ,15 ,16 ,17 ,18 ,19 ,20},
				     {1,1 ,2 ,10 ,11 ,12 ,16 ,17 ,19},
				     {1,1,2 ,5 ,9 ,10, 12, 16, 18},
				     {4,6,7,8 ,13, 14, 15, 15, 18}};

//		System.out.println(median(m));
		print(m);

	}
	
	public static void print(int[][] m) {
		int[] arr = new int[m.length*m[0].length];
		int k=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				arr[k++]=m[i][j];
			}
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {			
			System.out.println(i+" -- "+arr[i]);
		}
	}

	public static int median(int[][] m) {
		int k = (m.length * m[0].length +1)/ 2;

		int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
		for (int i = 0; i < m.length; i++) {

			if (lo > m[i][0]) {
				lo = m[i][0];
			}

			if (hi < m[i][m[0].length - 1]) {
				hi = m[i][m[0].length - 1];
			}

		}

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int j = m[0].length - 1;
			int count = 0;
			// count is no of elements smaller than mid in matrix
			for (int i = 0; i < m.length; ++i) {
				while (j >= 0 && m[i][j] > mid)
					--j;
				count += (j + 1);
			}

			
			if (count < k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}

		return lo;

	}

}
