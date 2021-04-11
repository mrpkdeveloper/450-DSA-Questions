package mattrix;

public class spiraltraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spiral(matrix, matrix.length, matrix[0].length);

	}

	public static void spiral(int[][] matrix, int R, int C) {

		int dir = 1, up = 0, down = R - 1, left = 0, right = C - 1, r = 0, c = 0;
		while (up <= down && left <= right) {
			while (dir == 1 && c <= right) {
				System.out.println(matrix[r][c] + ", ");
				c++;
			}
			while (dir == 2 && r <= down) {
				System.out.println(matrix[r][c] + ", ");
				r++;
			}
			while (dir == 3 && c >= left) {
				System.out.println(matrix[r][c] + ", ");
				c--;
			}
			while (dir == 4 && r >= up) {
				System.out.println(matrix[r][c] + ", ");
				r--;
			}

			if (dir == 1 && c > right) {
				dir = 2;
				c = right;
				up++;
				r = up;
			} else if (dir == 2 && r > down) {
				dir = 3;
				r = down;
				right--;
				c = right;
			} else if (dir == 3 && c < left) {
				dir = 4;
				c = left;
				down--;
				r = down;
			} else if (dir == 4 && r < up) {
				dir = 1;
				r = up;
				left++;
				c = left;
			}

		}

	}

}
