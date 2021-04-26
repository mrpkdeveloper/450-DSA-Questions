package graphs;

import java.util.LinkedList;

public class minstepsKnight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] kpos = { 2, 2 };
//		int[] target = { 4, 2 };
//		int n = 5;
		int[] kpos = { 5, 0 };
		int[] target = { 1, 3 };
		int n = 7;
//		7
//		6 1
//		2 4
		minsteps(kpos, target, n);

	}

	public static void minsteps(int[] kpos, int[] target, int n) {

		int[][] vis = new int[n][n];
		int[][] ans = new int[n][n];
		LinkedList<int[]> queue = new LinkedList<>();
		int xpos = kpos[0];
		int ypos = kpos[1];
		int xt = target[0];
		int yt = target[1];
		int[] arr = new int[2];
		arr[0] = xpos;
		arr[1] = ypos;
		queue.addLast(arr);
		int[] cx = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] cy = { 2, 1, -1, -2, -2, -1, 1, 2 };
		while (!queue.isEmpty()) {

//			System.out.println("----------------------------");
//			for (int i = 0; i < ans.length; i++) {
//				for (int j = 0; j < ans.length; j++) {
//					System.out.print(ans[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("----------------------------");

			int[] rv = queue.removeFirst();
			if (rv[0] == xt && rv[1] == yt) {
				System.out.println(ans[xt][yt]);
				break;
			}
			if (vis[rv[0]][rv[1]] == 1) {
				continue;
			}
			vis[rv[0]][rv[1]] = 1;
			for (int i = 0; i < 8; i++) {
				int x = rv[0] + cx[i];
				int y = rv[1] + cy[i];
				if (x >= 0 && y >= 0 && x < n && y < n && vis[x][y] == 0) {
					int[] arr1 = new int[2];
					arr1[0] = x;
					arr1[1] = y;
					queue.addLast(arr1);
					ans[x][y] = ans[rv[0]][rv[1]] + 1;
				}
			}
		}
	}

}
