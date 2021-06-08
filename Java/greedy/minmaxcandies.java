package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class minmaxcandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static ArrayList<Integer> candyStore(int candies[], int N, int K) {

		int mincost = 0;
		Arrays.sort(candies);
		int j = N - 1;
		for (int i = 0; i <= j; i++) {
			mincost += candies[i];
			int c = 0;
			while (j >= i && c < K) {
				j--;
				c++;
			}
		}

		j = 0;
		int maxcost = 0;
		for (int i = N - 1; i >= j; i--) {
			maxcost += candies[i];
			int c = 0;
			while (i > j && c < K) {
				j++;
				c++;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(mincost);
		ans.add(maxcost);
		return ans;
	}

}
