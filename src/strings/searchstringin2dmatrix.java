package strings;

public class searchstringin2dmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		move(arr, "GEEKS");
//		move(arr, "EEE");
//		System.out.println(solve(2, 2, "EEE", 0, arr));

	}

	// not in zig zag form
	public static boolean solve(int i, int j, String s, int ind, char[][] arr) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return false;
		}
		if (arr[i][j] == s.charAt(ind)) {
			for (int dir = 0; dir < 8; dir++) {
				int k;
				int row = i, col = j;
				for (k = 1; k < s.length(); k++) {
					if (dir == 0) {
						col++;
					} else if (dir == 1) {
						col--;
					} else if (dir == 2) {
						row++;
					} else if (dir == 3) {
						row--;
					} else if (dir == 4) {
						row++;
						col++;
					} else if (dir == 5) {
						row--;
						col++;
					} else if (dir == 6) {
						row++;
						col--;
					} else if (dir == 7) {
						row--;
						col--;
					}
					if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
						break;
					}
					if (arr[row][col] != s.charAt(k)) {
						break;
					}
				}
				if (k == s.length()) {
					return true;
				}
			}
		}
		return false;

	}

	public static void move(char[][] arr, String s) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (solve(i, j, s, 0, arr)) {
					System.out.println(i + " " + j);
				}
			}
		}
	}

}
