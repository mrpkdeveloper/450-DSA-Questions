package graphs;

public class noofislands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void countisland(int[][] arr) {

		int[][] visited = new int[arr.length][arr[0].length];

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1 && visited[i][j] == 0) {
					count++;
					dfs(arr, visited, i, j);
				}
			}
		}

		System.out.println(count);

	}

	private static void dfs(int[][] arr, int[][] visited, int i, int j) {

		if (arr[i][j] == 0 || visited[i][j] == 1 || i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
			return;
		}

		visited[i][j] = 1;

		dfs(arr, visited, i, j + 1);
		dfs(arr, visited, i, j - 1);
		dfs(arr, visited, i + 1, j);
		dfs(arr, visited, i - 1, j);
		dfs(arr, visited, i - 1, j + 1);
		dfs(arr, visited, i + 1, j + 1);
		dfs(arr, visited, i + 1, j - 1);
		dfs(arr, visited, i - 1, j - 1);

	}

}
