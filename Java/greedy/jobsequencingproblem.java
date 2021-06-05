package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class jobsequencingproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Job {
		int id, profit, deadline;
	}

	int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, new Comparator<Job>() {
			@Override
			public int compare(Job a, Job b) {
				return b.profit - a.profit;
			}
		});

		int time = 1, profit = arr[0].profit, deadline = arr[0].deadline;
		for (int i = 1; i < arr.length; i++) {
			if (time < arr[i].deadline) {
				profit += arr[i].profit;
				time++;
				if (deadline < arr[i].deadline) {
					deadline = arr[i].deadline;
				}
			}
		}

		int[] ans = new int[2];
		ans[0] = time;
		ans[1] = profit;
		return ans;
	}

}
