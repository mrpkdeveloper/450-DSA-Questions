package greedy;

import java.util.Arrays;

public class maximumtrain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		train[] arr = new train[6];
		arr[5] = new train(900, 1005, 1);
		arr[2] = new train(1000, 1020, 2);
		arr[0] = new train(1000, 1030, 1);
		arr[1] = new train(1010, 1030, 1);
		arr[3] = new train(1030, 1230, 2);
		arr[4] = new train(1200, 1230, 3);

		maxtrain(arr, 3);

	}

	public static class train implements Comparable<train> {
		int at, dt, pn;

		train(int a, int d, int p) {
			this.at = a;
			this.dt = d;
			this.pn = p;
		}

		@Override
		public int compareTo(train o) {
			return this.dt - o.dt;
		}
	}

	public static void maxtrain(train[] arr, int n) {
		Arrays.parallelSort(arr);

		int[] platform = new int[n + 1];
		for (int i = 0; i < platform.length; i++) {
			platform[i] = -1;
		}
		int maxc = 0;
		for (int i = 0; i < arr.length; i++) {
			int pn = arr[i].pn;
			if (platform[pn] == -1) {
				maxc++;
				platform[pn] = i;
			} else {
				int tn = platform[pn];
				if (arr[tn].dt < arr[i].at) {
					maxc++;
					platform[pn] = i;
				}
			}
		}

		for (int i = 0; i < platform.length; i++) {
			System.out.println(platform[i]);
		}

		System.out.println(maxc);

	}
}
