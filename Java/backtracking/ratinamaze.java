package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class ratinamaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		// Your code here
		ArrayList<String> ans = new ArrayList<String>();
		path(m, 0, 0, "", ans);
		Collections.sort(ans);
		return ans;
	}

	public static void path(int[][] m, int i, int j, String ans, ArrayList<String> list) {
		if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] == 0) {
			return;
		}
		if (i == m.length - 1 && j == m[0].length - 1) {
			list.add(ans);
			return;
		}

		m[i][j] = 0;
		path(m, i + 1, j, ans + "D", list);// down
		path(m, i - 1, j, ans + "U", list);// up
		path(m, i, j + 1, ans + "R", list);// right
		path(m, i, j - 1, ans + "L", list);// left
		m[i][j] = 1;
	}

}
