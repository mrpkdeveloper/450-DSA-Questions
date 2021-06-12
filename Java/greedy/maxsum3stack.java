package greedy;

public class maxsum3stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] st1 = { 1, 2, 3, 4 };
//		int[] st2 = { 2, 3, 4 };
//		int[] st3 = { 3, 4 };
		int[] st1 = { 3, 10 };
		int[] st2 = { 4, 5 };
		int[] st3 = { 2, 1 };

		solve(st1, st2, st3);
	}

	public static void solve(int[] st1, int[] st2, int[] st3) {

		for (int i = st1.length - 2; i >= 0; i--) {
			st1[i] += st1[i + 1];
		}
		for (int i = st2.length - 2; i >= 0; i--) {
			st2[i] += st2[i + 1];
		}
		for (int i = st3.length - 2; i >= 0; i--) {
			st3[i] += st3[i + 1];
		}

		int i = 0, j = 0, k = 0;
		while (i < st1.length && j < st2.length && k < st3.length) {
			if (st1[i] > st2[j] && st1[i] > st3[k]) {
				i++;
			} else if (st2[j] > st1[i] && st2[j] > st3[k]) {
				j++;
			} else if (st3[k] > st1[i] && st3[k] > st2[j]) {
				k++;
			} else if (st2[j] == st1[i] && st2[j] == st3[k]) {
				System.out.println(st2[j]);
				break;
			} else if (st2[j] < st1[i] || st2[j] < st3[k]) {
				i++;
				k++;
			} else if (st2[j] > st1[i] || st3[k] > st1[i]) {
				j++;
				k++;
			} else if (st3[k] < st1[i] || st2[j] > st3[k]) {
				i++;
				j++;
			}
		}

	}

}
