package stackandqueue;

import java.util.Stack;

public class celebrityproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int celebrity(int m[][], int n) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() >= 2) {
			int a = st.pop();
			int b = st.pop();

			if (m[a][b] == 1) {
				st.push(b);
			} else {
				st.push(a);
			}
		}

		int celb = st.pop();
		for (int i = 0; i < n; i++) {
			if (i != celb) {
				if (m[celb][i] == 1 || m[i][celb] == 0) {
					return -1;
				}
			}
		}

		return celb;
	}

}
