package backtracking;

public class knighttour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[8][8];
		tour(grid, 0, 0, 0);

	}

	public static boolean tour(int[][] grid, int i, int j, int count) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] > 0) {
			return false;
		} else if (count == grid.length * grid.length - 1) {
			System.out.println("hello");
			grid[i][j] = count;
			for (int k = 0; k < grid.length; k++) {
				for (int k2 = 0; k2 < grid[0].length; k2++) {
					System.out.print(grid[k][k2] + " ");
				}
				System.out.println();
			}
//			grid[i][j] = 0;
			return true;
		}

//		int[] rx = { -1, 1, 2, 2, 1, -1, -2, -2 };
//		int[] ry = { 2, 2, 1, -1, -2, -2, -1, 1 };
		// different call order can alter time complexity
		int rx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int ry[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		grid[i][j] = count;
		for (int k = 0; k < 8; k++) {
			if (tour(grid, i + rx[k], j + ry[k], count + 1)) {
				return true;
			}
		}
		grid[i][j] = 0;
		return false;
	}

}
