package strings;

public class countofnumberofstringinarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr = { { 'B', 'B', 'M', 'B', 'B', 'B' }, { 'C', 'B', 'A', 'B', 'B', 'B' },
				{ 'I', 'B', 'G', 'B', 'B', 'B' }, { 'G', 'B', 'I', 'B', 'B', 'B' }, { 'A', 'B', 'C', 'B', 'B', 'B' },
				{ 'M', 'C', 'I', 'G', 'A', 'M' } };
		System.out.println(move(arr, "MAGIC"));

	}

	public static int solve(int i, int j, String s, int ind, char[][] arr) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return 0;
		}
		int count = 0;
		if (arr[i][j] == s.charAt(ind)) {
			char temp = s.charAt(ind);
			arr[i][j] = '0';
			ind++;
			if (ind == s.length()) {
				count = 1;
			} else {
				count += solve(i, j + 1, s, ind, arr);
				count += solve(i, j - 1, s, ind, arr);
				count += solve(i + 1, j, s, ind, arr);
				count += solve(i - 1, j, s, ind, arr);
			}
			arr[i][j] = temp;
		}
		return count;

	}

	public static int move(char[][] arr, String s) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				total += solve(i, j, s, 0, arr);
			}
		}
		return total;
	}

}
