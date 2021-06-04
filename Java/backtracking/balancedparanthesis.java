package backtracking;

public class balancedparanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(3, "", 0, 0);

	}

	public static void print(int n, String ans, int no, int nc) {
		if (no > n || nc > n || nc > no) {
			return;
		}
		if (no == nc && n == no) {
			System.out.println(ans);
			return;
		}

		print(n, ans + ')', no, nc + 1);
		print(n, ans + '(', no + 1, nc);
	}

}
