package backtracking;

public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (SolveSudoku(grid)) {
			printGrid(grid);
		}
	}

	static boolean SolveSudoku(int grid[][]) {
		return solve(grid, 0, 0);
	}

	static boolean solve(int[][] grid, int i, int j) {

		if (i == grid.length - 1 && j == grid.length) {
			return true;
		}

		if (i >= grid.length) {
			return false;
		}

		if (j == grid.length) {
			j = 0;
			i = i + 1;
		}
		if (grid[i][j] == 0) {
			for (int val = 1; val <= 9; val++) {
				if (check(grid, i, j, val)) {
					grid[i][j] = val;
					if (solve(grid, i, j + 1)) {
						return true;
					}
					grid[i][j] = 0;
				}

			}
		} else {
			return solve(grid, i, j + 1);
		}

		return false;
	}

	private static boolean check(int[][] grid, int i, int j, int val) {
		// column
		for (int k = 0; k < grid.length; k++) {
			if (grid[k][j] == val) {
				return false;
			}
		}

		// row
		for (int k = 0; k < grid.length; k++) {
			if (grid[i][k] == val) {
				return false;
			}
		}

		// square
		int starti = (i / 3) * 3;
		int startj = (j / 3) * 3;
		for (int k = starti; k < starti + 3; k++) {
			for (int k2 = startj; k2 < startj + 3; k2++) {
				if (grid[k][k2] == val) {
					return false;
				}
			}
		}
		return true;
	}

	// Function to print grids of the Sudoku.
	static void printGrid(int grid[][]) {
		for (int k1 = 0; k1 < grid.length; k1++) {
			for (int k2 = 0; k2 < grid.length; k2++) {
				System.out.print(grid[k1][k2] + " ");
			}
			System.out.println();
		}
	}

}
