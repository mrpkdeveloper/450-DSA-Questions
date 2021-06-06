package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class jobsequencingproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job[] arr = new Job[4];
		arr[0] = new Job(20, 4);
		arr[1] = new Job(10, 1);
		arr[2] = new Job(40, 1);
		arr[3] = new Job(30, 1);

		JobScheduling(arr, arr.length);

	}

	public static class Job {
		int profit, deadline;

		Job(int p, int d) {
			this.profit = p;
			this.deadline = d;
		}
	}

	// O(n2) -> time
	public static void JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, new Comparator<Job>() {
			@Override
			public int compare(Job a, Job b) {
				return b.profit - a.profit;
			}
		});

		int maxdeadline = 0;
		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i].profit + " - " + arr[i].deadline);
			if (maxdeadline < arr[i].deadline) {
				maxdeadline = arr[i].deadline;
			}
		}

		int[] sheduler = new int[maxdeadline + 1];
		for (int i = 0; i < sheduler.length; i++) {
			sheduler[i] = -1;
		}

		int maxprofit = 0, c = 0;
		for (int i = 0; i < arr.length; i++) {
			int dead = arr[i].deadline;
			for (int j = dead; j >= 1; j--) {
				if (sheduler[j] == -1) {
					c++;
					sheduler[j] = arr[i].profit;
					maxprofit += arr[i].profit;
					break;
				}
			}
		}

//		System.out.println();
//		for (int i = 0; i < sheduler.length; i++) {
//			System.out.println(sheduler[i]);
//		}
//
//		System.out.println();
		System.out.println(maxprofit);

	}

}
