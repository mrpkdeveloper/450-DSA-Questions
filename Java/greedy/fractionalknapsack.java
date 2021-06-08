package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalknapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Item {
		int value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}
	}

	public static double fractionalKnapsack(int W, Item arr[], int n) {
		Arrays.sort(arr, new Comparator<Item>() {
			public int compare(Item a, Item b) {
				double ra = (double) a.value / (double) a.weight;
				double rb = (double) b.value / (double) b.weight;
				if (rb - ra < 0) {
					return -1;
				}
				return 1;
			}
		});
		int sumweight = 0, i = 0;
		double maxvalue = 0;
		while (sumweight != W && i < arr.length) {
			if (arr[i].weight + sumweight <= W) {
				sumweight += arr[i].weight;
				maxvalue += arr[i].value;
			} else {
				double left = W - sumweight;
				// System.out.println(left);
				double r = (double) arr[i].value / (double) arr[i].weight;
				maxvalue += left * r;
				sumweight += left;
				break;
			}
			i++;
		}
		return maxvalue;
	}

}
