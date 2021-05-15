package graphs;

import java.util.LinkedList;

public class snakeandladder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 49;
		int moves[] = new int[N + 1];
		for (int i = 0; i <= N; i++)
			moves[i] = -1;

		int[][] board = { { -1, -1, 27, 13, -1, 25, -1 }, { -1, -1, -1, -1, -1, -1, -1 }, { 44, -1, 8, -1, -1, 2, -1 },
				{ -1, 30, -1, -1, -1, -1, -1 }, { 3, -1, 20, -1, 46, 6, -1 }, { -1, -1, -1, -1, -1, -1, 29 },
				{ -1, 29, 21, 33, -1, -1, -1 } };

		int k = 1;
		int m = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			if (m % 2 == 0) {
				for (int j = 0; j < board[0].length; j++) {
					moves[k++] = board[i][j];
				}
			} else {
				for (int j = board[0].length - 1; j >= 0; j--) {
					moves[k++] = board[i][j];
				}
			}
			m++;
		}

		for (int i = 0; i < moves.length; i++) {
			System.out.println(i + 1 + " -  " + moves[i]);
		}

		getMinDiceThrows(moves, N);

	}

	public static class pair {
		int val;
		int mindice;
		String psf;

		pair(int n, int m, String p) {
			this.val = n;
			this.mindice = m;
			this.psf = p;
		}

	}

	// bfs traversal
	private static void getMinDiceThrows(int[] moves, int n) {
		int[] visited = new int[n + 1];
		LinkedList<pair> queue = new LinkedList<>();
		queue.addFirst(new pair(1, 0, "1 "));
		while (!queue.isEmpty()) {
			pair rv = queue.removeFirst();
			if (visited[rv.val] == 1) {
				continue;
			}
			visited[rv.val] = 1;

			if (rv.val == n) {
				System.out.println(rv.mindice + " --------------");
				System.out.println(rv.psf + " --------------");
				break;
			}

			for (int i = rv.val + 1; i <= rv.val + 6 && i < moves.length; i++) {
				int nbr = 0;
				if (moves[i] == -1) {
					nbr = i;
				} else {
					nbr = moves[i];
				}
				if (visited[nbr] == 0) {
					queue.addLast(new pair(nbr, rv.mindice + 1, rv.psf + nbr + " "));
				}
			}

		}

	}

}
